package springboot.pdl.pdl.projet.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import springboot.pdl.pdl.projet.dtos.DiagrammeDto;
import springboot.pdl.pdl.projet.services.DiagrammeService;

@RestController
@RequestMapping(path = "/api", consumes = MediaType.ALL_VALUE)
public class DiagrammeController {

    private DiagrammeService diagrammeService; 
    
    DiagrammeController(DiagrammeService _diagrammeService){
        this.diagrammeService = _diagrammeService;
    }
    
    @PostMapping(path = "/store/diagramme", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.ALL_VALUE)
    public DiagrammeDto store(DiagrammeDto diagrammeDto){
        DiagrammeDto diagrammeDto2 = this.diagrammeService.create(diagrammeDto);

        return diagrammeDto2;
    }
}
