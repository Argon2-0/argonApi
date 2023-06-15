package vision2cloud.argon.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vision2cloud.argon.model.user.User;
import vision2cloud.argon.model.user.UserLogin;
import vision2cloud.argon.service.user.UserLoginService;
import vision2cloud.argon.service.user.UserService;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/userLogin")
public class UserLoginController {
    @Autowired
    @Qualifier("UserLoginService")
    UserLoginService userLoginService;

    @RequestMapping(value = "/Login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> Login(@RequestBody UserLogin user) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(userLoginService.Login(user.getEmail(), user.getPassword()), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserLoginController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody UserLogin user) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(userLoginService.update(user), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserLoginController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
