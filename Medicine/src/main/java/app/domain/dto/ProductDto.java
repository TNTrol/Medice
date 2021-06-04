package app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto
{
    private Integer id ;
    private MedicamentDto medicament;
    private Integer count;
    private Integer delay;

    public ProductDto(MedicamentDto medicament, Integer count, Integer delay)
    {
        this.delay = delay;
        this.medicament = medicament;
        this.count = count;
    }
}
