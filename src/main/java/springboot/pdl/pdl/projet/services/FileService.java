
package springboot.pdl.pdl.projet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.pdl.pdl.projet.dtos.FilesDto;
import springboot.pdl.pdl.projet.models.Files;
import springboot.pdl.pdl.projet.repository.FileRepository;
import springboot.pdl.pdl.projet.services.interfaces.AbstractService;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class FileService {

    @Autowired
    private final FileRepository fileRepository;
    private final String FOLDER_PATH= "/Users/Joëlla_T/Desktop/PROJETPDL/";
    public FileService( FileRepository fileRepository){
        this.fileRepository = fileRepository;
    }


}

