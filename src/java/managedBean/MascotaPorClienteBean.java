/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.ClienteDao;
import dao.MascotaDao;
import dao.MascotaporClienteDao;
import entidades.Clientepormascota;
import entidades.ClientepormascotaId;
import entidades.Mascota;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;

/**
 *
 * @author USUARIO
 */
@ManagedBean
@ViewScoped
public class MascotaPorClienteBean {

    private ArrayList listaclientes;
     private int idCliente;
     
    private ArrayList listamascotas;
    private int idMascota;
    
    private Clientepormascota mascotaporcliente;
    private ClientepormascotaId mascotaporclienteid;
    
    public MascotaPorClienteBean(){
       listaclientes = new ArrayList();
       listamascotas = new ArrayList();
       mascotaporcliente = new Clientepormascota();
       mascotaporclienteid = new ClientepormascotaId();
       listarCombos();
   
    }
   public  void listarCombos(){
       ClienteDao clientedao= new ClienteDao();
       MascotaDao mascotadao = new MascotaDao();
       listaclientes = clientedao.listarCliente();
       listamascotas = mascotadao.listarMascotas();
       
   }
   public String guardar (){
       
       MascotaporClienteDao dao = new MascotaporClienteDao();
       
       mascotaporclienteid.setClienteIdCliente(idCliente);
       mascotaporclienteid.setMascotaIdMascota(idMascota);
        
         mascotaporcliente.setId(mascotaporclienteid);
         dao.guardarClientepormascota(mascotaporcliente);
         return "/RegistroMascotaPorCliente";
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

    public ArrayList getListamascotas() {
        return listamascotas;
    }

    public void setListamascotas(ArrayList listamascotas) {
        this.listamascotas = listamascotas;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public ClientepormascotaId getMascotaporclienteid() {
        return mascotaporclienteid;
    }

    public void setMascotaporclienteid(ClientepormascotaId mascotaporclienteid) {
        this.mascotaporclienteid = mascotaporclienteid;
    }

    public Clientepormascota getMascotaporcliente() {
        return mascotaporcliente;
    }

    public void setMascotaporcliente(Clientepormascota mascotaporcliente) {
        this.mascotaporcliente = mascotaporcliente;
    }
}
