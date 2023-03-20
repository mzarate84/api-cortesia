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
public class CortesiaUpdReq {
    private Long nroCortesia;
    private String docViajante;
    private String nombreViajante;
    private String observacion;
    private Integer porcentajeDesc;
    private Integer codServicioBuses;
    private Integer codRutaIda;
    private Integer CodRutaVuelta;
    private Date fechaViaje;
    private String impreso;
    private Integer cantPasaje;
    private String solicitanteExterno;
}
