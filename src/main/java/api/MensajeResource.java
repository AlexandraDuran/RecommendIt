/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import Model.Dao.MensajeDao;
import Model.Entity.Mensaje;
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
@Path("/apimensaje")public class MensajeResource {
    
    MensajeDao mensajeDao = new MensajeDao();

    @GET
    @Path("/mensaje")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar() {
        List<Mensaje> mensajes = new ArrayList<>();
        mensajes = mensajeDao.consultar();
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .entity(mensajes)
                .build();
    }

    @GET
    @Path("/mensaje/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarId(@PathParam("id") int id) {
        Mensaje mensaje = new Mensaje(id);
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .entity(mensajeDao.consultarId(mensaje))
                .build();
    }

    @POST
    @Path("/crearmensaje")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Mensaje mensaje) {
        try {
            mensajeDao.Insertar(mensaje);
            return Response.status(Response.Status.CREATED).entity(mensaje).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

//    @DELETE
//    @Path("/usuariodelete/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response borrar(@PathParam("id") String id) {
//        Mensaje usuario = new Mensaje(id);
//        int i = usuarioDao.borrar(usuario);
//        if (i == 0) {
//            return Response
//                    .status(Response.Status.BAD_REQUEST)
//                    .header("Access-Control-Allow-Origin", "*")
//                    .entity("Mensaje not found")
//                    .build();
//        } else {
//            return Response.ok("Correcto").build();
//        }
//    }
    @Path("/updatemensaje")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizar(Mensaje mensaje) {
       try{
            mensajeDao.actualizar(mensaje);
            return Response.status(Response.Status.CREATED).entity(mensaje).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    }
}
