package springboot.pdl.pdl.projet.services;

import org.springframework.stereotype.Service;
import springboot.pdl.pdl.projet.repository.FileRepository;

@Service
public class FileService {

    private final FileRepository fileRepository;
    public FileService( FileRepository fileRepository){
        this.fileRepository = fileRepository;
    }

}
