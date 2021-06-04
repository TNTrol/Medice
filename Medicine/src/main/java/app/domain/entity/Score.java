package app.domain.entity;

import app.domain.dto.MedicamentDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "score")
@Data
public class Score
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "date")
    private Integer date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medicament_id")
    private Medicament medicament;

    @Column(name = "count")
    private Integer count;

    public Score(Double cost, Integer date, Medicament medicament, Integer count, Customer customer)
    {
        this.customer = customer;
        this.cost = cost;
        this.date = date;
        this.medicament = medicament;
        this.count = count;
    }

    public Score(){}

    public String toString()
    {
        return "{cost = " +  cost + "; customer name = " + customer.getName() + "; medicament = " + medicament.getName()+ "; count = " + count + "}";
    }
}
