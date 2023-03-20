package py.com.nsa.cortesia.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.nsa.cortesia.controller.cortesiaResourse;
import py.com.nsa.cortesia.model.Cortesia;
import py.com.nsa.cortesia.model.params.CortesiaInsReq;
import py.com.nsa.cortesia.model.params.CortesiaListReq;
import py.com.nsa.cortesia.model.params.CortesiaUpdReq;
import py.com.nsa.cortesia.repository.mapper.CortesiaMapper;

import java.util.List;

@Service
public class CortesiaService {
    private static final Logger logger = LoggerFactory.getLogger(cortesiaResourse.class);

    @Autowired
    private final CortesiaMapper cortesia;

    public CortesiaService(CortesiaMapper cortesia) {
        this.cortesia = cortesia;

    }

    public List<Cortesia> lisCortesia(CortesiaListReq req) {
        return cortesia.selectByCortesia(req);
    }

    public Long naxCortesia() {
        return cortesia.selectByMaxCortesia();
    }

    public int insCortesia(CortesiaInsReq req) {
        CortesiaInsReq record = new CortesiaInsReq();
        //RECUPERAMOS EL MAX DE NRO DE CORTESIA
        Long nroC = cortesia.selectByMaxCortesia();

        //CARGAMOS LAS VARIABLES EN EL NUEVO ARRAY
        record.setNroCortesia(nroC);
        record.setIdentificador(req.getIdentificador());
        record.setDocViajante(req.getDocViajante());
        record.setNombreViajante(req.getNombreViajante());
        record.setObservacion(req.getObservacion());
        record.setFechaGraba(req.getFechaGraba());
        record.setPorcentajeDesc(req.getPorcentajeDesc());
        record.setCodEmpleado(req.getCodEmpleado());
        record.setCodAgencia(req.getCodAgencia());
        record.setCodCargo(req.getCodCargo());
        record.setCodServicioBuses(req.getCodServicioBuses());
        record.setCodRutaIda(req.getCodRutaIda());
        record.setCodRutaVuelta(req.getCodRutaVuelta());
        record.setCodUsuarioGraba(req.getCodUsuarioGraba());
        record.setFechaViaje(req.getFechaViaje());
        record.setImpreso(req.getImpreso());
        record.setCantPasaje(req.getCantPasaje());
        record.setSolicitanteExterno(req.getSolicitanteExterno());
        logger.info("===> Filters CortesiaService Ins 2 ={}", record);
        return cortesia.insByCortesia(record);
    }

    public int updCortesia(CortesiaUpdReq req) {
         logger.info("===> Filters CortesiaService Upd 2 ={}", req);
        return cortesia.updByCortesia(req);
    }


    public int delCortesia(Long nroCortesia) { return cortesia.delByCortesia(nroCortesia); }

}
