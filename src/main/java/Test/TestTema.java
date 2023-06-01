/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import Model.Dao.TemaDao;
import Model.Entity.Tema;

/**
 *
 * @author Anyela Herrera
 */
public class TestTema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TemaDao temaDao = new TemaDao();
        
        
        //consultar si sirve
//        System.out.println("consulta completa:"+temaDao.consultar());
        
        //insertar
//        Tema t = new Tema(11114, "Ropa"); 
//        System.out.println("resultado: " + temaDao.Insertar(t));//sale error (0) pero no se si es por la llave foranea que en netbeans no carga como atributo
        
        //consultar por id si sirve
//        Tema t = new Tema(11113);
//        System.out.println("consultar por id" + temaDao.consultarId(t));
        
        //eliminar si sirve
//        Tema t = new Tema(11113);
//        System.out.println("eliminar");
//        temaDao.borrar(t);

        //actualizar si sirve
//        System.out.println("actualizar");
//        Tema t = new Tema(11113, "Fiesta");
//        int result = temaDao.actualizar(t);
    }
    
}
