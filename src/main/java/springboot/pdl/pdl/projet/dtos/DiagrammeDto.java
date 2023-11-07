package springboot.pdl.pdl.projet.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import springboot.pdl.pdl.projet.models.Diagramme;

@Data
@Builder
public class DiagrammeDto{
    private Long id;
    private String couleur;
    private String police;
    private float taille;

    @JsonIgnore
    private List<FilesDto> files;
  
    public static DiagrammeDto fromEntity(Diagramme diagramme)
    {
        if(diagramme == null){
            return null;
        }

        return DiagrammeDto.builder()
                .id(diagramme.getId())
                .couleur(diagramme.getCouleur())
                .police(diagramme.getPolice())
                .taille(diagramme.getTaille())
                .build();
    }

    public static  Diagramme toEntity(DiagrammeDto diagrammeDto){
        if(diagrammeDto == null){
            return null;
        }

        Diagramme diagramme = new Diagramme();
        diagramme.setId(diagrammeDto.getId());
        diagramme.setCouleur(diagrammeDto.getCouleur());
        diagramme.setPolice(diagrammeDto.getPolice());
        diagramme.setTaille(diagrammeDto.getTaille());

        return diagramme;
    } 
}
