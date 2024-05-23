package com.bibliotheque.gestionbibliotheque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bibliotheque.gestionbibliotheque.Repository.ScannedDataRepository;
import com.bibliotheque.gestionbibliotheque.entities.ScannedData;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageProcessingService {
    @Autowired
    private ScannedDataRepository scannedDataRepository;

    public List<String> processImage(MultipartFile file) throws IOException {
        // Créer un fichier temporaire
        File tempFile = File.createTempFile("upload", file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(file.getBytes());
        }

        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("/usr/share/tesseract-ocr/4.00/tessdata"); // Assurez-vous que ce chemin est correct

        try {
            String text = tesseract.doOCR(tempFile);
            List<String> lines = Arrays.asList(text.split("\\r?\\n"));
            lines.forEach(line -> {
                ScannedData data = new ScannedData();
                data.setText(line);
                scannedDataRepository.save(data);
            });
            return lines;
        } catch (TesseractException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing OCR", e);
        } finally {
            // Supprimer le fichier temporaire
            tempFile.delete();
        }
    }

    public List<String> getAllScannedData() {
        List<ScannedData> scannedDataList = scannedDataRepository.findAll();
        return scannedDataList.stream()
                .map(ScannedData::getText)
                .collect(Collectors.toList());
    }

    public void deleteAllScannedData() {
        scannedDataRepository.deleteAll();
    }
}
