package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, String> { //Customer - Meeke CustomerRepo ekata adaala table records tika thiyagena inna entity eka... String - ee entity ekee primary key ekee data type eka.


}
