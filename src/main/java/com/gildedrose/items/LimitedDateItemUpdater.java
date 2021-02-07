package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdater;

public class LimitedDateItemUpdater implements ItemUpdater {
    @Override
    public Item passDay(Item item) {
        int sellIn = item.sellIn;
        int quality = item.quality;

        if (sellIn > 10) {
            quality++;
        } else if (sellIn > 5) {
            quality += 2;
        } else if (sellIn > 0) {
            quality += 3;
        } else {
            quality = 0;
        }
        sellIn--;

        return new Item(item.name, sellIn, quality);
    }
}
