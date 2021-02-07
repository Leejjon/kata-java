package com.gildedrose;

public interface ItemUpdater {
    int maxQuality = 50;

    Item passDay(Item item);

    static int incrementQuality(int quality, int increment) {
        final int incrementedValue = quality + increment;
        if (incrementedValue >= maxQuality) {
            return maxQuality;
        } else {
            return incrementedValue;
        }
    }
}
