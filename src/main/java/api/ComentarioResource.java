/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;
import Model.Dao.ComentarioDao;
import Model.Entity.Comentario;
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
 * @author Anyela Herrera
 */
@Path("/apicomentario")
public class ComentarioResource {
    ComentarioDao comentarioDao = new ComentarioDao();

    @GET
    @Path("/comentario")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar() {
        List<Comentario> comentarios = new ArrayList<>();
        comentarios = comentarioDao.consultar();
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .entity(comentarios)
                .build();
    }

    @GET
    @Path("/comentario/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarId(@PathParam("id") int id) {
        Comentario comentario = new Comentario(id);
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .entity(comentarioDao.consultarId(comentario))
                .build();
    }

    @POST
    @Path("/crearcomentario")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Comentario comentario) {
        try {
            comentarioDao.Insertar(comentario);
            return Response.status(Response.Status.CREATED).entity(comentario).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

//    @DELETE
//    @Path("/usuariodelete/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response borrar(@PathParam("id") String id) {
//        Comentario usuario = new Comentario(id);
//        int i = usuarioDao.borrar(usuario);
//        if (i == 0) {
//            return Response
//                    .status(Response.Status.BAD_REQUEST)
//                    .header("Access-Control-Allow-Origin", "*")
//                    .entity("Comentario not found")
//                    .build();
//        } else {
//            return Response.ok("Correcto").build();
//        }
//    }
    @Path("/updatecomentario")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizar(Comentario comentario) {
       try{
            comentarioDao.actualizar(comentario);
            return Response.status(Response.Status.CREATED).entity(comentario).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    }
}
