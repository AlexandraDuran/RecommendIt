/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Model.Dao.UsuarioDao;
import Model.Entity.Usuario;
/**
 *
 * @author SEBASTIAN
 */
public class Test {

    public static void main(String[] args) {
        UsuarioDao usuarioDao = new UsuarioDao();
        
        //consultar
//        System.out.println("consultar");
//        System.out.println(usuarioDao.consultar());
        
        //insertar
//        Usuario t = new Usuario("peter", "spidey@gmail.com", "000004", "4");
//        System.out.println("resultado: " + usuarioDao.Insertar(t));
        
        //consultar por id
//        Usuario t = new Usuario("2");
//        System.out.println("consultar por id" + usuarioDao.consultarId(t));
        
        //eliminar
//        Usuario t = new Usuario("000007");
//        System.out.println("eliminar");
//        usuarioDao.borrar(t);

        //actualizar
        System.out.println("actualizar");
        Usuario t = new Usuario("juakin", "juakin@gmail.com", "000006", "2");
        int result = usuarioDao.actualizar(t);
    }
}