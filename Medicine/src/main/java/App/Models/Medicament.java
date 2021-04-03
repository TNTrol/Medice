package App.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicament
{
    private static int counter = 0;
    private Integer id = counter++;
    private String name;
    private TypeMedicament type;
    private Double price;

    public  Medicament(String name, TypeMedicament type, Double price)
    {
        this.name = name;
        this.type = type;
        this.price = price;
    }
}
