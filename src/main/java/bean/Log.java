package bean;

public class Log {
    private String id_item;
    private String id_player;
    private String message;
    private String time;

    public Log(String id_item, String id_player, String message, String time) {
        this.id_item = id_item;
        this.id_player = id_player;
        this.message = message;
        this.time = time;
    }

    public String getId_item() {
        return id_item;
    }

    public void setId_item(String id_item) {
        this.id_item = id_item;
    }

    public String getId_player() {
        return id_player;
    }

    public void setId_player(String id_player) {
        this.id_player = id_player;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
