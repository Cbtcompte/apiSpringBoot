package springboot.pdl.pdl.projet.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import springboot.pdl.pdl.projet.models.Diagramme;


public interface DiagrammeRepository extends JpaRepository<Diagramme, Long>{
    
}
