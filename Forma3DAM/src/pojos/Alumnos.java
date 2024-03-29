package pojos;
// Generated 28-feb-2024 17:10:15 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Alumnos generated by hbm2java
 */
public class Alumnos implements java.io.Serializable {

    private Integer idAlumno;
    private String dniAlumno;
    private String nombreAlumno;
    private Integer yearCurso;
    private Integer segSocialAlumno;
    private Boolean validez;
    private String cicloAlumno;
    private byte[] cv;
    private Set bolsas = new HashSet(0);
    private Set alumnosAsignaturases = new HashSet(0);
    private Set practicases = new HashSet(0);

    public Alumnos() {
    }

    public Alumnos(String dniAlumno) {
        this.dniAlumno = dniAlumno;
    }

    public Alumnos(String dniAlumno, String nombreAlumno, Integer yearCurso, Integer segSocialAlumno, Boolean validez, String cicloAlumno, byte[] cv) {
        this.dniAlumno = dniAlumno;
        this.nombreAlumno = nombreAlumno;
        this.yearCurso = yearCurso;
        this.segSocialAlumno = segSocialAlumno;
        this.validez = validez;
        this.cicloAlumno = cicloAlumno;
        this.cv = cv;
    }

    public Alumnos(String dniAlumno, String nombreAlumno, Integer yearCurso, Integer segSocialAlumno, Boolean validez, String cicloAlumno, byte[] cv, Set bolsas, Set alumnosAsignaturases, Set practicases) {
        this.dniAlumno = dniAlumno;
        this.nombreAlumno = nombreAlumno;
        this.yearCurso = yearCurso;
        this.segSocialAlumno = segSocialAlumno;
        this.validez = validez;
        this.cicloAlumno = cicloAlumno;
        this.cv = cv;
        this.bolsas = bolsas;
        this.alumnosAsignaturases = alumnosAsignaturases;
        this.practicases = practicases;
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

    public Integer getYearCurso() {
        return this.yearCurso;
    }

    public void setYearCurso(Integer yearCurso) {
        this.yearCurso = yearCurso;
    }

    public Integer getSegSocialAlumno() {
        return this.segSocialAlumno;
    }

    public void setSegSocialAlumno(Integer segSocialAlumno) {
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

    public Set getBolsas() {
        return this.bolsas;
    }

    public void setBolsas(Set bolsas) {
        this.bolsas = bolsas;
    }

    public Set getAlumnosAsignaturases() {
        return this.alumnosAsignaturases;
    }

    public void setAlumnosAsignaturases(Set alumnosAsignaturases) {
        this.alumnosAsignaturases = alumnosAsignaturases;
    }

    public Set getPracticases() {
        return this.practicases;
    }

    public void setPracticases(Set practicases) {
        this.practicases = practicases;
    }

}
