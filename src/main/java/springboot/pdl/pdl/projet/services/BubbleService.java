package springboot.pdl.pdl.projet.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import springboot.pdl.pdl.projet.dtos.BubbleDto;
import springboot.pdl.pdl.projet.exceptions.EntityNotFoundException;
import springboot.pdl.pdl.projet.exceptions.ErrorCodes;
import springboot.pdl.pdl.projet.exceptions.InvalidEntityException;
import springboot.pdl.pdl.projet.models.Bubble;
import springboot.pdl.pdl.projet.repository.BubbleRepository;
import springboot.pdl.pdl.projet.services.interfaces.AbstractService;
import springboot.pdl.pdl.projet.validators.BubbleValidator;

@Service
public class BubbleService implements AbstractService<BubbleDto, Long> {

    @Autowired
    private BubbleRepository bubbleRepository;

    private BubbleValidator bubbleValidator;


    public BubbleService(){
        this.bubbleValidator = new BubbleValidator();
    }

    @Override
    public ResponseEntity<BubbleDto> create(BubbleDto bubbleDto) {
        Map<String, String> errors = this.bubbleValidator.validate(bubbleDto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("Les informations ne sont pas correctes", ErrorCodes.BUBBLE_NOT_VALID, errors);
        }

        return ResponseEntity.ok(BubbleDto.fromEntity(
            this.bubbleRepository.save(
                BubbleDto.toEntity(bubbleDto)
            )
        ));
    }

    @Override
    public ResponseEntity<BubbleDto> findById(Long id) {
       if(id == null){
            return null;
       }
       Optional<Bubble> bubbleOptional = bubbleRepository.findById(id);

       BubbleDto dto = BubbleDto.fromEntity(bubbleOptional.get());

       return ResponseEntity.ok(Optional.of(dto).orElseThrow(()-> new EntityNotFoundException("Cette donnée n'existe pas ou n'est pas encore créé", ErrorCodes.BUBBLE_NOT_FOUND)));
    }

    @Override
    public ResponseEntity<BubbleDto> put(Long id, BubbleDto _bubbleDto) {
        BubbleDto bubbleDto = this.findById(id).getBody();
        bubbleDto = _bubbleDto;
        this.bubbleRepository.save(BubbleDto.toEntity(bubbleDto));

        return ResponseEntity.ok(bubbleDto);
    }

    @Override
    public ResponseEntity<Collection<BubbleDto>> get() {
       List<Bubble> bulles = this.bubbleRepository.findAll();
       ArrayList<BubbleDto> bulleDtos = new ArrayList<>();
        for (Bubble bubble : bulles) {
            bulleDtos.add(BubbleDto.fromEntity(bubble));
        }  
        return ResponseEntity.ok(bulleDtos);
    }

    @Override
    public ResponseEntity<BubbleDto> findAll(BubbleDto bubbleDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}
