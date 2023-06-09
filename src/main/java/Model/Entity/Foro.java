/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

/**
 *
 * @author Anyela Herrera
 */
public class Foro {

    private int id;
    private String nombre;
    private Mensaje id_mensaje;
    private Tema id_tema;
    private Usuario id_usuario;

    public Foro() {
    }

    public Foro(int id, String nombre, Mensaje id_mensaje, Tema id_tema, Usuario id_usuario) {
        this.id = id;
        this.nombre = nombre;
        this.id_mensaje = id_mensaje;
        this.id_tema = id_tema;
        this.id_usuario = id_usuario;
    }

    public Foro(int id) {
        this.id=id;
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

    public Mensaje getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(Mensaje id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public Tema getId_tema() {
        return id_tema;
    }

    public void setId_tema(Tema id_tema) {
        this.id_tema = id_tema;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Foro{" + "id=" + id
                + ", nombre=" + nombre
                + ", id_mensaje=" + id_mensaje
                + ", id_tema=" + id_tema
                + ", id_usuario=" + id_usuario + '}';
    }

}
