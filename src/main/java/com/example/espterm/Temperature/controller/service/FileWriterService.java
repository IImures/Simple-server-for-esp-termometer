package com.example.espterm.Temperature.controller.service;

import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Service
public class FileWriterService {

    private final Path filePath;

    public FileWriterService() {
        this.filePath = Paths.get("report/temperature.txt");
    }

    public synchronized void writeToFile(String content) throws IOException {
        Files.createDirectories(filePath.getParent());

        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(content);
            writer.newLine();
        }
    }
}