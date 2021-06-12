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
        this.user = new UserDto(user);
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

