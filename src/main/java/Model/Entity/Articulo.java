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
    private int id;
//    private int id_comentario;
//    private int id_usuario;

    public Articulo() {
    }

    public Articulo(String titulo, String foto, String descripcion, int id) {
        this.titulo = titulo;
        this.foto = foto;
        this.descripcion = descripcion;
        this.id = id;
    }
    
//    public Usuario (int id){
//        
//    }

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

    @Override
    public String toString() {
        return "Articulo{" + "titulo=" + titulo + 
                ", foto=" + foto + ", descripcion=" + 
                descripcion + ", id=" + id + '}';
    }

    

}
