package esprit.tn.ticketservice.controllers;

import esprit.tn.ticketservice.clients.CustomerRestClient;
import esprit.tn.ticketservice.entities.Ticket;
import esprit.tn.ticketservice.services.ITicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TicketRestController {
    ITicketService ticketService;
    private CustomerRestClient customerRestClient;
    @PostMapping("/add")
    @ResponseBody
    public Ticket addTicket(@RequestBody Ticket ticket) {
        return ticketService.addTicket(ticket);
    }

    @GetMapping("/getall")
    @ResponseBody
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Ticket getTicket(@PathVariable Long id) {
        return  ticketService.getTicket(id);

    }

    @PutMapping("/update")
    @ResponseBody
    public Ticket updateTicket(@RequestBody Ticket ticket) {
        return ticketService.updateTicket(ticket);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
    }

}
