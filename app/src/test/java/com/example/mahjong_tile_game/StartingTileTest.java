package com.example.mahjong_tile_game;

import org.junit.Test;
import static org.junit.Assert.*;

import com.example.mahjong_tile_game.model.mahjong_blocks.StartingTile;
import com.example.mahjong_tile_game.model.mahjong_blocks.Suit;

public class StartingTileTest {

    @Test
    public void startingTileCreationTest() {
        StartingTile tile = new StartingTile();

        assertNotNull(tile);
        assertEquals(1, tile.getRank());
        assertEquals(Suit.PURPLE, tile.getSuit());
    }

    @Test
    public void startingTileIncrementRankTest() {
        StartingTile tile = new StartingTile();

        tile.incrementRank();
        assertEquals("Rank needs to be incremented", 2, tile.getRank());
        assertEquals("Suit should not be changed",Suit.PURPLE, tile.getSuit());
    }
}
