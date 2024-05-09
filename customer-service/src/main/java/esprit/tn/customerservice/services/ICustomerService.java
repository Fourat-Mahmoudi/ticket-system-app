package esprit.tn.customerservice.services;

import esprit.tn.customerservice.entities.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> customerList();
    Customer customerById(Long id);
    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(Long id);

}
