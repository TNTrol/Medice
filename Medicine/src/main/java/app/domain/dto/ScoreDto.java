package app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreDto
{
    private static int counter = 0;
    private Integer id = counter++;
    private CustomerDto customer;
    private Double cost;
    private Integer date;
    private MedicamentDto medicament;
    private Integer count;

    public ScoreDto(Double cost, Integer date, MedicamentDto medicament, Integer count, CustomerDto customer)
    {
        this.customer = customer;
        this.cost = cost;
        this.date = date;
        this.medicament = medicament;
        this.count = count;
    }
}
