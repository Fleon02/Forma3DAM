package pojos;
// Generated 24-feb-2024 21:20:04 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Practicas generated by hbm2java
 */
public class Practicas  implements java.io.Serializable {


     private Integer idPractica;
     private Empresas empresas;
     private String dniAlumno;
     private String calendario;
     private byte[] informeSeguimiento;
     private byte[] informeFinal;
     private Set empresases = new HashSet(0);

    public Practicas() {
    }

    public Practicas(Empresas empresas, String dniAlumno, String calendario, byte[] informeSeguimiento, byte[] informeFinal, Set empresases) {
       this.empresas = empresas;
       this.dniAlumno = dniAlumno;
       this.calendario = calendario;
       this.informeSeguimiento = informeSeguimiento;
       this.informeFinal = informeFinal;
       this.empresases = empresases;
    }
   
    public Integer getIdPractica() {
        return this.idPractica;
    }
    
    public void setIdPractica(Integer idPractica) {
        this.idPractica = idPractica;
    }
    public Empresas getEmpresas() {
        return this.empresas;
    }
    
    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }
    public String getDniAlumno() {
        return this.dniAlumno;
    }
    
    public void setDniAlumno(String dniAlumno) {
        this.dniAlumno = dniAlumno;
    }
    public String getCalendario() {
        return this.calendario;
    }
    
    public void setCalendario(String calendario) {
        this.calendario = calendario;
    }
    public byte[] getInformeSeguimiento() {
        return this.informeSeguimiento;
    }
    
    public void setInformeSeguimiento(byte[] informeSeguimiento) {
        this.informeSeguimiento = informeSeguimiento;
    }
    public byte[] getInformeFinal() {
        return this.informeFinal;
    }
    
    public void setInformeFinal(byte[] informeFinal) {
        this.informeFinal = informeFinal;
    }
    public Set getEmpresases() {
        return this.empresases;
    }
    
    public void setEmpresases(Set empresases) {
        this.empresases = empresases;
    }




}


