package springboot.pdl.pdl.projet.dtos;

import lombok.Builder;
import lombok.Data;
import springboot.pdl.pdl.projet.models.Files;

@Data
@Builder
public class FilesDto {
    private Long id;
    private String nom;
    private Float taille;
    private Boolean visibility;
    
    public FilesDto fromEntity(Files files)
    {
        if(files == null){
            return null;
        }

        return FilesDto.builder()
                .id(files.getId())
                .taille(files.getTaille())
                .nom(files.getNom())
                .visibility(files.getVisibility())
                .build();
    }

    public  Files toEntity(FilesDto filesDto){
        if(filesDto == null){
            return null;
        }

        Files files = new Files();
        files.setId(filesDto.getId());
        files.setNom(filesDto.getNom());
        files.setVisibility(filesDto.getVisibility());
        files.setTaille(filesDto.getTaille());
        
        return files;
    }
}
