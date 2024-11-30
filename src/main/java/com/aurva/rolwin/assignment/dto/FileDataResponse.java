package com.aurva.rolwin.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class FileDataResponse {

    @Builder.Default
    private List<File> files = new ArrayList<>();

    @Data
    @Builder(toBuilder = true)
    @AllArgsConstructor
    @NoArgsConstructor
    public static class File {
        private int id;
        private PII pii;
        private PHI phi;
        private PCI pci;
        private String medicalInformation; // according to: https://www.johnsnowlabs.com/extract-medical-named-entities-with-regex-in-healthcare-nlp-at-scale/
    }

    @Data
    @Builder(toBuilder = true)
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PII { // Personally Identifiable Information
        List<String> panNumbers;
        List<String> socialSecurityNumbers;
    }

    @Data
    @Builder(toBuilder = true)
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PCI { // Payment Card Information
        List<String> creditCardNumbers;
    }


    @Data
    @Builder(toBuilder = true)
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PHI { // Protected Health Information
        /* according to: https://www.aurosiksha.org/lica/ebook/medical_chapter5 */
        List<String> healthCardNumbers;
    }

}
