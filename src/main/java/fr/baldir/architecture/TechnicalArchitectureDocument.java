package fr.baldir.architecture;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import io.quarkus.qute.Template;

@Path("/technical-architecture-document")
public class TechnicalArchitectureDocument {

    @Inject
    Template header;

    @Inject
    Template intro;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String fullDemoTemplate() {
        return "hello";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String generate(@MultipartForm GenerateDocument command) {

        StringBuilder builder = new StringBuilder();
        builder.append(header.data("test", command.outputType).render());
        builder.append(intro.data("test", command.outputType).render());
        return builder.toString();
    }

}