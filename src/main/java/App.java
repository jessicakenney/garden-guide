import com.google.gson.Gson;
import dao.Sql2oPlantDao;
import models.Plant;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static spark.Spark.*;

public class App {

  public static void main(String[] args) {


    //----------DataBase SetUp----------//

    Sql2oPlantDao plantDao;
    Connection conn;
    Gson gson = new Gson();

    //String connectionString = "jdbc:h2:~/recipe-box.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
    String connectionString = ("jdbc:postgresql://localhost:5432/garden_guide");

    Sql2o sql2o = new Sql2o(connectionString, null, null);
    plantDao = new Sql2oPlantDao(sql2o);
    conn = sql2o.open();

    //----------Plant API EndPoints----------//

    // only admin: Endpoint to Enter Plant JSON file
    post("/gardenguideapi/plants/new", "application/json", (req, res) -> {
      Plant[] plantList = gson.fromJson(req.body(), Plant[].class);
      for (Plant plant: plantList) {
        plantDao.add(plant);
      }
      res.status(201);

      return gson.toJson(plantList);
    });

    // Get All Recipe cards
    get("/gardenguideapi/plants", "application/json", (req, res) -> {
      return gson.toJson(plantDao.getAll());
    });



  }
}
