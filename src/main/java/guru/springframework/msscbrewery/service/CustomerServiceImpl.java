package guru.springframework.msscbrewery.service;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID id) {
        return CustomerDto.builder().id(id).name("Tester Testerson").build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().id(UUID.randomUUID()).name(customerDto.getName()).build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto beerDto) {
        log.debug("Updating customer...");
    }

    @Override
    public void deleteBeerById(UUID customerId) {
        log.debug("Deleting customer...");

    }
}
