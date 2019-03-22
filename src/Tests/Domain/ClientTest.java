package Tests.Domain;

import Domain.Client;
import Domain.ClientValidator;
import Domain.IValidator;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.ClientService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClientTest {

    private IValidator<Client> clientValidator = new ClientValidator();
    private IRepository<Client> clientRepository = new InMemoryRepository<>(clientValidator);
    private ClientService clientService = new ClientService(clientRepository);

    @Test
    public void setNameSurnameCNPBirthdayRegistrationDayPoints() {
        clientService.addClient("10","Daniela","Dan","2920417124936","17.04.1992","21.03.2010",30);

        clientService.getAllClients().get(0).setName("Teodora");
        assertEquals("Teodora", clientService.getAllClients().get(0).getName());

        clientService.getAllClients().get(0).setSurname("Prodan");
        assertEquals("Prodan", clientService.getAllClients().get(0).getSurname());

        clientService.getAllClients().get(0).setCnp("2940505124935");
        assertEquals("2940505124935", clientService.getAllClients().get(0).getCnp());

        clientService.getAllClients().get(0).setBirthday("05.05.1994");
        assertEquals("05.05.1994", clientService.getAllClients().get(0).getBirthday());

        clientService.getAllClients().get(0).setRegistrationDay("10.10.2015");
        assertEquals("10.10.2015", clientService.getAllClients().get(0).getRegistrationDay());

        clientService.getAllClients().get(0).setPoints(70);
        assertEquals(70, clientService.getAllClients().get(0).getPoints());
    }

}
