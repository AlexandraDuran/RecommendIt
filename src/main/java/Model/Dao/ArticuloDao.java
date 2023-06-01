/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import Red.BaseDeDatos;
import Model.Entity.Articulo;
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
 * @author Anyela Herrera
 */
public class ArticuloDao implements IArticulo {

    final static String SQL_CONSULTAR = "SELECT * FROM articulo";//aterisco para traer todo
    final static String SQL_INSERTAR = "INSERT INTO articulo (id, titulo, foto, descripcion, id_usuario) VALUES(?,?,?,?,?)";//arreglado con las llaves foraneas
    final static String SQL_BORRAR = "DELETE FROM articulo WHERE id = ?";
    final static String SQL_CONSULTARID = "SELECT * FROM articulo WHERE id = ?";
    final static String SQL_ACTUALIZAR = "UPDATE articulo SET titulo = ?, foto = ?, descripcion = ?, id_usuario = ? WHERE id = ?";//arreglado con las llaves foraneas

    @Override
    public int Insertar(Articulo articulo) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_INSERTAR);
            sentencia.setInt(1, articulo.getId());
            sentencia.setString(2, articulo.getTitulo());
            sentencia.setString(3, articulo.getFoto());
            sentencia.setString(4, articulo.getDescripcion());
            sentencia.setString(5, articulo.getId_usuario().getId());//arreglado con las llaves foraneas
            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } finally {
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
            }
        }
        return resultado;
    }

    @Override
    public List<Articulo> consultar() {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        List<Articulo> articulos = new ArrayList<>();
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTAR);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String titulo = resultado.getString("titulo");
                String foto = resultado.getString("foto");
                int id = resultado.getInt("id");
                String descripcion = resultado.getString("descripcion");
                Usuario id_usuario = new Usuario(resultado.getString("id_usuario"));//arreglado con las llaves foraneas
                Articulo articulo = new Articulo(titulo, foto, descripcion, id, id_usuario);
                articulos.add(articulo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } finally {
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
            }

        }
        return articulos;
    }

    @Override
    public Articulo consultarId(Articulo articulo) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        Articulo rArticulo = null;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTARID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setInt(1, articulo.getId());
            resultado = sentencia.executeQuery();
            resultado.absolute(1);
            String titulo = resultado.getString("titulo");
            String foto = resultado.getString("foto");
            String descripcion = resultado.getString("descripcion");
            int id = resultado.getInt("id");
            Usuario id_usuario = new Usuario(resultado.getString("id_usuario"));//arreglado con las llaves foraneas
            rArticulo = new Articulo(titulo, foto, descripcion, id, id_usuario);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } finally {
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
            }
        }
        return rArticulo;
    }

    @Override
    public int borrar(Articulo articulo) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_BORRAR);
            sentencia.setInt(1, articulo.getId());
            resultado = sentencia.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class
                    .getName()).log(Level.SEVERE, SQL_CONSULTAR);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class
                    .getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } finally {
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class
                        .getName()).log(Level.SEVERE, SQL_CONSULTAR);
            }
        }
        return resultado;
    }

    @Override
    public int actualizar(Articulo articulo) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_ACTUALIZAR);
            sentencia.setInt(5, articulo.getId());
            sentencia.setString(1, articulo.getTitulo());
            sentencia.setString(2, articulo.getFoto());
            sentencia.setString(3, articulo.getDescripcion());
            sentencia.setString(4, articulo.getId_usuario().getId());//arreglado con las llaves foraneas
            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }
}
