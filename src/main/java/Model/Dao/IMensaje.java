/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Dao;

import Model.Entity.Mensaje;
import java.util.List;

/**
 *
 * @author Anyela Herrera
 */
public interface IMensaje {
    public int Insertar(Mensaje mensaje);
    public List<Mensaje> consultar();
    public Mensaje consultarId(Mensaje mensaje);
    public int borrar(Mensaje mensaje);
    public int actualizar(Mensaje mensaje);
}