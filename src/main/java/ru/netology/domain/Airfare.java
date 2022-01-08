package ru.netology.domain;

import java.util.Objects;

public class Airfare implements Comparable<Airfare> {
    private int id;
    private int price;
    private String from;
    private String to;
    private int time;

    public Airfare(int id, int price, String from, String to, int time) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.time = time;
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airfare airfare = (Airfare) o;
        return getId() == airfare.getId() && getPrice() == airfare.getPrice() && getTime() == airfare.getTime() && Objects.equals(getFrom(), airfare.getFrom()) && Objects.equals(getTo(), airfare.getTo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrice(), getFrom(), getTo(), getTime());
    }

    @Override
    public String toString() {
        return "Airfare{" +
                "id=" + id +
                ", price=" + price +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", time=" + time +
                '}';
    }

    @Override
    public int compareTo(Airfare o) {
        return price - o.price;
    }
}
