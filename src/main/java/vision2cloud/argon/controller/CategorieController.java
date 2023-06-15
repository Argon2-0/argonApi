package vision2cloud.argon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vision2cloud.argon.model.Categorie;
import vision2cloud.argon.service.CategorieService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/categorie")
public class CategorieController {
    @Autowired
    @Qualifier("CategorieService")
    CategorieService categorieService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Categorie categorie) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(categorieService.create(categorie), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(CategorieController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseEntity<?> getCategories() {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(categorieService.getCategories(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(CategorieController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getCategorieById(@PathVariable("id") int id) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(categorieService.getCategorieById(id), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(CategorieController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Categorie categorie) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(categorieService.update(categorie), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(CategorieController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
