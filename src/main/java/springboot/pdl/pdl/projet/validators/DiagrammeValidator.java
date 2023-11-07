package springboot.pdl.pdl.projet.validators;

import java.util.Map;
import org.springframework.util.StringUtils;
import springboot.pdl.pdl.projet.dtos.DiagrammeDto;
import java.util.HashMap;

public class DiagrammeValidator {

    public  Map<String, String> vaildate(DiagrammeDto diagrammeDto){
        Map<String, String> errors = new HashMap<>();

        if(diagrammeDto == null){

            errors.put("message", "Veuillez renseignez les champs du formulaire");
        }else{

            if(!StringUtils.hasLength(diagrammeDto.getCouleur())){
                errors.put("couleur", "Ce champs est obligatoire");
            }

            if(!StringUtils.hasLength(diagrammeDto.getPolice())){
                errors.put("police", "Ce champs est obligatoire");
            }

            if(diagrammeDto.getTaille() <= 0){
                errors.put("taille", "Renseignez la taille des bulles du diagramme");
            }  
        }

        return errors;
    }
}
