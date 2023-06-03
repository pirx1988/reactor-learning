package rp.stepVerifier.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpaceShip {
    private String id;
    private String name;
    private Integer crew;

    public SpaceShip(String name, Integer crew) {
        this.name = name;
        this.crew = crew;
    }
    public SpaceShip(Integer id, String name, Integer crew) {
        this.id = id.toString();
        this.name = name;
        this.crew = crew;
    }
}
