package springboot.pdl.pdl.projet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import springboot.pdl.pdl.projet.dtos.FilesDto;
import springboot.pdl.pdl.projet.exceptions.EntityNotFoundException;
import springboot.pdl.pdl.projet.exceptions.ErrorCodes;
import springboot.pdl.pdl.projet.exceptions.InvalidEntityException;
import springboot.pdl.pdl.projet.models.Files;
import springboot.pdl.pdl.projet.repository.FileRepository;
import springboot.pdl.pdl.projet.services.interfaces.AbstractService;
import springboot.pdl.pdl.projet.validators.FilesValidator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FileService implements AbstractService<FilesDto, Long> {

    @Autowired
    private FileRepository fileRepository;

    private FilesValidator filesValidator;

    public FileService() {
        this.filesValidator = new FilesValidator();
    }

    @Override
    public ResponseEntity<FilesDto> create(FilesDto filesDto) {
        Map<String, String> errors = this.filesValidator.validate(filesDto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("Les informations ne sont pas correctes", ErrorCodes.FILE_NOT_VALID, errors);
        }

        return ResponseEntity.ok(FilesDto.fromEntity(
            this.fileRepository.save(
                FilesDto.toEntity(filesDto)
            )
        ));
    }

    @Override
    public ResponseEntity<FilesDto> findById(Long id) {
         if(id == null){
            return null;
       }
       Optional<Files> fileOptional = fileRepository.findById(id);

       FilesDto dto = FilesDto.fromEntity(fileOptional.get());

       return ResponseEntity.ok(Optional.of(dto).orElseThrow(()-> new EntityNotFoundException("Ce fichier n'existe pas ou n'est pas encore créé", ErrorCodes.BUBBLE_NOT_FOUND)));
    }

    @Override
    public ResponseEntity<FilesDto> findAll(FilesDto filesDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public ResponseEntity<Collection<FilesDto>> get() {
       List<Files> files = this.fileRepository.findAll();
       ArrayList<FilesDto> filesDtos = new ArrayList<>();
        for (Files file : files) {
            filesDtos.add(FilesDto.fromEntity(file));
        }  
        return ResponseEntity.ok(filesDtos);
     }

    @Override
    public ResponseEntity<FilesDto> put(Long id, FilesDto filesDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'put'");
    }

    

}
