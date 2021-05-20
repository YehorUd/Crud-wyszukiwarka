package com.example.demon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface AnimalRepo extends JpaRepository <com.example.demon.Animal, Integer> {
    List<com.example.demon.Animal> findByName(String search);
}

