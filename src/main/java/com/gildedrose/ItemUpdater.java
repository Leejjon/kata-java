package com.gildedrose;

public interface ItemUpdater {
    int maxQuality = 50;
    int minQuality = 0;

    Item passDay(Item item);

    static int updateQuality(int quality, int delta) {
        final int updatedQuality = quality + delta;
        if (updatedQuality <= minQuality) {
            return minQuality;
        } else if (updatedQuality >= maxQuality) {
            return maxQuality;
        } else {
            return updatedQuality;
        }
    }
}
