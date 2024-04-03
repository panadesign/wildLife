package com.wildLife.WildLife.service;

import java.util.List;

import com.wildLife.WildLife.model.Animal;

public interface AnimalService {
	List<Animal> getAnimals();
	Animal addAnimal(Animal animal);
	
}
