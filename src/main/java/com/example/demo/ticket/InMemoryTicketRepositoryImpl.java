package com.example.demo.ticket;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryTicketRepositoryImpl implements TicketRepository {

    private final static List<Ticket> AVAILABLE_TICKETS = Arrays.asList(
            new Ticket(123, "seat1"),
            new Ticket(124, "seat2"),
            new Ticket(125, "seat3"),
            new Ticket(126, "seat4"),
            new Ticket(127, "seat5"),
            new Ticket(128, "seat6")
    );

    @Override
    public Optional<Ticket> getById(long id) {
        return AVAILABLE_TICKETS.stream().filter(o -> o.getId() == id).findFirst();
    }
}
