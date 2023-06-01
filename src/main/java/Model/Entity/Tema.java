/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

/**
 *
 * @author Leydi
 */
public class Tema {
    private int id;
    private String nombre;
    private Usuario id_usuario;
    
    public Tema(){
    }

    public Tema(int id, String nombre, Usuario id_usuario) {
        this.id = id;
        this.nombre = nombre;
        this.id_usuario = id_usuario;
    }

    public Tema(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Tema{" + "id=" + id 
                + ", nombre=" + nombre 
                + ", id_usuario=" + id_usuario + '}';
    }
    
    
}
