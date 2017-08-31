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

    //    //Read
    List<GardenPlant> getAll();
    GardenPlant findById(int id);

    //update
    void update(int id, int plantId, int gardenId, Boolean isPlanted, Date datePlanted);

    //delete
    void deleteById(int id);


}
