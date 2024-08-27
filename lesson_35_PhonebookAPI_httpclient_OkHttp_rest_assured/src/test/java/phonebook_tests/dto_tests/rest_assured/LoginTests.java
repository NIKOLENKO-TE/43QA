package phonebook_tests.dto_tests.rest_assured;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import phonebook.dto.AuthRequestDto;
import phonebook.dto.AuthResponseDto;
import phonebook.dto.ErrorDto;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class LoginTests extends TestBase{
  AuthRequestDto requestDto = AuthRequestDto.builder()
      .username("user_admin_new3@gmail.com")
      .password("Password@1")
      .build();

  @Test
  public void loginSuccessTest(){
    AuthResponseDto dto = given()
        .contentType(ContentType.JSON)
        .body(requestDto)
        .when()
        .post("user/login/usernamepassword")
        .then()
        .assertThat().statusCode(200)
        .extract().response().as(AuthResponseDto.class);
    System.out.println(dto);
  }

  @Test
  public void loginSuccessTest2(){
    String responseToken = given()
        .contentType(ContentType.JSON)
        .body(requestDto)
        .when()
        .post("user/login/usernamepassword")
        .then()
        .assertThat().statusCode(200)
        .body(containsString("token"))
        .extract().path("token");
    System.out.println(responseToken);
  }

  @Test
  public void loginWithWrongPasswordTest(){
    ErrorDto errorDto = given()
        .body(AuthRequestDto.builder()
            .username("user_admin_new3@gmail.com")
            .password("Password@@@@@@@@@1")
            .build())
        .contentType(ContentType.JSON)
        .when()
        .post("user/login/usernamepassword")
        .then()
        .assertThat().statusCode(401)
        .extract().response().as(ErrorDto.class);
//    System.out.println(errorDto);
//    System.out.println(errorDto.getMessage());
//    System.out.println(errorDto.getError());
//    System.out.println(errorDto.getTimestamp());
//    System.out.println(errorDto.getPath());
//    System.out.println(errorDto.getStatus());
    Assert.assertEquals(errorDto.getError(),"Unauthorized");
    Assert.assertEquals(errorDto.getMessage(),"Login or Password incorrect");
  }

  @Test
  public void loginWithWrongPasswordPerfectTest() {
    given()
        .body(AuthRequestDto.builder()
            .username("user_admin_new3@gmail.com")
            .password("Password@@@@@@@@@1")
            .build())
        .contentType(ContentType.JSON)
        .when()
        .post("user/login/usernamepassword")
        .then()
        .assertThat().statusCode(401)
        .assertThat().body("error", equalTo("Unauthorized"))
        .assertThat().body("error", containsString("Unauth"));
  }
}
