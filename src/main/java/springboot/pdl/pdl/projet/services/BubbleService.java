package springboot.pdl.pdl.projet.services;

import springboot.pdl.pdl.projet.dtos.BubbleDto;
import springboot.pdl.pdl.projet.models.Bubble;
import springboot.pdl.pdl.projet.repository.BubbleRepository;
import springboot.pdl.pdl.projet.services.interfaces.AbstractService;

public class BubbleService implements AbstractService<Bubble, BubbleDto> {

   private final BubbleRepository bubbleRepository;

   public BubbleService(BubbleRepository bubbleRepository){
        this.bubbleRepository = bubbleRepository;
   }

    @Override
    public Bubble create(Bubble bubble) {
        return null;
    }

    @Override
    public Bubble findById(BubbleDto v) {
        return null;
    }

    @Override
    public Bubble findAll(Bubble bubble) {
        return null;
    }
}
