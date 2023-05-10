/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

/**
 *
 * @author Anyela Herrera
 */
public class Articulo {

    private String titulo;
    private String foto;
    private String descripcion;
    private String id;
//    private String id_comentario;
//    private String id_usuario;

    public Articulo() {
    }

    public Articulo(String titulo, String foto, String descripcion, String id, String id_comentario, String id_usuario) {
        this.titulo = titulo;
        this.foto = foto;
        this.descripcion = descripcion;
        this.id = id;
//        this.id_comentario = id_comentario;
//        this.id_usuario = id_usuario;
    }

    public Articulo(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public String getId_comentario() {
//        return id_comentario;
//    }
//
//    public void setId_comentario(String id_comentario) {
//        this.id_comentario = id_comentario;
//    }
//
//    public String getId_usuario() {
//        return id_usuario;
//    }
//
//    public void setId_usuario(String id_usuario) {
//        this.id_usuario = id_usuario;
//    }

    @Override
    public String toString() {
        return "Articulo{" + "titulo=" + titulo + 
                ", foto=" + foto + ", descripcion=" + 
                descripcion + ", id=" + id + '}';
    }

    

}
