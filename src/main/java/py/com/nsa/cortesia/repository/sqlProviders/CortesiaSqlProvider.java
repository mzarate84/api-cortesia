package py.com.nsa.cortesia.repository.sqlProviders;

import org.apache.ibatis.jdbc.SQL;
import py.com.nsa.cortesia.model.params.CortesiaInsReq;
import py.com.nsa.cortesia.model.params.CortesiaListReq;
import py.com.nsa.cortesia.model.params.CortesiaUpdReq;


public class CortesiaSqlProvider {

    public String selectByCortesia (CortesiaListReq filtro) {

        SQL sql = new SQL();
        sql.SELECT("c.nro_cortesia, c.identificador, c.documento_viajante, c.observacion, c.fecha_grabacion,\n" +
                "c.confirmacion, c.fecha_confirmacion, c.porcentaje_des, c.fecha_autorizacion, c.cod_empleado,\n" +
                "c.cod_agencia, c.cod_cargo, c.cod_servicio_buses, c.cod_ruta_ida, c.cod_ruta_vuelta, \n" +
                "c.cod_usuario_grabacion, c.cod_usuario_autoriza, c.fecha_viaje, c.impreso, c.nro_impresion,\n" +
                "c.cantidad_pasaje, c.solicitante_externo, c.fecha_modifi, c.fecha_anulacion, c.cod_usuario_modifi,\n" +
                "c.cod_usuario_anulacion FROM cortesia c");

        if (filtro.getFechaIni()!= null) {
            sql.WHERE("c.fecha_grabacion >= to_date(#{fechaIni}, 'yyyymmdd hh24:mi:ss')");
        }
        if (filtro.getFechaFin() != null) {
            sql.WHERE("c.fecha_grabacion <= to_date(#{fechaFin}, 'yyyymmdd hh24:mi:ss')");
        }
        if (filtro.getNroCortesia() != null) {
            sql.WHERE("c.nro_cortesia = #{nroCortesia}");
        }
        if (filtro.getCodEmpleado() != null) {
            sql.WHERE("c.cod_empleado = #{codEmpleado}");
        }
        if (filtro.getCodUsuarioGraba() != null) {
            sql.WHERE("c.cod_usuario_grabacion = #{codUsuarioGraba}");
        }

        return sql.toString();
    }

