package com.aurva.rolwin.assignment.service.implementation;

import com.aurva.rolwin.assignment.dto.FileDataResponse;
import com.aurva.rolwin.assignment.dto.FileDeleteResponse;
import com.aurva.rolwin.assignment.entity.FilesEntity;
import com.aurva.rolwin.assignment.repository.FilesRepository;
import com.aurva.rolwin.assignment.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DataServiceImpl implements DataService {

    @Autowired
    private FilesRepository filesRepository;

    @Override
    public FileDeleteResponse deleteEntity(int id) {
        try {
            FilesEntity filesEntity = filesRepository.findById(id);
            if(filesEntity == null) {
                return FileDeleteResponse.builder()
                        .fileDeleteStatus(false)
                        .message("File entity is not present in the database")
                        .build();
            }

            filesRepository.delete(filesEntity);
            return FileDeleteResponse.builder()
                    .fileDeleteStatus(true)
                    .message("File entity " + id + " deleted successfully!")
                    .build();
        } catch (Exception e) {
            log.error("Error while deleting entity: ", e);
            return FileDeleteResponse.builder()
                    .fileDeleteStatus(false)
                    .error(e.getMessage())
                    .build();
        }
    }

    @Override
    public FileDataResponse getAllFiles() {
        try {
            List<FilesEntity> files = filesRepository.findAll();

            List<FileDataResponse.File> fileList = new ArrayList<>();
            for(FilesEntity filesEntity: files) {

                FileDataResponse.PII pii = FileDataResponse.PII.builder()
                        .panNumbers(filesEntity.getPanList())
                        .socialSecurityNumbers(filesEntity.getSsns())
                        .build();

                FileDataResponse.PCI pci = FileDataResponse.PCI.builder()
                        .creditCardNumbers(filesEntity.getCreditCardNumbers())
                        .build();

                FileDataResponse.PHI phi = FileDataResponse.PHI.builder()
                        .build();

                FileDataResponse.File file = FileDataResponse.File.builder()
                        .id(filesEntity.getId())
                        .pii(pii)
                        .pci(pci)
                        .phi(phi)
                        .build();

                fileList.add(file);
            }

            return FileDataResponse.builder()
                    .files(fileList)
                    .build();

        } catch (Exception e) {
            log.error("Error while fetching files from table: ", e);
            return null; // return null data in case of an error
        }
    }
}
