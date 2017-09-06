package dao;

import models.Garden;
import models.GardenPlant;

import java.util.Date;
import java.util.List;

/**
 * Created by Guest on 8/30/17.
 */
public interface GardenPlantDao {

    //Create
    void add(GardenPlant gardenPlant);

    //Read
    List<GardenPlant> getAll();
    GardenPlant findById(int id);
    List<GardenPlant> getAllPlantsByGardenId(int gardenId);

    //update
    void updatePlanting(int id, String isPlanted, Date datePlanted);

    //delete
    void deleteById(int id);


}
