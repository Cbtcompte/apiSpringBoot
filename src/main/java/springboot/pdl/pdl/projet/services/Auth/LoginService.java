package springboot.pdl.pdl.projet.services.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.pdl.pdl.projet.repository.UserRepository;
import springboot.pdl.pdl.projet.validators.LoginValidator;

@Service
public class LoginService {
    
     @Autowired
    private UserRepository UserRepository;

    private LoginValidator loginValidator;
}
