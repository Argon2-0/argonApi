package vision2cloud.argon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.*;
import vision2cloud.argon.model.informes.*;
import vision2cloud.argon.model.zkt.Transaction;
import vision2cloud.argon.persistence.Impl.*;
import vision2cloud.argon.persistence.Impl.zkt.TransactionImpl;

import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;

@Service("VisitaVisitanteService")
public class VisitaVisitanteService {
    @Autowired
    @Qualifier("VisitaVisitaVisitanteImpl")
    VisitaVisitaVisitanteImpl visitaVisitanteImpl;
    @Autowired
    @Qualifier("ParticipanteImpl")
    ParticipanteImpl participanteImpl;
    @Autowired
    @Qualifier("CursoImpl")
    CursoImpl cursoImpl;
    @Autowired
    @Qualifier("TipoServicioImpl")
    TipoServicioImpl tipoServicioImpl;
    @Autowired
    @Qualifier("EmpresaImpl")
    EmpresaImpl empresaImpl;
    @Autowired
    @Qualifier("TransactionImpl")
    TransactionImpl transactionImpl;
    @Autowired
    @Qualifier("HerramientaParticipanteImpl")
    HerramientaParticipanteImpl herramientaParticipanteImpl;
    @Autowired
    @Qualifier("HerramientaImpl")
    HerramientaImpl herramientaImpl;

    public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public long unDiaEnMillis = 24 * 60 * 60 * 1000;

    public Object create(VisitaVisitante item) {
        return visitaVisitanteImpl.create(item);
    }

    public List<VisitaVisitante> getVisitantesCursos() {
        return visitaVisitanteImpl.getVisitantesCursos();
    }

    public VisitaVisitante getVisitanteCursoById(Long id) {
        return visitaVisitanteImpl.getVisitanteCursoById(id);
    }

    public VisitaVisitante getByVisitanteId(Long id) {
        return visitaVisitanteImpl.getByVisitanteId(id);
    }

    public Object update(VisitaVisitante item) {
        return visitaVisitanteImpl.update(item);
    }

    public Object createMasive(ArrayList<RegistroCurso> cursos) {
        ArrayList<VisitaVisitante> visitaVisitantes = new ArrayList<>();
        for (RegistroCurso registroCurso : cursos) {
            visitaVisitantes.add(
                    new VisitaVisitante(
                            participanteImpl.findByTipoDocumentoAndCedulaLike(registroCurso.getTipoDocumento(), registroCurso.getNumeroDocumento()).getId(),
                            new Curso(registroCurso.getCodigo()),
                            new TipoServicio(registroCurso.getTiposervicioId()),
                            new Empresa(registroCurso.getEmpresaNit()),
                            registroCurso.getFechaInicio(),
                            registroCurso.getFechaFin()
                    )
            );
        }
        return visitaVisitanteImpl.createMasive(visitaVisitantes);
    }

    public List<CursoInforme> findBetweenAndCurso(Timestamp start, Timestamp end, String codigo) throws URISyntaxException {
        List<VisitaVisitante> visitaVisitantes = new ArrayList<>();
        List<CursoInforme> cursoInforme = new ArrayList<>();
        List<Curso> cursos = new ArrayList<>();
        List<Transaction> transactions = new ArrayList<>();
        Participante participante = null;
        if (codigo.equals("Todos")) {
            cursos = cursoImpl.getCursos();
        } else {
            cursos.add(cursoImpl.findByCodigoLike(codigo));
        }
        for (Curso curso : cursos) {
            visitaVisitantes.addAll(visitaVisitanteImpl.findByCursoCodigoLikeAndDiaInicioBetweenOrDiaFinBetween(start, end, curso.getCodigo()));
        }
        for (Timestamp date = start; date.before(end) || date.equals(end); date.setTime(date.getTime() + unDiaEnMillis)) {
            for (VisitaVisitante vistante : visitaVisitantes) {
                // Verificar si la fecha está dentro de los límites de fechainicio y fechafin
                if (date.equals(vistante.getDiaInicio()) || (date.after(vistante.getDiaInicio()) && date.before(vistante.getDiaFin())) || date.equals(vistante.getDiaFin())) {
                    // La fecha está dentro del rango de fechas de la visita

                    participante = participanteImpl.getParticipanteById(vistante.getVisitanteId());
                    transactions = transactionImpl.get(vistante.getVisitanteId().toString(), dateFormat.format(date), dateFormat.format(date.getTime() + unDiaEnMillis));
                    if(!transactions.isEmpty()) {
                        cursoInforme.add(
                                new CursoInforme(
                                        participante.getTipoDocumento(),
                                        participante.getCedula(),
                                        participante.getNombres(),
                                        participante.getApellidos(),
                                        participante.getCelular(),
                                        participante.getEmail(),
                                        vistante.getCurso().getCodigo(),
                                        vistante.getCurso().getNombre(),
                                        transactions.get(transactions.size() - 1).getEventTime(),
                                        participante.getTratDatos()
                                )
                        );
                    }

                } else {
                    // La fecha no está dentro del rango de fechas de la visita
                    System.out.println("Fecha " + date + " NO está dentro del rango de la visita.");
                }
            }
        }

        return cursoInforme;
    }

