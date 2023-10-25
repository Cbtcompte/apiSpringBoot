package springboot.pdl.pdl.projet.validators;

import org.springframework.util.StringUtils;
import springboot.pdl.pdl.projet.dtos.FilesDto;

import java.util.ArrayList;
import java.util.List;

public class FilesValidator {
    public static List<String> validate(FilesDto filedto){
        List<String> errors = new ArrayList<>();
        if (StringUtils ){
            errors.add("Veuillez renseigner les informations du fichier");
        }
        return  errors;
    }
}
