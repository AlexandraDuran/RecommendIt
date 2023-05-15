/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

/**
 *
 * @author Anyela Herrera
 */
public class Usuario {
    private String nombre;
    private String correo;
    private String usuario;
    private String contraseña;
    private int id;

    public Usuario() {
    }

    public Usuario(String nombre, String correo, String usuario, String contraseña, int id) {
        this.nombre = nombre;
        this.correo = correo;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.id = id;
    }
    
    public Usuario (int id){
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + 
                ", correo=" + correo + 
                ", usuario=" + usuario + 
                ", contrase\u00f1a=" + contraseña + 
                ", id=" + id + '}';
    }
    
}
