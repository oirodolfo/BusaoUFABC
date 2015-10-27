package xyz.oirodolfo.busaoufabc.domain;

/**
 * Created by Rod on 26/10/2015.
 */
public class Route {
    private int id;
    private int line;
    private String time;
    private int place_id;
    Place place;

    public Route() {}

    public Route(int id, int line, String time, int place_id, Place place) {
        this.id = id;
        this.line = line;
        this.time = time;
        this.place_id = place_id;
        this.place = place;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
