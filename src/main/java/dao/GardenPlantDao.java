package dao;

import models.Garden;
import models.GardenPlant;

import java.util.List;

/**
 * Created by Guest on 8/30/17.
 */
public interface GardenPlantDao {

    //Create
    void add(GardenPlant gardenPlant);

    //    //Read
    List<Garden> getAll();
    Garden findById(int id);

    //update
    //omit for now

    //delete
    void deleteById(int id);


}
