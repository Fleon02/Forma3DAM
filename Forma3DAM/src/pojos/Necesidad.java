package pojos;
// Generated 14-feb-2024 20:24:14 by Hibernate Tools 4.3.1



/**
 * Necesidad generated by hbm2java
 */
public class Necesidad  implements java.io.Serializable {


     private Integer idNecesidad;
     private String cifEmpresa;
     private String cicloNecesidad;
     private Integer dam;
     private Integer daw;
     private Integer asir;
     private Integer mark;
     private Integer fin;

    public Necesidad() {
    }

    public Necesidad(String cifEmpresa, String cicloNecesidad, Integer dam, Integer daw, Integer asir, Integer mark, Integer fin) {
       this.cifEmpresa = cifEmpresa;
       this.cicloNecesidad = cicloNecesidad;
       this.dam = dam;
       this.daw = daw;
       this.asir = asir;
       this.mark = mark;
       this.fin = fin;
    }
   
    public Integer getIdNecesidad() {
        return this.idNecesidad;
    }
    
    public void setIdNecesidad(Integer idNecesidad) {
        this.idNecesidad = idNecesidad;
    }
    public String getCifEmpresa() {
        return this.cifEmpresa;
    }
    
    public void setCifEmpresa(String cifEmpresa) {
        this.cifEmpresa = cifEmpresa;
    }
    public String getCicloNecesidad() {
        return this.cicloNecesidad;
    }
    
    public void setCicloNecesidad(String cicloNecesidad) {
        this.cicloNecesidad = cicloNecesidad;
    }
    public Integer getDam() {
        return this.dam;
    }
    
    public void setDam(Integer dam) {
        this.dam = dam;
    }
    public Integer getDaw() {
        return this.daw;
    }
    
    public void setDaw(Integer daw) {
        this.daw = daw;
    }
    public Integer getAsir() {
        return this.asir;
    }
    
    public void setAsir(Integer asir) {
        this.asir = asir;
    }
    public Integer getMark() {
        return this.mark;
    }
    
    public void setMark(Integer mark) {
        this.mark = mark;
    }
    public Integer getFin() {
        return this.fin;
    }
    
    public void setFin(Integer fin) {
        this.fin = fin;
    }




}


