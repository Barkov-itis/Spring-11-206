package ru.itis.springdemo_11206.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.springdemo_11206.dto.ServiceDto;
import ru.itis.springdemo_11206.dto.ServiceForm;
import ru.itis.springdemo_11206.services.ServicesService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ServicesController {

    @Autowired
    private ServicesService servicesService;


    @GetMapping("/allservices")
    @ResponseBody
    public ResponseEntity<List<ServiceDto>> getAllServices() {
        return ResponseEntity.ok(servicesService.getAllServices());
    }

    @GetMapping("/service")
    public String getSericePage(Model model) {
        model.addAttribute("serviceList", servicesService.getAllServices());
        return "services";
    }

    @PostMapping("/services")
    @ResponseBody
    public ResponseEntity<ServiceDto> addService(@RequestBody ServiceForm serviceForm) {
        return ResponseEntity.ok(servicesService.addService(serviceForm));
    }

    //localhost:8080/papers/service/search?page=0
    @GetMapping("/papers/service/search")
    @ResponseBody
    public ResponseEntity<List<ServiceDto>> search(@RequestParam("page") Integer page,
                                                   @RequestParam("size") Integer size,
                                                   @RequestParam(value = "q", required = false) String query,
                                                   @RequestParam(value = "sort", required = false) String sort,
                                                   @RequestParam(value = "direction", required = false) String direction) {
        return ResponseEntity.ok(servicesService.search(size, page, query, sort, direction));
    }

}