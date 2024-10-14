package app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {
    
    private long id;
    private PersonDto PersonId; 
    private String username;
    private String password;
    private String Role;


}
