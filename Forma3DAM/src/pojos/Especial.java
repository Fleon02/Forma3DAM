package pojos;
// Generated 09-feb-2024 2:11:34 by Hibernate Tools 4.3.1



/**
 * Especial generated by hbm2java
 */
public class Especial  implements java.io.Serializable {


     private String correoUsuario;
     private String hashUsuario;
     private String saltUsuario;

    public Especial() {
    }

	
    public Especial(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }
    public Especial(String correoUsuario, String hashUsuario, String saltUsuario) {
       this.correoUsuario = correoUsuario;
       this.hashUsuario = hashUsuario;
       this.saltUsuario = saltUsuario;
    }
   
    public String getCorreoUsuario() {
        return this.correoUsuario;
    }
    
    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }
    public String getHashUsuario() {
        return this.hashUsuario;
    }
    
    public void setHashUsuario(String hashUsuario) {
        this.hashUsuario = hashUsuario;
    }
    public String getSaltUsuario() {
        return this.saltUsuario;
    }
    
    public void setSaltUsuario(String saltUsuario) {
        this.saltUsuario = saltUsuario;
    }




}

