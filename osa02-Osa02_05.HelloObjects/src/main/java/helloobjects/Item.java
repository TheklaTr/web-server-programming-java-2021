package helloobjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // creates a parameterless constructor for the class
@AllArgsConstructor // creates a constructor containing all attributes
@Data // create getters, setters, equals-method, hashcode-method, and toString-method
public class Item {

  private String name;
  private String type;
}
