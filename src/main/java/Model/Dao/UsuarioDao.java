/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

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
public class UsuarioDao implements IUsuario {

    final static String SQL_CONSULTAR = "SELECT * FROM usuario";
    final static String SQL_INSERTAR = "INSERT INTO usuario (id, nombre, correo, usuario,contraseña) VALUES(?,?,?,?,?)";
    final static String SQL_BORRAR = "DELETE FROM usuario WHERE id = ?";
    final static String SQL_CONSULTARID = "SELECT * FROM usuario WHERE id = ?";
    final static String SQL_ACTUALIZAR = "UPDATE usuario SET nombre = ?, correo = ?, usuario = ?, contraseña = ? WHERE id = ?";

    @Override
    public int Insertar(Usuario usuario) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_INSERTAR);
            sentencia.setInt(1, usuario.getId());
            sentencia.setString(2, usuario.getNombre());
            sentencia.setString(4, usuario.getCorreo());
            sentencia.setString(3, usuario.getUsuario());
            sentencia.setString(5, usuario.getContraseña());
            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
        } finally {
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, SQL_CONSULTAR);
            }
        }
        return resultado;
    }

    @Override
    public List<Usuario> consultar() {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTAR);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String correo = resultado.getString("correo");
                String usuario = resultado.getString("usuario");
                String contraseña = resultado.getString("contraseña");
                Usuario usu = new Usuario(nombre, correo, usuario, contraseña, id);
                usuarios.add(usu);
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
        return usuarios;
    }

    @Override
    public Usuario consultarId(Usuario usuario) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        Usuario rUsuario = null;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_CONSULTARID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            sentencia.setInt(1, usuario.getId());
            resultado = sentencia.executeQuery();
            resultado.absolute(1);
            int id = resultado.getInt("id");
            String nombre = resultado.getString("nombre");
            String correo = resultado.getString("correo");
            String usuarioEnUso = resultado.getString("usuario");
            String contraseña = resultado.getString("contraseña");
            rUsuario = new Usuario(nombre, correo, usuarioEnUso, contraseña, id);

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
        return rUsuario;
    }

    @Override
    public int borrar(Usuario usuario) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_BORRAR);
            sentencia.setInt(1, usuario.getId());
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
    public int actualizar(Usuario usuario) {
        Connection connection = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        try {
            connection = BaseDeDatos.getConnection();
            sentencia = connection.prepareStatement(SQL_ACTUALIZAR);
            sentencia.setInt(5, usuario.getId());
            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getCorreo());
            sentencia.setString(3, usuario.getUsuario());
            sentencia.setString(4, usuario.getContraseña());
            resultado = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, SQL_ACTUALIZAR);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, SQL_ACTUALIZAR);
        } finally {
            try {
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(connection);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, SQL_ACTUALIZAR);
            }
        }
        return resultado;
    }

}
