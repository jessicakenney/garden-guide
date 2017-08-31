package dao;

import models.Garden;
import models.GardenPlant;
import models.Plant;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/30/17.
 */
public class Sql2oGardenPlantDaoTest {

    private Sql2oGardenPlantDao gardenPlantDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/garden.sql'";
        //String connectionString = ("jdbc:postgresql://localhost:5432/gardenPlant_guide_test");
        Sql2o sql2o = new Sql2o(connectionString, null, null);
        gardenPlantDao = new Sql2oGardenPlantDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    public GardenPlant getTestGardenPlant() {
        int plantId = 1;
        int gardenId = 1;
        return new GardenPlant(plantId,gardenId);
    }

    @Test
    public void addingGardenPlantSetsId() throws Exception {
        GardenPlant gardenPlant = getTestGardenPlant();
        gardenPlantDao.add(gardenPlant);
        assertEquals(1, gardenPlant.getId());
    }

    @Test
    public void existingGardenPlantsCanBeFoundById() throws Exception {
        GardenPlant gardenPlant = getTestGardenPlant();
        gardenPlantDao.add(gardenPlant);
        GardenPlant foundGardenPlant = gardenPlantDao.findById(gardenPlant.getId());
        assertEquals(gardenPlant, foundGardenPlant);
    }

    @Test
    public void getAll_allGardenPlantsAreFound() throws Exception {
        GardenPlant gardenPlant = getTestGardenPlant();
        GardenPlant anotherGardenPlant = getTestGardenPlant();
        gardenPlantDao.add(gardenPlant);
        gardenPlantDao.add(anotherGardenPlant);
        int number = gardenPlantDao.getAll().size();
        assertEquals(2, number);
    }

    @Test
    public void getAll_noGardenPlantsAreFound() throws Exception {
        int number = gardenPlantDao.getAll().size();
        assertEquals(0, number);
    }

    @Test
    public void deleteById_deletesVeryWell() {
        GardenPlant gardenPlant = getTestGardenPlant();
        gardenPlantDao.add(gardenPlant);
        gardenPlantDao.deleteById(gardenPlant.getId());
        assertEquals(0,gardenPlantDao.getAll().size());
    }


}