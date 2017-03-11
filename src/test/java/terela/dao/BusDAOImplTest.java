package terela.dao;

import org.junit.Test;
import terela.model.Bus;
import terela.model.Route;

import static org.junit.Assert.assertEquals;
// Created by tolik on 11.03.2017.

public class BusDAOImplTest {

    @Test
    public void testSaveBus() throws Exception {
        BusDAOImpl busDAO = new BusDAOImpl();
        Route route = new Route();
        route.setId(3L);
        Bus bus  = new Bus();
        bus.setNumber(26);
        bus.setRoute(route);
        busDAO.saveBus(bus);
        Bus expected = busDAO.getBusById(bus.getId());

        assertEquals (bus,expected);

    }
}