package guru.springframework.msscbrewery.service;

import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface CustomerService {
    public CustomerDto getCustomerById(UUID id);

    CustomerDto saveCustomer(CustomerDto customerDto);

    void updateCustomer(UUID beerId, CustomerDto customerDto);

    void deleteBeerById(UUID customerId);
}
