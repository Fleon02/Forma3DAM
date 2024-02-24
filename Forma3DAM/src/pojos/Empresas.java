package pojos;
// Generated 23-feb-2024 18:13:22 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Empresas generated by hbm2java
 */
public class Empresas implements java.io.Serializable {

    private String cifEmpresa;
    private String nombreEmpresa;
    private String direccion;
    private String telefono;
    private String owner;
    private String tutorPracticas;
    private String responsableContratacion;
    private Set practicases = new HashSet(0);
    private Set necesidads = new HashSet(0);
    private Set practicases_1 = new HashSet(0);
    private Set convenios = new HashSet(0);

    public Empresas() {
    }

    public Empresas(String cifEmpresa) {
        this.cifEmpresa = cifEmpresa;
    }

    public Empresas(String cifEmpresa, String nombreEmpresa, String direccion, String telefono, String owner, String tutorPracticas, String responsableContratacion, Set practicases, Set necesidads, Set practicases_1, Set convenios) {
        this.cifEmpresa = cifEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
        this.telefono = telefono;
        this.owner = owner;
        this.tutorPracticas = tutorPracticas;
        this.responsableContratacion = responsableContratacion;
        this.practicases = practicases;
        this.necesidads = necesidads;
        this.practicases_1 = practicases_1;
        this.convenios = convenios;
    }

    public Empresas(String cifEmpresa, String nombreEmpresa, String direccion, String telefono, String owner, String tutorPracticas, String responsableContratacion) {
        this.cifEmpresa = cifEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
        this.telefono = telefono;
        this.owner = owner;
        this.tutorPracticas = tutorPracticas;
        this.responsableContratacion = responsableContratacion;
    }

    public String getCifEmpresa() {
        return this.cifEmpresa;
    }

    public void setCifEmpresa(String cifEmpresa) {
        this.cifEmpresa = cifEmpresa;
    }

    public String getNombreEmpresa() {
        return this.nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
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

    public Set getPracticases_1() {
        return this.practicases_1;
    }

    public void setPracticases_1(Set practicases_1) {
        this.practicases_1 = practicases_1;
    }

    public Set getConvenios() {
        return this.convenios;
    }

    public void setConvenios(Set convenios) {
        this.convenios = convenios;
    }

}
