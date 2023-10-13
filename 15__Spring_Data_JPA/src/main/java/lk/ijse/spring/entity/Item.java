package lk.ijse.spring.entity;

import lk.ijse.spring.config.JPAConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Import;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data  //getters setters
@ToString

public class Item {
    @Id
    private String code;
    private String description;
    private int qtyOnHand;
    private BigDecimal unitPrice;

}