    public String insByCortesia(CortesiaInsReq record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("NSA.CORTESIA");

        if (record.getNroCortesia()!= null) {
            sql.VALUES("nro_cortesia", "#{record.nroCortesia,jdbcType=DECIMAL}");
        }
        if (record.getIdentificador() != null) {
            sql.VALUES("identificador", "#{record.identificador,jdbcType=VARCHAR}");
        }
        if (record.getDocViajante() != null) {
            sql.VALUES("documento_viajante", "#{record.docViajante,jdbcType=VARCHAR}");
        }
        if (record.getNombreViajante() != null) {
            sql.VALUES("nombre_viajante", "#{record.nombreViajante,jdbcType=VARCHAR}");
        }
        if (record.getObservacion() != null) {
            sql.VALUES("observacion", "#{record.observacion,jdbcType=VARCHAR}");
        }
        if (record.getFechaGraba() != null) {
            sql.VALUES("fecha_grabacion", "#{record.fechaGraba,jdbcType=TIMESTAMP}");
        }
        if (record.getConfirmacion() != null) {
            sql.VALUES("confirmacion", "#{record.confirmacion,jdbcType=VARCHAR}");
        }
        if (record.getFechaConfirmacion() != null) {
            sql.VALUES("fecha_confirmacion", "#{record.fechaConfirmacion,jdbcType=TIMESTAMP}");
        }
        if (record.getPorcentajeDesc() != null) {
            sql.VALUES("porcentaje_des", "#{record.porcentajeDesc,jdbcType=DECIMAL}");
        }
        if (record.getFechaAutorizacion() != null) {
            sql.VALUES("fecha_autorizacion", "#{record.fechaAutorizacion,jdbcType=TIMESTAMP}");
        }
        if (record.getCodEmpleado() != null) {
            sql.VALUES("cod_empleado", "#{record.codEmpleado,jdbcType=DECIMAL}");
        }
        if (record.getCodAgencia() != null) {
            sql.VALUES("cod_agencia", "#{record.codAgencia,jdbcType=DECIMAL}");
        }
        if (record.getCodCargo() != null) {
            sql.VALUES("codCargo", "#{record.cod_cargo,jdbcType=DECIMAL}");
        }
        if (record.getCodServicioBuses() != null) {
            sql.VALUES("cod_servicio_buses", "#{record.codServicioBuses,jdbcType=DECIMAL}");
        }
        if (record.getCodRutaIda() != null) {
            sql.VALUES("cod_ruta_ida", "#{record.codRutaIda,jdbcType=DECIMAL}");
        }
        if (record.getCodRutaVuelta()!= null) {
            sql.VALUES("cod_ruta_vuelta", "#{record.CodRutaVuelta,jdbcType=DECIMAL}");
        }
        if (record.getCodUsuarioGraba() != null) {
            sql.VALUES("cod_usuario_grabacion", "#{record.codUsuarioGraba,jdbcType=DECIMAL}");
        }
        if (record.getCodUsuarioAutoriza() != null) {
            sql.VALUES("cod_usuario_autoriza", "#{record.codUsuarioAutoriza,jdbcType=DECIMAL}");
        }
        if (record.getFechaViaje() != null) {
            sql.VALUES("fecha_viaje", "#{record.fechaViaje,jdbcType=TIMESTAMP}");
        }
        if (record.getImpreso() != null) {
            sql.VALUES("impreso", "#{record.impreso,jdbcType=VARCHAR}");
        }
        if (record.getNroImpresion() != null) {
            sql.VALUES("nro_impresion", "#{record.nroImpresion,jdbcType=DECIMAL}");
        }
        if (record.getCantPasaje() != null) {
            sql.VALUES("cantidad_pasaje", "#{record.cantPasaje,jdbcType=DECIMAL}");
        }
        if (record.getSolicitanteExterno() != null) {
            sql.VALUES("solicitante_externo", "#{record.solicitanteExterno,jdbcType=VARCHAR}");
        }
        if (record.getFechaModifi()!= null) {
            sql.VALUES("fecha_modifi", "#{record.fechaModifi,jdbcType=TIMESTAMP}");
        }
        if (record.getFechaAnula() != null) {
            sql.VALUES("fecha_anulacion", "#{record.fechaAnula,jdbcType=TIMESTAMP}");
        }
        if (record.getCodUsuarioModifi() != null) {
            sql.VALUES("cod_usuario_modifi", "#{record.codUsuarioModifi,jdbcType=DECIMAL}");
        }
        if (record.getCodUsuarioAnula() != null) {
            sql.VALUES("cod_usuario_anulacion", "#{record.codUsuarioAnula,jdbcType=DECIMAL}");
        }

        return sql.toString();
    }

    public String updByCortesia(CortesiaUpdReq record) {
        SQL sql = new SQL();
        sql.UPDATE("NSA.CORTESIA");

        if (record.getDocViajante() != null) {
            sql.SET("documento_viajante = #{record.docViajante,jdbcType=VARCHAR}");
        }
        if (record.getNombreViajante() != null) {
            sql.SET("nombre_viajante = #{record.nombreViajante,jdbcType=VARCHAR}");
        }
        if (record.getObservacion() != null) {
            sql.SET("observacion = #{record.observacion,jdbcType=VARCHAR}");
        }
        if (record.getPorcentajeDesc() != null) {
            sql.SET("porcentaje_des = #{record.porcentajeDesc,jdbcType=DECIMAL}");
        }
        if (record.getCodServicioBuses() != null) {
            sql.SET("cod_servicio_buses = #{record.codServicioBuses,jdbcType=DECIMAL}");
        }
        if (record.getCodRutaIda() != null) {
            sql.SET("cod_ruta_ida = #{record.codRutaIda,jdbcType=DECIMAL}");
        }
        if (record.getCodRutaVuelta() != null) {
            sql.SET("cod_ruta_vuelta = #{record.CodRutaVuelta,jdbcType=DECIMAL}");
        }
        if (record.getFechaViaje() != null) {
            sql.SET("fecha_viaje = #{record.fechaViaje,jdbcType=TIMESTAMP}");
        }
        if (record.getImpreso() != null) {
            sql.SET("impreso = #{record.impreso,jdbcType=VARCHAR}");
        }
        if (record.getCantPasaje() != null) {
            sql.SET("cantidad_pasaje = #{record.cantPasaje,jdbcType=DECIMAL}");
        }
        if (record.getSolicitanteExterno() != null) {
            sql.SET("solicitante_externo = #{record.solicitanteExterno,jdbcType=VARCHAR}");
        }

        sql.WHERE("nro_cortesia = #{record.nroCortesia,jdbcType=DECIMAL}");
        return sql.toString();
    }
}
