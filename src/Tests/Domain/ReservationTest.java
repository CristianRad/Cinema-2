package Tests.Domain;

import Domain.*;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.ReservationService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReservationTest {

    private IValidator<Film> filmValidator = new FilmValidator();
    private IValidator<Client> clientValidator = new ClientValidator();
    private IValidator<Reservation> reservationValidator = new ReservationValidator();

    private IRepository<Film> filmRepository = new InMemoryRepository<>(filmValidator);
    private IRepository<Client> clientRepository = new InMemoryRepository<>(clientValidator);
    private IRepository<Reservation> reservationRepository = new InMemoryRepository<>(reservationValidator);

    private ReservationService reservationService = new ReservationService(reservationRepository, clientRepository, filmRepository);

    private Film newFilm = new Film("5","American Pie",2001,50.0,true);
    private Client newClient = new Client("20","Doru","Bogdan","1880201124935","01.02.1988","18.04.2011",44);

    @Test
    public void getIdFilm() {
        filmRepository.insert(newFilm);
        clientRepository.insert(newClient);
        reservationService.addReservation("10","5","20","11.11.2018","16:45");

        assertEquals("5", reservationService.getAllReservations().get(0).getIdFilm());
    }

    public void setIdFilmIdClientDateTime() {
        filmRepository.insert(newFilm);
        clientRepository.insert(newClient);
        reservationService.addReservation("10","5","20","11.11.2018","16:45");

        reservationService.getAllReservations().get(0).setIdFilm("1");
        assertEquals("1", reservationService.getAllReservations().get(0).getIdFilm());

        reservationService.getAllReservations().get(0).setIdCardClient("1");
        assertEquals("1", reservationService.getAllReservations().get(0).getIdCardClient());

        reservationService.getAllReservations().get(0).setDate("01.01.2019");
        assertEquals("01.01.2019", reservationService.getAllReservations().get(0).getDate());

        reservationService.getAllReservations().get(0).setTime("18:00");
        assertEquals("18:00", reservationService.getAllReservations().get(0).getTime());
    }

}
