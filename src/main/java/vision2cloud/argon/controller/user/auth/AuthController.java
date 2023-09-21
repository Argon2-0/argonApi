package vision2cloud.argon.controller.user.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;
import vision2cloud.argon.model.user.Auth.Token;
import vision2cloud.argon.model.user.UserInfo;
import vision2cloud.argon.service.TipoServicioService;

import javax.xml.bind.DatatypeConverter;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import static vision2cloud.argon.model.user.Auth.Constants.*;


@RestController
@RequestMapping( "/accessbiosecurity/auth" )
public class AuthController
{
    @Autowired
    @Qualifier("AuthService")
    AuthService authService;
    @RequestMapping(value = "/generate",method = RequestMethod.POST)
    @ResponseBody
    public Token generateToken(@RequestBody UserInfo userInfo )
    {
        return authService.TokenGenerator( userInfo );
    }

    @RequestMapping(value = "/validate",method = RequestMethod.POST)
    @ResponseBody
    public Boolean validateToken(@RequestHeader (name="Authorization") String token, @RequestBody UserInfo userInfo )
    {
        System.out.println("------------------------");
        System.out.println(token.toString());
        System.out.println("------------------------");
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY.getBytes())
                .parseClaimsJws(token).getBody();
        System.out.println("+++++++++++++++++++++++++");
        System.out.println(claims);
        System.out.println("+++++++++++++++++++++++++");
        return claims.get(CLAIMS_NAME_KEY) == userInfo.getName() &&
                claims.get(CLAIMS_EMAIL_KEY) == userInfo.getEmail() &&
                claims.get(CLAIMS_ROLES_KEY) == userInfo.getRole() &&
                claims.getExpiration().after(new Date());
    }


}