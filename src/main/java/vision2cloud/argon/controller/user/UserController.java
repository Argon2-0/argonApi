package vision2cloud.argon.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vision2cloud.argon.model.user.User;
import vision2cloud.argon.service.user.UserService;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/user")
public class UserController {
    @Autowired
    @Qualifier("UserService")
    UserService userService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody User user) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(userService.create(user), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/createMasive",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createMasive(@RequestBody ArrayList<User> users) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(userService.createMasive(users), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseEntity<?> getUsers() {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(userService.getUsers(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getUserById(@PathVariable("id") int id) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(userService.getUserById(id), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody User user) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(userService.update(user), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
