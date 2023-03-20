package py.com.nsa.cortesia.model.params;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CortesiaListReq {
    private Long nroCortesia;
    private String fechaIni;
    private String fechaFin;
    private Integer codUsuarioGraba;
    private Integer codEmpleado;

}
