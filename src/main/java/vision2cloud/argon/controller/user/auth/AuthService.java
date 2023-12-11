package vision2cloud.argon.controller.user.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.user.Auth.Token;
import vision2cloud.argon.model.user.UserInfo;
import vision2cloud.argon.service.user.UserInfoService;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import static vision2cloud.argon.model.user.Auth.Constants.*;
@Service("AuthService")
public class AuthService {

    @Autowired
    @Qualifier("UserInfoService")
    UserInfoService userInfoService;
    public String generateTokenHash(UserInfo usuario, Date expirationDate )
    {

        return Jwts.builder()
                .setSubject(String.valueOf(usuario.getId()))
                .claim(CLAIMS_NAME_KEY, usuario.getName())
                .claim(CLAIMS_EMAIL_KEY, usuario.getEmail())
                .claim( CLAIMS_ROLES_KEY, usuario.getRole() )
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date() )
                .setExpiration( expirationDate )
                .signWith( SignatureAlgorithm.HS256, SECRET_KEY )
                .compact();
    }

    public Token TokenGenerator(UserInfo usuario)
    {
        LocalDateTime expirationLocalDate = LocalDateTime.now();
        System.out.println(expirationLocalDate);
        expirationLocalDate = expirationLocalDate.plusMinutes(TOKEN_DURATION_MINUTES );
        Timestamp timeExpiration = Timestamp.valueOf(expirationLocalDate);
        Date expirationDate = new Date(timeExpiration.getTime());

        String token = generateTokenHash( usuario, expirationDate);
        System.out.println(token);
        return new Token( token, expirationDate);
    }

    public ArrayList<String> VerificateToken(String token, Timestamp lastTime, Timestamp currentTime)
    {
        System.out.println(token);
        System.out.println("------------ Decode JWT ------------");
        String[] split_string = token.split("\\.");
        String base64EncodedHeader = split_string[0];
        String base64EncodedBody = split_string[1];
        String base64EncodedSignature = split_string[2];

        System.out.println("~~~~~~~~~ JWT Header ~~~~~~~");
        Base64 base64Url = new Base64(true);
        String header = new String(base64Url.decode(base64EncodedHeader));
        System.out.println("JWT Header : " + header);


        System.out.println("~~~~~~~~~ JWT Body ~~~~~~~");
        String body = new String(base64Url.decode(base64EncodedBody));
        System.out.println("JWT Body : "+body);

        String[] bodyseparate = body.replace("\"","").replace("{","").replace("}","").split(",");

        Timestamp dueDate = null;
        Long milis = 0L;
        String email = "";
        Boolean aprueba = false;
        for (String part: bodyseparate){
            String[] intern = part.split(":");
            if(intern[0].equals("email")){
                email = intern[1];
            }
            else if(intern[0].equals("exp")){
                System.out.println(intern[0]);
                System.out.println(intern[1]);
                milis = Long.valueOf(intern[1]);
                Timestamp dueTime = new Timestamp(milis*1000);
                System.out.println(dueTime);
                System.out.println(dueTime.toLocalDateTime());
                if(currentTime.before(dueTime) || (lastTime.before(dueTime) && currentTime.toLocalDateTime().isBefore(lastTime.toLocalDateTime().plusMinutes(TOKEN_DURATION_MINUTES)))){
                    aprueba=true;
                }
            }
        }
        ArrayList<String> respuesta = new ArrayList<>();
        if (aprueba){
            respuesta.add("true");
            respuesta.add(TokenGenerator(userInfoService.getByEmail(email)).getToken());
        }
        else{
            respuesta.add("false");
        }
        System.out.println(dueDate);
        return respuesta;
    }
}
