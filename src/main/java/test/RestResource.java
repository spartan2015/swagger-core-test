package test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.jaxrs.Reader;
import io.swagger.jaxrs.config.DefaultReaderConfig;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.models.Swagger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 */
@Path("start")
public class RestResource {

    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public Swagger get(){
        Swagger swagger = new SwaggerContextService()
                .withBasePath("some base path")
                .getSwagger();
        DefaultReaderConfig rc = new DefaultReaderConfig();
        rc.setScanAllResources(true);

        Reader reader = new Reader(swagger, rc);

        reader.read(RestResource.class);

        return swagger;
    }

}
