package springboot.pdl.pdl.projet.controllers;

import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import springboot.pdl.pdl.projet.config.JwtConfig;
import springboot.pdl.pdl.projet.dtos.UserDto;
import springboot.pdl.pdl.projet.exceptions.EntityNotFoundException;
import springboot.pdl.pdl.projet.models.User;
import springboot.pdl.pdl.projet.services.Auth.UserService;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api", consumes = MediaType.ALL_VALUE)
public class UserController {
    private UserService userService; 
    private AuthenticationManager authenticationManager;
    private JwtConfig jwtConfig;

    @PostMapping(path = "/user/register", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> register(UserDto _userDto) {
        User user = this.userService.checkUser(_userDto.getEmail());
        if(user != null){
            throw new EntityNotFoundException("Ce mail est déjà untilisé");
        }
        return this.userService.register(_userDto);
    }

    @PostMapping(path = "/user/login", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> login(UserDto _userDto) {
        
        final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(_userDto.getEmail(), _userDto.getPassword()));
        if(authentication.isAuthenticated()){
            User user = this.userService.checkUser(_userDto.getEmail());
            
            _userDto.setToken(this.jwtConfig.generate(user));

            user.setToken(_userDto.getToken());

            return ResponseEntity.ok(UserDto.fromEntity(user));
        }else{
             throw new EntityNotFoundException("Utilisateur introuvable");
        }
    }
}
