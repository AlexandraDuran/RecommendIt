/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Dao;

import Model.Entity.Comentario;
import java.util.List;
/**
 *
 * @author Leydi
 */
public interface IComentario {
    public int Insertar(Comentario comentario);
    public List<Comentario> consultar();
    public Comentario consultarId(Comentario comentario);
    public int borrar(Comentario comentario);
    public int actualizar(Comentario comentario);
}