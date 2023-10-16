package springboot.pdl.pdl.projet.models;

import java.util.Iterator;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Builder;
import lombok.Data;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "diagrammes")
public class Diagramme extends AbstractClass{
    
    @Column(name = "couleur")
    private String couleur;

    @Column(name = "police")
    private String police;

    @Column(name = "taille")
    private float taille;

    @ManyToMany
    @JoinTable(
        name = "diagramme_file",
        joinColumns = @JoinColumn(name = "diagramme_id"),
        inverseJoinColumns = @JoinColumn(name = "file_id")
    )
    private List<Files> files;
    

    // public Diagramme(String couleur, String police, float taille) {
    //     this.couleur = couleur;
    //     this.police = police;
    //     this.taille = taille;
    // }


    public String getCouleur() {
        return this.couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getPolice() {
        return this.police;
    }

    public void setPolice(String police) {
        this.police = police;
    }

    public float getTaille() {
        return this.taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public Iterator<Files> getFiles() {
        return this.files.iterator();
    }

    public void setFiles(List<Files> files) {
        this.files = files;
    }
}
