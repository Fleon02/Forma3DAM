package pojos;
// Generated 14-feb-2024 20:16:34 by Hibernate Tools 4.3.1



/**
 * Practicas generated by hbm2java
 */
public class Practicas  implements java.io.Serializable {


     private Integer idPractica;
     private String dniAlumno;
     private String calendario;
     private String informeSeguimiento;
     private String informeFinal;

    public Practicas() {
    }

    public Practicas(String dniAlumno, String calendario, String informeSeguimiento, String informeFinal) {
       this.dniAlumno = dniAlumno;
       this.calendario = calendario;
       this.informeSeguimiento = informeSeguimiento;
       this.informeFinal = informeFinal;
    }
   
    public Integer getIdPractica() {
        return this.idPractica;
    }
    
    public void setIdPractica(Integer idPractica) {
        this.idPractica = idPractica;
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
    public String getInformeSeguimiento() {
        return this.informeSeguimiento;
    }
    
    public void setInformeSeguimiento(String informeSeguimiento) {
        this.informeSeguimiento = informeSeguimiento;
    }
    public String getInformeFinal() {
        return this.informeFinal;
    }
    
    public void setInformeFinal(String informeFinal) {
        this.informeFinal = informeFinal;
    }




}


