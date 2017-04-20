package terela;

import terela.dao.BusDAO;
import terela.dao.BusDAOImpl;
import terela.model.Bus;

import java.util.List;

public class Test {

    private static BusDAO busDAO = new BusDAOImpl();

    public static void main(String[] args) {
        List<Bus> buses = busDAO.getAllBusses();
//            for (int i = 0; i < buses.size(); i++) {
//                System.out.println(buses.get(i));
//            }
//
//            Bus bus = busDAO.getBusById(1L);
//            System.out.println(bus);

        // add Buss3
        Bus busForAdd = new Bus();
        busForAdd.setNumber(433);
        busDAO.addBus(busForAdd);
        busDAO.getBusById((long) 1);


    }
}
