/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Dao;

import Model.Entity.Tema;
import java.util.List;

/**
 *
 * @author Leydi
 */
public interface ITema {
    public int Insertar(Tema tema);
    public List<Tema> consultar();
    public Tema consultarId(Tema tema);
    public int borrar(Tema tema);
    public int actualizar(Tema tema);
}