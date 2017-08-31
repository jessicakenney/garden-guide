package dao;

import models.DB;
import models.Plant;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.sql.DriverManager;
import java.util.Arrays;

//import static models.DB.sql2o;
import static org.junit.Assert.*;

public class Sql2oPlantDaoTest {
  private Sql2oPlantDao plantDao;
  private Connection conn;

  @Before
  public void setUp() throws Exception {
    //String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
    String connectionString = ("jdbc:postgresql://localhost:5432/garden_guide_test");
    Sql2o sql2o = new Sql2o(connectionString, null, null);
    plantDao = new Sql2oPlantDao(sql2o);
    conn = sql2o.open();
  }

  @After
  public void tearDown() throws Exception {
    conn.close();
    String sql = "DELETE FROM plants *;";
    conn.createQuery(sql).executeUpdate();
    //then need to restart the key
  }

  public Plant getTestPlant() {
    String plantName = "tomato";
    int daysToMaturity = 4;
    String plantSpacing = "1foot";
    String rowSpacing = "2foot";
    return new Plant(plantName,daysToMaturity,plantSpacing,rowSpacing);
  }

  @Test
  public void addingPlantSetsId() throws Exception {
    Plant plant = getTestPlant();
    plantDao.add(plant);
    assertEquals(1, plant.getId());
  }

  @Test
  public void existingPlantsCanBeFoundById() throws Exception {
    Plant plant = getTestPlant();
    plantDao.add(plant);
    Plant foundPlant = plantDao.findById(plant.getId());
    assertEquals(plant, foundPlant);
  }

  @Test
  public void getByPlantName_works_great() throws Exception {
    Plant plant = getTestPlant();
    plantDao.add(plant);
    Plant foundPlant = plantDao.getByPlantName(plant.getPlantName());
    assertEquals(plant, foundPlant);
  }

  @Test
  public void getAll_allPlantsAreFound() throws Exception {
    Plant plant = getTestPlant();
    Plant anotherPlant = getTestPlant();
    plantDao.add(plant);
    plantDao.add(anotherPlant);
    int number = plantDao.getAll().size();
    assertEquals(2, number);
  }

  @Test
  public void getAll_noPlantsAreFound() throws Exception {
    int number = plantDao.getAll().size();
    assertEquals(0, number);
  }

  @Test
  public void deleteById_deletesVeryWell() {
    Plant plant = getTestPlant();
    plantDao.add(plant);
    plantDao.deleteById(plant.getId());
    assertEquals(0,plantDao.getAll().size());
  }


}