package com.develhpe.downlodupload.service;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileStorageService {

    @Value("${uploadDownloadDir}")
    private String fileRepositoryFolder;

    public String upload(MultipartFile file) throws IOException {
        String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(file.getOriginalFilename());
        File finalDestination = new File(fileRepositoryFolder + "/" + newFileName);
        if (finalDestination.exists()) throw new IOException("File already exists");
        file.transferTo(finalDestination);
        return newFileName;
    }

    public byte[] download(String fileName) throws IOException {
        File fileFromRepository = new File(fileRepositoryFolder + "/" + fileName);
        return IOUtils.toByteArray(new FileInputStream(fileFromRepository));
    }

}
