package fr.baldir.architecture;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ExampleResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/technical-architecture-document")
          .then()
             .statusCode(200)
             .body(is(loadResourceAsString("expected-demo-result.md")));
    }

    private String loadResourceAsString(String resourceName){
      ClassLoader classLoader = this.getClass().getClassLoader();
      try(var inputStream = classLoader.getResourceAsStream(resourceName)){
        return IOUtils.toString(inputStream,"UTF-8");
      }catch(IOException ioException){
        fail("Cannot load test fixture reource : "+resourceName);
        return "";
      }

    }

}
