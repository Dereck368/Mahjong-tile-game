package com.example.mahjong_tile_game.model.mahjong_blocks;

import androidx.annotation.NonNull;
import android.graphics.Point;

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

    private final Point point;

    /**
     * nested interface used to control access to the {@code setRank} method.
     */
    protected interface RankSetter { void incrementRank(); }

    public Block(int rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        this.point = new Point();
    }


    public final int getRank() {
        return rank;
    }

    protected final void setRank(int rank, RankSetter setter) {
        if (setter != null) {
            this.rank = rank;
        }
    }

    public final Suit getSuit() {
        return suit;
    }

    public final Point getCopyOfPoint() { return new Point(point); }

    public final void setPoint(int x, int y) { point.set(x, y); }

    public final void offsetPoint(int x, int y) { point.offset(x, y); }

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
        builder.append("  ");
        if (this.point.x != 0 && this.point.y != 0) {
            builder.append("Coordinate: ");
            builder.append('(');
            builder.append(point.x);
            builder.append(",");
            builder.append(point.y);
            builder.append(')');
        }

        return builder.toString();
    }
}