package com.madurai.fishApp.Controller;

import com.madurai.fishApp.Entity.Items;
import com.madurai.fishApp.Records.ItemsRecord;
import com.madurai.fishApp.Service.ItemsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fishApp/items")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class ItemsController {
    private final ItemsService itemsService;
    @PostMapping("/addItem")
    public ResponseEntity<String> addItem(@RequestBody ItemsRecord itemsRecord) {
        try {
            log.info("Saving item : {}", itemsRecord.itemName());
            return new ResponseEntity<>(itemsService.addItem(itemsRecord), HttpStatus.OK);
        } catch(Exception e) {
            log.info("Error in saving the item : {}", itemsRecord.itemName());
            return new ResponseEntity<>("Error in saving the item : " + itemsRecord.itemName(), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/deleteItem")
    public ResponseEntity<String> deleteItem(@RequestParam Integer itemId) {
        try {
            log.info("Deleting item with id: {}", itemId);
            return new ResponseEntity<>(itemsService.deleteItem(itemId), HttpStatus.OK);
        } catch(Exception e) {
            log.info("Error in deleting the item with id : {}", itemId);
            return new ResponseEntity<>("Error in deleting the item with id : " + itemId, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getAllItems")
    public ResponseEntity<List<Items>> getAllItems() {
        try {
            log.info("Getting all items");
            return new ResponseEntity<>(itemsService.getAllItems(), HttpStatus.OK);
        } catch(Exception e) {
            log.info("Error in getting all the items");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }
}
