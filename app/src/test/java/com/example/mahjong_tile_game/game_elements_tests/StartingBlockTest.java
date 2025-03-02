package com.example.mahjong_tile_game.game_elements_tests;

import org.junit.Test;
import static org.junit.Assert.*;

import com.example.mahjong_tile_game.model.game_elements.StartingBlock;
import com.example.mahjong_tile_game.model.game_elements.Suit;

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
