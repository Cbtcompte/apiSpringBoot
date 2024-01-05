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

            if(diagrammeDto.getTailleBulle() <= 0){
                errors.put("tailleBulle", "Renseignez la taille des bulles du diagramme");
            }

            if(diagrammeDto.getFontSize() <= 0){
                errors.put("fontSize", "Renseignez la taille du texte du diagramme");
            }  

            if(!StringUtils.hasLength(diagrammeDto.getFontFamily())){
                errors.put("fontFamily", "Ce champs est obligatoire");
            } 

            if(!StringUtils.hasLength(diagrammeDto.getFormeEnfant())){
                errors.put("formeEnfant", "Ce champs est obligatoire");
            } 

            if(!StringUtils.hasLength(diagrammeDto.getFormeParent())){
                errors.put("formeParent", "Ce champs est obligatoire");
            } 
        }

        return errors;
    }
}
