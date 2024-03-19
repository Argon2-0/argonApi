package vision2cloud.argon.service.validaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import vision2cloud.argon.controller.user.auth.AuthService;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

@Service("Validaciones")
public class Validaciones {
    @Autowired
    @Qualifier("AuthService")
    AuthService authService;
    public ArrayList<String> TokenValidation(String token, Long milisLastTime, Long milisCurrentTime){

        Timestamp lastTime = new Timestamp(milisLastTime);
        Timestamp currentTime = new Timestamp(milisCurrentTime);
        Instant instantLastTime = lastTime.toInstant();
        Instant instantCurrentTime = currentTime.toInstant();
        ZoneId zonaColombia = ZoneId.of("America/Bogota");
        ZonedDateTime zonedDateLastTime = instantLastTime.atZone(zonaColombia);
        ZonedDateTime zonedDateCurrentTime = instantCurrentTime.atZone(zonaColombia);
        Timestamp newLastTime = Timestamp.valueOf(zonedDateLastTime.toLocalDateTime().withHour(0).withMinute(0).withSecond(0).withNano(0));
        Timestamp newCurrentTime = Timestamp.valueOf(zonedDateCurrentTime.toLocalDateTime().withHour(0).withMinute(0).withSecond(0).withNano(0));
        System.out.println("------------------Validating--------------------");
        System.out.println(newLastTime);
        System.out.println(newCurrentTime);
        return authService.VerificateToken(token, newLastTime, newCurrentTime);
    }

    public Boolean IpValidation(String ip){
        return "201.184.62.170".equals(ip);
    }
}
