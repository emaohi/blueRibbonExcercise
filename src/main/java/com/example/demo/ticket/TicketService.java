package com.example.demo.ticket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TicketService {

    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public boolean isValid(long ticketId) {
        if (ticketRepository.getById(ticketId).isPresent()) {
            log.info("Found ticket!");
            return true;
        }
        log.info("Couldnt find ticket...");
        return false;
    }
}
