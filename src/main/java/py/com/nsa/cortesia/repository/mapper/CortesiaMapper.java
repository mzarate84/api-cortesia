package py.com.nsa.cortesia.repository.mapper;

import org.apache.ibatis.annotations.*;
import py.com.nsa.cortesia.model.Cortesia;
import py.com.nsa.cortesia.model.params.CortesiaInsReq;
import py.com.nsa.cortesia.model.params.CortesiaListReq;
import py.com.nsa.cortesia.model.params.CortesiaUpdReq;
import py.com.nsa.cortesia.repository.sqlProviders.CortesiaSqlProvider;


import java.util.List;

@Mapper
public interface CortesiaMapper {

    @SelectProvider(type = CortesiaSqlProvider.class, method = "selectByCortesia")
    @Results({
            @Result(property = "nroCortesia", column = "NRO_CORTESIA"),
            @Result(property = "identificador", column = "IDENTIFICADOR"),
            @Result(property = "docViajante", column = "DOCUMENTO_VIAJANTE"),
            @Result(property = "nombreViajante", column = "NOMBRE_VIAJANTE"),
            @Result(property = "observacion", column = "OBSERVACION"),
            @Result(property = "fechaGraba", column = "FECHA_GRABACION"),
            @Result(property = "confirmacion", column = "CONFIRMACION"),
            @Result(property = "fechaConfirmacion", column = "FECHA_CONFIRMACION"),
            @Result(property = "porcentajeDesc", column = "PORCENTAJE_DES"),
            @Result(property = "fechaAutorizacion", column = "FECHA_AUTORIZACION"),
            @Result(property = "codEmpleado", column = "COD_EMPLEADO"),
            @Result(property = "codAgencia", column = "COD_AGENCIA"),
            @Result(property = "codCargo", column = "COD_CARGO"),
            @Result(property = "codServicioBuses", column = "COD_SERVICIO_BUSES"),
            @Result(property = "codRutaIda", column = "COD_RUTA_IDA"),
            @Result(property = "CodRutaVuelta", column = "COD_RUTA_VUELTA"),
            @Result(property = "codUsuarioGraba", column = "COD_USUARIO_GRABACION"),
            @Result(property = "codUsuarioAutoriza", column = "COD_USUARIO_AUTORIZA"),
            @Result(property = "fechaViaje", column = "FECHA_VIAJE"),
            @Result(property = "impreso", column = "IMPRESO"),
            @Result(property = "nroImpresion", column = "NRO_IMPROSION"),
            @Result(property = "cantPasaje", column = "CANTIDAD_PASAJE"),
            @Result(property = "solicitanteExterno", column = "SOLICITANTE_EXTERNO"),
            @Result(property = "fechaModifi", column = "FECHA_MODIFI"),
            @Result(property = "fechaAnula", column = "FECHA_ANULACION"),
            @Result(property = "codUsuarioModifi", column = "COD_USUARIO_MODIFICA"),
            @Result(property = "codUsuarioAnula", column = "COD_USUARIO_ANULACION")
    })
    List<Cortesia> selectByCortesia(CortesiaListReq req);


    @Select("SELECT (MAX(c.nro_cortesia)+1) nrocortesia FROM cortesia c")
    @Results({
            @Result(column = "NROCORTESIA"),
    })
    Long selectByMaxCortesia();

    @InsertProvider(type = CortesiaSqlProvider.class, method = "insByCortesia")
    int insByCortesia(@Param("record") CortesiaInsReq record);

    @UpdateProvider(type = CortesiaSqlProvider.class, method = "updByCortesia")
    int updByCortesia(@Param("record") CortesiaUpdReq record);


    @Delete({
            "delete from NSA.CORTESIA",
            "where NRO_CORTESIA = #{nroCortesia,jdbcType=DECIMAL}"
    })
    int delByCortesia(Long nroCortesia);

}
