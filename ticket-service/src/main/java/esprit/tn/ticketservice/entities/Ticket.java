package esprit.tn.ticketservice.entities;
import esprit.tn.ticketservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate createdAt;
    @Enumerated(EnumType.STRING)
    private TicketType type;
    @Transient
    private Customer customer;
    private Long customerId;
}
