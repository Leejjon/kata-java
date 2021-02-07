package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdater;

public class LimitedDateItemUpdater implements ItemUpdater {

    @Override
    public Item passDay(Item item) {
        int sellIn = item.sellIn;
        int quality = item.quality;

        if (sellIn > 10) {
            quality = ItemUpdater.incrementQuality(quality, 1);
        } else if (sellIn > 5) {
            quality = ItemUpdater.incrementQuality(quality, 2);
        } else if (sellIn > 0) {
            quality = ItemUpdater.incrementQuality(quality, 3);
        } else {
            quality = 0;
        }
        sellIn--;

        return new Item(item.name, sellIn, quality);
    }
}
