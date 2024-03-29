package pojos;
// Generated 28-feb-2024 17:10:15 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Asignaturas generated by hbm2java
 */
public class Asignaturas  implements java.io.Serializable {


     private Integer idAsignatura;
     private String nombreAsignatura;
     private String abreviatura;
     private String cicloFormativo;
     private Set alumnosAsignaturases = new HashSet(0);

    public Asignaturas() {
    }

    public Asignaturas(String nombreAsignatura, String abreviatura, String cicloFormativo, Set alumnosAsignaturases) {
       this.nombreAsignatura = nombreAsignatura;
       this.abreviatura = abreviatura;
       this.cicloFormativo = cicloFormativo;
       this.alumnosAsignaturases = alumnosAsignaturases;
    }
   
    public Integer getIdAsignatura() {
        return this.idAsignatura;
    }
    
    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }
    public String getNombreAsignatura() {
        return this.nombreAsignatura;
    }
    
    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }
    public String getAbreviatura() {
        return this.abreviatura;
    }
    
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
    public String getCicloFormativo() {
        return this.cicloFormativo;
    }
    
    public void setCicloFormativo(String cicloFormativo) {
        this.cicloFormativo = cicloFormativo;
    }
    public Set getAlumnosAsignaturases() {
        return this.alumnosAsignaturases;
    }
    
    public void setAlumnosAsignaturases(Set alumnosAsignaturases) {
        this.alumnosAsignaturases = alumnosAsignaturases;
    }




}


