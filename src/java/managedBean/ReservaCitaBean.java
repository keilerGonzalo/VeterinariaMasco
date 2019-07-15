/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;


import dao.ClienteDao;
import dao.ReservacitaDao;
import dao.TiporeservaDao;
import dao.UsuarioDao;
import entidades.Cliente;
import entidades.Reservacita;
import entidades.Tiporeserva;
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
public class ReservaCitaBean implements Serializable{
     private Reservacita reservacita;
     
    private ArrayList listatiporeserva;
    private ArrayList listcliente;
    private ArrayList listusuario;

 
    private int idTipoReserva;
    private int idCliente;
    private int idUsuario;

    final private Cliente clienteId;
    final private Tiporeserva tiporeservaId;
    final private Usuario usuarioId;

    private boolean banderaSelected = false;

    public ReservaCitaBean() {
        listatiporeserva = new ArrayList();
        listcliente = new ArrayList();
        listusuario = new ArrayList();

        reservacita = new Reservacita();
        clienteId = new Cliente();
        tiporeservaId = new Tiporeserva();
        usuarioId = new Usuario();

        listarCombos();
    }

    public void listarCombos() {
        TiporeservaDao tipresrevadao = new TiporeservaDao();
        ClienteDao clientdao = new ClienteDao();
        UsuarioDao userdao = new UsuarioDao();

        listatiporeserva = tipresrevadao.listarTiporeserva();
        listcliente = clientdao.listarCliente();
        listusuario = userdao.listarUsuarios();
    }

    public String guardarReservacita() {
        try {
            ReservacitaDao recervacitadao = new ReservacitaDao();
            clienteId.setIdCliente(idCliente);
            tiporeservaId.setIdTipoReserva(idTipoReserva);
            usuarioId.setIdUsuario(idUsuario);

            reservacita.setCliente(clienteId);
            reservacita.setTiporeserva(tiporeservaId);
            reservacita.setUsuario(usuarioId);

            boolean respuest = recervacitadao.guardarReservacita(reservacita);
            if (respuest) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo registrar"));
            }
        } catch (Exception e) {
            System.out.println("Error:: "+e.getMessage());
        }

        return "/RegistroReservaCita";
    }

    public ArrayList<Reservacita> listarReservacita() {
        ArrayList<Reservacita> lista = new ArrayList<>();
        ReservacitaDao recervacitadao = new ReservacitaDao();
        lista = recervacitadao.listarReservacitas();
        return lista;
    }

    public String actualizarReservacita() {
        try {
            ReservacitaDao recervdao = new ReservacitaDao();
            boolean respuesta = recervdao.actualizarReservacita(reservacita);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistroReservaCita";
    }

    public String eliminar() {
        ReservacitaDao recervacitadao = new ReservacitaDao();
        boolean respuesta = recervacitadao.eliminarReservacita(reservacita);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/RegistroReservaCita";
    }

    public String limpiar() {
        return "/RegistroReservaCita";
    }
    
   public void selectBandera(){
   banderaSelected = true;
   }

    public Reservacita getReservacita() {
        return reservacita;
    }

    public void setReservacita(Reservacita reservacita) {
        this.reservacita = reservacita;
    }

    public ArrayList getListatiporeserva() {
        return listatiporeserva;
    }

    public void setListatiporeserva(ArrayList listatiporeserva) {
        this.listatiporeserva = listatiporeserva;
    }

    public ArrayList getListcliente() {
        return listcliente;
    }

    public void setListcliente(ArrayList listcliente) {
        this.listcliente = listcliente;
    }

    public ArrayList getListusuario() {
        return listusuario;
    }

    public void setListusuario(ArrayList listusuario) {
        this.listusuario = listusuario;
    }

    public int getIdTipoReserva() {
        return idTipoReserva;
    }

    public void setIdTipoReserva(int idTipoReserva) {
        this.idTipoReserva = idTipoReserva;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean isBanderaSelected() {
        return banderaSelected;
    }

    public void setBanderaSelected(boolean banderaSelected) {
        this.banderaSelected = banderaSelected;
    }
}
