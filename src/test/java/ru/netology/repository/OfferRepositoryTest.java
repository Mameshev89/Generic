package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketOffer;

import static org.junit.jupiter.api.Assertions.*;

class OfferRepositoryTest {
    private final OfferRepository repository=new OfferRepository();
    TicketOffer first = new TicketOffer(1, 5000, "DME", "LED", 2);
    TicketOffer second = new TicketOffer(2, 6000, "SVO", "VOG", 1);
    TicketOffer third = new TicketOffer(3, 12000, "SVO", "DXB", 4);
    TicketOffer fourth = new TicketOffer(4, 2500, "LED", "DXB", 2);
    TicketOffer fifth = new TicketOffer(5, 15000, "DXB", "DME", 3);
    TicketOffer sixth = new TicketOffer(6, 15000, "DXB", "DME", 3);
    TicketOffer seven = new TicketOffer(7, 30000, "DME", "JFK", 7);

    @BeforeEach
    void setUp(){
       repository.save(first);
       repository.save(second);
       repository.save(third);
       repository.save(fourth);
       repository.save(fifth);
       repository.save(sixth);
       repository.save(seven);

    }
    @Test
    void FindAll(){
        TicketOffer[] actual=repository.findAll();
        TicketOffer[]expected=new TicketOffer[]{first,second,third,fourth,fifth,sixth,seven};
        assertArrayEquals(expected,actual);
    }

    @Test
    void Find(){
        repository.removeAll();
        TicketOffer[] actual=repository.findAll();
        TicketOffer[]expected=new TicketOffer[]{};
        assertArrayEquals(expected,actual);
    }

}