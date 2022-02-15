package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.TicketOffer;
import ru.netology.repository.OfferRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ManagerOfferTicketsTest {
    private final OfferRepository repo = Mockito.mock(OfferRepository.class);
    private final ManagerOfferTickets manager = new ManagerOfferTickets(repo);

    TicketOffer first = new TicketOffer(1, 5000, "DME", "LED", 2);
    TicketOffer second = new TicketOffer(2, 6000, "SVO", "VOG", 1);
    TicketOffer third = new TicketOffer(3, 12000, "SVO", "DXB", 4);
    TicketOffer fourth = new TicketOffer(4, 2500, "LED", "DXB", 2);
    TicketOffer fifth = new TicketOffer(5, 15000, "DXB", "DME", 3);
    TicketOffer sixth = new TicketOffer(6, 15000, "DXB", "DME", 3);
    TicketOffer seven = new TicketOffer(7, 30000, "DME", "JFK", 7);

    @Test
    void save(){
        doNothing().when(repo).save(any());
        doReturn(new TicketOffer[]{fifth}).when(repo).findAll();
        manager.add(fifth);
        Assertions.assertArrayEquals(new TicketOffer[]{fifth}, manager.findAll());

        verify(repo).save(any());
    }

    @Test
    void searchBy() {
      doReturn(new TicketOffer[]{third,second}).when(repo).findAll();
      TicketOffer[] actual= manager.find("SVO","");
      TicketOffer[] expected= new TicketOffer[]{second,third};
      assertArrayEquals(expected,actual);
    }
    @Test
    void searchByOverThereBack() {
        doReturn(new TicketOffer[]{second}).when(repo).findAll();
        TicketOffer[] actual= manager.find("SVO","VOG");
        TicketOffer[] expected= new TicketOffer[]{second};
        assertArrayEquals(expected,actual);
    }
    @Test
    void searchByOverThereBackAnother() {
        doReturn(new TicketOffer[]{third,fourth}).when(repo).findAll();
        TicketOffer[] actual= manager.find("","DXB");
        TicketOffer[] expected= new TicketOffer[]{fourth,third};
        assertArrayEquals(expected,actual);
    }
    @Test
    void searchByOverThereBackInside() {
        doReturn(new TicketOffer[]{seven,first}).when(repo).findAll();
        TicketOffer[] actual= manager.find("DME","");
        TicketOffer[] expected= new TicketOffer[]{first,seven};
        assertArrayEquals(expected,actual);
    }
    @Test
    void searchByOverThereBackEmirates() {
        doReturn(new TicketOffer[]{fifth,sixth}).when(repo).findAll();
        TicketOffer[] actual= manager.find("DXB","DME");
        TicketOffer[] expected= new TicketOffer[]{fifth,sixth};
        assertArrayEquals(expected,actual);
    }
    @Test
    void searchNull() {
        doReturn(new TicketOffer[]{}).when(repo).findAll();
        TicketOffer[] actual= manager.find("Ddw","fww");
        TicketOffer[] expected= new TicketOffer[]{};
        assertArrayEquals(expected,actual);
    }

}