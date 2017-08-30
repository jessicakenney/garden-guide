package models;

import java.util.Date;

/**
 * Created by Guest on 8/30/17.
 */
public class GardenPlant extends Plant {
    private int id;
    private boolean isPlanted;
    private Date datePlanted;
    private int gardenId;
    //user to be able to add their own images of plant
    //private String image;

    public GardenPlant(String plantName, int daysToMaturity, String plantSpacing, String rowSpacing) {
        super(plantName,daysToMaturity,plantSpacing,rowSpacing);
        this.isPlanted = false;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGardenId() {
        return gardenId;
    }

    public void setGardenId(int gardenId) {
        this.gardenId = gardenId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GardenPlant that = (GardenPlant) o;

        if (id != that.id) return false;
        if (isPlanted != that.isPlanted) return false;
        if (gardenId != that.gardenId) return false;
        return datePlanted != null ? datePlanted.equals(that.datePlanted) : that.datePlanted == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id;
        result = 31 * result + (isPlanted ? 1 : 0);
        result = 31 * result + (datePlanted != null ? datePlanted.hashCode() : 0);
        result = 31 * result + gardenId;
        return result;
    }
}
