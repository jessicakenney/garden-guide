package dao;

import models.Garden;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

/**
 * Created by Guest on 8/30/17.
 */
public class Sql2oGardenDao implements GardenDao{
        private final Sql2o sql2o;

        public Sql2oGardenDao(Sql2o sql2o)  {
            this.sql2o = sql2o;
        }


        // Create
        @Override
        public void add(Garden garden) {
            String sql = "INSERT INTO gardens (userName,gardenName) VALUES (:userName,:gardenName)";
            try (Connection con = sql2o.open()) {
                int id = (int) con.createQuery(sql,true)
                        .bind(garden)
                        .executeUpdate()
                        .getKey();
                garden.setId(id);
            } catch (Sql2oException ex) {
                System.out.println(ex);
            }
        }

        // Read
        @Override
        public List<Garden> getAll() {
            String sql = "SELECT * FROM gardens ";
            try (Connection con = sql2o.open()) {
                return con.createQuery(sql)
                        .executeAndFetch(Garden.class);
            }
        }

        @Override
        public Garden findById(int id) {
            String sql = "SELECT * FROM gardens WHERE id = :id";
            try (Connection con = sql2o.open()) {
                return con.createQuery(sql)
                        .addParameter("id", id)
                        .executeAndFetchFirst(Garden.class);
            }
        }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from gardens WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

}