    public List<TipoServicioInforme> findBetweenAndTipoServicio(Timestamp start, Timestamp end, String codigo) throws URISyntaxException {
        List<VisitaVisitante> visitaVisitantes = new ArrayList<>();
        List<TipoServicioInforme> tipoServicioInforme = new ArrayList<>();
        List<TipoServicio> tiposServicio = new ArrayList<>();
        List<Transaction> transactions = new ArrayList<>();
        Participante participante = null;
        if (codigo.equals("Todos")) {
            tiposServicio = tipoServicioImpl.getTiposServicios();
        } else {
            tiposServicio.add(tipoServicioImpl.getTipoServicioById(Long.parseLong(codigo)));
        }
        for (TipoServicio tipoServicio : tiposServicio) {
            visitaVisitantes.addAll(visitaVisitanteImpl.findByTipoServicioLikeAndDiaInicioBetweenOrDiaFinBetween(start, end, tipoServicio.getId()));
        }
        for (Timestamp date = start; date.before(end) || date.equals(end); date.setTime(date.getTime() + unDiaEnMillis)) {
            for (VisitaVisitante vistante : visitaVisitantes) {
                // Verificar si la fecha está dentro de los límites de fechainicio y fechafin
                if (date.equals(vistante.getDiaInicio()) || (date.after(vistante.getDiaInicio()) && date.before(vistante.getDiaFin())) || date.equals(vistante.getDiaFin())) {
                    // La fecha está dentro del rango de fechas de la visita

                    participante = participanteImpl.getParticipanteById(vistante.getVisitanteId());
                    transactions = transactionImpl.get(vistante.getVisitanteId().toString(), dateFormat.format(date), dateFormat.format(date.getTime() + unDiaEnMillis));
                    if(!transactions.isEmpty()) {
                        tipoServicioInforme.add(
                                new TipoServicioInforme(
                                        participante.getTipoDocumento(),
                                        participante.getCedula(),
                                        participante.getNombres(),
                                        participante.getApellidos(),
                                        participante.getCelular(),
                                        participante.getEmail(),
                                        vistante.getTiposervicio().getNombre(),
                                        vistante.getTiposervicio().getDescripcion(),
                                        transactions.get(transactions.size() - 1).getEventTime(),
                                        participante.getTratDatos()
                                )
                        );
                    }

                } else {
                    // La fecha no está dentro del rango de fechas de la visita
                    System.out.println("Fecha " + date + " NO está dentro del rango de la visita.");
                }
            }
        }
        return tipoServicioInforme;
    }

