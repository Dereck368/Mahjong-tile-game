package com.example.mahjong_tile_game.model.game_logic;

import com.example.mahjong_tile_game.model.mahjong_blocks.Block;
import com.example.mahjong_tile_game.model.mahjong_blocks.MahjongBlock;
import com.example.mahjong_tile_game.model.mahjong_blocks.StartingBlock;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ResolvableQueue {
    private Queue<Block> queue;
    private boolean resolved;
    private boolean block;
    private final int rank;
    private static final float MAX_NUMBER_OF_BLOCKS = 4;
    private float currentNumberOfBlocks;

    public  ResolvableQueue(int rank, List<MahjongBlock> blocks) {
        queue = new LinkedList<>();
        resolved = false;
        block = false;
        this.rank = rank;
        currentNumberOfBlocks = 0;

        initialFill(blocks);
    }

    private void initialFill(List<MahjongBlock> blocks) {
        queue.addAll(blocks);
    }

    //TODO set up cords for each object
    //TODO queue needs to know if it is up or down


    public Block moveIn(MahjongBlock block) throws Exception {
        if (this.isBlocked()) {
            throw new Exception("Resolvable queue is blocked");
        }

        if (block.getRank() == -1) {
            throw new Exception("Moving block that is faced Down In to Queue");
        }

        if (block.getRank() != rank) {
            throw new Exception("Moving block with wrong rank in to ResolvableQueue of rank: " + rank);
        }

        this.updateState();

        queue.add(block);
        Block returnedBlock = queue.remove();

        performActionOn(returnedBlock);

        return returnedBlock;
    }

    public Block moveIn(StartingBlock block) throws Exception {
        if (this.isBlocked()) {
            throw new Exception("Resolvable queue is blocked");
        }

        queue.add(block);
        Block returnedBlock = queue.remove();

        performActionOn(returnedBlock);

        return returnedBlock;
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
        currentNumberOfBlocks++;
        if (currentNumberOfBlocks == MAX_NUMBER_OF_BLOCKS) {
            this.block = true;
            this.resolved = true;
        }
    }

    public boolean isResolved() {
        return resolved;
    }

    public boolean isBlocked() {
        return block;
    }
}
