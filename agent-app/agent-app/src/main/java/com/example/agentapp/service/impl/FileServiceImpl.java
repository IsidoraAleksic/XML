package com.example.agentapp.service.impl;

import com.example.agentapp.service.FileService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Service
public class FileServiceImpl implements FileService {

    public static final String uploadingDir = System.getProperty("user.dir") + "\\photos\\";

    @Override
    public boolean uploadFiles(MultipartFile[] files) {
        for(MultipartFile file : files) {
            File f = new File(uploadingDir + file.getOriginalFilename());
            try {
                file.transferTo(f);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    @Override
    public String getImageAsBase64String(String fileName) throws IOException {
        Path pathToFile = Paths.get(uploadingDir + fileName);
        byte[] imageBytes = Files.readAllBytes(pathToFile);
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    @Override
    public String getImageFormat(String fileName) {
       return fileName.substring(fileName.indexOf(".") + 1);
    }
}