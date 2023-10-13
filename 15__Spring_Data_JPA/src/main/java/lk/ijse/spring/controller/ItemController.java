package lk.ijse.spring.controller;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.service.ItemService;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemController {

    @Autowired
     private ItemService service;

  /*  @Autowired
     private ItemRepo repo;

    @Autowired
    private ModelMapper mapper;*/

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveItem(@ModelAttribute ItemDTO dto){
       /* if (repo.existsById(dto.getCode())){
//            throw new RuntimeException(dto.getCode()+ ": Item already Registered ");
            throw new RuntimeException("Customer already Exists.. Please enter another ID..");

        }
        repo.save(mapper.map(dto, Item.class)); //Repo ekee thiina save kiyana method ekata entity eka damiima.
*/
        /*mapper.map(dto, Item.class);*/ //dto eka connect karala entity eka ganiima
        service.saveItem(dto);
        return new ResponseUtil("OK","Successfully Registered..!",null);

    }

    @DeleteMapping(params = {"code"})
    public ResponseUtil deleteItem(@RequestParam String code){
      /*  if (!repo.existsById(code)){
            throw new RuntimeException(code+ ": Item Not Exists to Delete..! ");
        }
        //
        repo.deleteById(code);*/
        service.deleteItem(code);
        return new ResponseUtil("OK","Successfully Deleted. : "+code,null);

    }

    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDTO dto ){
      /*  if (!repo.existsById(dto.getCode())){
            throw new RuntimeException(dto.getCode()+ ": Item Not Exists for Update..! ");
        }
        repo.save(mapper.map(dto, Item.class));*/
        service.updateItem(dto);
        return new ResponseUtil("OK","Successfully Updated. : "+dto.getCode(),null);

    }

    @GetMapping
    public ResponseUtil getAllItems(){
//        ArrayList<ItemDTO> arrayList= new ArrayList<>();
//        List<Item> all = repo.findAll();

/*
        ArrayList<ItemDTO> list=mapper.map(repo.findAll(),new TypeToken<ArrayList<ItemDTO>>(){}.getType());
*/

        /*arrayList.add(new ItemDTO("I001","Lux",100,1000));
        arrayList.add(new ItemDTO("I002","Vanila",200,2000));
        arrayList.add(new ItemDTO("I003","Signal",300,3000));
        arrayList.add(new ItemDTO("I004","Detol",400,4000));
        arrayList.add(new ItemDTO("I005","Bunis",500,5000));
*/
        return new ResponseUtil("OK","Successfully Loaded. : ", service.getAllItems());

    }

}
