package dao;

import models.Plant;

import java.util.List;

/**
 * Created by Guest on 8/28/17.
 */
public interface PlantDao {

    //Create
     void add(Plant plant);
    //Join to event table?


     //Read
     List<Plant> getAll();
     Plant getByPlantName(String plantName);
     Plant findById(int id);

    //update
    //omit for now

    //delete
    void deleteById(int id);

}
