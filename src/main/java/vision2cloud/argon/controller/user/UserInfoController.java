package vision2cloud.argon.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vision2cloud.argon.model.user.User;
import vision2cloud.argon.model.user.UserInfo;
import vision2cloud.argon.service.user.UserInfoService;
import vision2cloud.argon.service.user.UserService;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/userInfo")
public class UserInfoController {
    @Autowired
    @Qualifier("UserInfoService")
    UserInfoService userInfoService;

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseEntity<?> getUsers() {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(userInfoService.getUsers(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserInfoController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getUserById(@PathVariable("id") int id) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(userInfoService.getUserById(id), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserInfoController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getByEmail",method = RequestMethod.POST)
    public ResponseEntity<?> getByEmail(@RequestBody UserInfo userInfo) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(userInfoService.getByEmail(userInfo.getEmail()), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserInfoController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody UserInfo user) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(userInfoService.update(user), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserInfoController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
