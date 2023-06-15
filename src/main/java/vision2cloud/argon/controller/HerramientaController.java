package vision2cloud.argon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vision2cloud.argon.model.Herramienta;
import vision2cloud.argon.model.TipoServicio;
import vision2cloud.argon.service.HerramientaService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/herramienta")
public class HerramientaController {
    @Autowired
    @Qualifier("HerramientaService")
    HerramientaService herramientaService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Herramienta herramienta) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(herramientaService.create(herramienta), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(HerramientaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/createMasive",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createMasive(@RequestBody ArrayList<Herramienta> herramientas) {
        try {
            System.out.println("herramienta.toString()");
            for(Herramienta herramienta:herramientas){
                System.out.println(herramienta.toString());
            }
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(herramientaService.createMasive(herramientas), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(TipoServicioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseEntity<?> getHerramientas() {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(herramientaService.getHerramientas(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(HerramientaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getEstadosForDasboard",method = RequestMethod.GET)
    public ResponseEntity<?> getEstadosForDasboard() {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(herramientaService.getEstadosForDasboard(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(HerramientaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getHerramientaById(@PathVariable("id") long id) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(herramientaService.getHerramientaById(id), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(HerramientaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Herramienta herramienta) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(herramientaService.update(herramienta), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(HerramientaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getByCodigoBarras/{codigobarras}",method = RequestMethod.GET)
    public ResponseEntity<?> findByCodigoBarras(@PathVariable("codigobarras") String codigo_barras) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(herramientaService.findByCodigoBarras(codigo_barras), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(HerramientaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
