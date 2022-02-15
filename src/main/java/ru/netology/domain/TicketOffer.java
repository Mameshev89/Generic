package ru.netology.domain;

public class TicketOffer implements Comparable<TicketOffer> {
    private int id;
    private int price;
    private String departure;
    private String arrive;
    private int flyTime;

    public TicketOffer(int id, int price, String departure, String arrive, int flyTime) {
        this.id = id;
        this.price = price;
        this.departure = departure;
        this.arrive = arrive;
        this.flyTime = flyTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrive() {
        return arrive;
    }

    public void setArrive(String arrive) {
        this.arrive = arrive;
    }

    public int getFlyTime() {
        return flyTime;
    }

    public void setFlyTime(int flyTime) {
        this.flyTime = flyTime;
    }

    @Override
    public int compareTo(TicketOffer o) {
        return this.price - o.price;
    }
}
