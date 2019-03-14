package no.oslomet.s315615springdockerserverproject;

import no.oslomet.s315615springdockerserverproject.model.Ticket;
import no.oslomet.s315615springdockerserverproject.model.User;
import no.oslomet.s315615springdockerserverproject.repository.TicketRepository;
import no.oslomet.s315615springdockerserverproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Date;

@SpringBootApplication
public class S315615SpringDockerServerProjectApplication implements CommandLineRunner {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    UserRepository userRepository;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(S315615SpringDockerServerProjectApplication.class, args);
    }

    //seeding
    @Override
    public void run(String... args) throws Exception {
        User user = new User("testname", "testlastname", "test@test.test", "test");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ADMIN");
        userRepository.save(user);
        ticketRepository.save(new Ticket(new Date(System.currentTimeMillis()), "testfilm", "testcinema", user));
    }
}
