package com.example.mahjong_tile_game.model.game_logic;

import com.example.mahjong_tile_game.model.game_elements.Block;
import com.example.mahjong_tile_game.model.game_elements.MahjongBlock;
import com.example.mahjong_tile_game.model.game_elements.StartingBlock;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ResolvableQueue {
    private final Queue<Block> queue;
    private boolean resolved;
    private final int rank;
    private static final int MAX_NUMBER_OF_BLOCKS_FOR_QUEUE = 4;
    private float currentNumberOfValidBlocks;

    public  ResolvableQueue(int rank, List<MahjongBlock> blocks) {
        queue = new LinkedList<>();
        resolved = false;
        this.rank = rank;
        currentNumberOfValidBlocks = 0;

        fillQueueWith(blocks);
    }

    private void fillQueueWith(List<MahjongBlock> blocks) {
        if (blocks.size() > 4) {
            throw new IllegalArgumentException("ResolvableQueue only takes in a list of size 4");
        }

        // Start from the bottom row
        int currentRow = 4;

        // putting blocks in grid format
        for (MahjongBlock block : blocks) {
            block.setPoint(rank, currentRow); // Rank is column, currentRow is row
            queue.add(block);
            currentRow--;
        }
    }

    public Block pushIn(Block block) {
        if (this.isResolved()) {
            throw new IllegalStateException("Resolvable queue is blocked");
        }

        if (block instanceof MahjongBlock) {
            isValid((MahjongBlock) block);
            this.updateState();
        }

        queue.add(block);
        Block blockPushedOut = queue.remove();

        performActionOn(blockPushedOut);

        return blockPushedOut;
    }

    private void isValid(MahjongBlock block) {
        if (!block.isUp()) {
            throw new IllegalArgumentException("Moving block that is faced DOWN into the Queue");
        }

        if (block.getRank() != rank) {
            throw new IllegalArgumentException("Moving block with wrong rank in to ResolvableQueue of rank: " + rank);
        }
    }

    private void performActionOn(Block block) {
        if (block instanceof MahjongBlock) {
            MahjongBlock mahjongBlock = (MahjongBlock) block;
            mahjongBlock.setStatusUp();

        } else {
            StartingBlock starterBlock = (StartingBlock) block;
            starterBlock.incrementRank();

        }
    }

    private void updateState() {
        currentNumberOfValidBlocks++;
        if (currentNumberOfValidBlocks == MAX_NUMBER_OF_BLOCKS_FOR_QUEUE) {
            this.resolved = true;
        }
    }

    public boolean isResolved() {
        return resolved;
    }

    public static int maxInput() {
        return MAX_NUMBER_OF_BLOCKS_FOR_QUEUE;
    }
}
