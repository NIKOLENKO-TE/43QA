package phonebook_tests.dto_tests.rest_assured;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class TestBase {
//protected final String baseURI = "https://contactapp-telran-backend.herokuapp.com";
  protected final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoidXNlcl9hZG1pbl9uZXczQGdtYWlsLmNvbSIsImlzcyI6IlJlZ3VsYWl0IiwiZXhwIjoxNzI1MzQ5NTQ1LCJpYXQiOjE3MjQ3NDk1NDV9.YPg64XOxqfRbzz-Vx0ukYroUNySeYoh50OK1r1vCzfA";
  protected final String AUTH = "Authorization";

  @BeforeMethod
  public void init(){
    RestAssured.baseURI = "https://contactapp-telran-backend.herokuapp.com";
    RestAssured.basePath = "v1";
  }
}
