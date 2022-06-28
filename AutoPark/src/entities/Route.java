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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(String endPlace) {
        this.endPlace = endPlace;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Route{");
        sb.append("id=").append(id);
        sb.append(", startPlace='").append(startPlace).append('\'');
        sb.append(", endPlace='").append(endPlace).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (id != route.id) return false;
        if (startPlace != null ? !startPlace.equals(route.startPlace) : route.startPlace != null) return false;
        return endPlace != null ? endPlace.equals(route.endPlace) : route.endPlace == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (startPlace != null ? startPlace.hashCode() : 0);
        result = 31 * result + (endPlace != null ? endPlace.hashCode() : 0);
        return result;
    }
}
