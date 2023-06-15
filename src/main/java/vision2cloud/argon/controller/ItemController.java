package vision2cloud.argon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vision2cloud.argon.model.Item;
import vision2cloud.argon.service.ItemService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/item")
public class ItemController {
    @Autowired
    @Qualifier("ItemService")
    ItemService itemService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Item item) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(itemService.create(item), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseEntity<?> getItems() {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(itemService.getItems(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getItemById(@PathVariable("id") int id) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(itemService.getItemById(id), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Item item) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(itemService.update(item), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
