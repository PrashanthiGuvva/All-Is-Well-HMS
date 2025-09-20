package com.alliswell.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.alliswell.hms.model.ServiceItem;
import com.alliswell.hms.repository.ServiceItemRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/services")
public class ServiceItemController {

    @Autowired
    private ServiceItemRepository serviceItemRepository;

    @GetMapping
    public List<ServiceItem> getAllServices() {
        return serviceItemRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ServiceItem> getServiceById(@PathVariable Long id) {
        return serviceItemRepository.findById(id);
    }

    @PostMapping
    public ServiceItem createService(@RequestBody ServiceItem serviceItem) {
        return serviceItemRepository.save(serviceItem);
    }

    @PutMapping("/{id}")
    public ServiceItem updateService(@PathVariable Long id, @RequestBody ServiceItem details) {
        return serviceItemRepository.findById(id)
                .map(service -> {
                    service.setServiceName(details.getServiceName());
                    service.setPrice(details.getPrice());
                    return serviceItemRepository.save(service);
                }).orElseThrow(() -> new RuntimeException("Service not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id) {
        serviceItemRepository.deleteById(id);
    }
}
