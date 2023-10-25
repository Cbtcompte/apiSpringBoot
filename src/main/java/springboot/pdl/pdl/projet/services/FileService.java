package springboot.pdl.pdl.projet.services;

import org.springframework.stereotype.Service;
import springboot.pdl.pdl.projet.dtos.FilesDto;
import springboot.pdl.pdl.projet.models.Files;
import springboot.pdl.pdl.projet.repository.FileRepository;
import springboot.pdl.pdl.projet.services.interfaces.AbstractService;

@Service
public class FileService implements AbstractService <Files, FilesDto> {

    private final FileRepository fileRepository;
    public FileService( FileRepository fileRepository){
        this.fileRepository = fileRepository;
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

