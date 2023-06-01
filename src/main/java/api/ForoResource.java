/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import Model.Dao.ForoDao;
import Model.Entity.Foro;
import jakarta.ws.rs.Consumes;
//import jakarta.ws.rs.DELETE;
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
@Path("/apiforo")
public class ForoResource {
    ForoDao foroDao = new ForoDao();

    @GET
    @Path("/foros")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar() {
        List<Foro> foros = new ArrayList<>();
        foros = foroDao.consultar();
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .entity(foros)
                .build();
    }

    @GET
    @Path("/foro/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarId(@PathParam("id") int id) {
        Foro foros = new Foro(id);
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .entity(foroDao.consultarId(foros))
                .build();
    }

    @POST
    @Path("/foro")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Foro foros) {
        try {
            foroDao.Insertar(foros);
            return Response.status(Response.Status.CREATED).entity(foros).build();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

//    @DELETE
//    @Path("/usuario/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response borrar(@PathParam("id") int id) {
//        Foro articulo = new Foro(id);
//        int i = articuloDao.borrar(articulo);
//        if (i == 0) {
//            return Response
//                    .status(Response.Status.BAD_REQUEST)
//                    .header("Access-Control-Allow-Origin", "*")
//                    .entity("Usuario not found")
//                    .build();
//        } else {
//            return Response.ok("Correcto").build();
//        }
//    }
    @Path("/updateforo")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizar(Foro foro) {
       try{
            foroDao.actualizar(foro);
            return Response.status(Response.Status.CREATED).entity(foro).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    } 
}
