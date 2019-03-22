package Domain;

import Repository.InMemoryRepositoryException;

import java.util.Calendar;

public class FilmValidator implements IValidator<Film> {

    /** Validates a film.
     * @param film the reservation to validate.
     * @throws InMemoryRepositoryException if there are validation errors.
     */

    public void validate (Film film) {
        String errors = "";

        if (film.getTicketPrice() <= 0)
            errors += "Ticket price must be greater than 0!\n";
        if (film.getYear() < 1920 || film.getYear() > Calendar.getInstance().get(Calendar.YEAR))
            errors += "The year is not valid!\n";
        if (!errors.isEmpty())
            throw new InMemoryRepositoryException("\n" + errors);
    }

}
