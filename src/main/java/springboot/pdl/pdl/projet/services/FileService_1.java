package springboot.pdl.pdl.projet.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import springboot.pdl.pdl.projet.models.Files;
import springboot.pdl.pdl.projet.repository.FileRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class FileService_1 {

    private final FileRepository fileRepository;

    public FileService_1(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    /*
     * On met dans le local directory le fichier à charger.
     * Notez que vous devez changer le chemin en fonction de votre machine
     * */
    public void uploadFileSystem(MultipartFile file) throws IllegalStateException, IOException {
        // Changez le chemin en fonction de votre configuration
        String uploadPath = "C:\\Users\\Joëlla_T\\Desktop\\COURS\\PDL\\TP\\pdl_project_groupe_4\\Uploads\\";

        File directory = new File(uploadPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        if (file.getOriginalFilename() != null && file.getOriginalFilename().toLowerCase().endsWith(".json")) {
            file.transferTo(new File(uploadPath + file.getOriginalFilename()));
        } else {
            throw new IllegalArgumentException("Le fichier doit être au format JSON.");
        }
    }


    /*
     * On récupère du local directory le fichier à charger et on stocke le path dans la base de données
     * Notez que vous devez changer le chemin en fonction de votre machine
     * */
    public Files uploadFileBase(MultipartFile file) {
        String uploadPath = "C:\\Users\\Joëlla_T\\Desktop\\COURS\\PDL\\TP\\pdl_project_groupe_4\\Uploads\\";
        try {
            file.transferTo(new File(uploadPath + file.getOriginalFilename()));

            Files files = new Files(file.getOriginalFilename(), true);
            return fileRepository.save(files);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
     * On récupère le chemin d'accès d'un fichier depuis la base de données
     * */
    public Files getFileByPath(String path_file) {
        Optional<Files> filesOptional = fileRepository.findByPath_file(path_file);

        return filesOptional.orElse(null);
    }

    /*
     * On récupère la liste des fichiers chargés en base de données
     * */
    public List<Files> getFilesList() {
        return fileRepository.findAll();
    }
}
