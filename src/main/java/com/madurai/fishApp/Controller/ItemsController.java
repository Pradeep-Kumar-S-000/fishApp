package com.madurai.fishApp.Controller;

import com.madurai.fishApp.Records.ItemsRecord;
import com.madurai.fishApp.Service.ItemsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fishApp/items")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class ItemsController {
    private final ItemsService itemsService;
    @PostMapping("/addItem")
    public void addItem(@RequestBody ItemsRecord itemsRecord) {
        log.info("Saving item : {}", itemsRecord.itemName());
        itemsService.addItem(itemsRecord);
    }
}
