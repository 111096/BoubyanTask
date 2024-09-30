package com.boubyan.task.utils;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

public class HelperClass {
  public static InputStream locateFile(String fileName) throws IOException {
        return new ClassPathResource(fileName).getInputStream();
    }
}
