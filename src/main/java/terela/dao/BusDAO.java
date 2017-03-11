package terela.dao;// Created by tolik on 11.03.2017.

import terela.model.Bus;

import java.util.List;

public interface BusDAO {
     Bus saveBus(Bus bus);
     Bus getBusById(Long l);
     List<Bus> getAllBusses();

    void addBus(Bus busForAdd);
}

