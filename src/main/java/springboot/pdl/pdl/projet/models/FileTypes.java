package springboot.pdl.pdl.projet.models;

import java.util.Iterator;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "filesTypes")
public class FileTypes extends AbstractClass{

    @Column(name = "extension")
    private String extension;

    @Column(name = "designation")
    private String designation;

    @OneToMany(mappedBy = "fileType")
    private List<Files> file;

    public FileTypes(String extension, String designation) {
        this.extension = extension;
        this.designation = designation;
    }


    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Iterator<Files> getFile() {
        return this.file.iterator();
    }

    public void setFile(List<Files> file) {
        this.file = file;
    }
    
}
