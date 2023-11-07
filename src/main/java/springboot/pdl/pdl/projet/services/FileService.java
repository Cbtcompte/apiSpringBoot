
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

    public String uploadFile(Files file) throws IOException{
        Optional<Files> files = Optional.of(fileRepository.save(Files.builder()
                .nom(file.getNom())
                .bubbles(file.getBubbles())
                .taille(file.getTaille())
                .visibility(file.getVisibility())
                .path_file(file.getPath_file())
                .build()));

        if (file != null){
            return "Fichier bien chargé : " + file.getNom();
        }
        return  null;


    }
    public byte[] downloadFile(String filename){
        Optional<Files> dbFile = fileRepository.findByNom(filename);
        byte [] file = dbFile.get().getPath_file().getBytes();
        return file;
    }
    public String uploadFileToSystem(Files file) throws IndexOutOfBoundsException{
        String  filepath= FOLDER_PATH+file.getNom();
       /* if (file != null){
            file.transferTo(new File(filepath));
        }*/
        Files fichier =  fileRepository.save(Files.builder()
                .nom(file.getNom())
                .taille(file.getTaille())
                .visibility(file.getVisibility())
                .path_file(filepath)
                .build());
       if(fichier != null) {
           return "Fichier ajouté avec succes : " + filepath;
       }
       return null;
    }

    public byte[] downloadFileFromSystem(String fileName) throws IndexOutOfBoundsException, IOException {
        Optional<Files> bdFiles = fileRepository.findByNom(fileName);
        String filepath = bdFiles.get().getPath_file();
        byte [] file = java.nio.file.Files.readAllBytes(new File(filepath).toPath());
        return file;
    }





}

