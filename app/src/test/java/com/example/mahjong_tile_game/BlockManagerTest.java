package com.example.mahjong_tile_game;

import com.example.mahjong_tile_game.model.game_logic.BlockManager;
import com.example.mahjong_tile_game.model.mahjong_blocks.MahjongBlock;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class BlockManagerTest {

    @Test
    public void testBlockManger() {
        BlockManager blockManager = new BlockManager();

        assertNotNull(blockManager);

        List<List<MahjongBlock>> listOfBlocks = blockManager.getDistributedBlocks();

        List<MahjongBlock> player1Blocks = listOfBlocks.get(0);
        List<MahjongBlock> player2Blocks = listOfBlocks.get(1);

        assertNotEquals(player1Blocks, player2Blocks);
        assertEquals(36, player1Blocks.size());
        assertEquals(36, player2Blocks.size());

        System.out.println("player1Blocks: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(player1Blocks.get(i));
        }

        System.out.println("player2Blocks: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(player2Blocks.get(i));
        }
    }
}
