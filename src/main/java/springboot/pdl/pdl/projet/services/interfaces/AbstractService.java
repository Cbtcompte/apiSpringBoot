package springboot.pdl.pdl.projet.services.interfaces;

import springboot.pdl.pdl.projet.dtos.DiagrammeDto;
import springboot.pdl.pdl.projet.models.Diagramme;

public interface AbstractService <T, V>{
    /**
     * Cette méthode permet d'enregistrer yn diagramme dans la base de données
     * @param v
     * @return Diagramme instance
     */
    public T create(V v);
    public T delete(V v);
    public T read (V v);
    public T update (V v);
}
