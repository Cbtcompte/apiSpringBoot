package springboot.pdl.pdl.projet.validators;

import org.springframework.util.StringUtils;
import springboot.pdl.pdl.projet.dtos.FilesDto;

import java.util.HashMap;
import java.util.Map;

public class FilesValidator {

    public  Map<String, String> validate(FilesDto filedto){

         Map<String, String> errors = new HashMap<>();

        if(!StringUtils.hasLength(filedto.getNom())){
            errors.put("nom", "Ce champs est obligatoire");
        }

        if(!StringUtils.hasLength(filedto.getType())){
            errors.put("type", "Ce champs est obligatoire");
        }

        if(filedto.getTaille() <= 0){
            errors.put("taille", "Renseignez la taille des bulles du diagramme");
        }
        return  errors;
    }
}
