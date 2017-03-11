package terela.model;// Created by tolik on 11.03.2017.

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "route_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "number")
    private int number;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "route")
    private Set<Bus> buses = new HashSet();


    public Route() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Set getBuses() {
        return buses;
    }

    public void setBuses(Set buses) {
        this.buses = buses;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}