    public List<EmpresaInforme> findBetweenAndEmpresa(Timestamp start, Timestamp end, String codigo) throws URISyntaxException {
        List<VisitaVisitante> visitaVisitantes = new ArrayList<>();
        List<EmpresaInforme> empresaInforme = new ArrayList<>();
        List<Empresa> empresas = new ArrayList<>();
        List<Transaction> transactions = new ArrayList<>();
        Participante participante = null;
        if (codigo.equals("Todos")) {
            empresas = empresaImpl.getEmpresas();
        } else {
            empresas.add(empresaImpl.getEmpresaByNit(codigo));
        }
        for (Empresa empresa : empresas) {
            visitaVisitantes.addAll(visitaVisitanteImpl.findByEmpesaLikeAndDiaInicioBetweenOrDiaFinBetween(start, end, empresa.getNit()));
        }
        for (Timestamp date = start; date.before(end) || date.equals(end); date.setTime(date.getTime() + unDiaEnMillis)) {
            for (VisitaVisitante vistante : visitaVisitantes) {
                // Verificar si la fecha está dentro de los límites de fechainicio y fechafin
                if (date.equals(vistante.getDiaInicio()) || (date.after(vistante.getDiaInicio()) && date.before(vistante.getDiaFin())) || date.equals(vistante.getDiaFin())) {
                    // La fecha está dentro del rango de fechas de la visita

                    participante = participanteImpl.getParticipanteById(vistante.getVisitanteId());
                    transactions = transactionImpl.get(vistante.getVisitanteId().toString(), dateFormat.format(date), dateFormat.format(date.getTime() + unDiaEnMillis));
                    if(!transactions.isEmpty()) {
                        empresaInforme.add(
                                new EmpresaInforme(
                                        participante.getTipoDocumento(),
                                        participante.getCedula(),
                                        participante.getNombres(),
                                        participante.getApellidos(),
                                        participante.getCelular(),
                                        participante.getEmail(),
                                        vistante.getEmpresa().getNit(),
                                        vistante.getEmpresa().getNombre(),
                                        transactions.get(transactions.size() - 1).getEventTime(),
                                        participante.getTratDatos()
                                )
                        );

                    }

                } else {
                    // La fecha no está dentro del rango de fechas de la visita
                    System.out.println("Fecha " + date + " NO está dentro del rango de la visita.");
                }
            }
        }
        return empresaInforme;
    }

    public List<ReportesInforme> findBetween(Timestamp start, Timestamp end) throws URISyntaxException {
        List<VisitaVisitante> visitaVisitantes = visitaVisitanteImpl.findByDiaInicioBetweenOrDiaFinBetween(start, end);
        List<ReportesInforme> reportesInforme = new ArrayList<>();
        List<Transaction> transactions = new ArrayList<>();
        Participante participante = null;
        for (Timestamp date = start; date.before(end) || date.equals(end); date.setTime(date.getTime() + unDiaEnMillis)) {
            for (VisitaVisitante vistante : visitaVisitantes) {
                // Verificar si la fecha está dentro de los límites de fechainicio y fechafin
                if (date.equals(vistante.getDiaInicio()) || (date.after(vistante.getDiaInicio()) && date.before(vistante.getDiaFin())) || date.equals(vistante.getDiaFin())) {
                    // La fecha está dentro del rango de fechas de la visita

                    participante = participanteImpl.getParticipanteById(vistante.getVisitanteId());
                    transactions = transactionImpl.get(vistante.getVisitanteId().toString(), dateFormat.format(date), dateFormat.format(date.getTime() + unDiaEnMillis));
                    if(!transactions.isEmpty()) {
                        reportesInforme.add(
                                new ReportesInforme(
                                        participante.getTipoDocumento(),
                                        participante.getCedula(),
                                        participante.getNombres(),
                                        participante.getApellidos(),
                                        participante.getCelular(),
                                        participante.getEmail(),
                                        vistante.getEmpresa().getNit(),
                                        vistante.getEmpresa().getNombre(),
                                        vistante.getCurso().getCodigo(),
                                        vistante.getCurso().getNombre(),
                                        vistante.getTiposervicio().getNombre(),
                                        vistante.getTiposervicio().getDescripcion(),
                                        transactions.get(transactions.size() - 1).getEventTime(),
                                        transactions.get(transactions.size() - 1).getEventPointName(),
                                        participante.getTratDatos()
                                )
                        );
                    }

                } else {
                    // La fecha no está dentro del rango de fechas de la visita
                    System.out.println("Fecha " + date + " NO está dentro del rango de la visita.");
                }
            }
        }
        return reportesInforme;
    }

