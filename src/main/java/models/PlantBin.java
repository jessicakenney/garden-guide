package models;

import java.util.Date;

public class PlantBin {
  private String plantName;
  private int daysToMaturity;
  private String plantSpacing;
  private String rowSpacing;
  private String image;

  private int gardenPlantId;
  private int plantId;
  private int gardenId;
  private boolean isPlanted;
  private Date datePlanted;


  public PlantBin(String plantName, int daysToMaturity, String plantSpacing, String rowSpacing, String image, int gardenPlantId,int plantId,int gardenId,boolean isPlanted,Date datePlanted) {
    this.plantName = plantName;
    this.daysToMaturity = daysToMaturity;
    this.plantSpacing = plantSpacing;
    this.rowSpacing = rowSpacing;
    this.image = image;

    this.gardenPlantId = gardenPlantId;
    this.plantId = plantId;
    this.gardenId = gardenId;
    this.isPlanted = isPlanted;
    this.datePlanted = datePlanted;
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

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public int getGardenPlantId() {
    return gardenPlantId;
  }

  public void setGardenPlantId(int gardenPlantId) {
    this.gardenPlantId = gardenPlantId;
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

  public boolean getIsPlanted() {
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

    PlantBin plantBin = (PlantBin) o;

    if (daysToMaturity != plantBin.daysToMaturity) return false;
    if (gardenPlantId != plantBin.gardenPlantId) return false;
    if (plantId != plantBin.plantId) return false;
    if (gardenId != plantBin.gardenId) return false;
    if (isPlanted != plantBin.isPlanted) return false;
    if (!plantName.equals(plantBin.plantName)) return false;
    if (plantSpacing != null ? !plantSpacing.equals(plantBin.plantSpacing) : plantBin.plantSpacing != null)
      return false;
    if (rowSpacing != null ? !rowSpacing.equals(plantBin.rowSpacing) : plantBin.rowSpacing != null) return false;
    if (image != null ? !image.equals(plantBin.image) : plantBin.image != null) return false;
    return datePlanted != null ? datePlanted.equals(plantBin.datePlanted) : plantBin.datePlanted == null;
  }

  @Override
  public int hashCode() {
    int result = plantName.hashCode();
    result = 31 * result + daysToMaturity;
    result = 31 * result + (plantSpacing != null ? plantSpacing.hashCode() : 0);
    result = 31 * result + (rowSpacing != null ? rowSpacing.hashCode() : 0);
    result = 31 * result + (image != null ? image.hashCode() : 0);
    result = 31 * result + gardenPlantId;
    result = 31 * result + plantId;
    result = 31 * result + gardenId;
    result = 31 * result + (isPlanted ? 1 : 0);
    result = 31 * result + (datePlanted != null ? datePlanted.hashCode() : 0);
    return result;
  }
}

