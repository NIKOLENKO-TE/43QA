package phonebook;

public class Contact {
  private final String name;
  private final String lastName;
  private final String phone;
  private final String email;
  private final String address;
  private final String description;

  public Contact(String name, String lastName, String phone, String email, String address, String description) {
    this.name = name;
    this.lastName = lastName;
    this.phone = phone;
    this.email = email;
    this.address = address;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }

  public String getAddress() {
    return address;
  }

  public String getDescription() {
    return description;
  }
}
