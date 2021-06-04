package app.domain.entity;

import app.domain.dto.CustomerDto;
import app.domain.dto.DiscountCardDto;
import app.domain.dto.MedicamentDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "offer")
@Data
@NoArgsConstructor
public class Offer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discountCard_id")
    private DiscountCard discountCard;
    @Column(name = "count")
    private Integer count;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicament_id")
    private Medicament medicament;

    public Offer(Customer customer, DiscountCard discountCard, Integer count, Medicament medicament)
    {
        this.customer = customer;
        this.discountCard = discountCard;
        this.medicament = medicament;
        this.count = count;
    }

    public String toString()
    {
        return "{count = "+ count + "; medicament = " + medicament.getName() + "; customer:" + customer.getName() + "}";
    }
}
