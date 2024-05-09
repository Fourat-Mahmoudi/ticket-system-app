package esprit.tn.customerservice.services;

import esprit.tn.customerservice.entities.Customer;
import esprit.tn.customerservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
@Slf4j
@AllArgsConstructor
public class CustomerServiceImp implements ICustomerService {

    CustomerRepository customerRepository;

    public List<Customer> customerList(){
        return customerRepository.findAll();
    }
    public Customer customerById(Long id){
        return customerRepository.findById(id).get();
    }
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    public Customer updateCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
}
