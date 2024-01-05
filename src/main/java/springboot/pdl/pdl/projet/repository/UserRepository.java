package springboot.pdl.pdl.projet.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import springboot.pdl.pdl.projet.models.User;
import java.util.List;
import java.time.Instant;


public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
