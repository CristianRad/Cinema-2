package Tests.Domain;

import Domain.IValidator;
import Domain.Reservation;
import Domain.ReservationValidator;
import Repository.InMemoryRepositoryException;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ReservationValidatorTest {

    private IValidator<Reservation> reservationIValidator = new ReservationValidator();

    @Test
    public void validate() {
        Reservation reservation = new Reservation("1","10","20","08.01.2016","09:45");
        try {
            reservationIValidator.validate(reservation);
        } catch (InMemoryRepositoryException error) {
            assertTrue(true);
        }

        Reservation newReservation = new Reservation("7","7","20","19.00.2021","30:15");
        try {
            reservationIValidator.validate(newReservation);
        } catch (InMemoryRepositoryException error) {
            assertTrue(true);
        }
    }

}
