package ru.itis.springdemo_11206.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.springdemo_11206.models.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    @Query("select service from Service service where (:q = 'empty' or UPPER(service.name) like UPPER(concat('%', :q, '%'))) ")
    Page<Service> search(@Param("q") String q, Pageable pageable);
}