package pojos;
// Generated 24-feb-2024 18:38:27 by Hibernate Tools 4.3.1



/**
 * Beep generated by hbm2java
 */
public class Beep  implements java.io.Serializable {


     private int idUsuario;
     private Login login;
     private String contrasena;

    public Beep() {
    }

	
    public Beep(Login login) {
        this.login = login;
    }
    public Beep(Login login, String contrasena) {
       this.login = login;
       this.contrasena = contrasena;
    }
   
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Login getLogin() {
        return this.login;
    }
    
    public void setLogin(Login login) {
        this.login = login;
    }
    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }




}


