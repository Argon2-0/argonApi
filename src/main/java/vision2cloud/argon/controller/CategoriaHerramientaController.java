package vision2cloud.argon.controller;

import jdk.nashorn.internal.runtime.Debug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vision2cloud.argon.model.CategoriaHerramienta;
import vision2cloud.argon.service.CategoriaHerramientaService;

import java.io.Console;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/categoriaherramienta")
public class CategoriaHerramientaController {
    @Autowired
    @Qualifier("CategoriaHerramientaService")
    CategoriaHerramientaService categoriaHerramientaService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody CategoriaHerramienta categoriaHerramienta) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(categoriaHerramientaService.create(categoriaHerramienta), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(CategoriaHerramientaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseEntity<?> getCategoriasHerramientas() {
        try {
            //obtener datos que se enviarán a través del API
            System.out.println("Controller");
            return new ResponseEntity<>(categoriaHerramientaService.getCategoriasHerramientas(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(CategoriaHerramientaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getCategoriaHerramientaById(@PathVariable("id") long id) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(categoriaHerramientaService.getCategoriaHerramientaById(id), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(CategoriaHerramientaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody CategoriaHerramienta categoriaHerramienta) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(categoriaHerramientaService.update(categoriaHerramienta), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(CategoriaHerramientaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
