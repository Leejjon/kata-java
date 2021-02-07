package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        // This would probably be autowired, or the mapping would come from the db.
        ItemUpdaterFactory itemUpdaterFactory = new ItemUpdaterFactory();
        for (int i = 0; i < items.length; i++) {
            items[i] = itemUpdaterFactory
                    .getItemUpdaterByName(items[i].name)
                    .passDay(items[i]);
        }
    }
}
