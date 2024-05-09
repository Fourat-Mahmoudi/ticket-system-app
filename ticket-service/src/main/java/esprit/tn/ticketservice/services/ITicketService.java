package esprit.tn.ticketservice.services;

import esprit.tn.ticketservice.entities.Ticket;

import java.util.List;

public interface ITicketService {
    Ticket addTicket(Ticket ticket);
    Ticket updateTicket(Ticket ticket);
    void deleteTicket(Long id);
    Ticket getTicket(Long id);
    List<Ticket> getAllTickets();
}
