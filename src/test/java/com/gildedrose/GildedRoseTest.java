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
    void testUpdateQuality_verifyQualityDoesntGetNegative_WhenSellInIsLowerThanZero() {
        final String name = "foo";
        Item[] items = new Item[] { new Item(name, 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item itemThatShouldHaveBeenUpdated = app.items[0];
        assertThat(itemThatShouldHaveBeenUpdated.quality, is(0));
        assertThat(itemThatShouldHaveBeenUpdated.sellIn, is(-1));
    }

    @Test
    void testUpdateQuality_verifyQualityIncreasesTwiceAsFast_AfterSellInReachesZero() {
        final String name = "food";
        Item[] items = new Item[] { new Item(name, 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item itemThatShouldHaveBeenUpdated = app.items[0];
        assertThat(itemThatShouldHaveBeenUpdated.quality, is(8));
        assertThat(itemThatShouldHaveBeenUpdated.sellIn, is(-1));
    }

    @Test
    void testUpdateQuality_verifyAgedBrieIncreasesInQuality() {
        final String name = "Aged Brie";
        Item[] items = new Item[] { new Item(name, 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item itemThatShouldHaveBeenUpdated = app.items[0];
        assertThat(itemThatShouldHaveBeenUpdated.quality, is(6));
        assertThat(itemThatShouldHaveBeenUpdated.sellIn, is(4));
    }

    @Test
    void testUpdateQuality_verifyAgedBrieIncreasesInQuality_afterSellInIsLowerThanZero() {
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

    @Test
    void testUpdateQuality_verifyAgedBrieQualityCantBeMoreThan50() {
        final String name = "Aged Brie";
        Item[] items = new Item[] { new Item(name, 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item itemThatShouldHaveBeenUpdated = app.items[0];
        assertThat(itemThatShouldHaveBeenUpdated.quality, is(50));
        assertThat(itemThatShouldHaveBeenUpdated.sellIn, is(0));
    }

    @Test
    void testUpdateQuality_verifySulfurasNeverDecreasesInQuality() {
        final String name = "Sulfuras, Hand of Ragnaros";
        Item[] items = new Item[] { new Item(name, 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item itemThatShouldHaveBeenUpdated = app.items[0];
        assertThat(itemThatShouldHaveBeenUpdated.quality, is(80));
        assertThat(itemThatShouldHaveBeenUpdated.sellIn, is(0));
    }
    
    @Test
    void testUpdateQuality_verifyBackStagePassQualityIsZero_afterSellInIsLowerThanZero() {
        final String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(name, 0, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item itemThatShouldHaveBeenUpdated = app.items[0];
        assertThat(itemThatShouldHaveBeenUpdated.quality, is(0));
        assertThat(itemThatShouldHaveBeenUpdated.sellIn, is(-1));
    }

    @Test
    void testUpdateQuality_verifyBackStagePassQualityIncreasesByOne_whenSellInIsAbove10() {
        final String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(name, 11, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item itemThatShouldHaveBeenUpdated = app.items[0];

        assertThat(itemThatShouldHaveBeenUpdated.quality, is(16));
        assertThat(itemThatShouldHaveBeenUpdated.sellIn, is(10));
    }

    @Test
    void testUpdateQuality_verifyBackStagePassQualityIncreasesByTwo_whenSellInIsTenOrLower() {
        final String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(name, 10, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item itemThatShouldHaveBeenUpdated = app.items[0];

        assertThat(itemThatShouldHaveBeenUpdated.quality, is(17));
        assertThat(itemThatShouldHaveBeenUpdated.sellIn, is(9));
    }

    @Test
    void testUpdateQuality_verifyBackStagePassQualityIncreasesByThree_whenSellInIsFiveOrLower() {
        final String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(name, 5, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item itemThatShouldHaveBeenUpdated = app.items[0];

        assertThat(itemThatShouldHaveBeenUpdated.quality, is(18));
        assertThat(itemThatShouldHaveBeenUpdated.sellIn, is(4));
    }

    @Test
    void testUpdateQuality_verifyWhetherConjuredItemsDegradeTwiceAsFast() {
        final String name = "Conjured Mana Cake";
        Item[] items = new Item[] { new Item(name, 5, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item itemThatShouldHaveBeenUpdated = app.items[0];
        assertThat(itemThatShouldHaveBeenUpdated.quality, is(13));
        assertThat(itemThatShouldHaveBeenUpdated.sellIn, is(4));
    }

    @Test
    void testUpdateQuality_verifyWhetherConjuredItemsDegradeTwiceAsFast_whenSellInIsZero() {
        final String name = "Conjured Mana Cake";
        Item[] items = new Item[] { new Item(name, 0, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item itemThatShouldHaveBeenUpdated = app.items[0];
        assertThat(itemThatShouldHaveBeenUpdated.quality, is(11));
        assertThat(itemThatShouldHaveBeenUpdated.sellIn, is(-1));
    }
}
