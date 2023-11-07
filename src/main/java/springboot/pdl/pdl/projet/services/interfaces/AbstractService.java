package springboot.pdl.pdl.projet.services.interfaces;

public interface AbstractService<V, I> {
    /**
     * Cette méthode permet d'enregistrer yn diagramme dans la base de données
     * @param v
     * @return Diagramme instance
     */

    public V create(V v);

    public V findById(I v);

    public V findAll(V v);
}
