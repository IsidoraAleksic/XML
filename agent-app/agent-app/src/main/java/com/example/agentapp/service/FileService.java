package com.example.agentapp.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    boolean uploadFiles(MultipartFile[] files);

    String getImageAsBase64String(String fileName) throws IOException;

    String getImageFormat(String fileName);
}
