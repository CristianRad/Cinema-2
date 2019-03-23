package Tests.Service;

import Domain.*;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.ReservationService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReservationServiceTest {

    private IValidator<Film> filmValidator = new FilmValidator();
    private IValidator<Client> clientValidator = new ClientValidator();
    private IValidator<Reservation> reservationValidator = new ReservationValidator();

    private IRepository<Film> filmRepository = new InMemoryRepository<>(filmValidator);
    private IRepository<Client> clientRepository = new InMemoryRepository<>(clientValidator);
    private IRepository<Reservation> reservationRepository = new InMemoryRepository<>(reservationValidator);

    private ReservationService reservationService = new ReservationService(reservationRepository, clientRepository, filmRepository);

    private Film film = new Film("1","Cars",2008,14.0,true);
    private Film sameFilm = new Film("1","Cars",2008,14.0,true);
    private Client client = new Client("1","Robert","Bura","1910909126212","09.09.1991","14.10.2013",43);

    @Test
    public void add() {
        filmRepository.insert(film);
        clientRepository.insert(client);
        reservationService.addReservation("1","1","1","22.12.2017","19:45");

        assertEquals(1, reservationService.getAllReservations().size());
    }

    @Test
    public void update() {
        filmRepository.insert(film);
        clientRepository.insert(client);
        reservationService.addReservation("1","1","1","22.12.2017","19:45");
        reservationService.updateReservation("1","1","1","22.12.2017","21:00");

        assertEquals("21:00", reservationService.getAllReservations().get(0).getTime());
    }

    @Test
    public void remove() {
        filmRepository.insert(film);
        clientRepository.insert(client);
        reservationService.addReservation("1","1","1","22.12.2017","19:45");
        reservationService.removeReservation("1");

        assertEquals(0, reservationService.getAllReservations().size());
    }

    @Test
    public void getAll() {
        filmRepository.insert(film);
        clientRepository.insert(client);
        reservationService.addReservation("1","1","1","07.12.2017","17:00");

        assertEquals(1, reservationService.getAllReservations().size());
    }

    @Test
    public void fullTextSearch() {
        filmRepository.insert(film);
        clientRepository.insert(client);
        reservationService.addReservation("1","1","1","22.12.2017","19:45");
        String text = "19";

        assertEquals(1, reservationService.fullTextSearch(text).size());
    }

}
