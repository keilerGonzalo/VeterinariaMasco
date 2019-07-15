/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Clientepormascota;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author USUARIO
 */
public interface IClientepormascota {
    public abstract boolean guardarClientepormascota(Clientepormascota mascotaporcliente);
    public abstract ArrayList<Clientepormascota> listarClientepormascota();
    public abstract boolean actualizarClientepormascota(Clientepormascota mascotaporcliente);
    public abstract boolean eliminarClientepormascota(Clientepormascota mascotaporcliente);

}
