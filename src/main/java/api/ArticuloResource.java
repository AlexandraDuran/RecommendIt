/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import Model.Dao.ArticuloDao;
import Model.Entity.Articulo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Sebastian Martinez
 */
@Path("/apiarticulo")
public class ArticuloResource {
   ArticuloDao articuloDao = new ArticuloDao();

    @GET
    @Path("/articulo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar() {
        List<Articulo> articulos = new ArrayList<>();
        articulos = articuloDao.consultar();
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .entity(articulos)
                .build();
    }

    @GET
    @Path("/articulo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarId(@PathParam("id") int id) {
        Articulo articulo = new Articulo(id);
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .entity(articuloDao.consultarId(articulo))
                .build();
    }

    @POST
    @Path("/usuario")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Articulo articulo) {
        try {
            articuloDao.Insertar(articulo);
            return Response.status(Response.Status.CREATED).entity(articulo).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("/usuario/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrar(@PathParam("id") int id) {
        Articulo articulo = new Articulo(id);
        int i = articuloDao.borrar(articulo);
        if (i == 0) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Access-Control-Allow-Origin", "*")
                    .entity("Usuario not found")
                    .build();
        } else {
            return Response.ok("Correcto").build();
        }
    }
    @Path("/usuario")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizar(Articulo articulo) {
       try{
            articuloDao.actualizar(articulo);
            return Response.status(Response.Status.CREATED).entity(articulo).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    } 
}
