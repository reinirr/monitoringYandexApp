package me.neatomaru.monitoringyandexapp.service;


import lombok.AllArgsConstructor;
import me.neatomaru.monitoringyandexapp.apiclient.TaxiApiClient;
import me.neatomaru.monitoringyandexapp.model.Coordinate;
import me.neatomaru.monitoringyandexapp.model.MomentPrice;
import me.neatomaru.monitoringyandexapp.model.Price;
import me.neatomaru.monitoringyandexapp.properties.YandexProperties;
import me.neatomaru.monitoringyandexapp.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@AllArgsConstructor
public class TaxiService {

    private final YandexProperties yandexProperties;
    private final TaxiApiClient taxiApiClient;
    private final PriceRepository priceRepository;

    public void getPrice(Coordinate startPoint, Coordinate endPoint) {
        String rll = startPoint.toString() + "~" + endPoint.toString();
        String clid = yandexProperties.getClid();
        String apiKey = yandexProperties.getApiKey();

        Price currentPrice = taxiApiClient. getPrice(clid, apiKey, rll);
        if (currentPrice.options.isEmpty()) {
                throw new RuntimeException("Options are empty");
        }

        double priceDouble = currentPrice.getOptions().getFirst().getPrice();
        MomentPrice momentPrice = new MomentPrice(
                LocalDateTime.now(ZoneId.of("Russia/Moscow")),
                priceDouble
        );
        priceRepository.save(momentPrice);

    }
}
