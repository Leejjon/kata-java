package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdater;

public class BetterByAgeItemUpdater implements ItemUpdater {

    @Override
    public Item passDay(Item item) {
        int sellIn = item.sellIn;
        int quality = item.quality;

        if (sellIn > 0) {
            quality = ItemUpdater.updateQuality(quality, 1);
        } else {
            quality = ItemUpdater.updateQuality(quality, 2);
        }
        sellIn--;

        return new Item(item.name, sellIn, quality);
    }
}
