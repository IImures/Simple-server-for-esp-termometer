package com.example.espterm.Temperature.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemperatureRequest {
    private String sensorName;
    private Double temperature;
}
