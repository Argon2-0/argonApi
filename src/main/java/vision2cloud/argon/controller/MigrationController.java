package vision2cloud.argon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vision2cloud.argon.model.Migration;
import vision2cloud.argon.service.MigrationService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/migration")
public class MigrationController {
    @Autowired
    @Qualifier("MigrationService")
    MigrationService migrationService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Migration migration) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(migrationService.create(migration), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(MigrationController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseEntity<?> getMigrations() {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(migrationService.getMigrations(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(MigrationController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getMigrationById(@PathVariable("id") int id) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(migrationService.getMigrationById(id), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(MigrationController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Migration migration) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(migrationService.update(migration), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(MigrationController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
