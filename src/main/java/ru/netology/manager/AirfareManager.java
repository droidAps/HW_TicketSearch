package ru.netology.manager;

import ru.netology.domain.Airfare;
import ru.netology.domain.NotFoundException;
import ru.netology.repository.AirfareRepository;

import java.util.Arrays;

public class AirfareManager {
    private AirfareRepository repository;

    public AirfareManager(AirfareRepository repository) {
        this.repository = repository;
    }

    public AirfareManager() {
    }

    public void add(Airfare airfare) {
        repository.save(airfare);
    }

    public Airfare[] searchBy(String from, String to) {
        Airfare[] result = new Airfare[0];
        for (Airfare airfare : repository.findAll()) {
            if (matches(airfare, from, to)) {
                Airfare[] tmp = new Airfare[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = airfare;
                result = tmp;
            }
        }
        if (result.length == 0) {
            throw new NotFoundException(
                    "There are no results matching the search conditions: from - " + from + ", to - " + to + ".");
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Airfare airfare, String from, String to) {
        if (airfare.getFrom().contains(from) && airfare.getTo().contains(to)) {
            return true;
        }
        return false;
    }

}
