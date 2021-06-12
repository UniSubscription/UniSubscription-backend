package az.code.unisubscription.controllers;

import az.code.unisubscription.dto.UserDto;
import az.code.unisubscription.dto.UserGetDto;
import az.code.unisubscription.dto.UserRegisterDto;
import az.code.unisubscription.dto.SubscriptionPostDto;
import az.code.unisubscription.models.User;
import az.code.unisubscription.services.IEmailService;
import az.code.unisubscription.services.IUserService;
import az.code.unisubscription.utils.JwtTokenUtil;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class UserController {
    private IUserService service;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private IEmailService emailService;

    public UserController(IUserService service) {
        this.service = service;
    }

    /**
     * creates new user
     * @param registration
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<UserGetDto> insertUser(@RequestBody UserRegisterDto registration){
        UserGetDto user = service.register(registration);
        emailService.sendMail(user.getEmail(), "Təbriklər","Siz uğurla qeydiyyatdan keçdiniz!");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<UserDto> getUser(HttpServletRequest request) throws BadHttpRequest {
        User user = jwtTokenUtil.getUserFromToken(request.getHeader("Authorization").replace("Bearer ", ""));
        if (user == null){
            throw new BadHttpRequest();
        }
        return new ResponseEntity(new UserDto(user), HttpStatus.OK);
    }
}
