package com.ciandt.people.business;

import android.test.InstrumentationTestCase;

import com.ciandt.people.application.App;
import com.ciandt.people.application.PeopleComponent;
import com.ciandt.people.entity.People;

import org.hamcrest.Matchers;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by snoleto on 03/10/15.
 */
public class PeopleBusinessTest extends InstrumentationTestCase {

    @Inject
    PeopleBusiness business;

    @Override
    protected void setUp() throws Exception {
        App app = (App) getInstrumentation().getTargetContext().getApplicationContext();
        PeopleComponent g = app.graph();
        this.business = g.peopleBusiness();
        g.inject(business);
    }

    public void testListPeopleFromService() throws IOException {
        List<People> ps = business.getArchitectsFromCity("BH");

        assertNotNull(ps);
        assertTrue(ps.size() > 0);

        for (People p : ps) {
            assertThat(p.getCity(), Matchers.equalTo("BH"));
            assertThat(p.getRole(), Matchers.equalTo("Software Architect"));
        }
    }

    public void testPeopleContent() throws IOException {
        People person = business.getPerson("akieras");

        assertNotNull(person);
        assertTrue(person.getLogin().equals("akieras"));
        assertTrue(person.getRole().equals("Software Architect"));
    }
}
