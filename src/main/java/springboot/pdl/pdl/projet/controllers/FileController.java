package springboot.pdl.pdl.projet.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springboot.pdl.pdl.projet.models.Files;
import springboot.pdl.pdl.projet.services.FileService;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class FileController {
    private final FileService fileService;

    public FileController(FileService fileService) {

        this.fileService = fileService;
    }

    // @PostMapping
    // public ResponseEntity<?> uploadFile(@RequestParam("fichier") Files file) throws IOException {
    //     String uploadFile = fileService.uploadFile((Files) file);
    //     return ResponseEntity.status(HttpStatus.OK)
    //             .body(uploadFile);
    // }

    // @GetMapping
    // public ResponseEntity<?> downloadFile(@PathVariable String filePath) throws IOException {
    //     Optional<byte[]> fichier = Optional.ofNullable(fileService.downloadFile(filePath));
    //     return ResponseEntity.status(HttpStatus.OK)
    //             .contentType(MediaType.valueOf("fichier/json"))
    //             .body(fichier);
    // }


    // @PostMapping
    // public ResponseEntity<?> uploadFileToSystem(@RequestParam("fichier") Files file) throws IOException {
    //     String uploadFile = fileService.uploadFileToSystem(file);
    //     return ResponseEntity.status(HttpStatus.OK)
    //             .body(uploadFile);
    // }

    // @GetMapping
    // public ResponseEntity<?> downloadFileFromSystem(@PathVariable String filePath) throws IOException {
    //     Optional<byte[]> fichier = Optional.ofNullable(fileService.downloadFileFromSystem(filePath));
    //     return ResponseEntity.status(HttpStatus.OK)
    //             .contentType(MediaType.valueOf("fichier/json"))
    //             .body(fichier);
    // }

}
