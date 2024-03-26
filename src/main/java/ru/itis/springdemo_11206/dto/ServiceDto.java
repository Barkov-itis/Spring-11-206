package ru.itis.springdemo_11206.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springdemo_11206.models.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceDto {
    private Long id;
    private String name;
    private String cost;
    private String date;

    public static ServiceDto of(Service service) {
        return ServiceDto.builder()
                .id(service.getId())
                .name(service.getName())
                .cost(service.getCost())
                .date(service.getDate())
                .build();
    }

    public static List<ServiceDto> from(List<Service> services) {
        return services.stream()
                .map(ServiceDto::of)
                .collect(Collectors.toList());
    }
}