    public List<PrestamosInforme> findByCreatedAtBetweenAndMarca(Timestamp start, Timestamp end, String marca) throws URISyntaxException {
        List<Herramienta> herramientas = new ArrayList<>();
        List<PrestamosInforme> prestamosInforme = new ArrayList<>();
        List<Transaction> transactions = new ArrayList<>();
        Participante participante = null;
        if (marca.equals("Todos")) {
            herramientas = herramientaImpl.getHerramientas();
        } else {
            herramientas = herramientaImpl.findByMarca(marca);
        }
        List<HerramientaParticipante> herramientasParticipantes = new ArrayList<>(herramientaParticipanteImpl.findByCreatedAtBetweenAndMarca(start, end, herramientas));

        for (HerramientaParticipante herramientaParticipante : herramientasParticipantes) {

            participante = participanteImpl.getParticipanteById(herramientaParticipante.getParticipante().getId());
            prestamosInforme.add(
                    new PrestamosInforme(
                            participante.getTipoDocumento(),
                            participante.getCedula(),
                            participante.getNombres(),
                            participante.getApellidos(),
                            participante.getCelular(),
                            participante.getEmail(),
                            herramientaParticipante.getHerramienta().getMarca(),
                            herramientaParticipante.getHerramienta().getNombre(),
                            herramientaParticipante.getHerramienta().getCodigoBarras(),
                            herramientaParticipante.getObservacionEntrada(),
                            herramientaParticipante.getObservacionSalida(),
                            herramientaParticipante.getEstado(),
                            herramientaParticipante.getCreatedAt(),
                            herramientaParticipante.getUpdatedAt()
                    )
            );

        }


        return prestamosInforme;


    }

    public List<Object> findBetweens(Timestamp startTime, Timestamp endTime) {
        List<Curso> cursos = cursoImpl.getCursos();
        LocalDateTime localDateTimeStart = startTime.toLocalDateTime();
        // Establecer la hora al inicio del día (medianoche)
        LocalDateTime start = localDateTimeStart.with(LocalTime.MIN);
        // Convertir el LocalDateTime de nuevo a Timestamp
        Timestamp startTimestamp = Timestamp.valueOf(start);
        // Convertir el Timestamp a LocalDateTime
        LocalDateTime localDateTimeEnd = endTime.toLocalDateTime();
        // Establecer la hora al inicio del día (medianoche)
        LocalDateTime end = localDateTimeEnd.with(LocalTime.MIN).plusDays(1);
        // Convertir el LocalDateTime de nuevo a Timestamp
        Timestamp endTimestamp = Timestamp.valueOf(end);
        List<Object> response = new ArrayList<Object>();
        List<String> servicios = new ArrayList<String>();
        List<Integer> cantidad = new ArrayList<Integer>();
        Integer cuantos;
        for (Curso curso : cursos) {
            System.out.println(curso.getCodigo());
            List<VisitaVisitante> visitaVisitantes = visitaVisitanteImpl.findByCursoCodigoLikeAndDiaInicioBetweenOrDiaFinBetween(startTimestamp, endTimestamp, curso.getCodigo());
            cuantos = visitaVisitantes.size();
            System.out.println(visitaVisitantes.size());
            servicios.add(curso.getNombre() + ": " + cuantos);
            cantidad.add(cuantos);
        }
        response.add(servicios);
        response.add(cantidad);
        return response;
    }

