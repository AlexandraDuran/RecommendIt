/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

/**
 *
 * @author Anyela Herrera actual
 */
public class Articulo {

    private String titulo;
    private String foto;
    private String descripcion;
    private int id;
//    private int id_comentario;
    private Usuario id_usuario;

    public Articulo() {
    }

    public Articulo(int id) {
        this.id=id;
    }

    public Articulo(String titulo, String foto, String descripcion, int id, Usuario id_usuario) {
        this.titulo = titulo;
        this.foto = foto;
        this.descripcion = descripcion;
        this.id = id;
        this.id_usuario = id_usuario;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Articulo{" + "titulo=" + titulo
                + ", foto=" + foto + ", descripcion="
                + descripcion + ", id=" + id
                + ", id_usuario=" + id_usuario + '}';
    }

}
