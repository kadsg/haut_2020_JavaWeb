package bean;

public class EventVolunteer {
    private String id_item;
    private String id_volunteer;

    public EventVolunteer(String id_item, String id_volunteer) {
        this.id_item = id_item;
        this.id_volunteer = id_volunteer;
    }

    public String getId_item() {
        return id_item;
    }

    public void setId_item(String id_item) {
        this.id_item = id_item;
    }

    public String getId_volunteer() {
        return id_volunteer;
    }

    public void setId_volunteer(String id_volunteer) {
        this.id_volunteer = id_volunteer;
    }
}
