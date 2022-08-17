package pet_api_project.controllers;

import org.springframework.web.bind.annotation.*;
import pet_api_project.models.Pet;

import java.util.ArrayList;

public class PetController {
    private final ArrayList<Pet> pets = new ArrayList<>();

    //ADD METHOD
    @PostMapping("api/pets")
    public Pet createPet(@RequestBody() Pet petCreation) {
        Pet pet = new Pet(
                petCreation.getId(),
                petCreation.getPetName(),
                petCreation.getAge(),
                petCreation.getType(),
                petCreation.getOwnerName()
        );

        this.pets.add(pet);
        return pet;
        }

    //VIEW METHOD
    @GetMapping("api/pets")
    public ArrayList<Pet> viewPets(){
        return  pets;
    }

    //UPDATE METHOD
    @PutMapping(path = "{id}")
    public void updatePetById(@PathVariable("id")int id, @RequestBody Pet pet){
        Pet petInfoUpdate = selectPet(id);
        int index = pets.indexOf(pet);
        if (petInfoUpdate != null){
            pets.set(index, pet);
            System.out.println(pet.getPetName() + "pet info was updated!");
        }
        System.out.println("Pet by selected ID not found");
    }


    //DELETE METHOD
    @DeleteMapping(path = "{id}")
    public void deletePetById(@PathVariable("id") int id){
        Pet petDelete = selectPet(id);
        if (petDelete == null){
            System.out.println("There is no Pet with such Id");
        }
        pets.remove(petDelete);
        System.out.println(petDelete.getPetName() + " was deleted successfully");
    }

    //METHOD TO FIND PET BY ID
    @GetMapping(path = "{id}")
    public Pet getPetById(@PathVariable("id") int id){
        return selectPet(id);
    }

    Pet selectPet(int id) {
        for (Pet pet: pets){
            if (id == pet.getId()){
                return pet;
            }
        }
        return null;
    }

}
