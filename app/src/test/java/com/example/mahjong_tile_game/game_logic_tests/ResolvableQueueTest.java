package com.example.mahjong_tile_game.game_logic_tests;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.mahjong_tile_game.model.game_elements.Block;
import com.example.mahjong_tile_game.model.game_elements.MahjongBlock;
import com.example.mahjong_tile_game.model.game_elements.Suit;
import com.example.mahjong_tile_game.model.game_elements.Testing.MockPoint;
import com.example.mahjong_tile_game.model.game_logic.ResolvableQueue;

import java.util.ArrayList;
import java.util.List;

public class ResolvableQueueTest {
    private static List<MahjongBlock> blocks;
    private final int rank1 = 1;
    private final int rank2 = 2;

    @BeforeClass
    public static void getBlocks() {
        blocks = new ArrayList<>();
        for(int rank = 0; rank < 9; rank++) {
            MockPoint point = new MockPoint();
            blocks.add(new MahjongBlock(1, Suit.RED, point));
        }
    }

    @Test(expected=IllegalArgumentException.class)
    public void testResolvableQueueThrowsExceptionWhenTooManyBlocks() {
         new ResolvableQueue(rank1, blocks);
    }

    @Test
    public void testResolvableQueueCreation() {
        ResolvableQueue queue = new ResolvableQueue(rank1, blocks.subList(0,
                ResolvableQueue.maxInput()));
        assertNotNull(queue);
    }

    @Test
    public void testPushInFunctionExceptions() {
        ResolvableQueue queue = new ResolvableQueue(rank1, blocks.subList(0,
                ResolvableQueue.maxInput()));

        MahjongBlock block1 = new MahjongBlock(rank1, Suit.RED);
        MahjongBlock block2 = new MahjongBlock(rank2, Suit.RED);

        assertThrows(IllegalArgumentException.class, ()-> queue.pushIn(block2));
        block2.setStatusUp();
        assertThrows(IllegalArgumentException.class, ()-> queue.pushIn(block2));

        block1.setStatusUp();
        queue.pushIn(block1);
        queue.pushIn(block1);
        queue.pushIn(block1);
        queue.pushIn(block1);

        assertTrue("Queue is not Resolved after adding in 4 blocks of same rank"
                , queue.isResolved());

        assertThrows(IllegalStateException.class, ()-> queue.pushIn(block2) );
    }

    @Test
    public void testPushIn() {
        ResolvableQueue queue = new ResolvableQueue(rank1
                , blocks.subList(0,ResolvableQueue.maxInput()));

        MahjongBlock block = new MahjongBlock(rank1, Suit.RED);
        block.setStatusUp();

        //test if returned block is up
        Block returnedBlock= queue.pushIn(block);
        assertTrue(((MahjongBlock) returnedBlock).isUp());

        queue.pushIn(block);
        queue.pushIn(block);
        queue.pushIn(block);

        //test isResolved function
        assertTrue(queue.isResolved());
    }

    @Test
    public void testCoordinateOfBlocks() {
        int rank = 1;
        ResolvableQueue queue = new ResolvableQueue(rank, blocks.subList(0
                ,ResolvableQueue.maxInput()));

        for (int i = 0; i < ResolvableQueue.maxInput(); i++) {
            assertEquals(new MockPoint(rank, ResolvableQueue.maxInput() - i)
                    , blocks.get(i).getPoint());
        }
    }
}
