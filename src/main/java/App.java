import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");



        // show home page (root route)
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
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

        //get: show careers page
        get("/plantDetail/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "plantDetail.hbs");
        }, new HandlebarsTemplateEngine());

    }

}