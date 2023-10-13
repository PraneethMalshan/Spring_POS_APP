package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data  //getters setters
@ToString

public class ItemDTO {

    private String code;
    private String description;
    private int qtyOnHand;
    private double unitPrice;

}
