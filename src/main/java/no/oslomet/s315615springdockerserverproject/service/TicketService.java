package no.oslomet.s315615springdockerserverproject.service;

import no.oslomet.s315615springdockerserverproject.model.Ticket;
import no.oslomet.s315615springdockerserverproject.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(long id){
        return ticketRepository.findById(id).get();
    }

    public Ticket saveTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public void deleteTicketById(long id){
        ticketRepository.deleteById(id);
    }
}
