package models;

import java.util.Date;


public class Plant {
    private int id;
    private String plantName;
    private int daysToMaturity;
    private String plantSpacing;
    private String rowSpacing;

    public Plant(String plantName, int daysToMaturity,String plantSpacing, String rowSpacing) {
       this.plantName = plantName;
       this.daysToMaturity = daysToMaturity;
       this.plantSpacing = plantSpacing;
       this.rowSpacing = rowSpacing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public int getDaysToMaturity() {
        return daysToMaturity;
    }

    public void setDaysToMaturity(int daysToMaturity) {
        this.daysToMaturity = daysToMaturity;
    }

    public String getPlantSpacing() {
        return plantSpacing;
    }

    public void setPlantSpacing(String plantSpacing) {
        this.plantSpacing = plantSpacing;
    }

    public String getRowSpacing() {
        return rowSpacing;
    }

    public void setRowSpacing(String rowSpacing) {
        this.rowSpacing = rowSpacing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plant plant = (Plant) o;

        if (id != plant.id) return false;
        if (daysToMaturity != plant.daysToMaturity) return false;
        if (!plantName.equals(plant.plantName)) return false;
        if (plantSpacing != null ? !plantSpacing.equals(plant.plantSpacing) : plant.plantSpacing != null) return false;
        return rowSpacing != null ? rowSpacing.equals(plant.rowSpacing) : plant.rowSpacing == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + plantName.hashCode();
        result = 31 * result + daysToMaturity;
        result = 31 * result + (plantSpacing != null ? plantSpacing.hashCode() : 0);
        result = 31 * result + (rowSpacing != null ? rowSpacing.hashCode() : 0);
        return result;
    }
}
