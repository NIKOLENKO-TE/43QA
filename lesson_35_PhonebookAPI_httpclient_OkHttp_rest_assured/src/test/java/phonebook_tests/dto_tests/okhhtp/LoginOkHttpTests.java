package phonebook_tests.dto_tests.okhhtp;

import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import phonebook.dto.AuthRequestDto;
import phonebook.dto.AuthResponseDto;

import java.io.IOException;

public class LoginOkHttpTests {
  Gson gson = new Gson();
  public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
  OkHttpClient client = new OkHttpClient();

  @Test
  public void loginSuccessfulTest() throws IOException {
    AuthRequestDto requestDto = AuthRequestDto.builder()
        .username("user_admin_new3@gmail.com")
        .password("Password@1")
        .build();
    RequestBody body = RequestBody.create(gson.toJson(requestDto), JSON);
    okhttp3.Request request = new okhttp3.Request.Builder()
        .url("https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword")
        .post(body)
        .build();
    Response response = client.newCall(request).execute();
    String responseJson = response.body().string();
    System.out.println(responseJson);

    AuthResponseDto authResponseDto = gson.fromJson(responseJson, AuthResponseDto.class);
    System.out.println(authResponseDto.getToken());
    Assert.assertEquals(200, response.code());
  }

  @Test
  public void loginFailedPasswordTest() throws IOException {
    AuthRequestDto requestDto = AuthRequestDto.builder()
        .username("user_admin_new3@gmail.com")
        .password("Password@@@1")
        .build();
    RequestBody body = RequestBody.create(gson.toJson(requestDto), JSON);
    okhttp3.Request request = new okhttp3.Request.Builder()
        .url("https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword")
        .post(body)
        .build();
    Response response = client.newCall(request).execute();
    String errorJson = response.body().string();
    System.out.println(errorJson);

    AuthResponseDto authResponseDto = gson.fromJson(errorJson, AuthResponseDto.class);
    // System.out.println(authResponseDto.getToken());
    Assert.assertTrue(errorJson.contains("Login or Password incorrect"));
    Assert.assertEquals(401, response.code());
  }
}
