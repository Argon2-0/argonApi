package vision2cloud.argon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vision2cloud.argon.model.ItemTag;
import vision2cloud.argon.service.ItemService;
import vision2cloud.argon.service.ItemTagService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/itemtag")
public class ItemTagController {
    @Autowired
    @Qualifier("ItemTagService")
    ItemTagService itemTagService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ItemTag itemTag) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(itemTagService.create(itemTag), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ItemTagController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseEntity<?> getItemsTags() {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(itemTagService.getItemsTags(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ItemTagController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
