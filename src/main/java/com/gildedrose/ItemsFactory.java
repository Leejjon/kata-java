package com.gildedrose;

import com.gildedrose.items.*;

public class ItemsFactory {
    public ItemUpdater getItemTypeByName(String name) {
        return switch (name) {
            case "Sulfuras, Hand of Ragnaros" -> new LegendaryItemUpdater();
            case "Aged Brie" -> new BetterByAgeItemUpdater();
            case "Backstage passes to a TAFKAL80ETC concert" -> new LimitedDateItemUpdater();
            case "Conjured Mana Cake" -> new VeryDegradableItemUpdater();
            default -> new DegradableItemUpdater();
        };
    }
}
