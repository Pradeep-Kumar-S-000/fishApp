package com.madurai.fishApp.Records;

public record ItemsRecord(
        Integer itemId,
        String itemName,
        Double stockAvailable,
        Double listPrice,
        Double discount
) {}

