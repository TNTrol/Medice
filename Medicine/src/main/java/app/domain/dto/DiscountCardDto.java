package app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountCardDto
{
    private static int counter = 0;
    private Integer id = counter++;
    private MedicamentDto medicament;
    private Integer discount;

    public DiscountCardDto(MedicamentDto medicament, Integer discount)
    {
        this.discount = discount;
        this.medicament = medicament;
    }
}
