package com.example.mahjong_tile_game.model.game_logic;

import com.example.mahjong_tile_game.model.mahjong_blocks.MahjongBlock;

import java.util.List;

public class PlayerField {
    //TODO SWITCH FROM QUEUE DATASTRUCTURE TO RESOLVABLEQUEUE DSA
    private final ResolvableQueue[] blockField;
    private boolean playerFieldComplete;
    private int numOfQueuesResolved;
    public PlayerField(List<MahjongBlock> blocks) {
        blockField = new ResolvableQueue[9];

        int indexL = 0;
        int indexR = 4;

        //TODO THINK more about the way this loop works.

        for (int rank = 1; rank <= 9; rank++) {
            List<MahjongBlock> blockSubset = blocks.subList(indexL, indexR);

            ResolvableQueue resolvableQueue = new ResolvableQueue(rank, blockSubset);
            blockField[rank] = resolvableQueue;

            indexL = indexR;
            indexR += 4;
        }

        playerFieldComplete = false;
        numOfQueuesResolved = 0;
    }

}
