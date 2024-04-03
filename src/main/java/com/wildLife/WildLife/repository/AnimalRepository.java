package com.wildLife.WildLife.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wildLife.WildLife.model.Animal;

import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
	Optional<Animal> getAnimalByName(String name);

}
