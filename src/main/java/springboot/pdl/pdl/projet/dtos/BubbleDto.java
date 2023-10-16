package springboot.pdl.pdl.projet.dtos;

import lombok.Builder;
import lombok.Data;
import springboot.pdl.pdl.projet.models.Bubble;

@Data
@Builder
public class BubbleDto {
    private Long id;
    
    private String libelle;

    private String couleur;

    private String police;

    private float taille;

    private Bubble parent;

    private FilesDto file;
    
}
