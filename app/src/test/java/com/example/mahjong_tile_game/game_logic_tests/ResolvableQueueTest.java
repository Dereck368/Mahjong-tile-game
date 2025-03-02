package com.example.mahjong_tile_game.game_logic_tests;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.mahjong_tile_game.model.game_elements.MahjongBlock;
import com.example.mahjong_tile_game.model.game_elements.Suit;
import com.example.mahjong_tile_game.model.game_logic.BlockFactory;
import com.example.mahjong_tile_game.model.game_logic.ResolvableQueue;

import java.util.List;

public class ResolvableQueueTest {

    private static List<MahjongBlock> blocks;

    @BeforeClass
    public static void getBlocks() {
        BlockFactory factory = new BlockFactory();
        blocks = factory.getDistributedBlocks().get(0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testResolvableQueueThrowsExceptionWhenTooManyBlocks() {
         new ResolvableQueue(1, blocks);
    }

    @Test
    public void testResolvableQueueCreation() {
        ResolvableQueue queue = new ResolvableQueue(1, blocks.subList(0,4));
        assertNotNull(queue);
    }

    @Test
    public void testPushInFunctionExceptions() {
        ResolvableQueue queue = new ResolvableQueue(1, blocks.subList(0,4));

        MahjongBlock block1 = new MahjongBlock(1, Suit.RED);
        MahjongBlock block2 = new MahjongBlock(2, Suit.RED);
        block1.setStatusUp();

        assertThrows(IllegalArgumentException.class, ()-> queue.pushIn(block2));
        block2.setStatusUp();
        assertThrows(IllegalArgumentException.class, ()-> queue.pushIn(block2));

        queue.pushIn(block1);
        queue.pushIn(block1);
        queue.pushIn(block1);
        queue.pushIn(block1);

        assertTrue("Queue is not Resolved after adding in 4 blocks of same rank"
                , queue.isResolved());

        assertThrows(IllegalStateException.class, ()-> queue.pushIn(block2) );
    }
}
