package com.aurva.rolwin.assignment.service.implementation;

import com.aurva.rolwin.assignment.dto.FileUploadRequest;
import com.aurva.rolwin.assignment.dto.FileUploadResponse;
import com.aurva.rolwin.assignment.entity.FilesEntity;
import com.aurva.rolwin.assignment.repository.FilesRepository;
import com.aurva.rolwin.assignment.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private FilesRepository filesRepository;

    @Override
    public FileUploadResponse uploadFile(FileUploadRequest fileUploadRequest) {
        try {

            MultipartFile file = fileUploadRequest.getFile();
            InputStream inputStream = file.getInputStream();
            StringBuilder resultStringBuilder = new StringBuilder();

            try (BufferedReader br
                         = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = br.readLine()) != null) {
                    resultStringBuilder.append(line).append("\n");
                }
            }

            String fileString = resultStringBuilder.toString();
            List<String> panList = getPanList(fileString);
            List<String> ssnList = getSsnList(fileString);
            List<String> creditCardNumbers = getCreditCardNumbers(fileString);
            String medicalRecords = getMedicalInformationRecords(fileString);


            FilesEntity filesEntity = FilesEntity.builder()
                    .panList(panList)
                    .ssns(ssnList)
                    .creditCardNumbers(creditCardNumbers)
                    .medicalRecords(medicalRecords)
                    .build();

            filesRepository.save(filesEntity);
            return FileUploadResponse.builder()
                    .fileUploadStatus(true)
                    .message("File uploaded successfully")
                    .build();
        } catch (Exception e) {
            log.error("Failed to upload the file. error: ", e);
            return FileUploadResponse.builder()
                    .fileUploadStatus(false)
                    .error(e.getMessage())
                    .build();
        }
    }

    private List<String> getPanList(String input) {
        // regular expression to extract PAN from input string
        String panRegex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
        Pattern pattern = Pattern.compile(panRegex);
        Matcher matcher = pattern.matcher(input);

        List<String> panList = new ArrayList<>();
        while (matcher.find()) {
            panList.add(matcher.group());
        }

        return panList;
    }

    private List<String> getSsnList(String input) {
        // regular expression to extract PAN from input string
        String ssnRegex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
        Pattern pattern = Pattern.compile(ssnRegex);
        Matcher matcher = pattern.matcher(input);

        List<String> panList = new ArrayList<>();
        while (matcher.find()) {
            panList.add(matcher.group());
        }

        return panList;
    }

    private List<String> getCreditCardNumbers(String input) {
        // List to store detected credit card numbers
        List<String> creditCardNumbersList = new ArrayList<>();

        // Regular expressions for different credit card types
        String visaRegex = "\\b4[0-9]{12}(?:[0-9]{3})?\\b";
        String masterCardRegex = "\\b5[1-5][0-9]{14}\\b";
        String americanExpressRegex = "\\b3[47][0-9]{13}\\b";
        String discoverRegex = "\\b6(?:011|5[0-9]{2})[0-9]{12}\\b";

        // Array of credit card regex patterns
        String[] creditCardRegexes = {visaRegex, masterCardRegex, americanExpressRegex, discoverRegex};

        // Iterate through each regex and find matches
        for (String regex : creditCardRegexes) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                creditCardNumbersList.add(matcher.group());
            }
        }

        return creditCardNumbersList;
    }

    private String getMedicalInformationRecords(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        String medicalInformationRegex = "(\\d{1,3}\\.){3}\\d{1,3}~IPADDR|\\d{4}-\\d{2}-\\d{2}|\\d{2}/\\d{2}/\\d{2}|\\d{2}/\\d{2}/\\d{2}~DATE|\\b(?:asthma|diabetes|heart|lung|kidney|cancer|hypertension|medication|surgery|treatment|infection|antibiotic|vaccination|paracetamol|ibuprofen|analgesic|inflammation|flu|cold|arthritis|diuretic|antiseptic|cardiologist|oncologist|chronic|acute|stroke|ulcer|neurosurgery|pneumonia|sepsis)\\b";
        Pattern pattern = Pattern.compile(medicalInformationRegex);
        Matcher matcher = pattern.matcher(input);


        while (matcher.find()) {
            stringBuilder.append(matcher.group());
            stringBuilder.append("\t");
        }

        return stringBuilder.toString();

    }


}
