package com.madurai.fishApp.Service;

import com.madurai.fishApp.Entity.Items;
import com.madurai.fishApp.Records.ItemsRecord;
import com.madurai.fishApp.Repository.ItemsRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemsService {
    private final ItemsRepo itemsRepo;

    public void addItem(ItemsRecord itemsRecord) {
        try {
            itemsRepo.save(recordToEntity(itemsRecord));
            log.info("Item added successfully in items table!");
        }
        catch(Exception e) {
            log.info("Failed to add item in items table!");
            e.printStackTrace();
        }
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
