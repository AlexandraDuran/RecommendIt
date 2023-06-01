/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

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
 * @author Leydi
 */
public class TemaDao implements ITema {

    final static String SQL_CONSULTAR = "SELECT * FROM tema";//aterisco para traer todo
    final static String SQL_INSERTAR = "INSERT INTO tema (id, nombre, id_usuario) VALUES(?,?,?)";//arreglado con las llaves foraneas
    final static String SQL_BORRAR = "DELETE FROM tema WHERE id = ?";
    final static String SQL_CONSULTARID = "SELECT * FROM tema WHERE id = ?";
    final static String SQL_ACTUALIZAR = "UPDATE tema SET nombre = ?, id_usuario=? WHERE id = ?";

    @Override
    public int Insertar(Tema tema) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_INSERTAR);
            sentencia.setInt(1, tema.getId());
            sentencia.setString(2, tema.getNombre());
            sentencia.setString(3, tema.getId_usuario().getId());//arreglado con las llaves foraneas

            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TemaDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TemaDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } finally {
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(TemaDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
            }
        }
        return resultado;
    }

    @Override
    public List<Tema> consultar() {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        List<Tema> temas = new ArrayList<>();
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTAR);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                Usuario id_usuario = new Usuario(resultado.getString("id_usuario"));//arreglado con las llaves foraneas
                Tema tema = new Tema(id, nombre, id_usuario);//arreglado con las llaves foraneas
                temas.add(tema);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TemaDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TemaDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } finally {
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(TemaDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
            }

        }
        return temas;
    }

    @Override
    public Tema consultarId(Tema tema) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        Tema rTema = null;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTARID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setInt(1, tema.getId());
            resultado = sentencia.executeQuery();
            resultado.absolute(1);
            int id = resultado.getInt("id");
            String nombre = resultado.getString("nombre");
            Usuario id_usuario = new Usuario(resultado.getString("id_usuario"));//arreglado con las llaves foraneas
            rTema = new Tema(id, nombre, id_usuario);//arreglado con las llaves foraneas
        } catch (SQLException ex) {
            Logger.getLogger(TemaDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TemaDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } finally {
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(TemaDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
            }

        }
        return rTema;
    }

    @Override
    public int borrar(Tema tema) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_BORRAR);
            sentencia.setInt(1, tema.getId());
            resultado = sentencia.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(TemaDao.class
                    .getName()).log(Level.SEVERE, SQL_CONSULTAR);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TemaDao.class
                    .getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } finally {
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);

            } catch (SQLException ex) {
                Logger.getLogger(TemaDao.class
                        .getName()).log(Level.SEVERE, SQL_CONSULTAR);
            }
        }
        return resultado;
    }

    @Override
    public int actualizar(Tema tema) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_ACTUALIZAR);
            sentencia.setInt(3, tema.getId());
            sentencia.setString(1, tema.getNombre());
            sentencia.setString(2, tema.getId_usuario().getId());//arreglado con las llaves foraneas

            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TemaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TemaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(TemaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }
}
