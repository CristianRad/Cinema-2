package Tests.Service;

import Domain.Client;
import Domain.ClientValidator;
import Domain.IValidator;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.ClientService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClientServiceTest {

    private IValidator<Client> clientValidator = new ClientValidator();
    private IRepository<Client> clientRepository = new InMemoryRepository<>(clientValidator);
    private ClientService clientService = new ClientService(clientRepository);

    @Test
    public void add() {
        clientService.addClient("1","Robert","Bura","1910909126212","09.09.1991","14.10.2013",43);
        assertEquals(1, clientService.getAllClients().size());
    }

    @Test
    public void update() {
        clientService.addClient("1","Robert","Bura","1910909126212","09.09.1991","14.10.2013",43);
        clientService.updateClient("1","Robert","Bura","1910909126212","09.09.1991","10.04.2018",43);

        assertEquals("10.04.2018", clientService.getAllClients().get(0).getRegistrationDay());
    }

    @Test
    public void remove() {
        clientService.addClient("1","Robert","Bura","1910909126212","09.09.1991","14.10.2013",43);
        clientService.removeClient("1");

        assertEquals(0, clientService.getAllClients().size());
    }

    @Test
    public void getAll() {
        clientService.addClient("1","Robert","Bura","1910909126212","09.09.1991","14.10.2013",43);
        assertEquals(1, clientService.getAllClients().size());
    }

}
