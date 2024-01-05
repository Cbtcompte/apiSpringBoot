package springboot.pdl.pdl.projet.dtos;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import springboot.pdl.pdl.projet.models.User;

@Data
@Builder
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String token;
    private Instant created_at;
    private Instant updated_at;

    @JsonIgnore
    private List<FilesDto> filesdto;

    @JsonIgnore
    private String password;
    
    public static UserDto fromEntity(User user){
        if(user == null){
            return null;
        }

        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .token(user.getToken())
                .password(user.getPassword())
                .created_at(user.getCreated_at())
                .updated_at(user.getUpdated_at())
                .build();
    }

    public static User toEntity(UserDto userdto){
        if(userdto == null){
            return null;
        }

        User user = new User();
        user.setEmail(userdto.getEmail());
        user.setName(userdto.getName());
        user.setToken(userdto.getToken());
        user.setId(userdto.getId());
        user.setPassword(userdto.getPassword());
        user.setCreated_at(Instant.now());
        user.setUpdated_at(Instant.now());
        return user;
    }
}
