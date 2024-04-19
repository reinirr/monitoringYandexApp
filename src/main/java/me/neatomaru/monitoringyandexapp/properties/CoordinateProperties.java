package me.neatomaru.monitoringyandexapp.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "coordinate")
public class CoordinateProperties {

    public String startLongitude;
    public String startLatitude;
    public String finishLongitude;
    public String finishLatitude;
}
