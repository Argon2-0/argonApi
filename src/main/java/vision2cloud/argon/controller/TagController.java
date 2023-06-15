package vision2cloud.argon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vision2cloud.argon.model.Tag;
import vision2cloud.argon.service.TagService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/tag")
public class TagController {
    @Autowired
    @Qualifier("TagService")
    TagService tagService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Tag tag) {

        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(tagService.create(tag), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(TagController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseEntity<?> getTags() {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(tagService.getTags(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(TagController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getTagById(@PathVariable("id") long id) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(tagService.getTagById(id), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(TagController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Tag tag) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(tagService.update(tag), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(TagController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
