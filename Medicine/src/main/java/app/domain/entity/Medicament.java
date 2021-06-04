package app.domain.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "medicament")
@Data
public class Medicament
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "price")
    private Double price;
}