    public List<Object> findBetweenServicios(Timestamp start, Timestamp end) throws URISyntaxException {
        List<VisitaVisitante> visitaVisitantes = new ArrayList<>();
        List<TipoServicio> tiposServicio = tipoServicioImpl.getTiposServicios();
        List<Object> response = new ArrayList<Object>();
        HashMap<String, Integer> serviciosCantidad = new HashMap<String, Integer>();
        List<Transaction> transactions = new ArrayList<>();
        LocalDate timestampDateStart = start.toLocalDateTime().toLocalDate();
        LocalDate timestampDateEnd = end.toLocalDateTime().toLocalDate();
        LocalDate today = LocalDate.now();
        for (TipoServicio tipoServicio : tiposServicio) {
            visitaVisitantes.addAll(visitaVisitanteImpl.findByTipoServicioLikeAndDiaInicioBetweenOrDiaFinBetween(start, end, tipoServicio.getId()));
        }
        for (Timestamp date = start; date.before(end) || date.equals(end); date.setTime(date.getTime() + unDiaEnMillis)) {
            for (VisitaVisitante vistante : visitaVisitantes) {
                // Verificar si la fecha está dentro de los límites de fechainicio y fechafin
                if (date.equals(vistante.getDiaInicio()) || (date.after(vistante.getDiaInicio()) && date.before(vistante.getDiaFin())) || date.equals(vistante.getDiaFin())) {
                    // La fecha está dentro del rango de fechas de la visita
                    transactions = transactionImpl.get(vistante.getVisitanteId().toString(), dateFormat.format(date), dateFormat.format(date.getTime() + unDiaEnMillis));
                    if(!transactions.isEmpty()) {
                        if ((serviciosCantidad.containsKey(vistante.getTiposervicio().getNombre()) &&
                                ((today.isEqual(timestampDateStart) && today.isEqual(timestampDateEnd) && transactions.get(1).getEventPointName().contains("Entrada")) ||
                                !today.isEqual(timestampDateStart) || !today.isEqual(timestampDateEnd)))) {
                            serviciosCantidad.put(vistante.getTiposervicio().getNombre(), serviciosCantidad.get(vistante.getTiposervicio().getNombre())+1);
                        }else {
                            if((today.isEqual(timestampDateStart) && today.isEqual(timestampDateEnd) && transactions.get(1).getEventPointName().contains("Entrada")) ||
                                    !today.isEqual(timestampDateStart) || !today.isEqual(timestampDateEnd)){
                                serviciosCantidad.put(vistante.getTiposervicio().getNombre(),1);
                            }
                        }
                    }
                } else {
                    // La fecha no está dentro del rango de fechas de la visita
                    System.out.println("Fecha " + date + " NO está dentro del rango de la visita.");
                }
            }
        }

        List<String> servicios = new ArrayList<>(serviciosCantidad.keySet());
        List<Integer> cantidad = new ArrayList<>(serviciosCantidad.values());
        for (int i=0; i<servicios.size(); i++){
            servicios.set(i, servicios.get((i))+": "+cantidad.get(i));
        }
        response.add(servicios);
        response.add(cantidad);

        return response;
    }

