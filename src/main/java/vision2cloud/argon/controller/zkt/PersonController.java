package vision2cloud.argon.controller.zkt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vision2cloud.argon.controller.CategoriaHerramientaController;
import vision2cloud.argon.model.zkt.Person;
import vision2cloud.argon.service.zkt.PersonService;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/zkt/persona")
public class PersonController {
    @Autowired
    @Qualifier("PersonService")
    PersonService personService;
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Person person) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(personService.create(person), HttpStatus.ACCEPTED);
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
            return new ResponseEntity<>(personService.update(pin), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(CategoriaHerramientaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
