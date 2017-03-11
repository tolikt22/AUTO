package terela.dao;// Created by tolik on 11.03.2017.

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terela.model.Bus;

import javax.persistence.*;
import java.util.List;

public class BusDAOImpl implements BusDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(BusDAOImpl.class.getName());

    private EntityManager em = Persistence.createEntityManagerFactory("Java_group").createEntityManager();

    public Bus saveBus(Bus bus){
        em.getTransaction().begin();
        if (bus.getId() == null) {
            System.out.println();
            LOGGER.info("Inserting new bus");
            em.persist(bus);
        } else {
            em.merge(bus);
            LOGGER.info("Updating existing bus");
        }
        em.getTransaction().commit();
        LOGGER.info("Bus saved with id: " + bus.getId());
        return bus;
    }

    public Bus getBusById(Long bus_id) {
        em.getTransaction().begin();
        TypedQuery<Bus> query = em.createNamedQuery("Bus.findById", Bus.class);
        query.setParameter("id", bus_id);
        Bus bus = query.getSingleResult();
        em.getTransaction().commit();
        return bus;
    }

    public List<Bus> getAllBusses() {
        em.getTransaction().begin();
        List<Bus> providers = em.createNamedQuery("Bus.findAll", Bus.class).getResultList();
        em.getTransaction().commit();
        return providers;
    }

    public void addBus(Bus busForAdd) {

    }


}
