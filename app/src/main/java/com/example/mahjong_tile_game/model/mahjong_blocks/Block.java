package com.example.mahjong_tile_game.model.mahjong_blocks;

import androidx.annotation.NonNull;

/**
 * Block class is an abstract class
 * the reason this is an abstract class instead of
 * an interface is because other instances of blocks
 * need to be compared to each other
 *
 * @author dereck
 * @version 1.0
 */
abstract public class Block {
    private int rank;
    private final Suit suit;

    /**
     * nested interface used to control access to the {@code setRank} method.
     */
    protected interface RankSetter {
        void incrementRank();
    }

    public Block(int rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public final int getRank() {
        return rank;
    }

    public final Suit getSuit() {
        return suit;
    }

    protected final void setRank(int rank, RankSetter setter) {
        if (setter != null) {
            this.rank = rank;
        }
    }

    @Override
    public abstract boolean equals(Object obj);

    @NonNull
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("block Rank: ");
        builder.append(rank);
        builder.append("  ");
        builder.append("block Suit: ");
        builder.append(suit.toString());

        return builder.toString();
    }
}