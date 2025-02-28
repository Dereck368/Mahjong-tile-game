package com.example.mahjong_tile_game.model.game_logic;

import com.example.mahjong_tile_game.model.mahjong_blocks.MahjongBlock;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// doesn't care what suit it is just want to hold blocks and move them arround
public class GameTile {
    //TODO SWITCH FROM QUEUE DATASTRUCTURE TO RESOLVABLEQUEUE DSA
    private final Queue<MahjongBlock>[] mahjongBlockQueues;

    private boolean gameTileCompletion;

    private int numOfQueueResolved;

    @SuppressWarnings("unchecked")
    public GameTile() {
        mahjongBlockQueues = (Queue<MahjongBlock>[]) new LinkedList[9];

        for(int i = 0; i < 9; i++) {
            Queue<MahjongBlock> queue = new LinkedList<>();
            mahjongBlockQueues[i] = queue;
        }

        gameTileCompletion = false;
        numOfQueueResolved = 0;
    }

    public void insertBlocks(List<MahjongBlock> blocks) {
        int col = 0;
        int row = 0;

        for (MahjongBlock block : blocks) {
            if (row == 4) {
                col++;
                row = 0;
            }

            mahjongBlockQueues[col].add(block);
            row++;
        }
    }



}
