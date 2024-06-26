package vision2cloud.argon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import vision2cloud.argon.service.validaciones.Validaciones;
import vision2cloud.argon.controller.user.auth.AuthService;
import vision2cloud.argon.model.Participante;
import vision2cloud.argon.service.ParticipanteService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/participante")
public class ParticipanteController {
    @Autowired
    @Qualifier("ParticipanteService")
    ParticipanteService participanteService;

    @Autowired
    @Qualifier("Validaciones")
    Validaciones validaciones;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Participante participante) {
        try {
            ArrayList<String> respuesta = new ArrayList<>( Arrays.asList("false", "") );
            boolean ipautorizada = false;
            if(validaciones.IpValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getRemoteAddr())){
                ipautorizada = true;
            }else {
                //obtener datos que se enviarán a través del API
                respuesta = validaciones.TokenValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization"),
                        Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime")),
                        Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime")));
            }
            //obtener datos que se enviarán a través del API
            String rolId = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("id");
            if((Boolean.parseBoolean(respuesta.get(0)) && (rolId.equals("1") || rolId.equals("2") || rolId.equals("3")))|| ipautorizada){
                System.out.println("----------------");
                System.out.println("controller");
                System.out.println(participante);
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(participanteService.create(participante));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseEntity<?> getParticipantes() {
        try {
            //obtener datos que se enviarán a través del API
            ArrayList<String> respuesta =validaciones.TokenValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization"),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime")),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime")));
            //obtener datos que se enviarán a través del API
            String rolId = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("id");
            if(Boolean.parseBoolean(respuesta.get(0)) && (rolId.equals("1") || rolId.equals("2") || rolId.equals("3"))){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(participanteService.getParticipantes());
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getParticipanteById(@PathVariable("id") long id) {
        try {
            //obtener datos que se enviarán a través del API
            ArrayList<String> respuesta =validaciones.TokenValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization"),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime")),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime")));
            //obtener datos que se enviarán a través del API
            String rolId = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("id");
            if(Boolean.parseBoolean(respuesta.get(0)) && (rolId.equals("1") || rolId.equals("2") || rolId.equals("3"))){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(participanteService.getParticipanteById(id));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getByTipoDocumentoAndCedula/{tipoDocumento}/{cedula}",method = RequestMethod.GET)
    public ResponseEntity<?> findByTipoDocumentoAndCedulaLike(@PathVariable("tipoDocumento") String tipoDocumento, @PathVariable("cedula") long cedula) {
        try {
            //obtener datos que se enviarán a través del API
            ArrayList<String> respuesta =validaciones.TokenValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization"),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime")),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime")));
            //obtener datos que se enviarán a través del API
            String rolId = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("id");
            if(Boolean.parseBoolean(respuesta.get(0)) && (rolId.equals("1") || rolId.equals("2") || rolId.equals("3"))){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(participanteService.findByTipoDocumentoAndCedulaLike(tipoDocumento, cedula));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getByCedula/{cedula}",method = RequestMethod.GET)
    public ResponseEntity<?> findByCedulaLike(@PathVariable("cedula") long cedula) {
        try {
            ArrayList<String> respuesta = new ArrayList<>( Arrays.asList("false", "") );
            boolean ipautorizada = false;
            if(validaciones.IpValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getRemoteAddr())){
                ipautorizada = true;
            }else {
                //obtener datos que se enviarán a través del API
                respuesta = validaciones.TokenValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization"),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime")),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime")));
            }
            //obtener datos que se enviarán a través del API
            String rolId = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("id");
            if((Boolean.parseBoolean(respuesta.get(0)) && (rolId.equals("1") || rolId.equals("2") || rolId.equals("3")))|| ipautorizada){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(participanteService.findByCedulaLike(cedula));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/getToday",method = RequestMethod.GET)
    public ResponseEntity<?> getParticipanteToday() {
        try {
            //obtener datos que se enviarán a través del API
            ArrayList<String> respuesta =validaciones.TokenValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization"),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime")),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime")));
            //obtener datos que se enviarán a través del API
            String rolId = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("id");
            if(Boolean.parseBoolean(respuesta.get(0)) && (rolId.equals("1") || rolId.equals("2") || rolId.equals("3"))){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(participanteService.getParticipanteToday());
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getBetween/{start}/{end}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getParticipanteBetween(@PathVariable("start") Long start, @PathVariable("end") Long end) {
        try {
            ArrayList<String> respuesta =validaciones.TokenValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization"),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime")),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime")));
            //obtener datos que se enviarán a través del API
            String rolId = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("id");
            if(Boolean.parseBoolean(respuesta.get(0)) && (rolId.equals("1") || rolId.equals("2") || rolId.equals("3"))){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(participanteService.getParticipanteBetween(new Timestamp(start), new Timestamp(end)));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getEmpresasByParticipanteBetween/{start}/{end}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getEmpresasByParticipanteBetween(@PathVariable("start") Long start, @PathVariable("end") Long end) {
        try {
            ArrayList<String> respuesta =validaciones.TokenValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization"),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime")),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime")));
            //obtener datos que se enviarán a través del API
            String rolId = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("id");
            if(Boolean.parseBoolean(respuesta.get(0)) && (rolId.equals("1") || rolId.equals("2") || rolId.equals("3"))){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(participanteService.getEmpresasByParticipanteBetween(new Timestamp(start), new Timestamp(end)));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findVisitantes/{start}/{end}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> findDistinctByCedulaAndCreatedAtBetween(@PathVariable("start") Long start, @PathVariable("end") Long end) {
        try {
            ArrayList<String> respuesta =validaciones.TokenValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization"),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime")),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime")));
            //obtener datos que se enviarán a través del API
            String rolId = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("id");
            if(Boolean.parseBoolean(respuesta.get(0)) && (rolId.equals("1") || rolId.equals("2") || rolId.equals("3"))){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(participanteService.findDistinctByCedulaAndCreatedAtBetween(new Timestamp(start), new Timestamp(end)));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Participante participante) {
        try {
            ArrayList<String> respuesta = new ArrayList<>( Arrays.asList("false", "") );
            boolean ipautorizada = false;
            if(validaciones.IpValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getRemoteAddr())){
                ipautorizada = true;
            }else {
                //obtener datos que se enviarán a través del API
                respuesta =validaciones.TokenValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization"),
                        Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime")),
                        Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime")));
            }
            //obtener datos que se enviarán a través del API
            String rolId = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("id");
            if((Boolean.parseBoolean(respuesta.get(0)) && (rolId.equals("1") || rolId.equals("2") || rolId.equals("3")))|| ipautorizada){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(participanteService.update(participante));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/createMasive",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createMasive(@RequestBody ArrayList<Participante> participantes) {
        try {
            //obtener datos que se enviarán a través del API
            ArrayList<String> respuesta =validaciones.TokenValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization"),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime")),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime")));
            //obtener datos que se enviarán a través del API
            String rolId = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("id");
            if(Boolean.parseBoolean(respuesta.get(0)) && (rolId.equals("1") || rolId.equals("2") || rolId.equals("3"))){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(participanteService.createMasive(participantes));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);

        } catch (Exception ex) {
            Logger.getLogger(CursoController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
