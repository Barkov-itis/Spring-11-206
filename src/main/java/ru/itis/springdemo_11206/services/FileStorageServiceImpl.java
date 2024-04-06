package ru.itis.springdemo_11206.services;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springdemo_11206.models.FileInfo;
import ru.itis.springdemo_11206.repository.FilesInfoRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class FileStorageServiceImpl implements FileStorageService {

    @Autowired
    private FilesInfoRepository filesInfoRepository;

    @Value("${storage.path}")
    private String storagePath;

    @Override
    public String saveFile(MultipartFile uploadFile) {

        String storageName = UUID.randomUUID().toString() + "." +
                FilenameUtils.getExtension(uploadFile.getOriginalFilename());

        FileInfo file = FileInfo.builder()
                .type(uploadFile.getContentType())
                .originalName(uploadFile.getOriginalFilename())
                .size(uploadFile.getSize())
                .storageFileName(storageName)
                .url(storagePath + "\\" + storageName)
                .build();

        try {
            Files.copy(uploadFile.getInputStream(), Paths.get(storagePath, storageName));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        filesInfoRepository.save(file);
        return file.getStorageFileName();
    }

    @Override
    public void writeFileToResponse(String fileName, HttpServletResponse response) {
        FileInfo fileInfo = filesInfoRepository.findByStorageFileName(fileName);
        response.setContentType(fileInfo.getType());
        try {
            IOUtils.copy(new FileInputStream(fileInfo.getUrl()), response.getOutputStream());
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
