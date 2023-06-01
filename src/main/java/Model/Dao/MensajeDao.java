/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import Model.Entity.Mensaje;
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
public class MensajeDao implements IMensaje {

    final static String SQL_CONSULTAR = "SELECT * FROM mensaje";//aterisco para traer todo
    final static String SQL_INSERTAR = "INSERT INTO mensaje (id, mensajes, fecha, hora, id_usuario) VALUES(?,?,?,?,?)";//arreglado con las llaves foraneas
    final static String SQL_BORRAR = "DELETE FROM mensaje WHERE id = ?";
    final static String SQL_CONSULTARID = "SELECT * FROM mensaje WHERE id = ?";
    final static String SQL_ACTUALIZAR = "UPDATE mensaje SET mensajes = ?, fecha = ?, hora = ? WHERE id = ?";

    @Override
    public int Insertar(Mensaje mensaje) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_INSERTAR);
            sentencia.setInt(1, mensaje.getId());
            sentencia.setString(2, mensaje.getMensajes());
            sentencia.setString(3, mensaje.getFecha());
            sentencia.setString(4, mensaje.getHora());
            sentencia.setString(5,mensaje.getId_usuario().getId());//arreglado con las llaves foraneas
            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MensajeDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MensajeDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } finally {
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(MensajeDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
            }
        }
        return resultado;
    }

    @Override
    public List<Mensaje> consultar() {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        List<Mensaje> mensajes = new ArrayList<>();
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTAR);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String msg = resultado.getString("mensajes");
                String fecha = resultado.getString("fecha");
                String hora = resultado.getString("hora");
                Usuario id_usuario = new Usuario(resultado.getString("id_usuario"));//arreglado con las llaves foraneas
                Mensaje mensaje = new Mensaje(id, msg, fecha, hora, id_usuario);//arreglado con las llaves foraneas
                mensajes.add(mensaje);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MensajeDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MensajeDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } finally {
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(MensajeDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
            }

        }
        return mensajes;
    }

    @Override
    public Mensaje consultarId(Mensaje mensaje) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        Mensaje rMensaje = null;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTARID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setInt(1, mensaje.getId());
            resultado = sentencia.executeQuery();
            resultado.absolute(1);
            int id = resultado.getInt("id");
            String msg = resultado.getString("mensajes");
            String fecha = resultado.getString("fecha");
            String hora = resultado.getString("hora");
            Usuario id_usuario = new Usuario(resultado.getString("id_usuario"));//arreglado con las llaves foraneas
            rMensaje = new Mensaje(id, msg, fecha, hora, id_usuario);//arreglado con las llaves foraneas
        } catch (SQLException ex) {
            Logger.getLogger(MensajeDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MensajeDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } finally {
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(MensajeDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
            }

        }
        return rMensaje;
    }

    @Override
    public int borrar(Mensaje mensaje) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_BORRAR);
            sentencia.setInt(1, mensaje.getId());
            resultado = sentencia.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MensajeDao.class
                    .getName()).log(Level.SEVERE, SQL_CONSULTAR);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MensajeDao.class
                    .getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } finally {
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);

            } catch (SQLException ex) {
                Logger.getLogger(MensajeDao.class
                        .getName()).log(Level.SEVERE, SQL_CONSULTAR);
            }
        }
        return resultado;
    }

    @Override
    public int actualizar(Mensaje mensaje) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_ACTUALIZAR);
            sentencia.setInt(4, mensaje.getId());
            sentencia.setString(1, mensaje.getMensajes());
            sentencia.setString(2, mensaje.getFecha());
            sentencia.setString(3, mensaje.getHora());
            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MensajeDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MensajeDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(MensajeDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

}
