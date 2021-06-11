package az.code.unisubscription.services;

import az.code.unisubscription.dao.UserDao;
import az.code.unisubscription.dto.UserGetDto;
import az.code.unisubscription.dto.UserRegisterDto;
import az.code.unisubscription.models.User;
import az.code.unisubscription.utils.DtoUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService implements IUserService{

    UserDao dao;

    public UserService(UserDao dao){
        this.dao = dao;
    }

    @Override
    public UserGetDto register(UserRegisterDto userDto) {
        User user = DtoUtil.convertRegisterDtoToUser(userDto);
        user.setCreationDate(LocalDateTime.now());
        user.setActive(true);
        return new UserGetDto(dao.createUser(user));
    }
}
