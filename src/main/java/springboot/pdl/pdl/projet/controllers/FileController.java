package springboot.pdl.pdl.projet.controllers;

import springboot.pdl.pdl.projet.services.FileService;

public class FileController {
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }
}
