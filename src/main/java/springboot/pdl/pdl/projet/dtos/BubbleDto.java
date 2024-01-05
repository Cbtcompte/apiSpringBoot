package springboot.pdl.pdl.projet.dtos;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import springboot.pdl.pdl.projet.models.Bubble;

@Data
@Builder
public class BubbleDto {
    private Long id;
    private String data;
    private String couleur;
    private String forme;
    private String fontFamily;
    private float tailleLabel;
    private float tailleBubble;
    private boolean isParent;
    private Bubble parent;
    private Instant created_at;
    private Instant updated_at;

    @JsonIgnore
    private FilesDto files;

    public static BubbleDto fromEntity(Bubble bubble)
    {
        if(bubble == null){
            return null;
        }

        return  BubbleDto.builder()
                .id(bubble.getId())
                .couleur(bubble.getCouleur())
                .tailleBubble(bubble.getTailleBubble())
                .tailleLabel(bubble.getTailleLabel())
                .fontFamily(bubble.getFontFamily())
                .forme(bubble.getForme())
                .data(bubble.getData())
                .parent(bubble.getParent())
                .isParent(bubble.getIsParent())
                .created_at(bubble.getCreated_at())
                .updated_at(bubble.getUpdated_at())
                .build();
    }

    public static  Bubble toEntity(BubbleDto bubbleDto){
        if(bubbleDto == null){
            return null;
        }

        Bubble bubble = new Bubble();
        bubble.setId(bubbleDto.getId());
        bubble.setCouleur(bubbleDto.getCouleur());
        bubble.setData(bubbleDto.getData());
        bubble.setTailleBubble(bubbleDto.getTailleBubble());
        bubble.setFontFamily(bubbleDto.getFontFamily());
        bubble.setTailleLabel(bubbleDto.getTailleLabel());
        bubble.setForme(bubbleDto.getForme());
        bubble.setParent(bubbleDto.getParent());
        bubble.setIsParent(bubbleDto.isParent);
        bubble.setCreated_at(Instant.now());
        bubble.setUpdated_at(Instant.now());

        return bubble;
    } 
    
}
