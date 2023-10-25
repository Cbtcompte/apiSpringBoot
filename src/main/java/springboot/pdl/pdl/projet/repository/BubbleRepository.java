package springboot.pdl.pdl.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.pdl.pdl.projet.models.Bubble;

public interface BubbleRepository extends JpaRepository<Bubble, Long> {
    
}
