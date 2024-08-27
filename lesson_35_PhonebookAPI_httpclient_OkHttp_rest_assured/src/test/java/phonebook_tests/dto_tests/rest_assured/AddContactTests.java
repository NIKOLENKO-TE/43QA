package phonebook_tests.dto_tests.rest_assured;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import phonebook.dto.ContactDto;
import phonebook.dto.ErrorDto;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class AddContactTests extends TestBase{
  ContactDto contactDto = ContactDto.builder()
      //.id("464646465464")
      .name("UserName")
      .lastName("UserName LastName")
      .email("email@gmail.com")
      .phone("1234567890")
      .address("Germany, Berlin")
      .description("Description")
      .build();

  @Test
  public void addNewContactTest(){
    given()
        .header(AUTH, TOKEN)
        .body(contactDto)
        .contentType(ContentType.JSON)
        .when()
        .post("contacts")
        .then()
        .assertThat().statusCode(200)
        .assertThat().body("message", containsString("Contact was added!"))
        .assertThat().body(containsString("Contact was added!"))
        ;
   // System.out.println(message); // Contact was added! ID: fc7ff299-b320-40ba-9fa0-408c1ca662d1
  }


  @Test
  public void addContactWithOutNameTest(){
    ContactDto contactWONameDto = ContactDto.builder()
      //.id("464646465464")
      //.name("UserName")
        .lastName("UserName LastName")
        .email("email@gmail.com")
        .phone("1234567890")
        .address("Germany, Berlin")
        .description("Description")
        .build();
    ErrorDto errorDto = given()
        .header(AUTH, TOKEN)
        .body(contactWONameDto)
        .contentType(ContentType.JSON)
        .when()
        .post("contacts")
        .then()
        .assertThat().statusCode(400)
        .extract().response().as(ErrorDto.class);
    System.out.println(errorDto); // name=must not be blank
    Assert.assertTrue(errorDto.getMessage().toString().contains("name=must not be blank"));
  }
  @Test
  public void addContactWithShortPhoneTest(){
    ContactDto contactWithShortPhoneDto = ContactDto.builder()
        //.id("464646465464")
        .name("UserName")
        .lastName("UserName LastName")
        .email("email@gmail.com")
        .phone("123")
        .address("Germany, Berlin")
        .description("Description")
        .build();
    ErrorDto errorDto = given()
        .header(AUTH, TOKEN)
        .body(contactWithShortPhoneDto)
        .contentType(ContentType.JSON)
        .when()
        .post("contacts")
        .then()
        .assertThat().statusCode(400)
        .extract().response().as(ErrorDto.class);
    System.out.println(errorDto);
    Assert.assertTrue(errorDto.getMessage().toString().contains("phone=Phone number must contain only digits! And length min 10, max 15!"));
  }
}
