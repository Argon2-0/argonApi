package vision2cloud.argon.service.validaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import vision2cloud.argon.controller.user.auth.AuthService;

import java.sql.Timestamp;
import java.util.ArrayList;

@Service("Validaciones")
public class Validaciones {
    @Autowired
    @Qualifier("AuthService")
    AuthService authService;
    public ArrayList<String> TokenValidation(String token, Long milisLastTime, Long milisCurrentTime){
        Timestamp lastTime = new Timestamp(milisLastTime);
        Timestamp currentTime = new Timestamp(milisCurrentTime);
        return authService.VerificateToken(token, lastTime, currentTime);
    }

    public Boolean IpValidation(String ip){
        return "186.86.32.92".equals(ip);
    }
}
