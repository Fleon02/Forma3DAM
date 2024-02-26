package pojos;
// Generated 26-feb-2024 17:26:47 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Empresas generated by hbm2java
 */
public class Empresas implements java.io.Serializable {

    private Integer idEmpresa;
    private String nombreEmpresa;
    private String cifEmpresa;
    private String direccion;
    private String telefono;
    private String owner;
    private String tutorPracticas;
    private String responsableContratacion;
    private Set practicases = new HashSet(0);
    private Set necesidads = new HashSet(0);
    private Set anexoses = new HashSet(0);
    private Set convenios = new HashSet(0);

    public Empresas() {
    }

    public Empresas(String cifEmpresa) {
        this.cifEmpresa = cifEmpresa;
    }

    public Empresas(String nombreEmpresa, String cifEmpresa, String direccion, String telefono, String owner, String tutorPracticas, String responsableContratacion, Set practicases, Set necesidads, Set anexoses, Set convenios) {
        this.nombreEmpresa = nombreEmpresa;
        this.cifEmpresa = cifEmpresa;
        this.direccion = direccion;
        this.telefono = telefono;
        this.owner = owner;
        this.tutorPracticas = tutorPracticas;
        this.responsableContratacion = responsableContratacion;
        this.practicases = practicases;
        this.necesidads = necesidads;
        this.anexoses = anexoses;
        this.convenios = convenios;
    }

    public Empresas(String nombreEmpresa, String cifEmpresa, String direccion, String telefono, String owner, String tutorPracticas, String responsableContratacion) {
        this.nombreEmpresa = nombreEmpresa;
        this.cifEmpresa = cifEmpresa;
        this.direccion = direccion;
        this.telefono = telefono;
        this.owner = owner;
        this.tutorPracticas = tutorPracticas;
        this.responsableContratacion = responsableContratacion;
    }

    public Integer getIdEmpresa() {
        return this.idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
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

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTutorPracticas() {
        return this.tutorPracticas;
    }

    public void setTutorPracticas(String tutorPracticas) {
        this.tutorPracticas = tutorPracticas;
    }

    public String getResponsableContratacion() {
        return this.responsableContratacion;
    }

    public void setResponsableContratacion(String responsableContratacion) {
        this.responsableContratacion = responsableContratacion;
    }

    public Set getPracticases() {
        return this.practicases;
    }

    public void setPracticases(Set practicases) {
        this.practicases = practicases;
    }

    public Set getNecesidads() {
        return this.necesidads;
    }

    public void setNecesidads(Set necesidads) {
        this.necesidads = necesidads;
    }

    public Set getAnexoses() {
        return this.anexoses;
    }

    public void setAnexoses(Set anexoses) {
        this.anexoses = anexoses;
    }

    public Set getConvenios() {
        return this.convenios;
    }

    public void setConvenios(Set convenios) {
        this.convenios = convenios;
    }

}
