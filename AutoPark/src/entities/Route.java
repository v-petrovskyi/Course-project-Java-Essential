package entities;

public class Route {
    private int id;
    private String startPlace;
    private String endPlace;

    public Route(int id, String startPlace, String endPlace) {
        this.id = id;
        this.startPlace = startPlace;
        this.endPlace = endPlace;
    }

}
