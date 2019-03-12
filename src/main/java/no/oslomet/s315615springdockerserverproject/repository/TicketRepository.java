package no.oslomet.s315615springdockerserverproject.repository;

import no.oslomet.s315615springdockerserverproject.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}