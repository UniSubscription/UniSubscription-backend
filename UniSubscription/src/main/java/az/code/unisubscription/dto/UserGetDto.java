package az.code.unisubscription.dto;

import az.code.unisubscription.models.User;

public class UserGetDto {
    public UserGetDto(User user){
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getMail();
    }

    private String name;
    private String surname;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
