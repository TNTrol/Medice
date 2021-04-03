package App.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product
{
    private static int counter = 0;
    private Integer id = counter++;
    private Medicament medicament;
    private Integer count;
    private Integer delay;

    public Product(Medicament medicament, Integer count, Integer delay)
    {
        this.delay = delay;
        this.medicament = medicament;
        this.count = count;
    }
}
