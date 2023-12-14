package vision2cloud.argon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import vision2cloud.argon.service.validaciones.Validaciones;
import vision2cloud.argon.controller.user.auth.AuthService;
import vision2cloud.argon.model.Migration;
import vision2cloud.argon.service.MigrationService;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/migration")
public class MigrationController {
    @Autowired
    @Qualifier("MigrationService")
    MigrationService migrationService;

    @Autowired
    @Qualifier("Validaciones")
    Validaciones validaciones;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Migration migration) {
        try {
            //obtener datos que se enviarán a través del API
            ArrayList<String> respuesta = validaciones.TokenValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization"),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime")),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime")));
            //obtener datos que se enviarán a través del API
            String rolId = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("id");
            if(Boolean.parseBoolean(respuesta.get(0)) && (rolId.equals("1") || rolId.equals("2") || rolId.equals("3"))){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(migrationService.create(migration));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(MigrationController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseEntity<?> getMigrations() {
        try {
            //obtener datos que se enviarán a través del API
            ArrayList<String> respuesta =validaciones.TokenValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization"),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime")),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime")));
            //obtener datos que se enviarán a través del API
            String rolId = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("id");
            if(Boolean.parseBoolean(respuesta.get(0)) && (rolId.equals("1") || rolId.equals("2") || rolId.equals("3"))){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(migrationService.getMigrations());
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(MigrationController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getMigrationById(@PathVariable("id") int id) {
        try {
            //obtener datos que se enviarán a través del API
            ArrayList<String> respuesta =validaciones.TokenValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization"),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime")),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime")));
            //obtener datos que se enviarán a través del API
            String rolId = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("id");
            if(Boolean.parseBoolean(respuesta.get(0)) && (rolId.equals("1") || rolId.equals("2") || rolId.equals("3"))){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(migrationService.getMigrationById(id));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
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
            ArrayList<String> respuesta =validaciones.TokenValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization"),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime")),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime")));
            //obtener datos que se enviarán a través del API
            String rolId = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("id");
            if(Boolean.parseBoolean(respuesta.get(0)) && (rolId.equals("1") || rolId.equals("2") || rolId.equals("3"))){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(migrationService.update(migration));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(MigrationController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
