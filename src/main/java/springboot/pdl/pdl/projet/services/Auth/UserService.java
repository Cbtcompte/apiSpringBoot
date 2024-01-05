package springboot.pdl.pdl.projet.services.Auth;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import springboot.pdl.pdl.projet.dtos.UserDto;
import springboot.pdl.pdl.projet.exceptions.ErrorCodes;
import springboot.pdl.pdl.projet.exceptions.InvalidEntityException;
import springboot.pdl.pdl.projet.exceptions.EntityNotFoundException;
import springboot.pdl.pdl.projet.models.User;
import springboot.pdl.pdl.projet.repository.UserRepository;
import springboot.pdl.pdl.projet.validators.LoginValidator;
import springboot.pdl.pdl.projet.validators.RegisterValidator;

@Slf4j
@AllArgsConstructor
@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder;

    private LoginValidator loginValidator;
    private RegisterValidator registerValidator;

    public UserService(){
        this.loginValidator = new LoginValidator();
        this.registerValidator = new RegisterValidator();
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public ResponseEntity<UserDto> login(UserDto userDto) {
        Map<String, String> errors = this.loginValidator.validate(userDto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("Les informations ne sont pas correctes", ErrorCodes.BUBBLE_NOT_VALID, errors);
        }
        User user = this.userRepository.findByEmail(userDto.getEmail());

        if(user == null || !this.passwordEncoder.matches(userDto.getPassword(), user.getPassword())){
            throw new EntityNotFoundException("L'adresse email ou le mot de passe sont incorrectes");
        }
        return ResponseEntity.ok(UserDto.fromEntity(user));
    } 

    public ResponseEntity<UserDto> register(UserDto userDto){
        Map<String, String> errors = this.registerValidator.validate(userDto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("Les informations ne sont pas correctes", ErrorCodes.BUBBLE_NOT_VALID, errors);
        }
        String mdp = this.passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(mdp);

        return  ResponseEntity.ok(UserDto.fromEntity(
                this.userRepository.save(
                    UserDto.toEntity(userDto)
                )
            ));
    }

    public ResponseEntity<UserDto> putToken(String email, String token){
        User user = this.checkUser(email);
        user.setToken(token);
        this.userRepository.save(user);

        return ResponseEntity.ok(UserDto.fromEntity(user));
    }

    public User checkUser(String email) {
        User user = this.userRepository.findByEmail(email);
        if(user == null){
            throw new EntityNotFoundException("Utilisateur introuvable");
        }
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       return this.checkUser(email);
    }
}
