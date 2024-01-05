package springboot.pdl.pdl.projet.validators;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import springboot.pdl.pdl.projet.dtos.BubbleDto;

public class BubbleValidator {

    public  Map<String, String> validate(BubbleDto bubbleDto){
        Map<String, String> errors = new HashMap<>();

        if(bubbleDto == null){

            errors.put("message", "Veuillez renseignez les champs du formulaire");
        }else{

            if(!StringUtils.hasLength(bubbleDto.getCouleur())){
                errors.put("couleur", "Ce champs est obligatoire");
            }

            if(!StringUtils.hasLength(bubbleDto.getFontFamily())){
                errors.put("fontFamily", "Ce champs est obligatoire");
            }

            if(!StringUtils.hasLength(bubbleDto.getData())){
                errors.put("data", "Ce champs est obligatoire");
            }

            if(!StringUtils.hasLength(bubbleDto.getForme())){
                errors.put("forme", "Ce champs est obligatoire");
            }

            if(bubbleDto.getTailleBubble() <= 0){
                errors.put("tailleBubble", "Renseignez la taille des bulles du bubble");
            }  

            if(bubbleDto.getTailleLabel() <= 0){
                errors.put("tailleLabel", "Renseignez la taille des data");
            }  
        }

        return errors;
    }
}
