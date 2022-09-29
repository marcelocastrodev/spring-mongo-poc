package com.marcelocastro.springmongopoc;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  @GetMapping
  public List<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
  }

  @GetMapping("{customerId}")
  public Customer getCustomerById(@PathVariable String customerId) {
    return customerService.getCustomerById(customerId);
  }

  @PostMapping
  public Customer postCustomer(@RequestBody Customer customer) {
    return customerService.postCustomer(customer);
  }

  @DeleteMapping("{customerId}")
  public void deleteCustomer(@PathVariable String customerId) {
    customerService.deleteCustomer(customerId);
  }
}
