package models;

import java.util.Date;

/**
 * Created by Guest on 8/30/17.
 */
public class GardenPlant extends Plant {
    private String plantName;
    private int daysToMaturity;
    private String plantSpacing;
    private String rowSpacing;
    private String image;

    private int id;
    private int plantId;
    private int gardenId;
    private boolean isPlanted;
    private Date datePlanted;
    //user to be able to add their own images of plant
    //private String image;

    public GardenPlant(String plantName,int daysToMaturity,String plantSpacing,String rowSpacing,String image,int plantId,int gardenId) {
        super (plantName,daysToMaturity,plantSpacing,rowSpacing,image);
        this.plantId = plantId;
        this.gardenId = gardenId;
        this.isPlanted = false;
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

    public boolean isPlanted() {
        return isPlanted;
    }

    public void setPlanted(boolean planted) {
        isPlanted = planted;
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
        if (isPlanted != that.isPlanted) return false;
        return datePlanted != null ? datePlanted.equals(that.datePlanted) : that.datePlanted == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + plantId;
        result = 31 * result + gardenId;
        result = 31 * result + (isPlanted ? 1 : 0);
        result = 31 * result + (datePlanted != null ? datePlanted.hashCode() : 0);
        return result;
    }
}
