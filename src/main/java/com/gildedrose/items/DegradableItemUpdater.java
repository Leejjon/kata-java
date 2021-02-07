package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdater;

/**
 * Food, drinks, or anything else that has an expiration date.
 */
public class DegradableItemUpdater implements ItemUpdater {
    final int defaultQualityDecrease;

    final int qualityDecreaseAfterSellInDate;

    public DegradableItemUpdater() {
        this(1, 2);
    }
    protected DegradableItemUpdater(int defaultQualityDecrease, int qualityDecreaseAfterSellInDate) {
        this.defaultQualityDecrease = defaultQualityDecrease;
        this.qualityDecreaseAfterSellInDate = qualityDecreaseAfterSellInDate;
    }

    @Override
    public Item passDay(Item item) {
        int sellIn = item.sellIn;
        int quality = item.quality;

        if (quality > 0) {
            if (sellIn <= 0) {
                quality -= qualityDecreaseAfterSellInDate;
            } else {
                quality -= defaultQualityDecrease;
            }
        }
        sellIn--;
        return new Item(item.name, sellIn, quality);
    }
}
