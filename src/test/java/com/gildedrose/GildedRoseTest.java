package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    @Test
    void testUpdateQuality_verifyQualityAndSellInDateDecrease_forStandardItems() {
        Item[] items = new Item[] { new Item("foo", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("foo", app.items[0].name);
        assertEquals(4, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void testUpdateQuality_verifyQualityDoesntGetNegative_WhenPassingSellInDate() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("foo", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void testUpdateQuality_proveQualityIncreasesTwiceAsFast_AfterSellInReachesZero() {
        Item[] items = new Item[] { new Item("food", 0, 10) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("food", app.items[0].name);
        assertEquals(8, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

}
