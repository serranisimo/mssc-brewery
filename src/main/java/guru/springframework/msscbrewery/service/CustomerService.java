package guru.springframework.msscbrewery.service;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface CustomerService {
    public CustomerDto getCustomerById(UUID id);
}
