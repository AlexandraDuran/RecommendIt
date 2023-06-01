/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import Model.Entity.Foro;
import Model.Entity.Mensaje;
import Model.Entity.Tema;
import Model.Entity.Usuario;
import Red.BaseDeDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anyela Herrera
 */
public class ForoDao implements IForo {

    final static String SQL_CONSULTAR = "SELECT * FROM foro";//aterisco para traer todo
    final static String SQL_INSERTAR = "INSERT INTO foro (id, nombre, id_mensaje, id_tema, id_usuario) VALUES(?,?,?,?,?)";//arreglado con las llaves foraneas
    final static String SQL_BORRAR = "DELETE FROM foro WHERE id = ?";
    final static String SQL_CONSULTARID = "SELECT * FROM foro WHERE id = ?";
    final static String SQL_ACTUALIZAR = "UPDATE foro SET nombre = ?, id_mensaje =?, id_tema =?, id_usuario=? WHERE id = ?";//arreglado con las llaves foraneas
    final static String SQL_CONSULTARPORNOMBRE = "SELECT * FROM foro WHERE nombre = ?";

    @Override
    public int Insertar(Foro foro) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_INSERTAR);
            sentencia.setInt(1, foro.getId());
            sentencia.setString(2, foro.getNombre());
            sentencia.setInt(3, foro.getId_mensaje().getId());//arreglado con las llaves foraneas
            sentencia.setInt(4, foro.getId_tema().getId());//arreglado con las llaves foraneas
            sentencia.setString(5, foro.getId_usuario().getId());//arreglado con las llaves foraneas
            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ForoDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ForoDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } finally {
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(ForoDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
            }
        }
        return resultado;
    }

    @Override
    public List<Foro> consultar() {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        List<Foro> foros = new ArrayList<>();
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTAR);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                int id = resultado.getInt("id");
                Mensaje id_mensaje = new Mensaje(resultado.getInt("id_mensaje"));//arreglado con las llaves foraneas
                Tema id_tema = new Tema(resultado.getInt("id_tema"));//arreglado con las llaves foraneas
                Usuario id_usuario = new Usuario(resultado.getString("id_usuario"));//arreglado con las llaves foraneas
                Foro foro = new Foro(id, nombre, id_mensaje, id_tema, id_usuario);//arreglado con las llaves foraneas
                foros.add(foro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ForoDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ForoDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } finally {
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(ForoDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
            }

        }
        return foros;
    }

    @Override
    public Foro consultarId(Foro foro) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        Foro rForo = null;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTARID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setInt(1, foro.getId());
            resultado = sentencia.executeQuery();
            resultado.absolute(1);
            String nombre = resultado.getString("nombre");
            int id = resultado.getInt("id");
            Mensaje id_mensaje = new Mensaje(resultado.getInt("id_mensaje"));//arreglado con las llaves foraneas
            Tema id_tema = new Tema(resultado.getInt("id_tema"));//arreglado con las llaves foraneas
            Usuario id_usuario = new Usuario(resultado.getString("id_usuario"));//arreglado con las llaves foraneas
            rForo = new Foro(id, nombre, id_mensaje, id_tema, id_usuario);//arreglado con las llaves foraneas
        } catch (SQLException ex) {
            Logger.getLogger(ForoDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ForoDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
            System.out.println(ex.getMessage());

        } finally {
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(ForoDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
            }
        }
        return rForo;
    }

    @Override
    public int borrar(Foro foro) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_BORRAR);
            sentencia.setInt(1, foro.getId());
            resultado = sentencia.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ForoDao.class
                    .getName()).log(Level.SEVERE, SQL_CONSULTAR);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ForoDao.class
                    .getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } finally {
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);

            } catch (SQLException ex) {
                Logger.getLogger(ForoDao.class
                        .getName()).log(Level.SEVERE, SQL_CONSULTAR);
            }
        }
        return resultado;
    }

    @Override
    public int actualizar(Foro foro) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_ACTUALIZAR);
            sentencia.setInt(5, foro.getId());
            sentencia.setString(1, foro.getNombre());
            sentencia.setInt(2, foro.getId_mensaje().getId());//arreglado con las llaves foraneas
            sentencia.setInt(3, foro.getId_tema().getId());//arreglado con las llaves foraneas
            sentencia.setString(4, foro.getId_usuario().getId());//arreglado con las llaves foraneas
            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ForoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ForoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);
                
            } catch (SQLException ex) {
                Logger.getLogger(ForoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    @Override
    public Foro consultarPorNombre(Foro foro) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        Foro rForo = null;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTARPORNOMBRE, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setString(1, foro.getNombre());
            resultado = sentencia.executeQuery();
            resultado.absolute(1);
            String nombre = resultado.getString("nombre");
            int id = resultado.getInt("id");
            Mensaje id_mensaje = new Mensaje(resultado.getInt("id_mensaje"));//arreglado con las llaves foraneas 
            Tema id_tema = new Tema(resultado.getInt("id_tema"));//arreglado con las llaves foraneas 
            Usuario id_usuario = new Usuario(resultado.getString("is_usuario"));//arreglado con las llaves foraneas 
            rForo = new Foro(id, nombre, id_mensaje, id_tema, id_usuario);//arreglado con las llaves foraneas 
        } catch (SQLException ex) {
            Logger.getLogger(ForoDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ForoDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } finally {
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(ForoDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
            }
        }
        return rForo;
    }
}
