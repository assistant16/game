package Game.dto;

public class UserDto {

    private Long Id;
    private String name;
    private String password;
    private String email;

    public UserDto(){}

    public UserDto(Long id, String name, String password, String email) {
        this.Id = Id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
