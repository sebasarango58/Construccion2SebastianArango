package app.dto;

public class UserDto {
    private long id;
    private PersonDto PersonId; 
    private String username;
    private String password;
    private String Role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PersonDto getPersonId() {
        return PersonId;
    }

    public void setPersonId(PersonDto PersonId) {
        this.PersonId = PersonId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }
    
    

}
