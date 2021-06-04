package app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentDto
{
    private static int counter = 0;
    private Integer id = counter++;
    private String name;
    private TypeMedicament type;
    private Double price;

    public MedicamentDto(String name, TypeMedicament type, Double price)
    {
        this.name = name;
        this.type = type;
        this.price = price;
    }
}
