package terela.model;// Created by tolik on 11.03.2017.

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "buses")
@NamedQueries({
        @NamedQuery(name = "Bus.findAll", query = "select b from Bus b"),
        @NamedQuery(name = "Bus.findById", query = "select distinct b from Bus b where b.id = :id")
})
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bus_id")
    private Long id;
    @Column(name = "number")
    private Integer number;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "bus_driver",
            joinColumns = {@JoinColumn(name = "bus_id",
                    nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "driver_id",
                    nullable = false, updatable = false)})
    private Set<Driver> drivers = new HashSet();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    public Bus() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", drivers=" + drivers +
                ", route=" + route +
                '}';
    }
}