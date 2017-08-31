import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.Sql2oEventDao;
import dao.Sql2oPlantDao;
import models.Event;
import models.Plant;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

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
        Sql2oEventDao eventDao;
        Connection conn;
        Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();

        //String connectionString = "jdbc:h2:~/recipe-box.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        String connectionString = ("jdbc:postgresql://localhost:5432/garden_guide");

        Sql2o sql2o = new Sql2o(connectionString, null, null);
        plantDao = new Sql2oPlantDao(sql2o);
        eventDao = new Sql2oEventDao(sql2o);
        conn = sql2o.open();
      
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

        post("/gardenguideapi/events/new", "application/json", (req, res) -> {
            Event[] eventList = gson.fromJson(req.body(), Event[].class);
            for (Event event: eventList) {
                eventDao.add(event);
            }
            res.status(201);

            return gson.toJson(eventList);
        });

        // Get All Plants
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
            Plant plant = plantDao.findById(idOfPlantToFind);
            List<Event> events = eventDao.getAllByPlantId(idOfPlantToFind);
            model.put("plant", plant);
            model.put("events", events);
            return new ModelAndView(model, "plantDetail.hbs");
        }, new HandlebarsTemplateEngine());

    }

}


