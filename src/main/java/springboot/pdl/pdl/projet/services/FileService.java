
package springboot.pdl.pdl.projet.services;

import org.hibernate.annotations.SecondaryRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import springboot.pdl.pdl.projet.dtos.FilesDto;
import springboot.pdl.pdl.projet.models.Files;
import springboot.pdl.pdl.projet.repository.FileRepository;
import springboot.pdl.pdl.projet.services.interfaces.AbstractService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service

public class FileService {
  //  @Autowired
    private final FileRepository fileRepository;
    public FileService( FileRepository fileRepository){

        this.fileRepository = fileRepository;
    }

    public void uploadFileSystem(MultipartFile file) throws IllegalStateException, IOException{
        file.transferTo(new File( "C:\\Users\\Joëlla_T\\Desktop\\COURS\\PDL\\TP\\pdl_project_groupe_4\\Uploads\\"+ file.getOriginalFilename()));
    }

    public Files uploadFileBase (MultipartFile file){
        String filename = file.getOriginalFilename();
        Files files =new Files(filename,true);
        return fileRepository.save(files);
    }

    public Files getFileByPath (String path_file) {
        Optional<Files> filesOptional = fileRepository.findByPath_file(path_file);

        if (filesOptional.isPresent()) {
            return filesOptional.get();
        }
             return null;
    }

    public List<Files> getFilesList(){
        return  fileRepository.findAll();
    }
}


