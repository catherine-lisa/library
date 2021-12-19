package com.example.demo;
import  java.io.File;
import  java.util.UUID;
import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
    public static String upload_file(MultipartFile file, String fileLocation) {
        String fileFinishName = null;
        try {
            File uploadDir = new File(fileLocation);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String fileName = file.getOriginalFilename();
            fileFinishName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."), fileName.length());
            File uploadFile = new File(uploadDir + uploadDir.separator + fileFinishName);
            file.transferTo(uploadFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return fileFinishName;
    }
}