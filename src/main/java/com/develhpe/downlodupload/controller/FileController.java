package com.develhpe.downlodupload.controller;

import com.develhpe.downlodupload.service.FileStorageService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    FileStorageService fileStorageService;

    @GetMapping("/download")
    public @ResponseBody byte[] download(String fileName, HttpServletResponse response) throws IOException {

        String extension = FilenameUtils.getExtension(fileName);
        switch (extension) {
            case "jpg":
                response.setContentType(MediaType.IMAGE_JPEG_VALUE);
                break;
            case "png":
                response.setContentType(MediaType.IMAGE_PNG_VALUE);
                break;
            case "gif":
                response.setContentType(MediaType.IMAGE_GIF_VALUE);
                break;
        }
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName );
        return fileStorageService.download(fileName);
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam MultipartFile file) throws IOException {
        return fileStorageService.upload(file);
    }

}
