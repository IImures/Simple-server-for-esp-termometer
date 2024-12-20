package com.example.espterm.Temperature.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemperatureError {
    private String sensorName;
    private String temperature;
    private String message;
}
