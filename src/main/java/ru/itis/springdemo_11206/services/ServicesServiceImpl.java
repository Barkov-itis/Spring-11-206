package ru.itis.springdemo_11206.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import ru.itis.springdemo_11206.dto.ServiceDto;
import ru.itis.springdemo_11206.dto.ServiceForm;
import ru.itis.springdemo_11206.models.Service;
import ru.itis.springdemo_11206.repository.ServiceRepository;

import java.util.List;

@Component
public class ServicesServiceImpl implements ServicesService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<ServiceDto> getAllServices() {
        return ServiceDto.from(serviceRepository.findAll());
    }

    @Override
    public ServiceDto addService(ServiceForm serviceForm) {
        Service service = Service.builder()
                .name(serviceForm.getName())
                .cost(serviceForm.getCost())
                .date(serviceForm.getDate())
                .build();
        serviceRepository.save(service);
        return ServiceDto.of(service);
    }

    @Override
    public List<ServiceDto> search(Integer size, Integer page, String query, String sortParameter, String directionParameter) {
        Sort.Direction direction = Sort.Direction.ASC;
        Sort sort = Sort.by(direction, "id");

        if (directionParameter != null) {
            direction = Sort.Direction.fromString(directionParameter);
        }

        if (sortParameter != null) {
            sort = Sort.by(direction, sortParameter);
        }

        if (query == null) {
            query = "empty";
        }
        if (size == null) {
            size = 3;
        }

        PageRequest pageRequest = PageRequest.of(page, size, sort);
        System.out.println(pageRequest);
        Page<Service> papersPage = serviceRepository.search(query, pageRequest);
        return ServiceDto.from(papersPage.getContent());
    }
}