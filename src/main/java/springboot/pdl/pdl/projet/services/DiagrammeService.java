package springboot.pdl.pdl.projet.services;

import springboot.pdl.pdl.projet.dtos.DiagrammeDto;
import springboot.pdl.pdl.projet.models.Diagramme;
import springboot.pdl.pdl.projet.services.interfaces.AbstractService;

public class DiagrammeService implements AbstractService<Diagramme, DiagrammeDto> {
    
    /**
     * Cette méthode permet d'enregistrer yn diagramme dans la base de données
     * @param diagrammeDto
     * @return Diagramme instance
     */
    @Override
    public Diagramme create(DiagrammeDto diagrammeDto) {
        return null;
    }

    @Override
    public Diagramme delete(DiagrammeDto diagrammeDto) {
        return null;
    }

    @Override
    public Diagramme read(DiagrammeDto diagrammeDto) {
        return null;
    }

    @Override
    public Diagramme update(DiagrammeDto diagrammeDto) {
        return null;
    }


}
