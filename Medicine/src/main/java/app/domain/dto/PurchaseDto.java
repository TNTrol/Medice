package app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDto
{
    private static int counter = 0;
    private Integer id = counter++;
    private MedicamentDto medicament;
    private Integer count;
    private Integer delay;
    private Integer timeDelay;
    //private Customer customer;

    public PurchaseDto(MedicamentDto medicament, Integer count, Integer delay)
    {
        this.medicament = medicament;
        this.count = count;
        this.delay = delay;
        //this.customer = customer;
        this.timeDelay = delay;
    }
}
