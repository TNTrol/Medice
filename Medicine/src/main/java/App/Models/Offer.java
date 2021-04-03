package App.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Offer
{
    private static int counter = 0;
    private Integer id = counter++;
    private Customer customer;
    private DiscountCard discountCard;
    private Integer count;
    private Medicament medicament;

    public Offer(Customer customer, DiscountCard discountCard, Integer count, Medicament medicament)
    {
        this.count = count;
        this.medicament = medicament;
        this.discountCard = discountCard;
        this.customer = customer;
    }
}
