package App.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase
{
    private static int counter = 0;
    private Integer id = counter++;
    private Medicament medicament;
    private Integer count;
    private Integer delay;
    private Integer timeDelay;
    //private Customer customer;

    public Purchase(Medicament medicament, Integer count, Integer delay)
    {
        this.medicament = medicament;
        this.count = count;
        this.delay = delay;
        //this.customer = customer;
        this.timeDelay = delay;
    }
}
