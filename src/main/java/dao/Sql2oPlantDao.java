package dao;

/**
 * Created by Guest on 8/28/17.
 */

import models.DB;
import org.sql2o.Sql2o;

        import models.Plant;
        import org.sql2o.Connection;
        import org.sql2o.Sql2o;
        import org.sql2o.Sql2oException;

        import java.util.ArrayList;
        import java.util.List;

public class Sql2oPlantDao implements PlantDao {
    private final Sql2o sql2o;

    public Sql2oPlantDao(Sql2o sql2o)  {
        this.sql2o = sql2o;
    }


    // Create
    @Override
    public void add(Plant plant) {
        String sql = "INSERT INTO plants (plantName,daysToMaturity,plantSpacing,rowSpacing,image) VALUES (:plantName,:daysToMaturity,:plantSpacing,:rowSpacing,:image)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql,true)
                    .bind(plant)
                    .executeUpdate()
                    .getKey();
            plant.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    // Read
    @Override
    public List<Plant> getAll() {
        String sql = "SELECT * FROM plants ";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Plant.class);
        }
    }

    @Override
    public Plant findById(int id) {
        String sql = "SELECT * FROM plants WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Plant.class);
        }
    }

    @Override
    public Plant getByPlantName(String plantName) {
        String sql = "SELECT * FROM plants WHERE plantName = :plantName";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("plantName", plantName)
                    .executeAndFetchFirst(Plant.class);
        }
    }

    //Update

    //Delete
    @Override
    //will want to delete from all joined tables
    public void deleteById(int id) {
        String sql = "DELETE from plants WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

}
