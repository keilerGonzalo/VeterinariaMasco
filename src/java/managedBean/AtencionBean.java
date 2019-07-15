
package managedBean;
import dao.AtencionDao;
import dao.ClienteDao;
import dao.MascotaDao;
import dao.PersonalDao;
import dao.TipoatencionDao;
import entidades.Atencion;
import entidades.Clientepormascota;
import entidades.ClientepormascotaId;
import entidades.Personal;
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
public class AtencionBean implements Serializable{
    
    private Atencion atencion;
   private boolean banderaSelect=false;
   
    private ArrayList listaclientes;
     private int idCliente;
      
    private ArrayList listamascotas;
    private int idMascota;
    
      private Personal personal;
    private ArrayList listapersonales; 
     private int idPersonal;
     
      private Tipoatencion tipoatencion;
    private ArrayList listatipoatenciones; 
     private int idTipoAtencion;
     
     
 
    private Clientepormascota mascotaporcliente;
    private ClientepormascotaId mascotaporclienteid;
    
    public AtencionBean(){
       atencion = new Atencion();
       personal = new Personal();
       tipoatencion = new Tipoatencion();
       listaclientes = new ArrayList();
       listamascotas = new ArrayList();
       listapersonales = new ArrayList();
       mascotaporcliente = new Clientepormascota();
       mascotaporclienteid = new ClientepormascotaId();
       listarCombos();
       
   
    }
    
   public  void listarCombos(){
      ClienteDao clientedao= new ClienteDao();
      MascotaDao mascotadao = new MascotaDao();
      PersonalDao personaldao = new PersonalDao();
      TipoatencionDao tipoatenciondao = new TipoatencionDao();
       listaclientes = clientedao.listarCliente();
       listamascotas = mascotadao.listarMascotas();
       listapersonales = personaldao.listarPersonal();
       listatipoatenciones = tipoatenciondao.listarTipoatencion();
   }
 
    public Atencion getAtencion() {
        return atencion;
    }

    public void setAtencion(Atencion atencion) {
        this.atencion = atencion;
    }

    public String guardarAtencion() {
        try {
            AtencionDao atencionDao = new AtencionDao();
            mascotaporcliente.setId(mascotaporclienteid);
            personal.setIdPersonal(idPersonal);
            tipoatencion.setIdTipoAtencion(idTipoAtencion);
            atencion.setClientepormascota(mascotaporcliente);
            atencion.setPersonal(personal);
            atencion.setTipoatencion(tipoatencion);
            atencion.setClientepormascota(mascotaporcliente);
            boolean respuesta = atencionDao.guardarAtencion(atencion);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro con éxito"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puede registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistroAtencion";
    }

    public String actualizarAtencion() {
        try {
            AtencionDao atencionDao = new AtencionDao();
            boolean respuesta = atencionDao.actualizarAtencion(atencion);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo con exito"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistroAtencion";

    }

    public ArrayList<Atencion> listarAtenciones() {
        ArrayList<Atencion> lista = new ArrayList<>();
        AtencionDao atencionDao = new AtencionDao();
        lista = atencionDao.listarAtenciones();
        return lista;
    }

    public String eliminar() {
        AtencionDao atencionDao = new AtencionDao();
        boolean respuesta = atencionDao.eliminarAtencion(atencion);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino con exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/RegistroAtencion";
    }

    public String limpiar() {
        return "/RegistroAtencion";
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

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public ArrayList getListapersonales() {
        return listapersonales;
    }

    public void setListapersonales(ArrayList listapersonales) {
        this.listapersonales = listapersonales;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public Clientepormascota getMascotaporcliente() {
        return mascotaporcliente;
    }

    public void setMascotaporcliente(Clientepormascota mascotaporcliente) {
        this.mascotaporcliente = mascotaporcliente;
    }

    public ClientepormascotaId getMascotaporclienteid() {
        return mascotaporclienteid;
    }

    public void setMascotaporclienteid(ClientepormascotaId mascotaporclienteid) {
        this.mascotaporclienteid = mascotaporclienteid;
    }

    public Tipoatencion getTipoatencion() {
        return tipoatencion;
    }

    public void setTipoatencion(Tipoatencion tipoatencion) {
        this.tipoatencion = tipoatencion;
    }

    public ArrayList getListatipoatenciones() {
        return listatipoatenciones;
    }

    public void setListatipoatenciones(ArrayList listatipoatenciones) {
        this.listatipoatenciones = listatipoatenciones;
    }

    public int getIdTipoAtencion() {
        return idTipoAtencion;
    }

    public void setIdTipoAtencion(int idTipoAtencion) {
        this.idTipoAtencion = idTipoAtencion;
    }

    
}
