package dao;

import models.Garden;
import models.Plant;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/30/17.
 */
public class Sql2oGardenDaoTest {

        private Sql2oGardenDao gardenDao;
        private Connection conn;

        @Before
        public void setUp() throws Exception {
            String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/garden.sql'";
            //String connectionString = ("jdbc:postgresql://localhost:5432/garden_guide_test");
            Sql2o sql2o = new Sql2o(connectionString, null, null);
            gardenDao = new Sql2oGardenDao(sql2o);
            conn = sql2o.open();
        }

        @After
        public void tearDown() throws Exception {
           conn.close();
        }

        public Garden getTestGarden() {
            String userName = "Jessica";
            String gardenName = "Spring2017";
            return new Garden(userName,gardenName);
        }

        @Test
        public void addingGardenSetsId() throws Exception {
            Garden garden = getTestGarden();
            gardenDao.add(garden);
            assertEquals(1, garden.getId());
        }

        @Test
        public void existingGardensCanBeFoundById() throws Exception {
            Garden garden = getTestGarden();
            gardenDao.add(garden);
            Garden foundGarden = gardenDao.findById(garden.getId());
            assertEquals(garden, foundGarden);
        }

        @Test
        public void getAll_allGardensAreFound() throws Exception {
            Garden garden = getTestGarden();
            Garden anotherGarden = getTestGarden();
            gardenDao.add(garden);
            gardenDao.add(anotherGarden);
            int number = gardenDao.getAll().size();
            assertEquals(2, number);
        }

        @Test
        public void getAll_noGardensAreFound() throws Exception {
            int number = gardenDao.getAll().size();
            assertEquals(0, number);
        }

        @Test
        public void deleteById_deletesVeryWell() {
            Garden garden = getTestGarden();
            gardenDao.add(garden);
            gardenDao.deleteById(garden.getId());
            assertEquals(0,gardenDao.getAll().size());
        }




}