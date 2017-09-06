package models;

import java.util.Date;

/**
 * Created by Guest on 8/30/17.
 */
public class GardenPlant {
    private int id;
    private int plantId;
    private int gardenId;
    private String isPlanted;
    private Date datePlanted;
    //user to be able to add their own images of plant
    //private String image;

    public GardenPlant(int plantId,int gardenId) {
        this.plantId = plantId;
        this.gardenId = gardenId;
        this.isPlanted = "false";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public int getGardenId() {
        return gardenId;
    }

    public void setGardenId(int gardenId) {
        this.gardenId = gardenId;
    }

    public String getIsPlanted() {
        return isPlanted;
    }

    public void setIsPlanted(String isPlanted) {
        this.isPlanted = isPlanted;
    }

    public Date getDatePlanted() {
        return datePlanted;
    }

    public void setDatePlanted(Date datePlanted) {
        this.datePlanted = datePlanted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GardenPlant that = (GardenPlant) o;

        if (id != that.id) return false;
        if (plantId != that.plantId) return false;
        if (gardenId != that.gardenId) return false;
        if (!isPlanted.equals(that.isPlanted)) return false;
        return datePlanted != null ? datePlanted.equals(that.datePlanted) : that.datePlanted == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + plantId;
        result = 31 * result + gardenId;
        result = 31 * result + isPlanted.hashCode();
        result = 31 * result + (datePlanted != null ? datePlanted.hashCode() : 0);
        return result;
    }
}
