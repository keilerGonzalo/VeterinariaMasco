/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.TipoatencionDao;
import entidades.Tipoatencion;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;

/**
 *
 * @author USUARIO
 */
@ManagedBean
@ViewScoped
public class TipoAtencionBean implements Serializable{
    
    private Tipoatencion tipoatencion;
   private boolean banderaSelect=false;
   
    public TipoAtencionBean() {
        this.tipoatencion = new Tipoatencion();
    }

   

    public String guardarTipoAtencion() {
        try {

            TipoatencionDao tipoatencionDao = new TipoatencionDao();
            boolean respuesta = tipoatencionDao.guardarTipoatencion(tipoatencion);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro con éxito"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puede registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistroTipoAtencion";
    }

    public String actualizarTipoAtencion() {
        try {
            TipoatencionDao tipoatencionDao = new TipoatencionDao();
            boolean respuesta = tipoatencionDao.actualizarTipoatencion(tipoatencion);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo con exito"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistroTipoAtencion";

    }

    public ArrayList<Tipoatencion> listarTipoAtencions() {
        ArrayList<Tipoatencion> lista = new ArrayList<>();
        TipoatencionDao tipoatencionDao = new TipoatencionDao();
        lista = tipoatencionDao.listarTipoatencion();
        return lista;
    }

    public String eliminar() {
        TipoatencionDao tipoatencionDao = new TipoatencionDao();
        boolean respuesta = tipoatencionDao.eliminarTipoatencion(tipoatencion);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino con exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/RegistroTipoAtencion";
    }
    public String limpiar() {
        banderaSelect=false;
        return "/RegistroTipoAtencion";
    }
   public void selectBandera(){
    banderaSelect=true;
   }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }

    public Tipoatencion getTipoatencion() {
        return tipoatencion;
    }

    public void setTipoatencion(Tipoatencion tipoatencion) {
        this.tipoatencion = tipoatencion;
    }
}
