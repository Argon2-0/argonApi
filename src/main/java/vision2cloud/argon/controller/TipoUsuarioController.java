package vision2cloud.argon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vision2cloud.argon.model.TipoUsuario;
import vision2cloud.argon.service.TipoUsuarioService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/tipousuario")
public class TipoUsuarioController {
    @Autowired
    @Qualifier("TipoUsuarioService")
    TipoUsuarioService tipoUsuarioService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody TipoUsuario tipoUsuario) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(tipoUsuarioService.create(tipoUsuario), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(TipoUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseEntity<?> getTiposUsuarios() {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(tipoUsuarioService.getTiposUsuarios(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(TipoUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getTipoUsuarioById(@PathVariable("id") long id) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(tipoUsuarioService.getTipoUsuarioById(id), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(TipoUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody TipoUsuario tipoUsuario) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(tipoUsuarioService.update(tipoUsuario), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(TipoUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
