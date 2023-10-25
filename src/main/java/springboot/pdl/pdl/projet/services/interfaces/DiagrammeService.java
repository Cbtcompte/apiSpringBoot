package springboot.pdl.pdl.projet.services.interfaces;

import springboot.pdl.pdl.projet.dtos.DiagrammeDto;
import springboot.pdl.pdl.projet.models.Diagramme;

public interface DiagrammeService {
    /**
     * Cette méthode permet d'enregistrer yn diagramme dans la base de données
     * @param DiagrammeDto
     * @return Diagramme instance
     */
    public Diagramme create(DiagrammeDto diagrammeDto);
}
