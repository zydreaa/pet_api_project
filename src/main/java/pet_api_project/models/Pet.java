package pet_api_project.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class Pet {
    private int id;
    private String petName;
    private double age;
    private String type;
    private String ownerName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Pet() {
        this.id = id;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Pet(int id, String petName, double age, String type, String ownerName) {
        this.id = id;
        this.petName = petName;
        this.age = age;
        this.type = type;
        this.ownerName = ownerName;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}