import dao.Sql2oEventDao;
import models.Event;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Sql2oEventDaoTest {

    private Sql2oEventDao eventDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        //String connectionString = ("jdbc:postgresql://localhost:5432/garden_guide_test");
        Sql2o sql2o = new Sql2o(connectionString, null, null);
        eventDao = new Sql2oEventDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
        //String sql = "DELETE FROM events *;";
        //conn.createQuery(sql).executeUpdate();
        //restart the id
    }

    //helper
    Date startDate;
    Date endDate;
    public Event getTestEvent() {
        String type = "harvest";
        int plantId = 1;
        String startDateString = "07/7/2017";
        String endDateString = "07/7/2017";
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        try {
            startDate = df.parse(startDateString);
            endDate = df.parse(endDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Event(startDate,endDate,type,plantId);
    }

    @Test
    public void addingEventSetsId() throws Exception {
        Event event = getTestEvent();
        eventDao.add(event);
        assertEquals(1, event.getId());
    }


    @Test
    public void getAllByPlantId_returnsCorrectly() throws Exception {
        Event event = getTestEvent();
        Event anotherEvent = getTestEvent();
        eventDao.add(event);
        eventDao.add(anotherEvent);
         List<Event> events  = eventDao.getAllByPlantId(1);
        int number = events.size();
        assertEquals(2, number);
    }


}
