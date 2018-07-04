package com.example.demo.ticket;

import java.util.Optional;

public interface TicketRepository {

    Optional<Ticket> getById(long id);

}
