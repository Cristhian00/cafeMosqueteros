package co.edu.uniquindio.proyecto.dto;

public class SocioNivelDTO {

    private String SocioLevel0;
    private String SocioLevel1;
    private String SocioLevel2;
    private String SocioLevel3;

    public SocioNivelDTO(String socioLevel0, String socioLevel1, String socioLevel2, String socioLevel3) {
        SocioLevel0 = socioLevel0;
        SocioLevel1 = socioLevel1;
        SocioLevel2 = socioLevel2;
        SocioLevel3 = socioLevel3;
    }

    public String getSocioLevel0() {
        return SocioLevel0;
    }

    public void setSocioLevel0(String socioLevel0) {
        SocioLevel0 = socioLevel0;
    }

    public String getSocioLevel1() {
        return SocioLevel1;
    }

    public void setSocioLevel1(String socioLevel1) {
        SocioLevel1 = socioLevel1;
    }

    public String getSocioLevel2() {
        return SocioLevel2;
    }

    public void setSocioLevel2(String socioLevel2) {
        SocioLevel2 = socioLevel2;
    }

    public String getSocioLevel3() {
        return SocioLevel3;
    }

    public void setSocioLevel3(String socioLevel3) {
        SocioLevel3 = socioLevel3;
    }
}
