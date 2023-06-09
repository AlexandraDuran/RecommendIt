/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Dao;
import Model.Entity.Foro;
import java.util.List;
/**
 *
 * @author Anyela Herrera
 */
public interface IForo {
    public int Insertar(Foro foro);
    public List<Foro> consultar();
    public Foro consultarId(Foro foro);
    public int borrar(Foro foro);
    public int actualizar(Foro foro);
    public Foro consultarPorNombre(Foro foro);
}
