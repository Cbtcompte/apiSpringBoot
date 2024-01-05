package springboot.pdl.pdl.projet.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "bubble")
public class Bubble extends AbstractClass{
    
    @Column(name = "data") 
    private String data;

    @Column(name = "couleur") 
    private String couleur;

    @Column(name = "forme") 
    private String forme;

    @Column(name = "fontFamily") 
    private String fontFamily;

    @Column(name = "tailleLabel") 
    private float TailleLabel;

    @Column(name = "tailleBubble") 
    private float TailleBubble;

    @Column(name = "isParent") 
    private boolean isParent;

    @OneToOne(optional = true)
    @JoinColumn(
        name="parent_id", referencedColumnName = "id", unique=true, nullable=true, updatable=true)
    private Bubble parent;

    @ManyToOne
    @JoinColumn(name = "file_id")
    private Files file;

    public String getCouleur() {
        return this.couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
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

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getForme() {
        return this.forme;
    }

    public void setForme(String forme) {
        this.forme = forme;
    }

    public String getFontFamily() {
        return this.fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public float getTailleLabel() {
        return this.TailleLabel;
    }

    public void setTailleLabel(float TailleLabel) {
        this.TailleLabel = TailleLabel;
    }

    public float getTailleBubble() {
        return this.TailleBubble;
    }

    public void setTailleBubble(float TailleBubble) {
        this.TailleBubble = TailleBubble;
    }

    public boolean getIsParent() {
        return this.isParent;
    }

    public void setIsParent(boolean isParent) {
        this.isParent = isParent;
    }
}
