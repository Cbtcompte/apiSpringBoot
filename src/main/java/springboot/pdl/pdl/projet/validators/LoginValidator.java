package springboot.pdl.pdl.projet.validators;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import springboot.pdl.pdl.projet.dtos.UserDto;

public class LoginValidator {
    public  Map<String, String> validate(UserDto userdto){

        Map<String, String> errors = new HashMap<>();

        if(!StringUtils.hasLength(userdto.getPassword())){
            errors.put("password", "Ce champs est obligatoire");
        }

        if(!StringUtils.hasLength(userdto.getEmail())){
            errors.put("email", "Ce champs est obligatoire");
        }

        if(!userdto.getEmail().contains("@")){
            errors.put("email", "Ce mail est invalid");
        }

        if(!userdto.getEmail().contains(".")){
            errors.put("email", "Ce mail est invalid");
        }

        return  errors;
    }
}
