package Domain;

public class Reservation extends Entity {

    private String idFilm;
    private String idCardClient;
    private String date;
    private String time;

    public Reservation(String id, String idFilm, String idCardClient, String date, String time) {
        super(id);
        this.idFilm = idFilm;
        this.idCardClient = idCardClient;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Rezervare{" +
                "id='" + id + '\'' +
                ", idFilm='" + idFilm + '\'' +
                ", idCardClient='" + idCardClient + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getId() { return id; }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(String idFilm) {
        this.idFilm = idFilm;
    }

    public String getIdCardClient() {
        return idCardClient;
    }

    public void setIdCardClient(String idCardClient) {
        this.idCardClient = idCardClient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}