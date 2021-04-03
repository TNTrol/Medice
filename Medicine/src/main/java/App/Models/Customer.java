package App.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer
{
    private static int counter = 0;
    private Integer id = counter++;
    private String name;
    private String numberPhone;
    private String address;

    private List<DiscountCard> discountCards = new ArrayList<>();
    private List<Purchase> purchases = new ArrayList<>();
    private List<Score> scores = new ArrayList<>();
    private List<Offer> offers = new ArrayList<>();

    public Customer(String name, String numberPhone, String address)
    {
        this.name = name;
        this.numberPhone = numberPhone;
        this.address = address;
    }
}
