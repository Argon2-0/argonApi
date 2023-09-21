package vision2cloud.argon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import vision2cloud.argon.controller.user.auth.AuthService;
import vision2cloud.argon.model.HistoryTipoServicio;
import vision2cloud.argon.service.HistoryTipoServicioService;
import vision2cloud.argon.service.TipoServicioService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/historytiposervicio")
public class HistoryTipoServicioController {
    @Autowired
    @Qualifier("HistoryTipoServicioService")
    HistoryTipoServicioService historyTipoServicioService;

    @Autowired
    @Qualifier("AuthService")
    AuthService authService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody HistoryTipoServicio historyTipoServicio) {
        try {
            //obtener datos que se enviarán a través del API
            String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
            Long milisLastTime = Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime"));
            Timestamp lastTime = new Timestamp(milisLastTime);
            Long milisCurrentTime = Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime"));
            Timestamp currentTime = new Timestamp(milisCurrentTime);
            ArrayList<String> respuesta = authService.VerificateToken(token, lastTime, currentTime);
            //obtener datos que se enviarán a través del API
            if(Boolean.parseBoolean(respuesta.get(0))){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(historyTipoServicioService.create(historyTipoServicio));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(HistoryTipoServicioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseEntity<?> getHistoryTiposServicios() {
        try {
            //obtener datos que se enviarán a través del API
            String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
            Long milisLastTime = Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime"));
            Timestamp lastTime = new Timestamp(milisLastTime);
            Long milisCurrentTime = Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime"));
            Timestamp currentTime = new Timestamp(milisCurrentTime);
            ArrayList<String> respuesta = authService.VerificateToken(token, lastTime, currentTime);
            //obtener datos que se enviarán a través del API
            if(Boolean.parseBoolean(respuesta.get(0))){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(historyTipoServicioService.getHistoryTiposServicios());
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(HistoryTipoServicioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getHistoryTipoServicioById(@PathVariable("id") long id) {
        try {
            //obtener datos que se enviarán a través del API
            String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
            Long milisLastTime = Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime"));
            Timestamp lastTime = new Timestamp(milisLastTime);
            Long milisCurrentTime = Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime"));
            Timestamp currentTime = new Timestamp(milisCurrentTime);
            ArrayList<String> respuesta = authService.VerificateToken(token, lastTime, currentTime);
            //obtener datos que se enviarán a través del API
            if(Boolean.parseBoolean(respuesta.get(0))){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(historyTipoServicioService.getHistoryTipoServicioById(id));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
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
            String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
            Long milisLastTime = Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime"));
            Timestamp lastTime = new Timestamp(milisLastTime);
            Long milisCurrentTime = Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime"));
            Timestamp currentTime = new Timestamp(milisCurrentTime);
            ArrayList<String> respuesta = authService.VerificateToken(token, lastTime, currentTime);
            //obtener datos que se enviarán a través del API
            if(Boolean.parseBoolean(respuesta.get(0))){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(historyTipoServicioService.update(historyTipoServicio));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(HistoryTipoServicioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
