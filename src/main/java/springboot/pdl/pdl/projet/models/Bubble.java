package springboot.pdl.pdl.projet.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "data")
public class Bubble extends AbstractClass{
    
    @Column(name = "libelle") 
    private String libelle;

    @Column(name = "couleur") 
    private String couleur;

    @Column(name = "police") 
    private String police;

    @Column(name = "taille") 
    private float taille;

    @OneToOne(optional = true)
    @JoinColumn(
        name="parent_id", referencedColumnName = "id", unique=true, nullable=true, updatable=true)
    private Bubble parent;

    @ManyToOne
    @JoinColumn(name = "file_id")
    private Files file;

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

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

    public Bubble getParent() {
        return this.parent;
    }

    public void setParent(Bubble parent) {
        this.parent = parent;
    }

    public Files getFile() {
        return this.file;
    }

    public void setFile(Files file) {
        this.file = file;
    }    

}
