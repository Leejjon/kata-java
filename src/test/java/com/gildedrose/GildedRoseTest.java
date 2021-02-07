package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class GildedRoseTest {
    @Test
    void testUpdateQuality_verifyQualityAndSellInDateDecrease_forStandardItem() {
        final String name = "foo";
        Item[] items = new Item[] { new Item(name, 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item itemThatShouldHaveBeenUpdated = app.items[0];
        assertThat(itemThatShouldHaveBeenUpdated.name, is(name));
        assertThat(itemThatShouldHaveBeenUpdated.quality, is(4));
        assertThat(itemThatShouldHaveBeenUpdated.sellIn, is(4));
    }

    @Test
    void testUpdateQuality_verifyQualityDoesntGetNegative_WhenPassingSellInDate() {
        final String name = "foo";
        Item[] items = new Item[] { new Item(name, 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item itemThatShouldHaveBeenUpdated = app.items[0];
        assertThat(itemThatShouldHaveBeenUpdated.quality, is(0));
        assertThat(itemThatShouldHaveBeenUpdated.sellIn, is(-1));
    }

    @Test
    void testUpdateQuality_proveQualityIncreasesTwiceAsFast_AfterSellInReachesZero() {
        final String name = "food";
        Item[] items = new Item[] { new Item(name, 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item itemThatShouldHaveBeenUpdated = app.items[0];
        assertThat(itemThatShouldHaveBeenUpdated.quality, is(8));
        assertThat(itemThatShouldHaveBeenUpdated.sellIn, is(-1));
    }

    @Test
    void testUpdateQuality_proveAgedBrieIncreasesInQuality() {
        final String name = "Aged Brie";
        Item[] items = new Item[] { new Item(name, 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item itemThatShouldHaveBeenUpdated = app.items[0];
        assertThat(itemThatShouldHaveBeenUpdated.quality, is(6));
        assertThat(itemThatShouldHaveBeenUpdated.sellIn, is(4));
    }

    @Test
    void testUpdateQuality_proveAgedBrieIncreasesInQuality_evenAfterSellInIsLowerThanZero() {
        final String name = "Aged Brie";
        Item[] items = new Item[] { new Item(name, 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item itemThatShouldHaveBeenUpdated = app.items[0];
        // TODO: Verify with product owner whether the faster increase if "Aged Brie" quality when SellIn
        //  is lower than zero is expected.
        assertThat(itemThatShouldHaveBeenUpdated.quality, is(2));
        assertThat(itemThatShouldHaveBeenUpdated.sellIn, is(-1));
    }

}
