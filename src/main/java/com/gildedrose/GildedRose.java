package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        // This would probably be autowired, or the mapping would come from the db.
        ItemsFactory itemsFactory = new ItemsFactory();
        for (int i = 0; i < items.length; i++) {
            items[i] = itemsFactory
                    .getItemTypeByName(items[i].name)
                    .passDay(items[i]);
        }
    }
}
