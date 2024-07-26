package phonebook.model;

public class User {

  // ! Удалить final
  private String mail;
  private String password;

//! удалить конструктор
//  public User(String mail, String password) {
//    this.mail = mail;
//    this.password = password;
//  }


  // ! void меняем на USER
  public User setMail(String mail) {
    this.mail = mail;
    return this;
  }

  public User setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getMail() {
    return mail;
  }

  public String getPassword() {
    return password;
  }

  // * в методах мы будем использовать get а в тестах - set
}
