package com.alliswell.hms.Service;


import com.alliswell.hms.model.ServiceItem;
import com.alliswell.hms.repository.ServiceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceItemService {

    @Autowired
    private ServiceItemRepository serviceRepo;

    public List<ServiceItem> getAllServices() {
        return serviceRepo.findAll();
    }
}

