package springboot.pdl.pdl.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.pdl.pdl.projet.models.Files;

public interface FileRepository extends JpaRepository<Files, String> {

}
