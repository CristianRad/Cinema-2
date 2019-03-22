package Tests.Domain;

import Domain.Client;
import Domain.ClientValidator;
import Domain.IValidator;
import Repository.InMemoryRepositoryException;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ClientValidatorTest {

    private IValidator<Client> clientIValidator = new ClientValidator();

    @Test
    public void validate() {
        Client client = new Client("17","Bogdan","Hadarean","1901210124936","10.12.1990","31.13.2014",-45);
        try {
            clientIValidator.validate(client);
        } catch (InMemoryRepositoryException error) {
            assertTrue(true);
        }
    }

}
