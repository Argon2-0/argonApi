package vision2cloud.argon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import vision2cloud.argon.model.VisitaVisitante;
import vision2cloud.argon.service.VisitaVisitanteService;
import vision2cloud.argon.service.validaciones.Validaciones;
import vision2cloud.argon.model.RegistroCurso;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/visitavisitante")
public class VisitaVisitanteController {
    @Autowired
    @Qualifier("VisitaVisitanteService")
    VisitaVisitanteService visitaVisitanteService;

    @Autowired
    @Qualifier("Validaciones")
    Validaciones validaciones;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody VisitaVisitante visitaVisitante) {
        try {
            System.out.println("visitaVisitanteController");
            System.out.println(visitaVisitante.toString());
            //obtener datos que se enviarán a través del API
            ArrayList<String> respuesta = validaciones.TokenValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization"),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime")),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime")));
            //obtener datos que se enviarán a través del API
            String rolId = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("id");
            if(Boolean.parseBoolean(respuesta.get(0)) && (rolId.equals("1") || rolId.equals("2") || rolId.equals("3"))){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(visitaVisitanteService.create(visitaVisitante));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(VisitaVisitanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseEntity<?> getCursoss() {
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
                response.add(visitaVisitanteService.getVisitantesCursos());
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(VisitaVisitanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getByCodigo/{nit}",method = RequestMethod.GET)
    public ResponseEntity<?> getCursoByCodigo(@PathVariable("codigo") long id) {
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
                response.add(visitaVisitanteService.getVisitanteCursoById(id));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(VisitaVisitanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getByVisitante/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getByVisitanteId(@PathVariable("id") long id) {
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
                response.add(visitaVisitanteService.getByVisitanteId(id));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(VisitaVisitanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody VisitaVisitante visitaVisitante) {
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
                response.add(visitaVisitanteService.update(visitaVisitante));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(VisitaVisitanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/createMasive",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createMasive(@RequestBody ArrayList<RegistroCurso> visitantesCursos) {
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
                response.add(visitaVisitanteService.createMasive(visitantesCursos));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);

        } catch (Exception ex) {
            Logger.getLogger(VisitaVisitanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getByTime/{start}/{end}",method = RequestMethod.GET)
    public ResponseEntity<?> findBetween(@PathVariable("start") Long start, @PathVariable("end") Long end, @PathVariable("codigo") String codigo) {
        System.out.println("aassssdasfasfafasfa");
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
                response.add(visitaVisitanteService.findBetween(new Timestamp(start), new Timestamp(end)));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(HerramientaParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findByCreatedAtBetweenAndMarca/{start}/{end}/{codigo}",method = RequestMethod.GET)
    public ResponseEntity<?> findByCreatedAtBetweenAndMarca(@PathVariable("start") Long start, @PathVariable("end") Long end, @PathVariable("marca") String marca) {
        System.out.println("aassssdasfasfafasfa");
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
                response.add(visitaVisitanteService.findByCreatedAtBetweenAndMarca(new Timestamp(start), new Timestamp(end), marca));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(HerramientaParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getByTimeAndCurso/{start}/{end}/{codigo}",method = RequestMethod.GET)
    public ResponseEntity<?> findBetweenAndCurso(@PathVariable("start") Long start, @PathVariable("end") Long end, @PathVariable("codigo") String codigo) {
        System.out.println("aassssdasfasfafasfa");
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
                response.add(visitaVisitanteService.findBetweenAndCurso(new Timestamp(start), new Timestamp(end), codigo));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(HerramientaParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getByTimeAndTipoServicio/{start}/{end}/{codigo}",method = RequestMethod.GET)
    public ResponseEntity<?> findBetweenAndTipoServicio(@PathVariable("start") Long start, @PathVariable("end") Long end, @PathVariable("codigo") String codigo) {
        System.out.println("aassssdasfasfafasfa");
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
                response.add(visitaVisitanteService.findBetweenAndTipoServicio(new Timestamp(start), new Timestamp(end), codigo));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(HerramientaParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getByTimeAndEmpresa/{start}/{end}/{codigo}",method = RequestMethod.GET)
    public ResponseEntity<?> findBetweenAndEmpresa(@PathVariable("start") Long start, @PathVariable("end") Long end, @PathVariable("codigo") String codigo) {
        System.out.println("aassssdasfasfafasfa");
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
                response.add(visitaVisitanteService.findBetweenAndEmpresa(new Timestamp(start), new Timestamp(end), codigo));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(HerramientaParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getByTimeAndCursoForDash/{start}/{end}",method = RequestMethod.GET)
    public ResponseEntity<?> findBetweenAndCursoForDash(@PathVariable("start") Long start, @PathVariable("end") Long end) {
        System.out.println("aassssdasfasfafasfa");
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
                response.add(visitaVisitanteService.findBetweens(new Timestamp(start), new Timestamp(end)));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(HerramientaParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findBetweenServicios/{start}/{end}",method = RequestMethod.GET)
    public ResponseEntity<?> findBetweenServicios(@PathVariable("start") Long start, @PathVariable("end") Long end) {
        System.out.println("aassssdasfasfafasfa");
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
                response.add(visitaVisitanteService.findBetweenServicios(new Timestamp(start), new Timestamp(end)));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(HerramientaParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findBetweenCursos/{start}/{end}",method = RequestMethod.GET)
    public ResponseEntity<?> findBetweenCursos(@PathVariable("start") Long start, @PathVariable("end") Long end) {
        System.out.println("aassssdasfasfafasfa");
        try {
            //obtener datos que se enviarán a través del API
            ArrayList<String> respuesta =validaciones.TokenValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization"),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime")),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime")));
            //obtener datos que se enviarán a través del API
            String rolId = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("id");
            if(Boolean.parseBoolean(respuesta.get(0)) && (rolId.equals("1") || rolId.equals("2") || rolId.equals("3"))){
                // Convertir el timestamp a un objeto LocalDateTime
                Instant instantStart = Instant.ofEpochSecond(start);
                Instant instantEnd = Instant.ofEpochSecond(end);
                LocalDateTime startdateTime = LocalDateTime.ofInstant(instantStart, ZoneId.systemDefault());
                LocalDateTime enddateTime = LocalDateTime.ofInstant(instantEnd, ZoneId.systemDefault());
                startdateTime = startdateTime.withHour(0).withMinute(0).withSecond(0).withNano(0);
                enddateTime = enddateTime.withHour(0).withMinute(0).withSecond(0).withNano(0).plusDays(1);
                System.out.println("--------------------------------------------------datees--------------------------------------------");
                System.out.println(startdateTime);
                System.out.println(enddateTime);
                ArrayList<Object> response = new ArrayList<Object>();
                response.add(respuesta.get(1));
                response.add(visitaVisitanteService.findBetweenCursos(Timestamp.valueOf(startdateTime), Timestamp.valueOf(enddateTime)));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(HerramientaParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findDataBetween/{start}/{end}",method = RequestMethod.GET)
    public ResponseEntity<?> findDataBetween(@PathVariable("start") Long start, @PathVariable("end") Long end) {
        System.out.println("aassssdasfasfafasfa");
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
                response.add(visitaVisitanteService.findDataBetween(new Timestamp(start), new Timestamp(end)));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(HerramientaParticipanteController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
