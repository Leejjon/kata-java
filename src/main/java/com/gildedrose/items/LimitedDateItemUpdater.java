package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdater;

public class LimitedDateItemUpdater implements ItemUpdater {
    private static final int maxQuality = 50;

    @Override
    public Item passDay(Item item) {
        int sellIn = item.sellIn;
        int quality = item.quality;

        if (sellIn > 10) {
            quality = incrementQuality(quality, 1);
        } else if (sellIn > 5) {
            quality = incrementQuality(quality, 2);
        } else if (sellIn > 0) {
            quality = incrementQuality(quality, 3);
        } else {
            quality = 0;
        }
        sellIn--;

        return new Item(item.name, sellIn, quality);
    }

    private int incrementQuality(int quality, int increment) {
        final int incrementedValue = quality + increment;
        if (incrementedValue >= maxQuality) {
            return maxQuality;
        } else {
            return incrementedValue;
        }
    }
}
