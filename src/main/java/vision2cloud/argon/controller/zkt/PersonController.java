package vision2cloud.argon.controller.zkt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import vision2cloud.argon.controller.CategoriaHerramientaController;
import vision2cloud.argon.controller.user.auth.AuthService;
import vision2cloud.argon.model.zkt.Person;
import vision2cloud.argon.service.TipoServicioService;
import vision2cloud.argon.service.zkt.PersonService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/zkt/persona")
public class PersonController {
    @Autowired
    @Qualifier("PersonService")
    PersonService personService;

    @Autowired
    @Qualifier("AuthService")
    AuthService authService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Person person) {
        try {
            //obtener datos que se enviarán a través del API
            String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
            Long milisLastTime = Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime"));
            Timestamp lastTime = new Timestamp(milisLastTime);
            Long milisCurrentTime = Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime"));
            Timestamp currentTime = new Timestamp(milisCurrentTime);
            ArrayList<String> respuesta = authService.VerificateToken(token, lastTime, currentTime);
            //obtener datos que se enviarán a través del API
            if(Boolean.parseBoolean(respuesta.get(0))){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(personService.create(person));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(CategoriaHerramientaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updatePrestamo/{pin}",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable("pin") String pin) {
        try {
            //obtener datos que se enviarán a través del API
            String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
            Long milisLastTime = Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime"));
            Timestamp lastTime = new Timestamp(milisLastTime);
            Long milisCurrentTime = Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime"));
            Timestamp currentTime = new Timestamp(milisCurrentTime);
            ArrayList<String> respuesta = authService.VerificateToken(token, lastTime, currentTime);
            //obtener datos que se enviarán a través del API
            if(Boolean.parseBoolean(respuesta.get(0))){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(personService.update(pin));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(CategoriaHerramientaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
