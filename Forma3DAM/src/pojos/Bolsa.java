package pojos;
// Generated 27-feb-2024 19:04:12 by Hibernate Tools 4.3.1



/**
 * Bolsa generated by hbm2java
 */
public class Bolsa  implements java.io.Serializable {


     private Integer idBolsa;
     private Alumnos alumnos;
     private Empresas empresas;
     private Boolean beca;
     private Boolean bolsa;

    public Bolsa() {
    }

    public Bolsa(Alumnos alumnos, Empresas empresas, Boolean beca, Boolean bolsa) {
       this.alumnos = alumnos;
       this.empresas = empresas;
       this.beca = beca;
       this.bolsa = bolsa;
    }
   
    public Integer getIdBolsa() {
        return this.idBolsa;
    }
    
    public void setIdBolsa(Integer idBolsa) {
        this.idBolsa = idBolsa;
    }
    public Alumnos getAlumnos() {
        return this.alumnos;
    }
    
    public void setAlumnos(Alumnos alumnos) {
        this.alumnos = alumnos;
    }
    public Empresas getEmpresas() {
        return this.empresas;
    }
    
    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }
    public Boolean getBeca() {
        return this.beca;
    }
    
    public void setBeca(Boolean beca) {
        this.beca = beca;
    }
    public Boolean getBolsa() {
        return this.bolsa;
    }
    
    public void setBolsa(Boolean bolsa) {
        this.bolsa = bolsa;
    }




}


