package phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTest extends TestBase {

  @BeforeMethod
  public void precondition() {
    loginExistedUserPositive();
    addNewContactPositiveData(CONTACT_NAME);
  }

  @Test(invocationCount = 1)
  public void createOneAndDeleteOneContactPositiveTest() {
    // Шаг 1: Получить текущее количество контактов
    int sizeBefore = actualSizeOfContacts();
    // Шаг 2: Удалить контакт
    deleteOneContactOnly();
    // Шаг 3: Получить количество контактов после удаления
    int sizeAfterDelete = actualSizeOfContacts();
    // Шаг 4: Проверить, что количество контактов уменьшилось на 1
    Assert.assertEquals(sizeBefore, sizeAfterDelete);
  }

  @Test
  public void deleteAllContactsTests() {
    deleteAllContacts();
    Assert.assertEquals(actualSizeOfContacts(), 0, "Not all contacts were deleted.");
  }

}