    public List<Object> findBetweenCursos(Timestamp start, Timestamp end) throws URISyntaxException {
        List<VisitaVisitante> visitaVisitantes = new ArrayList<>();
        List<Curso> cursos = cursoImpl.getCursos();
        List<Object> response = new ArrayList<Object>();
        HashMap<String, Integer> cursosCantidad = new HashMap<String, Integer>();

        List<Transaction> transactions = new ArrayList<>();
        LocalDate timestampDateStart = start.toLocalDateTime().toLocalDate();
        LocalDate timestampDateEnd = end.toLocalDateTime().toLocalDate();
        LocalDate today = LocalDate.now();

        System.out.println("---------------------------------------------------Cursos--------------------------------------------------------");
        for (Curso curso : cursos) {
            System.out.println(curso.toString());
            visitaVisitantes.addAll(visitaVisitanteImpl.findByCursoCodigoLikeAndDiaInicioBetweenOrDiaFinBetween(start, end, curso.getCodigo()));
        }

        for (Timestamp date = start; date.before(end) || date.equals(end); date.setTime(date.getTime() + unDiaEnMillis)) {
            System.out.println("---------------------------------------------------VisitaVisitantes--------------------------------------------------------");
            for (VisitaVisitante vistante : visitaVisitantes) {
                System.out.println(vistante.toString());
                // Verificar si la fecha está dentro de los límites de fechainicio y fechafin
                if (date.equals(vistante.getDiaInicio()) || (date.after(vistante.getDiaInicio()) && date.before(vistante.getDiaFin())) || date.equals(vistante.getDiaFin())) {
                    System.out.println("---------------------------------------------------DateIn--------------------------------------------------------");
                    // La fecha está dentro del rango de fechas de la visita
                    transactions = transactionImpl.get(vistante.getVisitanteId().toString(), dateFormat.format(date), dateFormat.format(date.getTime() + unDiaEnMillis));
                    if(!transactions.isEmpty()) {
                        System.out.println("---------------------------------------------------TransNotEmpty--------------------------------------------------------");
                        System.out.println(cursosCantidad.containsKey(vistante.getTiposervicio().getNombre()));
                        System.out.println(today.isEqual(timestampDateStart));
                        System.out.println(today.isEqual(timestampDateEnd));
                        System.out.println(transactions.get(1).getEventPointName().contains("Entrada"));
                        if ((cursosCantidad.containsKey(vistante.getTiposervicio().getNombre()) &&
                                ((today.isEqual(timestampDateStart) && today.isEqual(timestampDateEnd) && transactions.get(1).getEventPointName().contains("Entrada")) ||
                                        !today.isEqual(timestampDateStart) || !today.isEqual(timestampDateEnd)))) {
                            cursosCantidad.put(vistante.getCurso().getNombre(), cursosCantidad.get(vistante.getCurso().getNombre())+1);
                        }else {
                            if((today.isEqual(timestampDateStart) && today.isEqual(timestampDateEnd) && transactions.get(1).getEventPointName().contains("Entrada")) ||
                                    !today.isEqual(timestampDateStart) || !today.isEqual(timestampDateEnd)){
                                cursosCantidad.put(vistante.getCurso().getNombre(),1);
                            }
                        }
                    }
                } else {
                    // La fecha no está dentro del rango de fechas de la visita
                    System.out.println("Fecha " + date + " NO está dentro del rango de la visita.");
                }
            }
        }

        System.out.println("---------------------------------------------------KeySet--------------------------------------------------------");
        List<String> servicios = new ArrayList<>(cursosCantidad.keySet());
        System.out.println("---------------------------------------------------Values--------------------------------------------------------");
        List<Integer> cantidad = new ArrayList<>(cursosCantidad.values());
        for (int i=0; i<servicios.size(); i++){
            servicios.set(i, servicios.get((i))+": "+cantidad.get(i));
        }
        System.out.println("---------------------------------------------------Servicios--------------------------------------------------------");
        response.add(servicios);
        System.out.println("---------------------------------------------------Cantidad--------------------------------------------------------");
        response.add(cantidad);

        return response;
    }

    public List<Integer> findDataBetween(Timestamp start, Timestamp end) throws URISyntaxException {
        List<Integer> response = new ArrayList<>(Arrays.asList(0,0));
        List<Transaction> transactions = new ArrayList<>();
        List<VisitaVisitante> visitaVisitantes = new ArrayList<>(visitaVisitanteImpl.findByDiaInicioBetweenOrDiaFinBetween(start, end));
        for (Timestamp date = start; date.before(end) || date.equals(end); date.setTime(date.getTime() + unDiaEnMillis)) {
            for (VisitaVisitante vistante : visitaVisitantes) {
                // Verificar si la fecha está dentro de los límites de fechainicio y fechafin
                if (date.equals(vistante.getDiaInicio()) || (date.after(vistante.getDiaInicio()) && date.before(vistante.getDiaFin())) || date.equals(vistante.getDiaFin())) {
                    // La fecha está dentro del rango de fechas de la visita
                    transactions = transactionImpl.get(vistante.getVisitanteId().toString(), dateFormat.format(date), dateFormat.format(date.getTime() + unDiaEnMillis));
                    if(!transactions.isEmpty()) {
                        response.set(0, response.get(0)+1);
                        for(Transaction transaction: transactions){
                            if(transaction.getEventPointName().contains("Entrada")){
                                response.set(1, response.get(1)+1);
                            }
                        }
                    }
                } else {
                    // La fecha no está dentro del rango de fechas de la visita
                    System.out.println("Fecha " + date + " NO está dentro del rango de la visita.");
                }
            }
        }

        return response;
    }
}
