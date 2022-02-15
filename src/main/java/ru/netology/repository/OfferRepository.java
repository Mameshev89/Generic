package ru.netology.repository;

import ru.netology.domain.TicketOffer;

public class OfferRepository {
    private TicketOffer[] items = new TicketOffer[0];

    public void save(TicketOffer item) {
        TicketOffer[] tmt = new TicketOffer[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmt[i] = items[i];
        }
        tmt[tmt.length - 1] = item;
        items = tmt;
    }

    public void removeId(int id) {
        TicketOffer[] tmt = new TicketOffer[items.length - 1];
        int index = 0;
        for (TicketOffer item : items) {
            if (item.getId() != id) {
                tmt[index] = item;
                index++;
            }
            items = tmt;
        }
    }

    public TicketOffer[] findAll() {
        return items;
    }
}
