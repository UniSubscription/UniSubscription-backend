package az.code.unisubscription.services;

import az.code.unisubscription.dto.UserGetDto;
import az.code.unisubscription.dto.UserRegisterDto;
import az.code.unisubscription.models.User;

public interface IUserService {
    public User register(UserRegisterDto user);
}
