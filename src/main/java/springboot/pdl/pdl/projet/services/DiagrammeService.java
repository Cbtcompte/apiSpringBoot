package springboot.pdl.pdl.projet.services;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import springboot.pdl.pdl.projet.dtos.DiagrammeDto;
import springboot.pdl.pdl.projet.exceptions.ErrorCodes;
import springboot.pdl.pdl.projet.exceptions.InvalidEntityException;
import springboot.pdl.pdl.projet.models.Diagramme;
import springboot.pdl.pdl.projet.exceptions.EntityNotFoundException;
import springboot.pdl.pdl.projet.repository.DiagrammeRepository;
import springboot.pdl.pdl.projet.services.interfaces.AbstractService;
import springboot.pdl.pdl.projet.validators.DiagrammeValidator;

public class DiagrammeService implements AbstractService<DiagrammeDto, Long>{
    
    @Autowired
    private DiagrammeRepository diagrammeRepository;

    @Autowired
    private DiagrammeValidator diagrammeValidator;


    public DiagrammeService(){
        this.diagrammeValidator = new DiagrammeValidator();
    }

    /**
     * Cette méthode permet d'enregistrer yn diagramme dans la base de données
     * @param dto
     * @return Diagramme instance
     */
    @Override
    public DiagrammeDto create(DiagrammeDto dto) {
        Map<String, String> errors = diagrammeValidator.vaildate(dto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("Les informations ne sont pas correctes", ErrorCodes.DIAGRAMME_NOT_VALID, errors);
        }

        return DiagrammeDto.fromEntity(
            diagrammeRepository.save(
                DiagrammeDto.toEntity(dto)
            )
        );
    }

    @Override
    public DiagrammeDto findById(Long id) {
       if(id == null){
            return null;
       }
       Optional<Diagramme> diagramme = diagrammeRepository.findById(id);

       DiagrammeDto dto = DiagrammeDto.fromEntity(diagramme.get());

       return Optional.of(dto).orElseThrow(()-> new EntityNotFoundException("Ce diagramme n'existe pas ou n'est pas encore créer", ErrorCodes.DIAGRAMME_NOT_FOUND));
    }

    @Override
    public DiagrammeDto findAll(DiagrammeDto v) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }


    
}
