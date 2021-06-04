package app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto
{
    private Integer id ;
    private String name;
    private String numberPhone;
    private String address;

//    private List<DiscountCardDto> discountCards = new ArrayList<>();
//    private List<PurchaseDto> purchases = new ArrayList<>();
//    private List<ScoreDto> scores = new ArrayList<>();
//    private List<OfferDto> offers = new ArrayList<>();

    public CustomerDto(String name, String numberPhone, String address)
    {
        this.name = name;
        this.numberPhone = numberPhone;
        this.address = address;
    }
}
