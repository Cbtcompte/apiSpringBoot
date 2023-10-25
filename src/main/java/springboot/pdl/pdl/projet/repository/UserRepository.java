package springboot.pdl.pdl.projet.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import springboot.pdl.pdl.projet.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
