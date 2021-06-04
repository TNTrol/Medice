package app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountCardDto
{
    private Integer id ;
    private MedicamentDto medicament;
    private Integer discount;

    public DiscountCardDto(MedicamentDto medicament, Integer discount)
    {
        this.discount = discount;
        this.medicament = medicament;
    }
}
