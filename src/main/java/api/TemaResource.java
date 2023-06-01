/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import Model.Dao.TemaDao;
import Model.Entity.Tema;
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
@Path("/apitema")
public class TemaResource {
    TemaDao temaDao = new TemaDao();

    @GET
    @Path("/temas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar() {
        List<Tema> temas = new ArrayList<>();
        temas = temaDao.consultar();
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .entity(temas)
                .build();
    }

    @GET
    @Path("/tema/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarId(@PathParam("id") int id) {
        Tema tema = new Tema(id);
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .entity(temaDao.consultarId(tema))
                .build();
    }

    @POST
    @Path("/creartema")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Tema tema) {
        try {
            temaDao.Insertar(tema);
            return Response.status(Response.Status.CREATED).entity(tema).build();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
            
        }
    }

//    @DELETE
//    @Path("/usuariodelete/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response borrar(@PathParam("id") String id) {
//        Tema usuario = new Tema(id);
//        int i = usuarioDao.borrar(usuario);
//        if (i == 0) {
//            return Response
//                    .status(Response.Status.BAD_REQUEST)
//                    .header("Access-Control-Allow-Origin", "*")
//                    .entity("Tema not found")
//                    .build();
//        } else {
//            return Response.ok("Correcto").build();
//        }
//    }
    @Path("/updatetema")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizar(Tema tema) {
       try{
            temaDao.actualizar(tema);
            return Response.status(Response.Status.CREATED).entity(tema).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    }
}
