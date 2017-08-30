package dao;

import models.Garden;
import models.GardenPlant;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

/**
 * Created by Guest on 8/30/17.
 */
public class Sql2oGardenPlantDao {
    private final Sql2o sql2o;

    public Sql2oGardenPlantDao(Sql2o sql2o)  {
        this.sql2o = sql2o;
    }


    // Create
    @Override
    public void add(GardenPlant gardenPlant) {
        String sql = "INSERT INTO gardenplants (isPlanted,datePlanted,gardenId) VALUES (:isPlanted,:datePlanted,:gardenId)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql,true)
                    .bind(gardenPlant)
                    .executeUpdate()
                    .getKey();
            gardenPlant.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    // Read
    @Override
    public List<GardenPlant> getAll() {
        String sql = "SELECT * FROM gardenplants ";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(GardenPlant.class);
        }
    }

    @Override
    public GardenPlant findById(int id) {
        String sql = "SELECT * FROM gardenplants WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(GardenPlant.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from gardenplants WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

}
