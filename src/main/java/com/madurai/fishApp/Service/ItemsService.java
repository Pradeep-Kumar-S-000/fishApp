package com.madurai.fishApp.Service;

import com.madurai.fishApp.Entity.Items;
import com.madurai.fishApp.Records.ItemsRecord;
import com.madurai.fishApp.Repository.ItemsRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemsService {
    private final ItemsRepo itemsRepo;

    public String addItem(ItemsRecord itemsRecord) throws Exception {
        itemsRepo.save(recordToEntity(itemsRecord));
        log.info("Item with name: {} added successfully in items table!", itemsRecord.itemName());
        return "Item with name: " + itemsRecord.itemName() + " added successfully in items table!";
    }

    public String deleteItem(Integer itemId) throws Exception {
        String itemNameToDelete = null;
        Optional<Items> itemToDelete = itemsRepo.findById(itemId);
        if(itemToDelete.isPresent()) {
            itemNameToDelete = itemToDelete.get().getItemName();
            itemsRepo.deleteById(itemId);
            log.info("Item with name: {} deleted successfully in items table!", itemNameToDelete);
            return "Item with name: " + itemNameToDelete + " deleted successfully in items table!";
        } else {
            log.info("Item with id : {} not found", itemId);
            return "Item with id : " + itemId + " not found";
        }
    }

    public List<Items> getAllItems() {
        return itemsRepo.findAll();
    }

    public Items recordToEntity(ItemsRecord itemsRecord) {
        return new Items(
                itemsRecord.itemId(),
                itemsRecord.itemName(),
                itemsRecord.stockAvailable(),
                itemsRecord.listPrice(),
                itemsRecord.discount()
        );
    }
}
