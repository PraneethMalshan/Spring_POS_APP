package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    //Response formate
    //state - meeka use kalaa request state eka mokakda kiyala kiyanna.
    //message - mokakda wunee kiyala msg ekak ewanawa.. Successfully add wagee, Ok or error
    //data - Mokak hari data ekak ewanna thiinawa nam ewanna.(Result ekak search karoth eeka ganna oona nam ,  Mokak hari array ekak thiinawa nam eeke thiina data tika ganna oona nam )

    @Autowired
    private CustomerService service;

    /*@Autowired
    private CustomerRepo repo;

    @Autowired
    private ModelMapper mapper;*/

    @ResponseStatus(HttpStatus.CREATED)  //Yawanna oona status codeeka
    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO dto ){   //mehi @ModelAttribute annotation daanna awashyama nae. Ee wunaata daanna..

//        if (dto.getId().equals("C001")){

       /* if (repo.existsById(dto.getId())){
            throw new RuntimeException("Customer already Exists.. Please enter another ID..");
        }
        repo.save(mapper.map(dto, Customer.class));*/ //meeka geniyanawaa CustomerServiceImpl ekata. mokada meeke meewa thiyanna baa...

        /*  Customer map = mapper.map(dto, Customer.class);
//        Customer customer = new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getSalary());
        repo.save(map);*/

        //        System.out.println(dto.toString());
        service.saveCustomer(dto);
        return new ResponseUtil("OK","Successfully Registered..!",null);
   }

   @DeleteMapping(params = {"id"})
   public ResponseUtil deleteCustomer(@RequestParam String id){  //mehi @RequestParam annotation daanna awashyama nae. Ee wunaata daanna..

     /*  if (!repo.existsById(id)){
           throw new RuntimeException("Wrong ID. Please enter valid ID..");
       }
       repo.deleteById(id);*/
        service.deleteCustomer(id);
        return new ResponseUtil("OK","Successfully Deleted. : "+id,null);

   }

   @PutMapping
   public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto ){  //JSON ekakin data tika illa ganne @RequestBody eken.. Ee nisaa @RequestBody annotation eka damiima aniwaaryaya wee....

     /*  if (!repo.existsById(dto.getId())){
           throw new RuntimeException("Customer Not Exists.. Please enter Valid ID..!");
       }
       repo.save(mapper.map(dto, Customer.class));*/
       /*Customer customer = new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getSalary());
       repo.save(customer);*/



        service.updateCustomer(dto);
       return new ResponseUtil("OK","Successfully Updated. : "+dto.getId(),null);

   }

   @GetMapping
   public ResponseUtil getAllCustomers(){
     /*  ArrayList<CustomerDTO> arrayList= new ArrayList<>();
       List<Customer> all = repo.findAll();*/

/*
       ArrayList<CustomerDTO> allList=mapper.map(repo.findAll(), new TypeToken<ArrayList<CustomerDTO>>(){}.getType());
*/

       /*arrayList.add(new CustomerDTO("C001","Malshan","Galle",new BigDecimal(1000)));
       arrayList.add(new CustomerDTO("C002","Praneeth","Panadura",new BigDecimal(2000)));
       arrayList.add(new CustomerDTO("C003","Pasindu","Walapane",new BigDecimal(3000)));
       arrayList.add(new CustomerDTO("C004","Tasindu","Jafna",new BigDecimal(4000)));
       arrayList.add(new CustomerDTO("C005","Chathura","Australia",new BigDecimal(5000)));
*/
       return new ResponseUtil("OK","Successfully Loaded. : ",service.getAllCustomers());

   }

}
