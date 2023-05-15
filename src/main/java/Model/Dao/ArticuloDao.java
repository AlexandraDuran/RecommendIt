/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import Red.BaseDeDatos;
import Model.Entity.Articulo;
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
    final static String SQL_INSERTAR = "INSERT INTO articulo (id, titulo, foto, descripcion) VALUES(?,?,?,?)";
    final static String SQL_BORRAR = "DELETE FROM articulo WHERE id = ?";
    final static String SQL_CONSULTARID = "SELECT * FROM articulo WHERE id = ?";
    final static String SQL_ACTUALIZAR = "UPDATE articulo SET titulo = ?, foto = ?, descripcion = ?, WHERE id = ?";

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
            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
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
                Articulo articulo = new Articulo(titulo, foto, descripcion, id);
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
            rArticulo = new Articulo(titulo, foto, descripcion, id);
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
            sentencia.setInt(4, articulo.getId());
            sentencia.setString(1, articulo.getTitulo());
            sentencia.setString(2, articulo.getFoto());
            sentencia.setString(3, articulo.getDescripcion());
            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
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
