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
import vision2cloud.argon.model.Empresa;
import vision2cloud.argon.service.EmpresaService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/accessbiosecurity/empresa")
public class EmpresaController {
    @Autowired
    @Qualifier("EmpresaService")
    EmpresaService empresaService;

    @Autowired
    @Qualifier("Validaciones")
    Validaciones validaciones;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Empresa empresa) {
        try {
            //obtener datos que se enviarán a través del API
            ArrayList<String> respuesta = validaciones.TokenValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization"),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime")),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime")));
            //obtener datos que se enviarán a través del API
            String rolId = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("id");
            if(Boolean.parseBoolean(respuesta.get(0)) && (rolId.equals("1") || rolId.equals("2") || rolId.equals("3"))){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(empresaService.create(empresa));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseEntity<?> getEmpresas() {
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
                response.add(empresaService.getEmpresas());
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAllByDisponible/{estado}",method = RequestMethod.GET)
    public ResponseEntity<?> getEmpresasByDisponible(@PathVariable("estado") String estado) {
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
            String rolId = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("id");
            if((Boolean.parseBoolean(respuesta.get(0)) && (rolId.equals("1") || rolId.equals("2") || rolId.equals("3")))|| ipautorizada){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add(respuesta.get(1));
                response.add(empresaService.getEmpresasByDisponible(estado));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getByNit/{nit}",method = RequestMethod.GET)
    public ResponseEntity<?> getEmpresaById(@PathVariable("nit") String nit) {
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
                response.add(empresaService.getEmpresaByNit(nit));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Empresa empresa) {
        try {
            //obtener datos que se enviarán a través del API
            ArrayList<String> respuesta =validaciones.TokenValidation(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization"),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("LastTime")),
                    Long.valueOf(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("CurrentTime")));
            //obtener datos que se enviarán a través del API
            String rolId = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("id");
            if(Boolean.parseBoolean(respuesta.get(0)) && (rolId.equals("1") || rolId.equals("2") || (rolId.equals("3") && empresaService.getEmpresaByNit(empresa.getNit()).getDisponible().equals(empresa.getDisponible())))){
                ArrayList<Object> response = new ArrayList<Object>();
                response.add( respuesta.get(1));
                response.add(empresaService.update(empresa));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/createMasive",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createMasive(@RequestBody ArrayList<Empresa> empresa) {
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
                response.add(empresaService.createMasive(empresa));
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<>("Unauthorized",HttpStatus.FORBIDDEN);

        } catch (Exception ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
