package UI;

import Service.ClientService;
import Service.FilmService;
import Service.ReservationService;

import java.util.Scanner;

public class NaturalLanguageConsole {

    private FilmService filmService;
    private ClientService clientService;
    private ReservationService reservationService;
    private Scanner scanner;

    public NaturalLanguageConsole(FilmService filmService, ClientService clientService, ReservationService reservationService) {
        this.filmService = filmService;
        this.clientService = clientService;
        this.reservationService = reservationService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("Enter your command or type 'exit' to quit:");
            String input = scanner.nextLine();
            String text[] = input.split("\\s");
            switch (text[0].toLowerCase()) {
                case "add":
                    handleAdd(text);
                    break;
                case "update":
                    handleUpdate(text);
                    break;
                case "remove":
                    handleRemove(text);
                    break;
                case "showall":
                    handleShowAll(text);
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Invalid command!");
                    System.out.println("Available operations: add, update, remove, showall.");
            }
        }
    }

    private void handleAdd(String text[]) {
        String entity = text[1].toLowerCase();
        if (!entity.equals("film") && !entity.equals("client") && !entity.equals("reservation"))
            System.out.println("Invalid entity! Choose between: film, client, reservation.");
        if (entity.equals("film"))
            if (text.length != 7)
                System.out.println("There must be 7 arguments for adding a film!");
            else {
                try {
                    String id = text[2];
                    String title = text[3];
                    int year = Integer.parseInt(text[4]);
                    double price = Double.parseDouble(text[5]);
                    boolean onScreen = Boolean.parseBoolean(text[6]);

                    filmService.addFilm(id, title, year, price, onScreen);
                    System.out.println("Film successfully added!");
                } catch (RuntimeException rex) {
                    System.out.println("Errors: " + rex.getMessage());
                }
            }
        if (entity.equals("client"))
            if (text.length != 9)
                System.out.println("There must be 9 arguments for adding a client!");
            else {
                try {
                    String id = text[2];
                    String name = text[3];
                    String surname = text[4];
                    String cnp = text[5];
                    String birthday = text[6];
                    String registrationDay = text[7];
                    int points = Integer.parseInt(text[8]);

                    clientService.addClient(id, name, surname, cnp, birthday, registrationDay, points);
                    System.out.println("Client successfully added!");
                } catch (RuntimeException rex) {
                    System.out.println("Errors: " + rex.getMessage());
                }
            }
        if (entity.equals("reservation"))
            if (text.length != 7)
                System.out.println("There must be 7 arguments for adding a reservation!");
            else {
                try {
                    String id = text[2];
                    String idFilm = text[3];
                    String idCardClient = text[4];
                    String date = text[5];
                    String time = text[6];

                    reservationService.addReservation(id, idFilm, idCardClient, date, time);
                    if (clientService.getClientRepository().getStorage().containsKey(idCardClient))
                        System.out.println("Bonus points: " + clientService.getClientRepository().getStorage().get(idCardClient).getPoints());
                    System.out.println("Reservation successfully added!");
                } catch (RuntimeException rex) {
                    System.out.println("Errors: " + rex.getMessage());
                }
            }
    }

    private void handleUpdate(String text[]) {
        String entity = text[1].toLowerCase();
        if (!entity.equals("film") && !entity.equals("client") && !entity.equals("reservation"))
            System.out.println("Invalid entity! Choose between: film, client, reservation.");
        if (entity.equals("film"))
            if (text.length != 7)
                System.out.println("There must be 7 arguments for updating a film!");
            else {
                try {
                    String id = text[2];
                    String title = text[3];
                    int year = Integer.parseInt(text[4]);
                    double price = Double.parseDouble(text[5]);
                    boolean onScreen = Boolean.parseBoolean(text[6]);

                    filmService.updateFilm(id, title, year, price, onScreen);
                    System.out.println("Film successfully updated!");
                } catch (RuntimeException rex) {
                    System.out.println("Errors: " + rex.getMessage());
                }
            }
        if (entity.equals("client"))
            if (text.length != 9)
                System.out.println("There must be 9 arguments for updating a client!");
            else {
                try {
                    String id = text[2];
                    String name = text[3];
                    String surname = text[4];
                    String cnp = text[5];
                    String birthday = text[6];
                    String registrationDay = text[7];
                    int points = Integer.parseInt(text[8]);

                    clientService.updateClient(id, name, surname, cnp, birthday, registrationDay, points);
                    System.out.println("Client successfully updated!");
                } catch (RuntimeException rex) {
                    System.out.println("Errors: " + rex.getMessage());
                }
            }
        if (entity.equals("reservation"))
            if (text.length != 7)
                System.out.println("There must be 7 arguments for updating a reservation!");
            else {
                try {
                    String id = text[2];
                    String idFilm = text[3];
                    String idCardClient = text[4];
                    String date = text[5];
                    String time = text[6];

                    reservationService.addReservation(id, idFilm, idCardClient, date, time);
                    System.out.println("Reservation successfully updated!");
                } catch (RuntimeException rex) {
                    System.out.println("Errors: " + rex.getMessage());
                }
            }
    }

    private void handleRemove(String text[]) {
        if (text.length != 3)
            System.out.println("There must be 3 arguments for remove operation!");
        else {
            String id = text[2].toLowerCase();
            if (text[1].toLowerCase().equals("film")) {
                filmService.removeFilm(id);
                System.out.println("Film successfully removed!");
            } else if (text[1].toLowerCase().equals("client")) {
                clientService.removeClient(id);
                System.out.println("Client successfully removed!");
            } else if (text[1].toLowerCase().equals("reservation")) {
                reservationService.removeReservation(id);
                System.out.println("Reservation successfully removed!");
            } else
                System.out.println("Invalid entity! Choose between: film, client, reservation.");
        }
    }

    private void handleShowAll(String text[]) {
        if (text.length != 2)
            System.out.println("There must be 2 arguments for showall operation!");
        else {
            String entity = text[1].toLowerCase();
            if (entity.equals("film"))
                System.out.println(filmService.getAllFilms());
            else if (entity.equals("client"))
                System.out.println(clientService.getAllClients());
            else if (entity.equals("reservation"))
                System.out.println(reservationService.getAllReservations());
            else
                System.out.println("Invalid entity! Choose between: film, client, reservation.");
        }
    }

}
