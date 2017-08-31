package dao;

import models.Garden;
import models.Plant;

import java.util.List;

/**
 * Created by Guest on 8/30/17.
 */
public interface GardenDao {

    //Create
    void add(Garden garden);

    //    //Read
    List<Garden> getAll();
    Garden findById(int id);

    //update
    //omit for now

    //delete
    void deleteById(int id);
}
