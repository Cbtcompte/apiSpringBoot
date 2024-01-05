package springboot.pdl.pdl.projet.controllers;

import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.pdl.pdl.projet.dtos.BubbleDto;
import springboot.pdl.pdl.projet.services.BubbleService;

@RestController
@RequestMapping(path = "/api", consumes = MediaType.ALL_VALUE)
public class BubbleController {
    
    private BubbleService bubbleService; 
    
    public BubbleController(BubbleService _bubbleService){
        this.bubbleService = _bubbleService;
    }

    @GetMapping(path = "/get/bubble", produces = MediaType.ALL_VALUE)
    public ResponseEntity<Collection<BubbleDto>> index() {
        return this.bubbleService.get();
    }


    @PostMapping(path = "/store/bubble", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BubbleDto> store(BubbleDto _bubbleDto){
        return this.bubbleService.create(_bubbleDto);
    }

    @PutMapping(path = "/update/{id}/bubble", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public ResponseEntity<BubbleDto> update(@PathVariable Long id, BubbleDto _bubbleDto) {        
        return this.bubbleService.put(id, _bubbleDto);
    }
}
