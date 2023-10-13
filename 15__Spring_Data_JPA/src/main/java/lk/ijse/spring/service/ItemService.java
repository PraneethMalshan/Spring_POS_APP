package lk.ijse.spring.service;

import lk.ijse.spring.dto.ItemDTO;

import java.util.ArrayList;

public interface ItemService {
    public void saveItem(ItemDTO dto);
    public void deleteItem(String code);
    public void updateItem(ItemDTO dto);
    public ArrayList<ItemDTO> getAllItems();
}
