package com.bibliotheque.gestionbibliotheque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.bibliotheque.gestionbibliotheque.services.ImageProcessingService;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class FileUploadController {

    @Autowired
    private ImageProcessingService imageProcessingService;

    @PostMapping("/upload")
    public List<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            return imageProcessingService.processImage(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing image", e);
        }
    }

    @GetMapping("/images")
    public List<String> getAllImages() {
        return imageProcessingService.getAllScannedData();
    }

    @DeleteMapping("/images")
    public void deleteAllImages() {
        imageProcessingService.deleteAllScannedData();
    }
}
