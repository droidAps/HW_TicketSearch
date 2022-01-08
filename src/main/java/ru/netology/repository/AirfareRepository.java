package ru.netology.repository;

import ru.netology.domain.Airfare;
import ru.netology.domain.NotFoundException;

public class AirfareRepository {
    private Airfare[] airfares = new Airfare[0];

    public AirfareRepository() {
    }

    public void save(Airfare airfare) {
        int length = airfares.length + 1;
        Airfare[] tmp = new Airfare[length];
        System.arraycopy(airfares, 0, tmp, 0, airfares.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = airfare;
        airfares = tmp;
    }

    public Airfare[] findAll() {
        return airfares;
    }

    public Airfare findById(int id) {
        for (Airfare airfare : airfares) {
            if (airfare.getId() == id) {
                return airfare;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found");
        }
        int length = airfares.length - 1;
        Airfare[] tmp = new Airfare[length];
        int index = 0;
        for (Airfare airfare : airfares) {
            if (airfare.getId() != id) {
                tmp[index] = airfare;
                index++;
            }
        }
        airfares = tmp;
    }
}
