package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdater;

public class BetterByAgeItemUpdater implements ItemUpdater {
    private static final int maxQuality = 50;

    @Override
    public Item passDay(Item item) {
        int sellIn = item.sellIn;
        int quality = item.quality;

        if (sellIn > 0 && (quality + 1) <= maxQuality) {
            quality++;
        } else {
            if ((quality + 2) <= maxQuality) {
                quality += 2;
            }
        }
        sellIn--;

        return new Item(item.name, sellIn, quality);
    }
}
