package se.iths.robin.ViewModel;

import se.iths.robin.Model.IAstronaut;
import se.iths.robin.Model.People;
import se.iths.robin.Presenter.AstronautPresenter;
import se.iths.robin.Repository.AstronautRepository;
import java.util.Scanner;

public class MainViewModel {

    private AstronautPresenter astronautPresenter;
    private IAstronaut astronaut;

    public MainViewModel() {
        AstronautRepository astronautRepository = new AstronautRepository();
        astronautPresenter = new AstronautPresenter(astronautRepository);
    }

    public void present() {
        menu();
    }

    private void printNumberOfAstronauts() {
        System.out.println("Number of Astronauts in space: " + astronaut.getNumber() + "\n");
    }

    private boolean getAstronauts(){
        if (astronautPresenter.getAstronauts() == null){
            System.out.println("Something went wrong!"+ "\n");
            return false;
        }else {
            astronaut = astronautPresenter.getAstronauts();
            return true;
        }
    }

    private void printPeopleInSpace() {
        for (People p:astronaut.getPeople()) {
            System.out.println("Name : " + p.getName() + "\n" +
                    "Craft: " + p.getCraft() + "\n");
        }
    }

    private void printMenu(){
        System.out.println("Choose a number in the menu: " + "\n"+
                "1. Show number of people in space " + "\n"+
                "2. Show name and craft of people in space"+ "\n"+
                "3. Exit");
    }

    private void wrongInputError() {
        System.out.println("Wrong input"+ "\n");
    }

    private void menu() {
        Scanner s = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            while (!s.hasNextInt()) {
                wrongInputError();
                printMenu();
                s.next();
            }
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    if(getAstronauts())
                    printNumberOfAstronauts();
                    break;
                case 2:
                    if(getAstronauts())
                    printPeopleInSpace();
                    break;
                case 3:
                    break;
                default:
                    wrongInputError();
            }
        }while(choice != 3);
    }
}
