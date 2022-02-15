package ru.netology.manager;

import ru.netology.domain.TicketOffer;
import ru.netology.repository.OfferRepository;

import java.util.Arrays;

public class ManagerOfferTickets {
    private OfferRepository repository;

    public ManagerOfferTickets(OfferRepository repository) {
        this.repository = repository;
    }

    public void add(TicketOffer ticketOffer) {
        repository.save(ticketOffer);
    }

    public TicketOffer[] find(String from, String to) {
        TicketOffer[] result = new TicketOffer[0];
        for (TicketOffer item : repository.findAll()) {
            TicketOffer[] tmp = new TicketOffer[result.length + 1];
            if (item.getDeparture().contains(from) || item.getArrive().contains(to)) {
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public TicketOffer[] findAll() {
        TicketOffer[] result = repository.findAll();
        return result;
    }

    public void remove(int id) {
        repository.removeId(id);
    }

}
