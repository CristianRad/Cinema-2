package Domain;

import Repository.InMemoryRepositoryException;

import java.util.Calendar;

public class ReservationValidator implements IValidator<Reservation> {

    /** Validates a reservation.
     * @param reservation is the reservation to validate.
     * @throws InMemoryRepositoryException if there are validation errors.
     */

    public void validate(Reservation reservation) {
        if (reservation.getDate().length() != 10 || reservation.getTime().length() != 5 ||
            reservation.getDate().charAt(2) != '.' || reservation.getDate().charAt(5) != '.' ||
            reservation.getTime().charAt(2) != ':')
                throw new InMemoryRepositoryException("Invalid format! Date should be dd.mm.yyyy and Time should be hh:mm.");

        String errors = "";
        int day = Integer.parseInt(reservation.getDate().substring(0, 2));
        int month = Integer.parseInt(reservation.getDate().substring(3, 5));
        int year = Integer.parseInt(reservation.getDate().substring(6, 10));
        int hour = Integer.parseInt(reservation.getTime().substring(0, 2));
        int minutes = Integer.parseInt(reservation.getTime().substring(3, 5));

        if (day < 1 || day > 31)
            errors += "The day of reservation must be between 1 and 31!\n";
        if (month < 1 || month > 12)
            errors += "The month of reservation must be between 1 and 12!\n";
        if (year < 1920 || year > Calendar.getInstance().get(Calendar.YEAR))
            errors += "The year of reservation must be between 1920 and " + Calendar.getInstance().get(Calendar.YEAR) + "!\n";
        if (hour < 0 || hour > 23)
            errors += "The hour of reservation must be between 0 and 23!\n";
        if (minutes < 0 || minutes > 59)
            errors += "The number of minutes must be between 0 and 59!\n";
        if (!errors.isEmpty())
            throw new InMemoryRepositoryException("\n" + errors);
    }

}
