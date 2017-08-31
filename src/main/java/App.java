import com.google.gson.Gson;
import dao.Sql2oGardenDao;
import dao.Sql2oGardenPlantDao;
import dao.Sql2oPlantDao;
import models.Event;
import models.Garden;
import models.GardenPlant;
import models.Plant;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");
        Sql2oPlantDao plantDao;
        Sql2oGardenDao gardenDao;
        Sql2oGardenPlantDao gardenPlantDao;
        Connection conn;
        Gson gson = new Gson();

        //Golden Plant DB
        //String connectionString = "jdbc:h2:~/plant.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        String connectionString = ("jdbc:postgresql://localhost:5432/garden_guide");

        // Need seperate dB for user Garden
        String gardenConnectionString = "jdbc:h2:~/user-garden.db;INIT=RUNSCRIPT from 'classpath:db/garden.sql'";

        Sql2o sql2o = new Sql2o(connectionString, null, null);
        plantDao = new Sql2oPlantDao(sql2o);
        conn = sql2o.open();

        Sql2o gardenSql2o = new Sql2o(gardenConnectionString, null, null);
        gardenDao = new Sql2oGardenDao(gardenSql2o);
        gardenPlantDao = new Sql2oGardenPlantDao(gardenSql2o);

        //----------     API EndPoints     ----------//

        // Admin API:
        // Endpoints to Enter JSON files for plants and events
        post("/gardenguideapi/plants/new", "application/json", (req, res) -> {
          Plant[] plantList = gson.fromJson(req.body(), Plant[].class);
          for (Plant plant: plantList) {
            plantDao.add(plant);
          }
          res.status(201);

          return gson.toJson(plantList);
        });

        // Public API:
        // Get All Plants in database
        get("/gardenguideapi/plants", "application/json", (req, res) -> {
          return gson.toJson(plantDao.getAll());
        });

        // Get Plant Data by name of plant
        get("/gardenguideapi/plants/:plantName", "application/json", (req, res) -> {
            String plantName = req.params("plantName");
            return gson.toJson(plantDao.getByPlantName(plantName));
        });


        //----------     UserInterface     ----------//

        // show home page (root route)
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Plant> plants = plantDao.getAll();
            model.put("plants", plants);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show about page
        get("/about", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "about.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show sales page
        get("/sales", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "sales.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show careers page
        get("/careers", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "careers.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show API Information page
        get("/api_documentation", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "endpoints.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show conversion page
        get("/conversions", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "conversions.hbs");
        }, new HandlebarsTemplateEngine());



        //get: show plant detail page
        get("/plants/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPlantToFind = Integer.parseInt(req.params("id"));
            Plant plants = plantDao.findById(idOfPlantToFind);
            List<Garden> gardens = gardenDao.getAll();
            model.put("gardens", gardens);
            model.put("plants", plants);
            return new ModelAndView(model, "plantDetail.hbs");
        }, new HandlebarsTemplateEngine());

        //--------------- Garden Routes --------------------//

        //get: show new Garden form
        get("/gardens/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "garden-form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process a form to Add a Garden
        post("/gardens/new", (request,response) -> {
            Map<String, Object> model = new HashMap<>();
            String userName = request.queryParams("userName");
            String gardenName = request.queryParams("gardenName");
            Garden newGarden = new Garden(userName,gardenName);
            gardenDao.add(newGarden);
            model.put("garden", newGarden);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //Get: garden index show all gardens
        //need to add $userid here  and make a getAll($userid)
        get ("/gardens", (req, resp) -> {
            Map<String, Object> model = new HashMap<>();
            List<Garden> gardens = gardenDao.getAll();
            model.put("gardens", gardens);
            return new ModelAndView(model, "garden-index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show Garden detail page: (all plants in the garden)
        get("/gardens/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfGarden = Integer.parseInt(req.params("id"));
            Garden garden = gardenDao.findById(idOfGarden);
            // need to get plantid from  gardenPlant using garden id
            List<GardenPlant> gardenPlants = gardenPlantDao.getAllByGardenId(idOfGarden);
            List<Plant> plants = new ArrayList<>();
            //then for each plantId in gardenplants get all those plants findById
            //do i want to use a hashmap here to render in details to combine plant/gardenPlant info
            for (GardenPlant gardenPlant : gardenPlants){
                int plantId = gardenPlant.getPlantId();
                Plant plant = plantDao.findById(plantId);
                plants.add(plant);
            }
            model.put("garden", garden);
            model.put("gardenPlants", gardenPlants);
            model.put("plants", plants);
            return new ModelAndView(model, "garden-detail.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process a form to Add a Plant to A Garden
        post("/plants/:id", (request,response) -> {
            Map<String, Object> model = new HashMap<>();
            String gardenId = request.queryParams("gardenId");
            String plantId = request.queryParams("plantId");
            //add plant to Garden
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());


        // get: a form to Add plant to garden
        //this needs to live in plant detail
        //do this after merge with Rich's handlebars

        //--------------- Garden Routes End --------------------//

    }

}


