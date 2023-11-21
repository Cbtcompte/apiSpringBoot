
package springboot.pdl.pdl.projet.models;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "files")
public class Files extends AbstractClass {

    @Column(name = "nom")
    private String nom;

    @Column(name = "path_file")
    private String path_file;

    @Column(name = "taille")
    private Float taille;

    @Column(name = "visibility")
    private Boolean visibility;

    public Files(String nom, Boolean visibility) {
        this.nom = nom;
        this.visibility = visibility;
     }

    @OneToMany(mappedBy = "file")
    private List<Bubble> bubbles = new ArrayList<Bubble>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(mappedBy = "files")
    private List<Diagramme> diagrammes;

}
