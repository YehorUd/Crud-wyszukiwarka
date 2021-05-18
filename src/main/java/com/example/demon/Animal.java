package com.example.demon;

import javax.persistence.*;

@Entity
@Table(name="AnimalsBook")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private String name;
    private String size;
    private String weight;
    @Transient
    boolean  NEW;

    public Animal(Integer id, String type, String name, String size, String weight, boolean NEW) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.size = size;
        this.weight = weight;
        this.NEW = NEW;
    }
    public Animal(String type, String name, String size, String weight, boolean NEW) {
        this.type = type;
        this.name = name;
        this.size = size;
        this.weight = weight;
        this.NEW = NEW;
    }

    public Animal() { }

    @Override
    public String toString() {
        return "Animals{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", weight='" + weight + '\'' +
                ", nowy=" + NEW +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public boolean isNEW() {
        return NEW;
    }

    public void setNEW(boolean NEW) {
        this.NEW = NEW;
    }
}



