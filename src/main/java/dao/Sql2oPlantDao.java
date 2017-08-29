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


    @Override
    public void add(Plant plant) {
        String sql = "INSERT INTO plants (plantName,daysToMaturity,plantSpacing,rowSpacing) VALUES (:plantName,:daysToMaturity,:plantSpacing,:rowSpacing)";
        try (Connection con = DB.sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(plant)
                    .executeUpdate()
                    .getKey();
            plant.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Plant> getAll() {
        String sql = "SELECT * FROM plants ";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Plant.class);
        }
    }

    @Override
    public Plant findById(int id) {
        String sql = "SELECT * FROM plants WHERE id = :id";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Plant.class);
        }
    }

}
