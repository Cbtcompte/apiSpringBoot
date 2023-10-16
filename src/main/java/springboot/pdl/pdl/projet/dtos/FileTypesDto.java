package springboot.pdl.pdl.projet.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileTypesDto{

    private Long id;
    private String extension;
    private String designation;

    @JsonIgnore
    private List<FilesDto> files;
    
}
