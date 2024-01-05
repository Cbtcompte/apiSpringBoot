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
import lombok.Data;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "diagrammes")
public class Diagramme extends AbstractClass{
    
    @Column(name = "couleur")
    private String couleur;

    @Column(name = "tailleBulle")
    private double tailleBulle;

    @Column(name = "formeParent")
    private String formeParent;

    @Column(name = "formeEnfant")
    private String formeEnfant;

    @Column(name = "fontFamily")
    private String fontFamily;

    @Column(name = "fontSize")
    private double fontSize;

    @ManyToMany
    @JoinTable(
        name = "diagramme_file",
        joinColumns = @JoinColumn(name = "diagramme_id"),
        inverseJoinColumns = @JoinColumn(name = "file_id")
    )
    private List<Files> files;

    public String getCouleur() {
        return this.couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Iterator<Files> getFiles() {
        return this.files.iterator();
    }

    public void setFiles(List<Files> files) {
        this.files = files;
    }

    public String getFormeParent() {
        return this.formeParent;
    }

    public void setFormeParent(String formeParent) {
        this.formeParent = formeParent;
    }

    public String getFormeEnfant() {
        return this.formeEnfant;
    }

    public void setFormeEnfant(String formeEnfant) {
        this.formeEnfant = formeEnfant;
    }

    public double getTailleBulle() {
        return this.tailleBulle;
    }

    public void setTailleBulle(double tailleBulle) {
        this.tailleBulle = tailleBulle;
    }

    public String getFontFamily() {
        return this.fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public double getFontSize() {
        return this.fontSize;
    }

    public void setFontSize(double fontSize) {
        this.fontSize = fontSize;
    }
}
