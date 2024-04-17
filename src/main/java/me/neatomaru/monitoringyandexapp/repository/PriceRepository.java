package me.neatomaru.monitoringyandexapp.repository;

import me.neatomaru.monitoringyandexapp.model.MomentPrice;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<MomentPrice, Long> {
}
