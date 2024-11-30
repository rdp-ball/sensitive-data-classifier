package com.aurva.rolwin.assignment.controller;

import com.aurva.rolwin.assignment.dto.FileDataResponse;
import com.aurva.rolwin.assignment.dto.FileDeleteResponse;
import com.aurva.rolwin.assignment.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/data")
@Slf4j
public class DataController {

    @Autowired
    private DataService dataService;

    @DeleteMapping(value = "/delete/entity/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FileDeleteResponse deleteFile(@PathVariable("id") int id) {
        log.info("Id of Entity to be deleted: {}", id);
        return dataService.deleteEntity(id);
    }

    @GetMapping(value = "/files", produces = MediaType.APPLICATION_JSON_VALUE)
    public FileDataResponse getFiles() {
        return dataService.getAllFiles();
    }

}
