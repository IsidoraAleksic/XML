package com.example.agentapp.controller;

import com.example.agentapp.domain.AccommodationPhoto;
import com.example.agentapp.domain.dto.ImageData;
import com.example.agentapp.service.AccommodationPhotoService;
import com.example.agentapp.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/photos")
public class AccommodationPhotoController {

    private FileService fileService;
    private AccommodationPhotoService accommodationPhotoService;

    @Autowired
    public AccommodationPhotoController(FileService fileService, AccommodationPhotoService unitService) {
        this.fileService = fileService;
        this.accommodationPhotoService = unitService;
    }

    @GetMapping("/get/{unitId}")
    @ResponseBody
    public List<ImageData> getPhotosFromAccommodationUnit(@PathVariable("unitId") long id) throws IOException {
        List<AccommodationPhoto> photos = accommodationPhotoService.getPhotosByAccommodationUnitId(id);
        List<ImageData> encodedImages = new ArrayList<>();
        for (AccommodationPhoto photo : photos) {
            String format = fileService.getImageFormat(photo.getPath());
            String imageContent = fileService.getImageAsBase64String(photo.getPath());
            encodedImages.add(new ImageData(format, imageContent));
        }
        return encodedImages;
    }

    @PostMapping(path = "/{unitId}/upload")
    public boolean uploadFiles(@PathVariable("unitId") long id, @RequestParam("photos") MultipartFile[] files) {
        boolean isUploadSuccess = fileService.uploadFiles(files);
        if (isUploadSuccess) {  //ako je upload uspjesan, sacuvaj putanje fajlova
            List<String> fNames = Arrays.asList(files).stream()
                    .map(el -> el.getOriginalFilename())
                    .collect(Collectors.toList());
            accommodationPhotoService.saveUnitPhotos(id, fNames);
        }
        return isUploadSuccess;
    }

}
