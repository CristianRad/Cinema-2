package Service;

import Domain.Client;
import Repository.IRepository;
import Repository.InMemoryRepositoryException;

import java.util.List;

public class ClientService {

    private IRepository<Client> clientRepository;

    /**
     * Instantiates a service for clients.
     * @param clientRepository is the repository used.
     */

    public ClientService(IRepository<Client> clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Adds a client.
     * @param id is the ID of the client to add.
     * @param name is the name of the client to add.
     * @param surname is the surname of the client to add.
     * @param cnp is the CNP of the client to add.
     * @param birthday is the birthday of the client to add.
     * @param registrationDay is the registration day of the client to add.
     * @param points is the total of points on the card of the client to add.
     */

    public void addClient(String id, String name, String surname, String cnp, String birthday, String registrationDay, int points) {
        Client client = new Client(id, name, surname, cnp, birthday, registrationDay, points);
        if (clientRepository.getStorage().containsKey(id))
            throw new InMemoryRepositoryException(String.format("A client with the ID %s already exists!", id));
        clientRepository.insert(client);
    }

    /**
     * Updates a client.
     * @param id is the new ID of the client.
     * @param name is the new name of the client.
     * @param surname is the new surname of the client.
     * @param cnp is the new CNP of the client.
     * @param birthday is the new birthday of the client.
     * @param registrationDay is the new registration day of the client.
     * @param points is the new total of points on the card of the client.
     */

    public void updateClient(String id, String name, String surname, String cnp, String birthday, String registrationDay, int points) {
        Client client = new Client(id, name, surname, cnp, birthday, registrationDay, points);
        if (!clientRepository.getStorage().containsKey(id))
            throw new InMemoryRepositoryException(String.format("There is no client with the ID %s!", id));
        clientRepository.update(client);
    }

    /**
     * Removes a client.
     * @param id is the ID of the client to remove.
     */

    public void removeClient(String id) {
        if (!clientRepository.getStorage().containsKey(id))
            throw new InMemoryRepositoryException(String.format("There is no client with the ID %s!", id));
        clientRepository.remove(id);
    }

    /**
     * @return a list of all clients.
     */

    public List<Client> getAllClients() {
        return clientRepository.getAll();
    }

    public IRepository<Client> getClientRepository() { return clientRepository; }

}
