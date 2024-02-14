package pojos;
// Generated 14-feb-2024 20:16:34 by Hibernate Tools 4.3.1



/**
 * Convenio generated by hbm2java
 */
public class Convenio  implements java.io.Serializable {


     private int numConvenio;
     private String idAnexo;
     private String nombreEmpresa;
     private String cifEmpresa;
     private String responsableFirma;
     private Integer cantAnexos;

    public Convenio() {
    }

	
    public Convenio(int numConvenio) {
        this.numConvenio = numConvenio;
    }
    public Convenio(int numConvenio, String idAnexo, String nombreEmpresa, String cifEmpresa, String responsableFirma, Integer cantAnexos) {
       this.numConvenio = numConvenio;
       this.idAnexo = idAnexo;
       this.nombreEmpresa = nombreEmpresa;
       this.cifEmpresa = cifEmpresa;
       this.responsableFirma = responsableFirma;
       this.cantAnexos = cantAnexos;
    }
   
    public int getNumConvenio() {
        return this.numConvenio;
    }
    
    public void setNumConvenio(int numConvenio) {
        this.numConvenio = numConvenio;
    }
    public String getIdAnexo() {
        return this.idAnexo;
    }
    
    public void setIdAnexo(String idAnexo) {
        this.idAnexo = idAnexo;
    }
    public String getNombreEmpresa() {
        return this.nombreEmpresa;
    }
    
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    public String getCifEmpresa() {
        return this.cifEmpresa;
    }
    
    public void setCifEmpresa(String cifEmpresa) {
        this.cifEmpresa = cifEmpresa;
    }
    public String getResponsableFirma() {
        return this.responsableFirma;
    }
    
    public void setResponsableFirma(String responsableFirma) {
        this.responsableFirma = responsableFirma;
    }
    public Integer getCantAnexos() {
        return this.cantAnexos;
    }
    
    public void setCantAnexos(Integer cantAnexos) {
        this.cantAnexos = cantAnexos;
    }




}


