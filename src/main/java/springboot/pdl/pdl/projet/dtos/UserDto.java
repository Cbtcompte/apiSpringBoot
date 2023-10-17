package springboot.pdl.pdl.projet.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import springboot.pdl.pdl.projet.models.User;

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
    
    public UserDto fromEntity(User user){
        if(user == null){
            return null;
        }

        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .telephone(user.getTelephone())
                .build();
    }

    public User toEntity(UserDto userdto){
        if(userdto == null){
            return null;
        }

        User user = new User();
        user.setEmail(userdto.getEmail());
        user.setTelephone(userdto.getTelephone());
        user.setNom(userdto.getNom());
        user.setPrenom(userdto.getPrenom());
        user.setId(userdto.getId());
        return user;
    }
}
