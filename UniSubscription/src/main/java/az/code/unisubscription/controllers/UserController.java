package az.code.unisubscription.controllers;

import az.code.unisubscription.dto.UserDto;
import az.code.unisubscription.dto.UserGetDto;
import az.code.unisubscription.dto.UserRegisterDto;
import az.code.unisubscription.dto.SubscriptionPostDto;
import az.code.unisubscription.models.ConfirmationToken;
import az.code.unisubscription.models.User;
import az.code.unisubscription.repositories.ConfirmationTokenRepository;
import az.code.unisubscription.repositories.UserRepo;
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

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private UserRepo userRepo;

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
        User user = service.register(registration);
        ConfirmationToken confirmationToken = new ConfirmationToken(user);
        emailService.sendMail(user.getMail(), "Complete Registration!", "To confirm your account, please click here : " + "http://localhost:8080/api/confirm-account?token=" + confirmationToken.getConfirmationToken());
        confirmationTokenRepository.save(confirmationToken);
        UserGetDto userGetDto = new UserGetDto(user);
        return new ResponseEntity<>(userGetDto, HttpStatus.OK);
    }
    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity confirmUserAccount(@RequestParam("token")String confirmationToken){
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
        if(token != null)
        {
            User user = userRepo.getUserByMail(token.getUser().getMail());
            user.setActive(true);
            userRepo.save(user);
            emailService.sendMail(user.getMail(), "Təbriklər","Siz uğurla qeydiyyatdan keçdiniz!");
        }
        else
        {
//            "The link is invalid or broken!

        }
        return new ResponseEntity(HttpStatus.OK);
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
