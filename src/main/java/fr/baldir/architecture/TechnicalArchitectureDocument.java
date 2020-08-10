package fr.baldir.architecture;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

@Path("/technical-architecture-document")
public class TechnicalArchitectureDocument {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String generate(@MultipartForm GenerateDocument command) {

        StringBuilder builder = new StringBuilder();
        builder.append("# Document technique d'architecture");
        builder.append('\n');
        builder.append('\n');
        builder.append(command.outputType);
        return builder.toString();
    }

}