package az.code.unisubscription.dto;

import az.code.unisubscription.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {

    public LoginResponseDto(User user, String token){
        this.token = token;
        this.user = new UserDto(user.getId(), user.getName()+" "+user.getSurname());
    }

    private String token;
    private UserDto user;



    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class UserDto{
    private int id;
    private String fullName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}