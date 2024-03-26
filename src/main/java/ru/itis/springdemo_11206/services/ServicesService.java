package ru.itis.springdemo_11206.services;

import ru.itis.springdemo_11206.dto.ServiceDto;
import ru.itis.springdemo_11206.dto.ServiceForm;

import java.util.List;

public interface ServicesService {
    ServiceDto addService(ServiceForm serviceForm);
    List<ServiceDto> search(Integer size, Integer page, String query, String sort, String direction);

}