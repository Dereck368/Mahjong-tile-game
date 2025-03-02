package com.example.mahjong_tile_game.model.game_logic;

import com.example.mahjong_tile_game.model.game_elements.MahjongBlock;
import com.example.mahjong_tile_game.model.game_elements.Suit;

import java.util.List;

public class PlayerField {
    //TODO SWITCH FROM QUEUE DATASTRUCTURE TO RESOLVABLEQUEUE DSA
    private final ResolvableQueue[] field;
    private final Suit suit;
    private boolean playerFieldComplete;
    private int numOfQueuesResolved;
    public PlayerField(List<MahjongBlock> blocks, Suit suit) {
        field = new ResolvableQueue[9];
        int numBlocksPerQueue = ResolvableQueue.maxInput();
        int leftIndex = 0;

        for (int rank = 1; rank <= 9; rank++) {
            int rightIndex = leftIndex + numBlocksPerQueue;
            List<MahjongBlock> blockSubset = blocks.subList(leftIndex, rightIndex);

            field[rank] = new ResolvableQueue(rank, blockSubset);
            leftIndex = rightIndex;
        }

        playerFieldComplete = false;
        numOfQueuesResolved = 0;
        this.suit = suit;
    }

}
