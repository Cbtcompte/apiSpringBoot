package springboot.pdl.pdl.projet.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springboot.pdl.pdl.projet.models.Files;
import springboot.pdl.pdl.projet.services.FileService_1;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.List;

/* Ce controller travaille sur le chargement de fichiers qui seront utilisés pour générer
* les graphes. Nous avons choisi de travailler avec le local directory en amont puis stocker
* en base de données le chemin d'accès vers les fichiers par souci de limite de stockage.*/
@RestController
@RequestMapping(path = "/api", consumes = MediaType.ALL_VALUE)

public class FileChargementController {

    private final FileService_1 fileService;

    public FileChargementController(FileService_1 fileService) {
        this.fileService = fileService;
    }

    /*
    *   On travaille ici sur le chargement dans le local directory
    *  */
    @PostMapping(path = "/uploadfilesystem", consumes = MediaType.MULTIPART_FORM_DATA_VALUE , produces = MediaType.ALL_VALUE)
    public void uploadfileSystem(@RequestParam("file")MultipartFile file ) throws IllegalStateException, IOException{
        fileService.uploadFileSystem(file);
    }


    /*
     *   On travaille ici sur le chargement du local directory vers la base de données
     *  */
    @PostMapping(path = "/uploadfilebase", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.ALL_VALUE)
    public Files uploadfileBase (@RequestParam ("file") MultipartFile file) throws IllegalStateException, IOException {
        return fileService.uploadFileBase(file);
    }


    /*
     *   Cette fonction permet de retrouver un fichier à partir de son chemin d'accès stocké dans la base de données
     *  */
    @PostMapping(path = "/getfile/{file_path}", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.ALL_VALUE)
    public Files getFile(@PathVariable String file_path){
        return fileService.getFileByPath(file_path);
    }


    /*
     *   On récupère la liste des fichiers
     *  */
    @PostMapping(path = "/getfilelist", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.ALL_VALUE)
    public List<Files> getFiles(){
        return fileService.getFilesList();
    }



}
