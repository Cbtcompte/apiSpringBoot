package springboot.pdl.pdl.projet.controllers;

import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import springboot.pdl.pdl.projet.dtos.DiagrammeDto;
import springboot.pdl.pdl.projet.services.DiagrammeService;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping(path = "/api", consumes = MediaType.ALL_VALUE)
public class DiagrammeController {

    private DiagrammeService diagrammeService; 
    
    DiagrammeController(DiagrammeService _diagrammeService){
        this.diagrammeService = _diagrammeService;
    }

    @GetMapping(path = "/diagramme/get", produces = MediaType.ALL_VALUE)
    public ResponseEntity<Collection<DiagrammeDto>> getAll() {
        return this.diagrammeService.get();
    }

     @GetMapping(path = "/diagramme/{id}/get", produces = MediaType.ALL_VALUE)
    public ResponseEntity<DiagrammeDto> getById(@PathVariable Long id) {
        return this.diagrammeService.findById(id);
    }


    @PostMapping(path = "/diagramme/store", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiagrammeDto> store(DiagrammeDto _diagrammeDto){
        return this.diagrammeService.create(_diagrammeDto);
    }

    @PutMapping(path = "/diagramme/{id}/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public ResponseEntity<DiagrammeDto> update(@PathVariable Long id, DiagrammeDto _diagrammeDto) {
        return this.diagrammeService.put(id, _diagrammeDto);
    }
    
}
