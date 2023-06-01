/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

/**
 *
 * @author Leydi
 */
public class Comentario {

    private int id;
    private String comentario;
    private String fecha;
    private String calificacion;
    private Usuario id_usuario;
    private Articulo id_articulo;

    public Comentario() {
    }

    public Comentario(int id, String comentario, String fecha, String calificacion, Usuario id_usuario, Articulo id_articulo) {
        this.id = id;
        this.comentario = comentario;
        this.fecha = fecha;
        this.calificacion = calificacion;
        this.id_usuario = id_usuario;
        this.id_articulo = id_articulo;
    }

    public Comentario(int id) {
        this.id = id;
    }   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Articulo getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(Articulo id_articulo) {
        this.id_articulo = id_articulo;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id 
                + ", comentario=" + comentario 
                + ", fecha=" + fecha 
                + ", calificacion=" + calificacion 
                + ", id_usuario=" + id_usuario 
                + ", id_articulo=" + id_articulo + '}';
    }
    
    
}
