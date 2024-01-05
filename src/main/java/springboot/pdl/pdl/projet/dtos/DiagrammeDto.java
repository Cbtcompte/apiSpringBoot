package springboot.pdl.pdl.projet.dtos;

import java.time.Instant;
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
    private double tailleBulle;
    private String formeParent;
    private String formeEnfant;
    private String fontFamily;
    private double fontSize;
    private Instant created_at;
    private Instant updated_at;

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
                .tailleBulle(diagramme.getTailleBulle())
                .formeParent(diagramme.getFormeParent())
                .formeEnfant(diagramme.getFormeEnfant())
                .fontFamily(diagramme.getFontFamily())
                .fontSize(diagramme.getFontSize())
                .created_at(diagramme.getCreated_at())
                .updated_at(diagramme.getUpdated_at())
                .build();
    }

    public static  Diagramme toEntity(DiagrammeDto diagrammeDto){
        System.out.println(diagrammeDto);
        if(diagrammeDto == null){
            return null;
        }

        Diagramme diagramme = new Diagramme();
        diagramme.setId(diagrammeDto.getId());
        diagramme.setCouleur(diagrammeDto.getCouleur());
        diagramme.setTailleBulle(diagrammeDto.getTailleBulle());
        diagramme.setFontFamily(diagrammeDto.getFontFamily());
        diagramme.setFontSize(diagrammeDto.getFontSize());
        diagramme.setFormeEnfant(diagrammeDto.getFormeEnfant());
        diagramme.setFormeParent(diagrammeDto.getFormeParent());
        diagramme.setCreated_at(Instant.now());
        diagramme.setUpdated_at(Instant.now());

        return diagramme;
    } 
}
