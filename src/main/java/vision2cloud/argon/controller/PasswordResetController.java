package vision2cloud.argon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vision2cloud.argon.model.PasswordReset;
import vision2cloud.argon.service.PasswordResetService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/passwordreset")
public class PasswordResetController {
    @Autowired
    @Qualifier("PasswordResetService")
    PasswordResetService passwordResetService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody PasswordReset passwordReset) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(passwordResetService.create(passwordReset), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(PasswordResetController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseEntity<?> getPasswordsResets() {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(passwordResetService.getPasswordsResets(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(PasswordResetController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
