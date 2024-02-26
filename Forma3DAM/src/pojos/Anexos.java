package pojos;
// Generated 26-feb-2024 17:26:47 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Anexos generated by hbm2java
 */
public class Anexos  implements java.io.Serializable {


     private Integer idAnexo;
     private Alumnos alumnos;
     private Empresas empresas;
     private Necesidad necesidad;
     private String fechaInicio;
     private String fechaFin;
     private Boolean contratacion;
     private String calendario;
     private byte[] anexoDosUno;
     private byte[] anexoTres;
     private byte[] anexoCuatro;
     private byte[] anexoDosDos;
     private byte[] anexoOcho;
     private Set bolsas = new HashSet(0);
     private Set practicases = new HashSet(0);

    public Anexos() {
    }

	
    public Anexos(Empresas empresas) {
        this.empresas = empresas;
    }
    public Anexos(Alumnos alumnos, Empresas empresas, Necesidad necesidad, String fechaInicio, String fechaFin, Boolean contratacion, String calendario, byte[] anexoDosUno, byte[] anexoTres, byte[] anexoCuatro, byte[] anexoDosDos, byte[] anexoOcho, Set bolsas, Set practicases) {
       this.alumnos = alumnos;
       this.empresas = empresas;
       this.necesidad = necesidad;
       this.fechaInicio = fechaInicio;
       this.fechaFin = fechaFin;
       this.contratacion = contratacion;
       this.calendario = calendario;
       this.anexoDosUno = anexoDosUno;
       this.anexoTres = anexoTres;
       this.anexoCuatro = anexoCuatro;
       this.anexoDosDos = anexoDosDos;
       this.anexoOcho = anexoOcho;
       this.bolsas = bolsas;
       this.practicases = practicases;
    }
   
    public Integer getIdAnexo() {
        return this.idAnexo;
    }
    
    public void setIdAnexo(Integer idAnexo) {
        this.idAnexo = idAnexo;
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
    public Necesidad getNecesidad() {
        return this.necesidad;
    }
    
    public void setNecesidad(Necesidad necesidad) {
        this.necesidad = necesidad;
    }
    public String getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public String getFechaFin() {
        return this.fechaFin;
    }
    
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    public Boolean getContratacion() {
        return this.contratacion;
    }
    
    public void setContratacion(Boolean contratacion) {
        this.contratacion = contratacion;
    }
    public String getCalendario() {
        return this.calendario;
    }
    
    public void setCalendario(String calendario) {
        this.calendario = calendario;
    }
    public byte[] getAnexoDosUno() {
        return this.anexoDosUno;
    }
    
    public void setAnexoDosUno(byte[] anexoDosUno) {
        this.anexoDosUno = anexoDosUno;
    }
    public byte[] getAnexoTres() {
        return this.anexoTres;
    }
    
    public void setAnexoTres(byte[] anexoTres) {
        this.anexoTres = anexoTres;
    }
    public byte[] getAnexoCuatro() {
        return this.anexoCuatro;
    }
    
    public void setAnexoCuatro(byte[] anexoCuatro) {
        this.anexoCuatro = anexoCuatro;
    }
    public byte[] getAnexoDosDos() {
        return this.anexoDosDos;
    }
    
    public void setAnexoDosDos(byte[] anexoDosDos) {
        this.anexoDosDos = anexoDosDos;
    }
    public byte[] getAnexoOcho() {
        return this.anexoOcho;
    }
    
    public void setAnexoOcho(byte[] anexoOcho) {
        this.anexoOcho = anexoOcho;
    }
    public Set getBolsas() {
        return this.bolsas;
    }
    
    public void setBolsas(Set bolsas) {
        this.bolsas = bolsas;
    }
    public Set getPracticases() {
        return this.practicases;
    }
    
    public void setPracticases(Set practicases) {
        this.practicases = practicases;
    }




}


