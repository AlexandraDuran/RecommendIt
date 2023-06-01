/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Dao;

import Model.Entity.Articulo;
import java.util.List;
/**
 *
 * @author Anyela Herrera
 */
public interface IArticulo {
    public int Insertar(Articulo articulo);
    public List<Articulo> consultar();
    public Articulo consultarId(Articulo articulo);
    public int borrar(Articulo articulo);
    public int actualizar(Articulo articulo);
}
