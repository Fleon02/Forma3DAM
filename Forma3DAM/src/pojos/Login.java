package pojos;
// Generated 17-feb-2024 19:37:18 by Hibernate Tools 4.3.1



/**
 * Login generated by hbm2java
 */
public class Login  implements java.io.Serializable {


     private Integer idUsuario;
     private String nombreUsuario;
     private String correoUsuario;
     private String rol;
     private Beep beep;

    public Login() {
    }

	
    public Login(String rol) {
        this.rol = rol;
    }
    public Login(String nombreUsuario, String correoUsuario, String rol, Beep beep) {
       this.nombreUsuario = nombreUsuario;
       this.correoUsuario = correoUsuario;
       this.rol = rol;
       this.beep = beep;
    }
   
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getCorreoUsuario() {
        return this.correoUsuario;
    }
    
    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }
    public String getRol() {
        return this.rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    public Beep getBeep() {
        return this.beep;
    }
    
    public void setBeep(Beep beep) {
        this.beep = beep;
    }




}


