package Domain;

public class Client extends Entity {

    private String id;
    private String name, surname;
    private String cnp;
    private String birthday, registrationDay;
    private int points;

    public Client(String id, String name, String surname, String cnp, String birthday, String registrationDay, int points) {
        super(id);
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.cnp = cnp;
        this.birthday = birthday;
        this.registrationDay = registrationDay;
        this.points = points;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cnp='" + cnp + '\'' +
                ", birthday='" + birthday + '\'' +
                ", registrationDay='" + registrationDay + '\'' +
                ", points=" + points +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRegistrationDay() {
        return registrationDay;
    }

    public void setRegistrationDay(String registrationDay) {
        this.registrationDay = registrationDay;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

}
