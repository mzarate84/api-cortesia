package py.com.nsa.cortesia.model.params;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CortesiaInsReq {
    private Long nroCortesia;
    private String identificador;
    private String docViajante;
    private String nombreViajante;
    private String observacion;
    private Date fechaGraba;
    private String confirmacion;
    private Date fechaConfirmacion;
    private Integer porcentajeDesc;
    private Date fechaAutorizacion;
    private Integer codEmpleado;
    private Integer codAgencia;
    private Integer codCargo;
    private Integer codServicioBuses;
    private Integer codRutaIda;
    private Integer CodRutaVuelta;
    private Integer codUsuarioGraba;
    private Integer codUsuarioAutoriza;
    private Date fechaViaje;
    private String impreso;
    private Integer nroImpresion;
    private Integer cantPasaje;
    private String solicitanteExterno;
    private Date fechaModifi;
    private Date fechaAnula;
    private Integer codUsuarioModifi;
    private Integer codUsuarioAnula;
}
