package py.com.nsa.cortesia.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.com.nsa.cortesia.model.params.CortesiaInsReq;
import py.com.nsa.cortesia.model.params.CortesiaListReq;
import py.com.nsa.cortesia.model.params.CortesiaUpdReq;
import py.com.nsa.cortesia.service.CortesiaService;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import java.util.Date;

import static py.com.nsa.cortesia.util.Constants.API_BASE_URL;

@RestController
@RequestMapping(API_BASE_URL)
public class cortesiaResourse {
    private static final Logger logger = LoggerFactory.getLogger(cortesiaResourse.class);

    @Autowired
    private CortesiaService servi;

    @GetMapping("/listCortesia")
    private ResponseEntity<?> listCortesia(@QueryParam("fechaIni") String fechaIni,
                                           @QueryParam("fechaFin") String fechaFin,
                                           @QueryParam("nroCortesia") Long nroCortesia,
                                           @QueryParam("codEmpleado") Integer codEmpleado,
                                           @QueryParam("codUsuarioGraba") Integer codUsuarioGraba) {
         logger.info("===> Filters={}", nroCortesia, codUsuarioGraba, codEmpleado, fechaIni, fechaFin);
         CortesiaListReq req = new CortesiaListReq();
         req.setFechaIni(fechaIni);
         req.setFechaFin(fechaFin);
         req.setNroCortesia(nroCortesia);
         req.setCodEmpleado(codEmpleado);
         req.setCodUsuarioGraba(codUsuarioGraba);

         return ResponseEntity.ok(servi.lisCortesia(req));
     }

    @GetMapping("/maxCortesia")
    private ResponseEntity<?> listMaxCortesia() {
        return ResponseEntity.ok(servi.naxCortesia());
    }

    @PostMapping ("/insCortesia")
    private ResponseEntity<?> insCortesia(@QueryParam("nroCortesia") Long nroCortesia, @QueryParam("identificador") String identificador,
                                          @QueryParam("docViajante") String docViajante, @QueryParam("nombreViajante") String nombreViajante,
                                          @QueryParam("observacion") String observacion, @QueryParam("fechaGraba") Date fechaGraba,
                                          @QueryParam("porcentajeDesc") Integer porcentajeDesc, @QueryParam("codEmpleado") Integer codEmpleado,
                                          @QueryParam("codAgencia") Integer codAgencia, @QueryParam("codCargo") Integer codCargo,
                                          @QueryParam("codServicioBuses") Integer codServicioBuses, @QueryParam("codRutaIda") Integer codRutaIda,
                                          @QueryParam("getCodRutaVuelta") Integer getCodRutaVuelta, @QueryParam("codUsuarioGraba") Integer codUsuarioGraba,
                                          @QueryParam("fechaViaje") Date fechaViaje, @QueryParam("impreso") String impreso,
                                          @QueryParam("cantPasaje") Integer cantPasaje, @QueryParam("solicitanteExterno") String solicitanteExterno) {
        CortesiaInsReq req = new CortesiaInsReq();
        req.setNroCortesia(nroCortesia);
        req.setIdentificador(identificador);
        req.setDocViajante(docViajante);
        req.setNombreViajante(nombreViajante);
        req.setObservacion(observacion);
        req.setFechaGraba(fechaGraba);
        req.setPorcentajeDesc(porcentajeDesc);
        req.setCodEmpleado(codEmpleado);
        req.setCodAgencia(codAgencia);
        req.setCodCargo(codCargo);
        req.setCodServicioBuses(codServicioBuses);
        req.setCodRutaIda(codRutaIda);
        req.setCodRutaVuelta(getCodRutaVuelta);
        req.setCodUsuarioGraba(codUsuarioGraba);
        req.setFechaViaje(fechaViaje);
        req.setImpreso(impreso);
        req.setCantPasaje(cantPasaje);
        req.setSolicitanteExterno(solicitanteExterno);
        logger.info("===> Filters CortesiaResourse Ins 1 ={}", req);
        return ResponseEntity.ok(servi.insCortesia(req));
    }


    @PutMapping ("/updCortesia")
    private ResponseEntity<?> updCortesia(@QueryParam("nroCortesia") Long nroCortesia, @QueryParam("docViajante") String docViajante,
                                          @QueryParam("nombreViajante") String nombreViajante, @QueryParam("observacion") String observacion,
                                          @QueryParam("porcentajeDesc") Integer porcentajeDesc, @QueryParam("codServicioBuses") Integer codServicioBuses,
                                          @QueryParam("codRutaIda") Integer codRutaIda, @QueryParam("getCodRutaVuelta") Integer getCodRutaVuelta,
                                          @QueryParam("fechaViaje") Date fechaViaje, @QueryParam("impreso") String impreso,
                                          @QueryParam("cantPasaje") Integer cantPasaje, @QueryParam("solicitanteExterno") String solicitanteExterno){
        CortesiaUpdReq req = new CortesiaUpdReq();
        req.setNroCortesia(nroCortesia);
        req.setDocViajante(docViajante);
        req.setNombreViajante(nombreViajante);
        req.setObservacion(observacion);
        req.setPorcentajeDesc(porcentajeDesc);
        req.setCodServicioBuses(codServicioBuses);
        req.setCodRutaIda(codRutaIda);
        req.setCodRutaVuelta(getCodRutaVuelta);
        req.setFechaViaje(fechaViaje);
        req.setImpreso(impreso);
        req.setCantPasaje(cantPasaje);
        req.setSolicitanteExterno(solicitanteExterno);
        logger.info("===> Filters CortesiaResourse Upd 1 ={}", req);
        return ResponseEntity.ok(servi.updCortesia(req)); }


    @PostMapping ("/delCortesia")
    private ResponseEntity<?> delCortesia(@QueryParam("nroCortesia") Long nroCortesia) {
        return ResponseEntity.ok(servi.delCortesia(nroCortesia));
    }
}
