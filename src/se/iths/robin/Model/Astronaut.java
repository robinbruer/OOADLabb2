package se.iths.robin.Model;

import java.util.List;

public class Astronaut implements IAstronaut {

    private List<People> people;
    private int number;

    public int getNumber() {
        return number;
    }

    public List<People> getPeople() {
        return people;
    }

}
