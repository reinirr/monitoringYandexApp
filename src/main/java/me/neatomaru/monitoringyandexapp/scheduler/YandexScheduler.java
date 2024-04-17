package me.neatomaru.monitoringyandexapp.scheduler;

import lombok.RequiredArgsConstructor;
import me.neatomaru.monitoringyandexapp.model.Coordinate;
import me.neatomaru.monitoringyandexapp.properties.CoordinateProperties;
import me.neatomaru.monitoringyandexapp.service.TaxiService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class YandexScheduler {

    private final CoordinateProperties coordinateProperties;
    private final TaxiService taxiService;

    @Scheduled(fixedDelay = 30_000)
    public void updatePrice() {
        Coordinate startPoint = new Coordinate(coordinateProperties.getStartLongitude(), coordinateProperties.getStartLatitude());
        Coordinate endPoint = new Coordinate(coordinateProperties.getFinishLongitude(), coordinateProperties.getFinishLatitude());
        taxiService.getPrice(startPoint, endPoint);


    }
}
