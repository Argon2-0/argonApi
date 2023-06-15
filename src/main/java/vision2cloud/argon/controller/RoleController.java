package vision2cloud.argon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vision2cloud.argon.model.Role;
import vision2cloud.argon.service.RoleService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/role")
public class RoleController {
    @Autowired
    @Qualifier("RoleService")
    RoleService roleService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Role role) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(roleService.create(role), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(RoleController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseEntity<?> getRoles() {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(roleService.getRoles(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(RoleController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getRoleById(@PathVariable("id") long id) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(roleService.getRoleById(id), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(RoleController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Role role) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(roleService.update(role), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(RoleController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
