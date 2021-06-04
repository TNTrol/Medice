package app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentDto
{
    private Integer id ;
    private String name;
    private String type;
    private Double price;

    public MedicamentDto(String name, String type, Double price)
    {
        this.name = name;
        this.type = type;
        this.price = price;
    }
}
