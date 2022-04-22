package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.Socio;

public class SocioNivelDTO {

    private Socio SocioLevel1;
    private Socio SocioLevel2;
    private Socio SocioLevel3;

    public SocioNivelDTO(Socio socioLevel1, Socio socioLevel2, Socio socioLevel3) {
        SocioLevel1 = socioLevel1;
        SocioLevel2 = socioLevel2;
        SocioLevel3 = socioLevel3;
    }

    public Socio getSocioLevel1() {
        return SocioLevel1;
    }

    public void setSocioLevel1(Socio socioLevel1) {
        SocioLevel1 = socioLevel1;
    }

    public Socio getSocioLevel2() {
        return SocioLevel2;
    }

    public void setSocioLevel2(Socio socioLevel2) {
        SocioLevel2 = socioLevel2;
    }

    public Socio getSocioLevel3() {
        return SocioLevel3;
    }

    public void setSocioLevel3(Socio socioLevel3) {
        SocioLevel3 = socioLevel3;
    }
}
