package com.aurva.rolwin.assignment.service;

import com.aurva.rolwin.assignment.dto.FileUploadRequest;
import com.aurva.rolwin.assignment.dto.FileUploadResponse;

public interface FileUploadService {
    FileUploadResponse uploadFile(FileUploadRequest fileUploadRequest);
}
