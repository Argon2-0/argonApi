package vision2cloud.argon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vision2cloud.argon.model.Participante;
import vision2cloud.argon.model.RequestReporte;
import vision2cloud.argon.service.ParticipanteService;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/participante")
public class ParticipanteController {
    @Autowired
    @Qualifier("ParticipanteService")
    ParticipanteService participanteService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Participante participante) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(participanteService.create(participante), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseEntity<?> getParticipantes() {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(participanteService.getParticipantes(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getParticipanteById(@PathVariable("id") long id) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(participanteService.getParticipanteById(id), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getByCedula/{cedula}",method = RequestMethod.GET)
    public ResponseEntity<?> findByCedulaLike(@PathVariable("cedula") long cedula) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(participanteService.findByCedulaLike(cedula), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getToday",method = RequestMethod.GET)
    public ResponseEntity<?> getParticipanteToday() {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(participanteService.getParticipanteToday(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getBetween/{start}/{end}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getParticipanteBetween(@PathVariable("start") Long start, @PathVariable("end") Long end) {
        try {
            return new ResponseEntity<>(participanteService.getParticipanteBetween(new Timestamp(start), new Timestamp(end)), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/countByTiposervicio/{start}/{end}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> countByTiposervicio(@PathVariable("start") Long start, @PathVariable("end") Long end) {
        try {
            return new ResponseEntity<>(participanteService.countByTiposervicioAndCreatedAtBetween(new Timestamp(start), new Timestamp(end)), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/countByEdad/{start}/{end}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> countByEdad(@PathVariable("start") Long start, @PathVariable("end") Long end) {
        try {
            return new ResponseEntity<>(participanteService.countByEdadAndCreatedAtBetween(new Timestamp(start), new Timestamp(end)), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/countBySexo/{start}/{end}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> findBySexoLike(@PathVariable("start") Long start, @PathVariable("end") Long end) {
        try {
            return new ResponseEntity<>(participanteService.findBySexoLikeAndCreatedAtBetween(new Timestamp(start), new Timestamp(end)), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findVisitantes/{start}/{end}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> findDistinctByCedulaAndCreatedAtBetween(@PathVariable("start") Long start, @PathVariable("end") Long end) {
        try {
            return new ResponseEntity<>(participanteService.findDistinctByCedulaAndCreatedAtBetween(new Timestamp(start), new Timestamp(end)), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Participante participante) {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(participanteService.update(participante), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
