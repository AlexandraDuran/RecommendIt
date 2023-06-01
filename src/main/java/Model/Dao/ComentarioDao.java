/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import Model.Entity.Articulo;
import Red.BaseDeDatos;
import Model.Entity.Comentario;
import Model.Entity.Usuario;
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
 * @author Leydi
 */
public class ComentarioDao implements IComentario {

    final static String SQL_CONSULTAR = "SELECT * FROM comentario";//aterisco para traer todo
    final static String SQL_INSERTAR = "INSERT INTO comentario (id, comentario, fecha, calificacion, id_usuario, id_articulo) VALUES(?,?,?,?,?,?)";//arreglado con las llaves foraneas
    final static String SQL_BORRAR = "DELETE FROM comentario WHERE id = ?";
    final static String SQL_CONSULTARID = "SELECT * FROM comentario WHERE id = ?";
    final static String SQL_ACTUALIZAR = "UPDATE comentario SET comentario = ?, fecha = ?, calificacion = ? WHERE id = ?";

    @Override
    public int Insertar(Comentario comentario) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_INSERTAR);
            sentencia.setInt(1, comentario.getId());
            sentencia.setString(2, comentario.getComentario());
            sentencia.setString(3, comentario.getFecha());
            sentencia.setString(4, comentario.getCalificacion());
            sentencia.setString(5, comentario.getId_usuario().getId());//arreglado con las llaves foraneas
            sentencia.setInt(6, comentario.getId_articulo().getId());//arreglado con las llaves foraneas
            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } finally {
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
            }
        }
        return resultado;
    }

    @Override
    public List<Comentario> consultar() {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        List<Comentario> comentarios = new ArrayList<>();
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTAR);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String comentario = resultado.getString("comentario");
                String fecha = resultado.getString("fecha");
                String calificacion = resultado.getString("calificacion");
                Usuario id_usuario = new Usuario(resultado.getString("id_usuario"));//arreglado con las llaves foraneas
                Articulo id_articulo = new Articulo (resultado.getInt("id_articulo"));//arreglado con las llaves foraneas
                Comentario comentario1 = new Comentario(id, comentario, fecha, calificacion, id_usuario, id_articulo);//arreglado con las llaves foraneas
                comentarios.add(comentario1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } finally {
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
            }

        }
        return comentarios;
    }

    @Override
    public Comentario consultarId(Comentario comentario) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        Comentario rComentario = null;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTARID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setInt(1, comentario.getId());
            resultado = sentencia.executeQuery();
            resultado.absolute(1);
            int id = resultado.getInt("id");
            String coment = resultado.getString("comentario");
            String fecha = resultado.getString("fecha");
            String calificacion = resultado.getString("calificacion");
            Usuario id_usuario = new Usuario(resultado.getString("id_usuario"));//arreglado con las llaves foraneas
            Articulo id_articulo = new Articulo(resultado.getInt("id_articulo"));//arreglado con las llaves foraneas
            rComentario =new Comentario(id, coment, fecha, calificacion, id_usuario, id_articulo);//arreglado con las llaves foraneas
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } finally {
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
            }

        }
        return rComentario;
    }

    @Override
    public int borrar(Comentario comentario) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_BORRAR);
            sentencia.setInt(1, comentario.getId());
            resultado = sentencia.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDao.class
                    .getName()).log(Level.SEVERE, SQL_CONSULTAR);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComentarioDao.class
                    .getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } finally {
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);

            } catch (SQLException ex) {
                Logger.getLogger(ComentarioDao.class
                        .getName()).log(Level.SEVERE, SQL_CONSULTAR);
            }
        }
        return resultado;
    }

    @Override
    public int actualizar(Comentario comentario) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_ACTUALIZAR);
            sentencia.setInt(4, comentario.getId());
            sentencia.setString(1, comentario.getComentario());
            sentencia.setString(2, comentario.getFecha());
            sentencia.setString(3, comentario.getCalificacion());
            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(ComentarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }
}
