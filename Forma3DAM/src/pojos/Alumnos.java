package pojos;
// Generated 17-feb-2024 19:37:18 by Hibernate Tools 4.3.1

/**
 * Alumnos generated by hbm2java
 */
public class Alumnos implements java.io.Serializable {

    private Integer idAlumno;
    private String dniAlumno;
    private String nombreAlumno;
    private String yearCurso;
    private String segSocialAlumno;
    private Boolean validez;
    private String cicloAlumno;
    private byte[] cv;

    public Alumnos() {
    }

    public Alumnos(String dniAlumno) {
        this.dniAlumno = dniAlumno;
    }

    public Alumnos(String dniAlumno, String nombreAlumno, String yearCurso, String segSocialAlumno, Boolean validez, String cicloAlumno, byte[] cv) {
        this.dniAlumno = dniAlumno;
        this.nombreAlumno = nombreAlumno;
        this.yearCurso = yearCurso;
        this.segSocialAlumno = segSocialAlumno;
        this.validez = validez;
        this.cicloAlumno = cicloAlumno;
        this.cv = cv;
    }

    public Alumnos(Integer idAlumno, String dniAlumno, String nombreAlumno, String yearCurso, String segSocialAlumno, Boolean validez, String cicloAlumno, byte[] cv) {
        this.idAlumno = idAlumno;
        this.dniAlumno = dniAlumno;
        this.nombreAlumno = nombreAlumno;
        this.yearCurso = yearCurso;
        this.segSocialAlumno = segSocialAlumno;
        this.validez = validez;
        this.cicloAlumno = cicloAlumno;
        this.cv = cv;
    }

    public Integer getIdAlumno() {
        return this.idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getDniAlumno() {
        return this.dniAlumno;
    }

    public void setDniAlumno(String dniAlumno) {
        this.dniAlumno = dniAlumno;
    }

    public String getNombreAlumno() {
        return this.nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getYearCurso() {
        return this.yearCurso;
    }

    public void setYearCurso(String yearCurso) {
        this.yearCurso = yearCurso;
    }

    public String getSegSocialAlumno() {
        return this.segSocialAlumno;
    }

    public void setSegSocialAlumno(String segSocialAlumno) {
        this.segSocialAlumno = segSocialAlumno;
    }

    public Boolean getValidez() {
        return this.validez;
    }

    public void setValidez(Boolean validez) {
        this.validez = validez;
    }

    public String getCicloAlumno() {
        return this.cicloAlumno;
    }

    public void setCicloAlumno(String cicloAlumno) {
        this.cicloAlumno = cicloAlumno;
    }

    public byte[] getCv() {
        return this.cv;
    }

    public void setCv(byte[] cv) {
        this.cv = cv;
    }

}
