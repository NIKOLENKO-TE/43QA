package phonebook_tests.dto_tests.rest_assured;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import phonebook.dto.ContactDto;

import static io.restassured.RestAssured.given;

public class GetContactsTests extends TestBase{

  @Test
  public void printContacts() {
    ContactDto contacts = given()
        .header(AUTH, TOKEN)
        .contentType(ContentType.JSON)
        .when()
        .get("contacts")
        .then()
        .assertThat().statusCode(200)
        .extract().response().as(ContactDto.class);

    // Используем Gson для преобразования объекта в JSON строку
    Gson gson = new Gson();
    String contactsJson = gson.toJson(contacts);

    // Выводим JSON в консоль
    System.out.println(contactsJson);

    // Или можем вывести контакты более структурировано
    for (ContactDto contact : contacts.getContacts()) {
      System.out.println(contact);
    }
  }
}
