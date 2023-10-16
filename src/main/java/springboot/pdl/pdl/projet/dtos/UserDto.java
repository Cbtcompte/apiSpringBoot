package springboot.pdl.pdl.projet.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;

    @JsonIgnore
    private List<FilesDto> filesdto;
    
    // public UserDto fromEntity(){

    // }
}
