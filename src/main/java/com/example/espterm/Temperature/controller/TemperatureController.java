package com.example.espterm.Temperature.controller;

import com.example.espterm.Temperature.controller.request.TemperatureError;
import com.example.espterm.Temperature.controller.request.TemperatureRequest;
import com.example.espterm.Temperature.controller.service.FileWriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.OffsetDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/temperature")
public class TemperatureController {

    private final FileWriterService fileWriterService;

    @GetMapping
    public ResponseEntity<String> getTemperature() {
        return ResponseEntity.ok("Temperature Controller");
    }

    @PostMapping
    public ResponseEntity<Void> postTemperature(
            @RequestBody TemperatureRequest temperature
    ) throws IOException {
        String toSave = temperature.getSensorName() + " : "
                + temperature.getTemperature() + " : "
                + OffsetDateTime.now();
        fileWriterService.writeToFile(toSave);
        System.out.println(toSave);
        return ResponseEntity.ok().build();
    }

    @PostMapping("error")
    public ResponseEntity<Void> postTemperature(
            @RequestBody TemperatureError temperature
    ) throws IOException {
        String toSave = temperature.getSensorName() + " : "
                + temperature.getMessage() + " : "
                + temperature.getTemperature() + " : "
                + OffsetDateTime.now();
        fileWriterService.writeToFile(toSave);
        System.out.println(toSave);
        return ResponseEntity.ok().build();
    }
}
