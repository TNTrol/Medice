package app.domain.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "discountCard")
@Data
public class DiscountCard
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicament_id")
    private Medicament medicament;

    @Column(name = "discount")
    private Integer discount;
}
