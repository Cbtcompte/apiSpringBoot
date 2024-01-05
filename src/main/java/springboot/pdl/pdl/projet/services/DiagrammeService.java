package springboot.pdl.pdl.projet.services;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import springboot.pdl.pdl.projet.dtos.DiagrammeDto;
import springboot.pdl.pdl.projet.exceptions.ErrorCodes;
import springboot.pdl.pdl.projet.exceptions.InvalidEntityException;
import springboot.pdl.pdl.projet.models.Diagramme;
import springboot.pdl.pdl.projet.exceptions.EntityNotFoundException;
import springboot.pdl.pdl.projet.repository.DiagrammeRepository;
import springboot.pdl.pdl.projet.services.interfaces.AbstractService;
import springboot.pdl.pdl.projet.validators.DiagrammeValidator;
@Service
public class DiagrammeService implements AbstractService<DiagrammeDto, Long>{
    
    @Autowired
    private DiagrammeRepository diagrammeRepository;

    private  DiagrammeValidator diagrammeValidator;


    public DiagrammeService(){
        this.diagrammeValidator = new DiagrammeValidator();
    }

    /**
     * Cette méthode permet d'enregistrer yn diagramme dans la base de données
     * @param dto
     * @return Diagramme instance
     */
    @Override
    public ResponseEntity<DiagrammeDto> create(DiagrammeDto dto) {
        Map<String, String> errors = this.diagrammeValidator.vaildate(dto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("Les informations ne sont pas correctes", ErrorCodes.DIAGRAMME_NOT_VALID, errors);
        }

        return ResponseEntity.ok(DiagrammeDto.fromEntity(
                this.diagrammeRepository.save(
                    DiagrammeDto.toEntity(dto)
                )
            ));
    }

    @Override
    public ResponseEntity<DiagrammeDto> findById(Long id) {
       if(id == null){
            throw new InvalidEntityException("Les informations ne sont pas correctes");
       }
       Optional<Diagramme> diagramme = diagrammeRepository.findById(id);

       DiagrammeDto dto = DiagrammeDto.fromEntity(diagramme.get());

       return ResponseEntity.ok(Optional.of(dto).orElseThrow(()-> new EntityNotFoundException("Ce diagramme n'existe pas ou n'est pas encore créé", ErrorCodes.DIAGRAMME_NOT_FOUND)));
    }

    @Override
    public ResponseEntity<DiagrammeDto> findAll(DiagrammeDto v) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public ResponseEntity<Collection<DiagrammeDto>> get() {
       List<Diagramme> diagrammes = this.diagrammeRepository.findAll();
       ArrayList<DiagrammeDto> diagrammeDtos = new ArrayList<>();
        for (Diagramme diagramme : diagrammes) {
            diagrammeDtos.add(DiagrammeDto.fromEntity(diagramme));
        }  
        return ResponseEntity.ok(diagrammeDtos);
    }

    @Override
    public ResponseEntity<DiagrammeDto> put(Long id, DiagrammeDto _diagrammeDto){
        DiagrammeDto diagrammeDto = this.findById(id).getBody();
        diagrammeDto = _diagrammeDto;
        this.diagrammeRepository.save(DiagrammeDto.toEntity(diagrammeDto));

        return ResponseEntity.ok(diagrammeDto);
    }

    


    
}
