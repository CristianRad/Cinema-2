package Service;

import Domain.Film;
import Repository.IRepository;
import Repository.InMemoryRepositoryException;

import java.util.List;

public class FilmService {

    private IRepository<Film> filmRepository;

    /**
     * Instantiates a service for films.
     * @param filmRepository is the repository used.
     */

    public FilmService(IRepository<Film> filmRepository) {
        this.filmRepository = filmRepository;
    }

    /**
     * Adds a film.
     * @param id is the ID of the film to add.
     * @param title is the title of the film to add.
     * @param year is the release year of the film to add.
     * @param ticketPrice is the price of the tickets for the film to add.
     * @param onScreen indicates whether the film to add is scheduled to run or not.
     */

    public void addFilm(String id, String title, int year, double ticketPrice, boolean onScreen) {
        Film film = new Film(id, title, year, ticketPrice, onScreen);
        if (filmRepository.getStorage().containsKey(id))
            throw new InMemoryRepositoryException(String.format("A film with the ID %s already exists!", id));
        filmRepository.insert(film);
    }

    /**
     * Updates a film.
     * @param id is the new ID of the film.
     * @param title is the new title of the film.
     * @param year is the new release year of the film.
     * @param ticketPrice is the new price of the tickets for the film.
     * @param onScreen indicates whether the film is scheduled to run or not.
     */

    public void updateFilm(String id, String title, int year, double ticketPrice, boolean onScreen) {
        Film film = new Film(id, title, year, ticketPrice, onScreen);
        if (!filmRepository.getStorage().containsKey(id))
            throw new InMemoryRepositoryException(String.format("There is no film with the ID %s!", id));
        filmRepository.update(film);
    }

    /**
     * Removes a film.
     * @param id is the ID of the film to remove.
     */

    public void removeFilm(String id) {
        if (!filmRepository.getStorage().containsKey(id))
            throw new InMemoryRepositoryException(String.format("There is no film with the ID %s!", id));
        filmRepository.remove(id);
    }

    /**
     * @return a list of all films.
     */

    public List<Film> getAllFilms() {
        return filmRepository.getAll();
    }

    public IRepository<Film> getFilmRepository() { return filmRepository; }

}
