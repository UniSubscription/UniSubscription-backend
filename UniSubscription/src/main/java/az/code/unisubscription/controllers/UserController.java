package az.code.unisubscription.controllers;

import az.code.unisubscription.dto.UserGetDto;
import az.code.unisubscription.dto.UserRegisterDto;
import az.code.unisubscription.dto.SubscriptionPostDto;
import az.code.unisubscription.services.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class UserController {
    private IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    /**
     * creates new user
     * @param registration
     * @return
     */
    @PostMapping
    public ResponseEntity<UserGetDto> insertUser(@RequestBody UserRegisterDto registration){
        return new ResponseEntity<>(service.register(registration), HttpStatus.OK);
    }
}
