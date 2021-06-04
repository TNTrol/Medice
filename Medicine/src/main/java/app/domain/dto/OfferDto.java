package app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferDto
{
    private Integer id ;
    private CustomerDto customer;
    private DiscountCardDto discountCard;
    private Integer count;
    private MedicamentDto medicament;

    public OfferDto(CustomerDto customer, DiscountCardDto discountCard, Integer count, MedicamentDto medicament)
    {
        this.count = count;
        this.medicament = medicament;
        this.discountCard = discountCard;
        this.customer = customer;
    }
}
