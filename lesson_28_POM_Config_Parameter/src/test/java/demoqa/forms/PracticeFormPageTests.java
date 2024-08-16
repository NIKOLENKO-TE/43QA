package demoqa.forms;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.PracticeFormPage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormPageTests extends TestBase {
  @BeforeMethod
  public void precondition() {
    new HomePage(driver).getForms();
    new SidePage(driver).selectPracticeFormMenu().hideAds();
  }

  @Test
  public void PracticeFormTest(){
    new PracticeFormPage(driver)
        .enterPersonalData("Beth", "Gibbons","portishead@gmail.com", "1234567890")
        .selectGender("Female")
        //.chooseDateOfBirth("01 Jan 1965")
        .chooseDate("4","May", "1965")
        .enterSubjects(new String[]{"Math", "English"})
        .selectHobbies(new String[]{"Reading", "Music"})
        .uploadPicture("C:/Users/PORTISHEAD/Downloads/portishead/Beth.jpeg")
        .enterCurrentAddress("Portishead, Bristol, UK")
        .selectState("NCR")
        .selectCity("Delhi")
        .submitForm()
        .verifySuccessRegistration("Thanks for submitting the form")
    ;
  }
}
