package springboot.pdl.pdl.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.pdl.pdl.projet.models.Files;

import java.util.Optional;
@Repository

public interface FileRepository extends JpaRepository<Files, Long> {
     Optional<Files> findByNom(String nom);

     default Optional<Files> findByPath_file(String path) {
          return null;
     }

}
