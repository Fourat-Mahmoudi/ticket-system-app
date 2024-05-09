package esprit.tn.ticketservice.services;

import esprit.tn.ticketservice.clients.CustomerRestClient;
import esprit.tn.ticketservice.entities.Ticket;
import esprit.tn.ticketservice.model.Customer;
import esprit.tn.ticketservice.repository.TicketRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class TicketServiceImp implements ITicketService{
    TicketRepository ticketRepository;
    CustomerRestClient customerRestClient;

    @Override
    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        tickets.forEach(tick -> {
        tick.setCustomer(customerRestClient.findCustomerById(tick.getCustomerId()));
        });
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicket(Long id) {
         Ticket ticket=ticketRepository.findById(id).get();
         Customer customer=customerRestClient.findCustomerById(ticket.getCustomerId());
         ticket.setCustomer(customer);
         return ticket;
    }

    @Override
    public Ticket addTicket(Ticket ticket) {
        ticket.setCustomer(customerRestClient.findCustomerById(ticket.getCustomerId()));
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
