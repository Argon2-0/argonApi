package vision2cloud.argon.controller.zkt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import vision2cloud.argon.service.validaciones.Validaciones;
import vision2cloud.argon.controller.CategoriaHerramientaController;
import vision2cloud.argon.controller.user.auth.AuthService;
import vision2cloud.argon.model.zkt.Person;
import vision2cloud.argon.service.zkt.PersonService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/zkt/persona")
public class PersonController {
    @Autowired
    @Qualifier("PersonService")
    PersonService personService;

    @Autowired
    @Qualifier("Validaciones")
    Validaciones validaciones;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Person person) {
        try {
            ArrayList<String> respuesta = new ArrayList<>( Arrays.asList("false", "") );
            boolean ipautorizada = false;
            if(validaciones.IpValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getRemoteAddr())){
                ipautorizada = true;
            }else {
                //obtener datos que se enviarán a través del API
                respuesta = validaciones.TokenValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization"),
                        Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime")),
                        Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime")));
            }
            //obtener datos que se enviarán a través del API
            String rolId = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("id");
            if((Boolean.parseBoolean(respuesta.get(0)) && (rolId.equals("1") || rolId.equals("2") || rolId.equals("3")))|| ipautorizada){
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
            ArrayList<String> respuesta =validaciones.TokenValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization"),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime")),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime")));
            //obtener datos que se enviarán a través del API
            String rolId = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("id");
            if(Boolean.parseBoolean(respuesta.get(0)) && (rolId.equals("1") || rolId.equals("2") || rolId.equals("3"))){
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

    @RequestMapping(value = "/createMasive",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createMasive(@RequestBody ArrayList<Person> persons) {
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
                response.add(personService.createMasive(persons));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(CategoriaHerramientaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
