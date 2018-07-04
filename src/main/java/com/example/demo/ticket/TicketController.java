package com.example.demo.ticket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/tickets")
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @RequestMapping(value = "/{ticketId}", method = RequestMethod.GET)
    public boolean getStreamStatus(@PathVariable long ticketId) {
        log.info("Got request to check if ticket id {} is valid", ticketId);
        return ticketService.isValid(ticketId);
    }

}
