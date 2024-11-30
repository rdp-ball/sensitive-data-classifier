package com.aurva.rolwin.assignment.controller;

import com.aurva.rolwin.assignment.dto.FileUploadRequest;
import com.aurva.rolwin.assignment.dto.FileUploadResponse;
import com.aurva.rolwin.assignment.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/upload")
@Slf4j
public class FileController {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping(value = "/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public FileUploadResponse uploadFile(@ModelAttribute FileUploadRequest fileUploadRequest) {
        FileUploadResponse fileUploadResponse = fileUploadService.uploadFile(fileUploadRequest);
        log.info("file upload response: {}", fileUploadResponse);
        return fileUploadResponse;
    }
}
