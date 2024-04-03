package com.wildLife.WildLife.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.wildLife.WildLife.model.Animal;
import com.wildLife.WildLife.repository.AnimalRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AnimalServiceImpl implements AnimalService {
	
	private AnimalRepository animalRepository;

	public AnimalServiceImpl(AnimalRepository animalRepository) {
		this.animalRepository = animalRepository;
	}
	
	public List<Animal> getAnimals() {
		log.info("Get all animals");
		return animalRepository.findAll();
	}

	public Animal addAnimal(Animal animal) {
		log.info("Create a new animal");
		boolean animalExisting = animalRepository.findAll()
				.stream()
				.map(Animal::getName)
				.anyMatch(name -> name == animal.getName());

		if(animalExisting) {
			log.error("Animal with name :" + animal.getName() + " already exist in DB");
		}

		return animalRepository.save(animal);
	}


}
