import com.google.gson.Gson;
import dao.Sql2oPlantDao;
import models.Plant;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        Sql2oPlantDao plantDao;
        Connection conn;
        Gson gson = new Gson();

        //String connectionString = "jdbc:h2:~/recipe-box.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        String connectionString = ("jdbc:postgresql://localhost:5432/garden_guide");

        Sql2o sql2o = new Sql2o(connectionString, null, null);
        plantDao = new Sql2oPlantDao(sql2o);
        conn = sql2o.open();


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


        //get: show careers page
        get("/plantDetail/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "plantDetail.hbs");
        }, new HandlebarsTemplateEngine());

    }

}