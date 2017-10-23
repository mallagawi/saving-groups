package com.cleansoft.savago.commons;

import com.cleansoft.savago.commons.PropertiesLoader.InvalidPropertiesFile;
import com.cleansoft.savago.commons.PropertiesLoader.LoadingPropertiesException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PropertiesLoaderTest {

    @Test
    public void canCreate() {
        new PropertiesLoader("test.properties");
    }

    @Test(expected = InvalidPropertiesFile.class)
    public void givenNullPropertiesFile_whenCreate_thenShouldThrowException() {
        new PropertiesLoader(null);
    }

    @Test(expected = InvalidPropertiesFile.class)
    public void givenEmptyPropertiesFile_whenCreate_thenShouldThrowException() {
        new PropertiesLoader("");
    }

    @Test(expected = InvalidPropertiesFile.class)
    public void givenPropertiesFileWithoutPropertiesExtension_whenCreate_thenShouldThrowException() {
        new PropertiesLoader("propfile.p");
    }

    @Test(expected = InvalidPropertiesFile.class)
    public void givenPropertiesFileWithInvalidName_whenCreate_thenShouldThrowException() {
        new PropertiesLoader(".p");
        new PropertiesLoader(".");
        new PropertiesLoader("s.");
    }

    @Test(expected = LoadingPropertiesException.class)
    public void givenPropertiesFileName_whenCouldntLoadProperties_thenShouldThrowException() {
        PropertiesLoader propertiesLoader = new PropertiesLoader("wrong.properties");
        propertiesLoader.getValueOf("name");
    }


    @Test
    public void givenValidPropertiesFileName_whenGetExistingKey_thenShouldReturnTheValue() {
        PropertiesLoader propertiesLoader = new PropertiesLoader("student.properties");
        String value = propertiesLoader.getValueOf("name");
        assertEquals("Mousa Ibrahim", value);
    }

    @Test
    public void givenValidPropertiesFileName_whenGetMaltiKeys_thenShouldReturnMultiValuesInSameOrderOfRequestedKeys() {
        List<String> keys = Arrays.asList("name", "age", "DOB");
        Map<String, String> propertiesMap = new PropertiesLoader("student.properties").getValuesOf(keys);
        assertEquals("Mousa Ibrahim", propertiesMap.get("name"));
        assertEquals("33", propertiesMap.get("age"));
        assertEquals("27/2/1985", propertiesMap.get("DOB"));
    }
}
