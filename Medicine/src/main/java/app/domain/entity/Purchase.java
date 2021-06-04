package app.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "purchase")
@Data
@NoArgsConstructor
public class Purchase
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medicament_id")
    private Medicament medicament;
    @Column(name = "count")
    private Integer count;
    @Column(name = "delay")
    private Integer delay;
    @Column(name = "timeDelay")
    private Integer timeDelay;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
