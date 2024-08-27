package phonebook_tests.dto_tests.httpclient;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import phonebook.dto.AuthRequestDto;
import phonebook.dto.AuthResponseDto;
import phonebook.dto.ErrorDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LoginHttpClientTests {
  @Test
  public void LoginHtmlClientTest() throws IOException {
    Response response = Request.Post("https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword")
        .bodyString("{\n" +
            " \"username\":\"user_admin_new3@gmail.com\",\n" +
            " \"password\":\"Password@1\"\n" + "}", ContentType.APPLICATION_JSON)
        .execute();
    System.out.println(response);

    String responseJson = response.returnContent().asString();
    System.out.println(responseJson);

    JsonElement element = JsonParser.parseString(responseJson);
    JsonElement token = element.getAsJsonObject().get("token");
    System.out.println(token.getAsString());
  }

  @Test
  public void loginSuccessfulWithDto() throws IOException {
    AuthRequestDto requestDto = AuthRequestDto.builder()
        .username("user_admin_new3@gmail.com")
        .password("Password@1")
        .build();
    Gson gson = new Gson();
    Response response = Request.Post("https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword")
        .bodyString(gson.toJson(requestDto), ContentType.APPLICATION_JSON)
        .execute();
    String responseJson = response.returnContent().asString();
    AuthResponseDto authResponseDto = gson.fromJson(responseJson, AuthResponseDto.class);
    System.out.println(authResponseDto);
  }

  @Test
  public void  loginErrorTestDto() throws IOException {
    AuthRequestDto requestDto = AuthRequestDto.builder()
        .username("user_admin_new3@@@@@@@gmail.com")
        .password("Password@1")
        .build();
    Gson gson = new Gson();
    Response response = Request.Post("https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword")
        .bodyString(gson.toJson(requestDto), ContentType.APPLICATION_JSON)
        .execute();
    HttpResponse httpResponse = response.returnResponse();
    //System.out.println(httpResponse);
    System.out.println(httpResponse.getStatusLine().getStatusCode());
    System.out.println(httpResponse.getStatusLine().getProtocolVersion());

    InputStream content = httpResponse.getEntity().getContent();
    BufferedReader reader = new BufferedReader(new InputStreamReader(content));
    String line;
    StringBuilder sb = new StringBuilder();
    while ((line = reader.readLine()) != null){
      sb.append(line);
      System.out.println(line);
    }

    ErrorDto errorDto = gson.fromJson(sb.toString(), ErrorDto.class);
    System.out.println(errorDto.getTimestamp()+ " \n" + errorDto.getStatus() + " \n" + errorDto.getError() + " \n" + errorDto.getMessage() + " \n" + errorDto.getPath());
    Assert.assertEquals(errorDto.getStatus(), 401);
  }
}
