package phonebook.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class ContactDto {
  private String id;
  private String name;
  private String lastName;
  private String email;
  private String phone;
  private String address;
  private String description;
  private List<ContactDto> contacts;
}
