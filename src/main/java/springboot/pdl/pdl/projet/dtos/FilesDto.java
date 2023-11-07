package springboot.pdl.pdl.projet.dtos;

import lombok.Builder;
import lombok.Data;
import springboot.pdl.pdl.projet.models.Files;

@Data
@Builder
public class FilesDto {
    private Long id;
    private String nom;
    private String path_file;
    private Float taille;
    private Boolean visibility;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getTaille() {
        return this.taille;
    }

    public void setTaille(Float taille) {
        this.taille = taille;
    }

    public Boolean isVisibility() {
        return this.visibility;
    }

    public Boolean getVisibility() {
        return this.visibility;
    }

    public void setVisibility(Boolean visibility) {
        this.visibility = visibility;
    }

        public String getPath_file() {
        return this.path_file;
    }

    public void setPath_file(String path_file) {
        this.path_file = path_file;
    }
    
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
        files.setPath_file(filesDto.getPath_file());
        files.setTaille(filesDto.getTaille());
        
        return files;
    }
}
