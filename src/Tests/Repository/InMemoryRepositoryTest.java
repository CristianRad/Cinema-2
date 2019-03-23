package Tests.Repository;

import Domain.*;
import Repository.IRepository;
import Repository.InMemoryRepository;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class InMemoryRepositoryTest {

    private IValidator<Film> filmValidator = new FilmValidator();
    private IValidator<Client> clientValidator = new ClientValidator();
    private IValidator<Reservation> reservationValidator = new ReservationValidator();

    private IRepository<Film> filmRepository = new InMemoryRepository<>(filmValidator);
    private IRepository<Client> clientRepository = new InMemoryRepository<>(clientValidator);
    private IRepository<Reservation> reservationRepository = new InMemoryRepository<>(reservationValidator);

    private Film film = new Film("1","Heroes",1995,60.0,true);

    private Client client = new Client("10","Vlad","Rus","1234567891001","22.07.2000","14.01.2017",55);
    private Client newClient = new Client("10","Alin","Pop","1900712124938","12.07.1990","17.03.2014",80);

    private Reservation reservation = new Reservation("1","1","10","12.10.2012","15:00");

    @Test
    public void findFilmById() {
        filmRepository.insert(film);
        reservationRepository.insert(reservation);

        assertEquals(film, filmRepository.findById(reservation.getIdFilm()));
    }

    @Test
    public void insert() {
        filmRepository.insert(film);
        List<Film> allFilms = filmRepository.getAll();

        clientRepository.insert(client);
        List<Client> allClients = clientRepository.getAll();

        reservationRepository.insert(reservation);
        List<Reservation> allReservations = reservationRepository.getAll();

        assertEquals(1, allFilms.size());
        assertEquals(film, allFilms.get(0));

        assertEquals(1, allClients.size());
        assertEquals(client, allClients.get(0));

        assertEquals(1, allReservations.size());
        assertEquals(reservation, allReservations.get(0));
    }

    @Test
    public void update() {
        clientRepository.insert(client);
        clientRepository.update(newClient);
        List<Client> allClients = clientRepository.getAll();

        assertEquals(newClient, allClients.get(0));
        assertEquals(newClient, clientRepository.findById("10"));
    }

    @Test
    public void remove() {
        clientRepository.insert(client);
        clientRepository.remove("10");
        assertEquals(0, clientRepository.getAll().size());
    }

    @Test
    public void getAll() {
        filmRepository.insert(film);
        assertEquals(1, filmRepository.getAll().size());
    }

}
