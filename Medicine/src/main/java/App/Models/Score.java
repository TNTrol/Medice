package App.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score
{
    private static int counter = 0;
    private Integer id = counter++;
    //private Customer customer;
    private Double cost;
    private Integer date;
    private Medicament medicament;
    private Integer count;

    public Score( Double cost, Integer date, Medicament medicament, Integer count)
    {
        //this.customer = customer;
        this.cost = cost;
        this.date = date;
        this.medicament = medicament;
        this.count = count;
    }
}
