package com.example.mahjong_tile_game.game_elements_tests;

import com.example.mahjong_tile_game.model.game_elements.MahjongBlock;
import com.example.mahjong_tile_game.model.game_elements.Suit;

import org.junit.Test;
import static org.junit.Assert.*;

public class MahjongBlockTest {

    @Test
    public void testMahjongBlockCreation() {

        MahjongBlock redBlock = new MahjongBlock(1, Suit.RED);
        MahjongBlock blueBlock = new MahjongBlock(1, Suit.BLUE);

        System.out.println("initial creation:");
        System.out.println(redBlock);
        System.out.println(blueBlock);

        assertNotNull(redBlock);
        assertNotNull(blueBlock);
    }

    @Test
    public void testStatus() {
        MahjongBlock blueBlock = new MahjongBlock(1, Suit.BLUE);
        MahjongBlock redBlock = new MahjongBlock(2, Suit.RED);

        blueBlock.setStatusUp();

        assertTrue(blueBlock.isUp());
        assertFalse(redBlock.isUp());
    }

    @Test
    public void testEqualsMethod() {
        MahjongBlock block1 = new MahjongBlock(2, Suit.BLUE);
        MahjongBlock block2 = new MahjongBlock(2, Suit.BLUE);
        MahjongBlock differentBlock = new MahjongBlock(1, Suit.RED);

        // equals shouldn't return true unless it is up
        assertNotEquals(block1, block2);
        assertNotEquals(block1, differentBlock);

        // if one block is set up
        block1.setStatusUp();
        assertNotEquals(block1, block2);

        block2.setStatusUp();
        assertEquals(block1, block2);

        differentBlock.setStatusUp();
        assertNotEquals(block1, differentBlock);
    }

    @Test
    public void testGetRank() {
        MahjongBlock block = new MahjongBlock(2, Suit.BLUE);
        assertEquals(-1, block.getRank());

        block.setStatusUp();
        assertEquals(2, block.getRank());
    }

    @Test
    public void testGetSuit() {
        MahjongBlock block = new MahjongBlock(2, Suit.BLUE);
        assertEquals(Suit.UNKOWN, block.getSuit());

        block.setStatusUp();
        assertEquals(Suit.BLUE, block.getSuit());
    }
}