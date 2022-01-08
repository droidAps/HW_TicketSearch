package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Airfare;
import ru.netology.domain.NotFoundException;
import ru.netology.repository.AirfareRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AirfareManagerTest {

    Airfare one = new Airfare(1, 1300, "LED", "SVO", 85);
    Airfare two = new Airfare(2, 1200, "LED", "SVO", 95);
    Airfare three = new Airfare(3, 5500, "SVO", "KZN", 110);
    Airfare four = new Airfare(4, 17500, "LED", "VVO", 490);
    Airfare five = new Airfare(5, 1900, "DME", "LED", 100);
    Airfare six = new Airfare(6, 1100, "LED", "SVO", 90);

    @Test
    void shouldSearchWithManyResults() {
        AirfareRepository repo = new AirfareRepository();
        AirfareManager manager = new AirfareManager(repo);
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);

        Airfare[] expected = new Airfare[]{six, two, one};

        assertArrayEquals(expected, manager.searchBy("LED", "SVO"));
    }

    @Test
    void shouldSearchWithOneResult() {
        AirfareRepository repo = new AirfareRepository();
        AirfareManager manager = new AirfareManager(repo);
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);

        Airfare[] expected = new Airfare[]{five};

        assertArrayEquals(expected, manager.searchBy("DME", "LED"));
    }

    @Test
    void shouldSearchWithoutResults() {
        AirfareRepository repo = new AirfareRepository();
        AirfareManager manager = new AirfareManager(repo);
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);

        assertThrows(NotFoundException.class, () -> {
            manager.searchBy("KZN", "LED");
        });
    }
}