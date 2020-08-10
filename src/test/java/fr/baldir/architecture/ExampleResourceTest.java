package fr.baldir.architecture;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ExampleResourceTest {

  @Test
  public void testHelloEndpoint() {

    given().when().get("/technical-architecture-document")
    .then().statusCode(200)
    .body(equalTo(expectedDemoResult()));
  }

  private String expectedDemoResult() {
    StringBuilder builder = new StringBuilder();
    builder.append("# Document d'architecture technique");
    builder.append("\n\n");
    builder.append("Auteur : Marc Bouvier");
    builder.append("\n\n");
    builder.append("#");
    return builder.toString();
  }

}
