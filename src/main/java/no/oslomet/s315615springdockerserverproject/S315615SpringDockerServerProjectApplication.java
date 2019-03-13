package no.oslomet.s315615springdockerserverproject;

import no.oslomet.s315615springdockerserverproject.model.Ticket;
import no.oslomet.s315615springdockerserverproject.model.User;
import no.oslomet.s315615springdockerserverproject.repository.TicketRepository;
import no.oslomet.s315615springdockerserverproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class S315615SpringDockerServerProjectApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TicketRepository ticketRepository;

    public static void main(String[] args) {
        SpringApplication.run(S315615SpringDockerServerProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("testname", "testlastname", "test@email.test", "testpassword");
        userRepository.save(user);
        ticketRepository.save(new Ticket(new Date(System.currentTimeMillis()), "testfilm", "testcinema", user));
    }
}
