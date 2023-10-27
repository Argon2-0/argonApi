package vision2cloud.argon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import vision2cloud.argon.controller.user.auth.AuthService;
import vision2cloud.argon.model.Curso;
import vision2cloud.argon.model.Empresa;
import vision2cloud.argon.service.CursoService;
import vision2cloud.argon.service.EmpresaService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/curso")
public class CursoController {
    @Autowired
    @Qualifier("CursoService")
    CursoService cursoService;

    @Autowired
    @Qualifier("AuthService")
    AuthService authService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Curso curso) {
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
                response.add(cursoService.create(curso));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(CursoController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseEntity<?> getCursoss() {
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
                response.add(cursoService.getCursos());
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(CursoController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getByNit/{nit}",method = RequestMethod.GET)
    public ResponseEntity<?> getCursoByCodigo(@PathVariable("codigo") String codigo) {
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
                response.add(cursoService.findByCodigoLike(codigo));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(CursoController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Curso curso) {
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
                response.add(cursoService.update(curso));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(CursoController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/createMasive",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createMasive(@RequestBody ArrayList<Curso> curso) {
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
                response.add(cursoService.createMasive(curso));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);

        } catch (Exception ex) {
            Logger.getLogger(CursoController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
