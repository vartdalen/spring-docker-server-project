package no.oslomet.s315615springdockerserverproject.controller;

import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "This is a rest controller  ";
    }
}
