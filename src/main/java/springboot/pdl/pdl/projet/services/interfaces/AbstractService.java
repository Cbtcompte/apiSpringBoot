package springboot.pdl.pdl.projet.services.interfaces;

import java.util.Collection;

import org.springframework.http.ResponseEntity;

public interface AbstractService<V, I> {
    /**
     * Cette méthode permet d'enregistrer yn diagramme dans la base de données
     * @param v
     * @return Diagramme instance
     */

    public ResponseEntity<V> create(V v);

    public ResponseEntity<V> findById(I i);

    public ResponseEntity<V> findAll(V v);

    public ResponseEntity<Collection<V>> get();

    public ResponseEntity<V> put(I i, V v);
}
