package com.marcelocastro.springmongopoc;

import static org.springframework.beans.BeanUtils.copyProperties;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

  private final CustomerMongoRepository customerMongoRepository;

  public List<Customer> getAllCustomers() {
    return customerMongoRepository.findAll();
  }

  public Customer postCustomer(Customer customer) {
    return customerMongoRepository.insert(customer);
  }

  public Customer getCustomerById(String customerId) {
    return customerMongoRepository.findById(customerId)
        .orElseThrow(() -> new CustomerException("Customer not found with Id " + customerId));
  }

  public void deleteCustomer(String customerId) {
    customerMongoRepository.deleteById(customerId);
  }
}
