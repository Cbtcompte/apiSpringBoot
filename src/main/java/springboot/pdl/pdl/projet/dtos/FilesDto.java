package springboot.pdl.pdl.projet.dtos;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;
import springboot.pdl.pdl.projet.models.Files;

@Data
@Builder
public class FilesDto {
    private Long id;
    private String nom;
    private String type;
    private Float taille;
    private Boolean visibility;
    private Instant created_at;
    private Instant updated_at;
    
    public static FilesDto fromEntity(Files files)
    {
        if(files == null){
            return null;
        }

        return FilesDto.builder()
                .id(files.getId())
                .type(files.getType())
                .taille(files.getTaille())
                .nom(files.getNom())
                .visibility(files.getVisibility())
                .created_at(files.getCreated_at())
                .updated_at(files.getUpdated_at())
                .build();
    }

    public static Files toEntity(FilesDto filesDto){
        if(filesDto == null){
            return null;
        }

        Files files = new Files();
        files.setId(filesDto.getId());
        files.setNom(filesDto.getNom());
        files.setVisibility(filesDto.getVisibility());
        files.setType(filesDto.getType());
        files.setTaille(filesDto.getTaille());
        files.setCreated_at(Instant.now());
        files.setUpdated_at(Instant.now());

        return files;
    }
}
