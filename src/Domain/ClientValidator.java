package Domain;

import Repository.InMemoryRepositoryException;

import java.util.Calendar;

public class ClientValidator implements IValidator<Client> {

    /** Validates a reservation.
     * @param client the client to validate.
     * @throws InMemoryRepositoryException if there are validation errors.
     */

    public void validate(Client client) {
        String errors = "";

        int dayOfBirth = Integer.parseInt(client.getBirthday().substring(0, 2));
        int monthOfBirth = Integer.parseInt(client.getBirthday().substring(3, 5));
        int yearOfBirth = Integer.parseInt(client.getBirthday().substring(6, 10));

        int dayOfRegistration = Integer.parseInt(client.getRegistrationDay().substring(0, 2));
        int monthOfRegistration = Integer.parseInt(client.getRegistrationDay().substring(3, 5));
        int yearOfRegistration = Integer.parseInt(client.getRegistrationDay().substring(6, 10));

        if (client.getCnp().length() != 13)
            throw new InMemoryRepositoryException("The CNP must have exactly 13 digits!\n");

        if (client.getBirthday().charAt(2) != '.' || client.getBirthday().charAt(5) != '.')
            errors += "The date of birth format must be dd.mm.yyyy!\n";

        if (dayOfBirth < 1 || dayOfBirth > 31)
            errors += "The day of birth must be between 1 and 31!\n";
        if (monthOfBirth < 1 || monthOfBirth > 12)
            errors += "The month of birth must be between 1 and 12!\n";
        if (yearOfBirth < 1920 || yearOfBirth > Calendar.getInstance().get(Calendar.YEAR))
            errors += "The year of birth must be between 1920 and " + Calendar.getInstance().get(Calendar.YEAR) + "!\n";

        if (client.getRegistrationDay().charAt(2) != '.' || client.getRegistrationDay().charAt(5) != '.')
            errors += "The day of registration format must be dd.mm.yyyy!\n";

        if (dayOfRegistration < 1 || dayOfRegistration >31)
            errors += "The day of registration must be between 1 and 31!\n";
        if (monthOfRegistration < 1 || monthOfRegistration > 12)
            errors += "The month of registration must be between 1 and 12!\n";
        if (yearOfRegistration < 1940 || yearOfRegistration > Calendar.getInstance().get(Calendar.YEAR))
            errors += "The year of registration must be between 1940 and " + Calendar.getInstance().get(Calendar.YEAR) + "!\n";

        if (client.getPoints() < 0)
            errors += "Bonus points cannot be a negative value!\n";

        if (!errors.isEmpty())
            throw new InMemoryRepositoryException("\n" + errors);
    }

}
