package vision2cloud.argon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vision2cloud.argon.model.TipoServicio;
import vision2cloud.argon.service.TipoServicioService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/tiposervicio")
public class TipoServicioController {
    @Autowired
    @Qualifier("TipoServicioService")
    TipoServicioService tipoServicioService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody TipoServicio tipoServicio) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(tipoServicioService.create(tipoServicio), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(TipoServicioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/createMasive",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createMasive(@RequestBody ArrayList<TipoServicio> tiposServicio) {
        try {
            for(TipoServicio tipoServicio:tiposServicio){
                System.out.println(tipoServicio);
            }
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(tipoServicioService.createMasive(tiposServicio), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(TipoServicioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseEntity<?> getTiposServicios() {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(tipoServicioService.getTiposServicios(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(TipoServicioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getTipoServicioById(@PathVariable("id") long id) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(tipoServicioService.getTipoServicioById(id), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(TipoServicioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody TipoServicio tipoServicio) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(tipoServicioService.update(tipoServicio), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(TipoServicioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
