package springboot.pdl.pdl.projet.services;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import springboot.pdl.pdl.projet.dtos.FilesDto;
import springboot.pdl.pdl.projet.models.Files;
import springboot.pdl.pdl.projet.repository.FileRepository;
import springboot.pdl.pdl.projet.services.interfaces.AbstractService;
import springboot.pdl.pdl.projet.utils;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class FileService implements AbstractService <Files, FilesDto> {

    private final FileRepository fileRepository;
    private final String FOLDER_PATH= "/Users/Joëlla_T/Desktop/PROJETPDL/";
    public FileService( FileRepository fileRepository){
        this.fileRepository = fileRepository;
    }

    public String uploadFile(MultipartFile file) throws IOException{
        Optional<Files> files = Optional.of(fileRepository.save(Files.builder()
                .nom(file.getNom())
                .bubbles(file.getBubbles())
                .taille(file.getTaille())
                .visibility(file.getVisibility())
                .path_file(file.getPath_file()).build());

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
    public String uploadFileToSystem(MultipartFile file) throws IndexOutOfBoundsException{
        String  filepath= FOLDER_PATH+file.getNom();

        Files fichier =  fileRepository.save(Files.builder()
                .nom(file.getNom())
                .taille(file.getTaille())
                .visibility(file.getVisibility())
                .path_file(filepath).build());
        file.transferTo(new File(filepath);        );
       if(fichier != null) {
           return "Fichier ajouté avec succes : " + filepath;
       }
       return null;
    }

    public byte[] downloadFileFromSystem(String filePath) throws IndexOutOfBoundsException, IOException {
        Optional<Files> bdFiles = fileRepository.findByNom(fileName);
        String filepath = bdFiles.get().getPath_file();
        byte [] file = java.nio.file.Files.readAllBytes(new File(filepath).toPath());
        return file;
    }


    @Override
    public Files create(FilesDto filesDto) {
        return null;
    }

    @Override
    public Files delete(FilesDto filesDto) {
        return null;
    }

    @Override
    public Files read(FilesDto filesDto) {
        return null;
    }

    @Override
    public Files update(FilesDto filesDto) {
        return null;
    }


}

