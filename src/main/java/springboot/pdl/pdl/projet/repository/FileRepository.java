package springboot.pdl.pdl.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.pdl.pdl.projet.models.Files;

import java.util.Optional;

public interface FileRepository extends JpaRepository<Files, String> {
    Optional<Files> findByNom(String filename);
    Optional<Files> findByPath_file(String path_file);

}
