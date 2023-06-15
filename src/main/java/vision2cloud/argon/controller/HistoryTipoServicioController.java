package vision2cloud.argon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vision2cloud.argon.model.HistoryTipoServicio;
import vision2cloud.argon.service.HistoryTipoServicioService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/historytiposervicio")
public class HistoryTipoServicioController {
    @Autowired
    @Qualifier("HistoryTipoServicioService")
    HistoryTipoServicioService historyTipoServicioService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody HistoryTipoServicio historyTipoServicio) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(historyTipoServicioService.create(historyTipoServicio), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(HistoryTipoServicioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseEntity<?> getHistoryTiposServicios() {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(historyTipoServicioService.getHistoryTiposServicios(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(HistoryTipoServicioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getHistoryTipoServicioById(@PathVariable("id") long id) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(historyTipoServicioService.getHistoryTipoServicioById(id), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(HistoryTipoServicioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody HistoryTipoServicio historyTipoServicio) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(historyTipoServicioService.update(historyTipoServicio), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(HistoryTipoServicioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
