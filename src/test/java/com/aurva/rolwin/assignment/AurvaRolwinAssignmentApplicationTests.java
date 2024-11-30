package com.aurva.rolwin.assignment;

import com.aurva.rolwin.assignment.service.implementation.FileUploadServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AurvaRolwinAssignmentApplicationTests {

    @Autowired
    private FileUploadServiceImpl fileUploadService;

    private static final String testData = "UWPCL6780T PEVFV4506Y CTUGE1616I DAJPC4150P UWPCL6780T alskdfjaosldflasdf 778-62-8144 030 72 7381 70906649 16325404 757-85-7495 149-13-7317";

    @Test
    void testPanDataExtraction() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = FileUploadServiceImpl.class.getDeclaredMethod("getPanList", String.class);

        method.setAccessible(true);

        List<String> expectedResult = Arrays.asList("UWPCL6780T", "PEVFV4506Y", "CTUGE1616I", "DAJPC4150P", "UWPCL6780T");

        String testData = "UWPCL6780T PEVFV4506Y CTUGE1616I DAJPC4150P UWPCL6780T alskdfjaosldflasdf 778-62-8144 030 72 7381 70906649 16325404 757-85-7495 149-13-7317";
        List<String> actualResult = (List<String>) method.invoke(fileUploadService, testData);
        System.out.println(actualResult);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSocialSecurityNumberExtraction() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = FileUploadServiceImpl.class.getDeclaredMethod("getSsnList", String.class);

        method.setAccessible(true);

        List<String> expectedResult = Arrays.asList("778-62-8144", "757-85-7495", "149-13-7317");

        List<String> actualResult = (List<String>) method.invoke(fileUploadService, testData);
        System.out.println(actualResult);

        assertEquals(expectedResult, actualResult);
    }

}
