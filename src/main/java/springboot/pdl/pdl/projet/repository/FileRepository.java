package springboot.pdl.pdl.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.pdl.pdl.projet.models.Files;

import java.util.Optional;

public interface FileRepository extends JpaRepository<Files, Long> {
    // Optional<Files> findByNom(String filename);
    // Optional<Files> findByPathFile(String path_file);

}
