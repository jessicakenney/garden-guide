package models;

/**
 * Created by Guest on 8/28/17.
 */
public class Event {
    private int id;
    private String startDate;
    private String endDate;
    private String type;
    private int plantId;

    public Event(String startDate,String endDate, String type, int plantId){
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.plantId = plantId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != event.id) return false;
        if (plantId != event.plantId) return false;
        if (!startDate.equals(event.startDate)) return false;
        if (!endDate.equals(event.endDate)) return false;
        return type.equals(event.type);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + plantId;
        return result;
    }
}
