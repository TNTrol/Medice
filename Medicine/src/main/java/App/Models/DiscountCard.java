package App.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountCard
{
    private static int counter = 0;
    private Integer id = counter++;
    private Medicament medicament;
    private Integer discount;

    public DiscountCard(Medicament medicament, Integer discount)
    {
        this.discount = discount;
        this.medicament = medicament;
    }
}
