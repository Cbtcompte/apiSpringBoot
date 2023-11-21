package springboot.pdl.pdl.projet.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springboot.pdl.pdl.projet.models.Files;
import springboot.pdl.pdl.projet.services.FileService;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(path = "/api", consumes = MediaType.ALL_VALUE)

public class FileChargementController {
    private final FileService fileService;

    public FileChargementController(FileService fileService) {

        this.fileService = fileService;
    }

    @PostMapping(path = "/uploadfilesystem", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.ALL_VALUE)
    public void uploadfileSystem(@RequestParam("file")MultipartFile file ) throws IllegalStateException, IOException{
        fileService.uploadFileSystem(file);
        System.out.println("cocuoicvzdafdiugdsifhj");
    }

    @PostMapping(path = "/uploadfilebase", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.ALL_VALUE)
    public Files uploadfileBase (@RequestParam ("file") MultipartFile file) throws IllegalStateException, IOException {
        return fileService.uploadFileBase(file);
    }

    @PostMapping(path = "/getfile/{file_path}", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.ALL_VALUE)
    public Files getFile(@PathVariable String file_path){
        return fileService.getFileByPath(file_path);
    }

    @PostMapping(path = "/getfilelist", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.ALL_VALUE)
    public List<Files> getFiles(){
        return fileService.getFilesList();
    }



}
