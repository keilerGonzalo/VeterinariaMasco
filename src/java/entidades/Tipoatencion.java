package entidades;
// Generated 17/07/2019 06:49:38 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tipoatencion generated by hbm2java
 */
public class Tipoatencion  implements java.io.Serializable {


     private int idTipoAtencion;
     private String descripcion;
     private Set atencions = new HashSet(0);

    public Tipoatencion() {
    }

	
    public Tipoatencion(int idTipoAtencion, String descripcion) {
        this.idTipoAtencion = idTipoAtencion;
        this.descripcion = descripcion;
    }
    public Tipoatencion(int idTipoAtencion, String descripcion, Set atencions) {
       this.idTipoAtencion = idTipoAtencion;
       this.descripcion = descripcion;
       this.atencions = atencions;
    }
   
    public int getIdTipoAtencion() {
        return this.idTipoAtencion;
    }
    
    public void setIdTipoAtencion(int idTipoAtencion) {
        this.idTipoAtencion = idTipoAtencion;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getAtencions() {
        return this.atencions;
    }
    
    public void setAtencions(Set atencions) {
        this.atencions = atencions;
    }




}


