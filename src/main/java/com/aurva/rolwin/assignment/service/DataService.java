package com.aurva.rolwin.assignment.service;

import com.aurva.rolwin.assignment.dto.FileDataResponse;
import com.aurva.rolwin.assignment.dto.FileDeleteResponse;

public interface DataService {
    FileDeleteResponse deleteEntity(int id);

    FileDataResponse getAllFiles();
}
