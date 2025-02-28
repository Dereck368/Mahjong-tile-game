package com.example.mahjong_tile_game;

import org.junit.Test;
import static org.junit.Assert.*;

import android.graphics.Point;

import com.example.mahjong_tile_game.model.mahjong_blocks.StartingBlock;
import com.example.mahjong_tile_game.model.mahjong_blocks.Suit;

public class StartingBlockTest {

    @Test
    public void startingTileCreationTest() {
        StartingBlock Block = new StartingBlock();

        assertNotNull(Block);
        assertEquals(1, Block.getRank());
        assertEquals(Suit.PURPLE, Block.getSuit());
    }

    @Test
    public void startingTileIncrementRankTest() {
        StartingBlock tile = new StartingBlock();

        tile.incrementRank();
        assertEquals("Rank needs to be incremented", 2, tile.getRank());
        assertEquals("Suit should not be changed",Suit.PURPLE, tile.getSuit());
    }
}
