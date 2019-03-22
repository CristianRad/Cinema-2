import Domain.*;
import Repository.*;
import Service.ClientService;
import Service.FilmService;
import Service.ReservationService;
import UI.Console;
import UI.NaturalLanguageConsole;

public class Main {

    public static void main(String[] args) {
        IValidator<Film> filmValidator = new FilmValidator();
        IRepository<Film> filmRepository = new InMemoryRepository<>(filmValidator);
        FilmService filmService = new FilmService(filmRepository);

        IValidator<Client> clientValidator = new ClientValidator();
        IRepository<Client> clientRepository = new InMemoryRepository<>(clientValidator);
        ClientService clientService = new ClientService(clientRepository);

        IValidator<Reservation> reservationValidator = new ReservationValidator();
        IRepository<Reservation> reservationRepository = new InMemoryRepository<>(reservationValidator);
        ReservationService reservationService = new ReservationService(reservationRepository, clientRepository, filmRepository);

        Console console = new Console(filmService, clientService, reservationService);
        //NaturalLanguageConsole naturalLanguageConsole = new NaturalLanguageConsole(filmService, clientService, reservationService);

        console.run();
        //naturalLanguageConsole.run();
    }

}
