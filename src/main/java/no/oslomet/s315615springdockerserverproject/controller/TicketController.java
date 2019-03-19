package no.oslomet.s315615springdockerserverproject.controller;

import no.oslomet.s315615springdockerserverproject.model.Ticket;
import no.oslomet.s315615springdockerserverproject.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/tickets")
    public List<Ticket> getAllTickets() { return ticketService.getAllTickets(); }

    @GetMapping("/tickets/{id}")
    public Ticket getTicketById(@PathVariable long id) { return ticketService.getTicketById(id); }

    @DeleteMapping("/tickets/{id}")
    public void deleteTicketById(@PathVariable long id) {
         ticketService.deleteTicketById(id);
    }

    @PostMapping("/tickets")
    public Ticket saveTicket(@RequestBody  Ticket newTicket) { return ticketService.saveTicket(newTicket); }

    @PutMapping("/tickets/{id}")
    public Ticket updateTicket(@PathVariable long id, @RequestBody Ticket newTicket) {
        newTicket.setId(id);
        return ticketService.saveTicket(newTicket);
    }
}
