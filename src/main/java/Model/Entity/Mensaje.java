/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

/**
 *
 * @author Anyela Herrera
 */
public class Mensaje {
    private int id;
    private String mensajes;
    private String fecha;
    private String hora;
    private Usuario id_usuario;

    public Mensaje() {
    }

    public Mensaje(int id, String mensajes, String fecha, String hora, Usuario id_usuario) {
        this.id = id;
        this.mensajes = mensajes;
        this.fecha = fecha;
        this.hora = hora;
        this.id_usuario = id_usuario;
    }

    public Mensaje(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensajes() {
        return mensajes;
    }

    public void setMensajes(String mensajes) {
        this.mensajes = mensajes;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Mensaje{" + "id=" + id 
                + ", mensajes=" + mensajes 
                + ", fecha=" + fecha 
                + ", hora=" + hora 
                + ", id_usuario=" + id_usuario + '}';
    }
    
    
}
