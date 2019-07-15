/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.UsuarioDao;
import dao.ClienteDao;
import dao.MascotaDao;
import dao.PersonalDao;
import dao.UsuarioDao;
import entidades.Usuario;
import entidades.Cliente;
import entidades.Clientepormascota;
import entidades.ClientepormascotaId;
import entidades.Personal;
import entidades.Usuario;
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
public class UsuarioBean implements Serializable{
    
    private Usuario usuario;
   private boolean banderaSelect=false;
   
 
      private Personal personal;
    private ArrayList listarPersonales; 
     private int idPersonal;
     
     private Cliente cliente;
    private ArrayList listaclientes; 
     private int idCliente;
     
    public UsuarioBean(){
       usuario = new Usuario();
        personal = new Personal();
        cliente = new Cliente();
       listaclientes = new ArrayList();
       listarPersonales = new ArrayList();
       listarCombos();
       
   
    }
    
   public  void listarCombos(){
      ClienteDao clientedao= new ClienteDao();
      PersonalDao personaldao = new PersonalDao();
       listaclientes = clientedao.listarCliente();
       listarPersonales = personaldao.listarPersonal();
   }


    public String guardarUsuario() {
        try {
            UsuarioDao usuariodao = new UsuarioDao();
            personal.setIdPersonal(idPersonal);
            cliente.setIdCliente(idCliente);
            usuario.setPersonal(personal);
            usuario.setCliente(cliente);
            boolean respuesta = usuariodao.guardarUsuario(usuario);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro con éxito"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puede registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistroUsuario";
    }

    public String actualizarUsuario() {
        try {
            UsuarioDao usuarioDao = new UsuarioDao();
            boolean respuesta = usuarioDao.actualizarUsuario(usuario);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo con exito"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistroUsuario";

    }

    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<>();
        UsuarioDao usuarioDao = new UsuarioDao();
        lista = usuarioDao.listarUsuarios();
        return lista;
    }

    public String eliminar() {
        UsuarioDao usuarioDao = new UsuarioDao();
        boolean respuesta = usuarioDao.eliminarUsuario(usuario);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino con exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/RegistroUsuario";
    }
    public String limpiar() {
        banderaSelect=false;
        return "/RegistroUsuario";
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public ArrayList getListapersonales() {
        return listarPersonales;
    }

    public void setListapersonales(ArrayList listapersonales) {
        this.listarPersonales = listapersonales;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList getListaclientes() {
        return listaclientes;
    }

    public void setListaclientes(ArrayList listaclientes) {
        this.listaclientes = listaclientes;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

}
