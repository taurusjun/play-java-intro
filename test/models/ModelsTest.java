package models;

import models.*;
import org.junit.*;
import static org.junit.Assert.*;
import play.test.WithApplication;
import static play.test.Helpers.*;
/**
 * Created by I306067 on 2/15/2015.
 */
public class ModelsTest extends WithApplication {
    @Before
    public void setUp(){
        start(fakeApplication(inMemoryDatabase()));
    }

    @Test
    public void createAndRetrievePerson() {
        new Person("p1","May").save();
        Person may=Person.find.where().eq("name","May").findUnique();
        assertNotNull(may);
        assertEquals("May",may.name);
    }
}
