package com.example.mahjong_tile_game.model.game_logic;

import com.example.mahjong_tile_game.model.mahjong_blocks.Suit;
import com.example.mahjong_tile_game.model.mahjong_blocks.MahjongBlock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BlockFactory {

    private static final int TOTAL_BLOCKS = 72;
    private static final int BLOCKS_PER_PLAYER = TOTAL_BLOCKS / 2;

    public BlockFactory() {}

    private List<MahjongBlock> createMahjongBlocks() {
        List<MahjongBlock> blocks = new ArrayList<>();

        // 9 columns of blocks, and 4 rows
        // creates blocks 1-9 with a frequency of 4 for each block
        // i.e there would be 4 block 1s'
        // does this for both colors
        for (int rank = 1; rank < 10; rank++) {
            for (int freq = 0; freq < 4; freq ++) {
                blocks.add(new MahjongBlock(rank, Suit.BLUE));
                blocks.add(new MahjongBlock(rank, Suit.RED));
            }
        }

        return blocks;
    }

    private List<MahjongBlock> getRandomizedMahjongBlocks() {
        List<MahjongBlock> blocks = createMahjongBlocks();

        Collections.shuffle(blocks);
        return blocks;
    }

    private List<List<MahjongBlock>> splitBlocks(List<MahjongBlock> blocks) {
        List<MahjongBlock> split1 = blocks.subList(0, BLOCKS_PER_PLAYER);
        List<MahjongBlock> split2 = blocks.subList(BLOCKS_PER_PLAYER, TOTAL_BLOCKS);

        return Arrays.asList(split1, split2);
    }

    public List<List<MahjongBlock>> getDistributedBlocks() {
        List<MahjongBlock> blocks = getRandomizedMahjongBlocks();

        return splitBlocks(blocks);
    }

}