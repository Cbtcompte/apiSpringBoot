
package springboot.pdl.pdl.projet.models;

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

    @Column(name = "type")
    private String type;

    @Column(name = "taille")
    private Float taille;

    @Column(name = "visibility")
    private Boolean visibility;

    @OneToMany(mappedBy = "file")
    private List<Bubble> bubbles = new ArrayList<Bubble>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(mappedBy = "files")
    private List<Diagramme> diagrammes;

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getTaille() {
        return this.taille;
    }

    public void setTaille(Float taille) {
        this.taille = taille;
    }

    public Boolean isVisibility() {
        return this.visibility;
    }

    public Boolean getVisibility() {
        return this.visibility;
    }

    public void setVisibility(Boolean visibility) {
        this.visibility = visibility;
    }

    public List<Bubble> getBubbles() {
        return this.bubbles;
    }

    public void setBubbles(List<Bubble> bubbles) {
        this.bubbles = bubbles;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Diagramme> getDiagrammes() {
        return this.diagrammes;
    }

    public void setDiagrammes(List<Diagramme> diagrammes) {
        this.diagrammes = diagrammes;
    }

}

    
