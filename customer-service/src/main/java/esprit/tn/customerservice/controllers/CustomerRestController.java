package esprit.tn.customerservice.controllers;
import esprit.tn.customerservice.entities.Customer;
import esprit.tn.customerservice.repository.CustomerRepository;
import esprit.tn.customerservice.services.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
public class CustomerRestController {
    ICustomerService customerService;
    @PostMapping("/add")
    @ResponseBody
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }
    @PutMapping("/update")
    @ResponseBody
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
    @GetMapping("/getall")
    @ResponseBody
    public List<Customer> customerList(){
        return customerService.customerList();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Customer customerById(@PathVariable Long id){
        return customerService.customerById(id);
    }
}