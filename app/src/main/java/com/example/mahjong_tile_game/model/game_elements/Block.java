package com.example.mahjong_tile_game.model.game_elements;

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

    private final Coordinate point;

    /**
     * nested interface used to control access to the {@code setRank} method.
     */
    protected interface RankSetter { void incrementRank(); }

    public Block(int rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        this.point = new AndroidPoint();
    }

    public Block(int rank, Suit suit, Coordinate point) {
        this.rank = rank;
        this.suit = suit;
        this.point= point; // Set custom position
    }


    public int getRank() {
        return rank;
    }

    protected final void setRank(int rank, RankSetter setter) {
        if (setter != null) {
            this.rank = rank;
        }
    }

    public Suit getSuit() {
        return suit;
    }

    public final Coordinate getPoint() { return point; }

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
        if (this.point.getX() != 0 && this.point.getY() != 0) {
            builder.append("Coordinate: ");
            builder.append('(');
            builder.append(point.getX());
            builder.append(",");
            builder.append(point.getY());
            builder.append(')');
        }

        return builder.toString();
    }
}