package com.example.mahjong_tile_game.model.game_elements;

import androidx.annotation.NonNull;

public class MahjongBlock extends Block{
    private Status status;

    // don't want it to be accessed out side of this class
    private enum Status {
        UP, DOWN;

        @NonNull
        @Override
        public String toString() {
            switch (this) {
                case UP:
                    return "UP";
                case DOWN:
                    return "DOWN";
            }

            return "";
        }
    }

    public MahjongBlock(int rank, Suit suit) {
        super(rank, suit);
        status = Status.DOWN;
    }

    public MahjongBlock(int rank, Suit suit, Coordinate point) {
        super(rank, suit, point);
        status = Status.DOWN;
    }

    public boolean isUp() {
        return status == Status.UP;
    }

    public void setStatusUp() {
        status = Status.UP;
    } // push action

    // this information is only available when block is up
    @Override
    public int getRank() {
        return this.isUp() ? super.getRank() : -1;
    }

    @Override
    public Suit getSuit() {
        return this.isUp() ? super.getSuit() : Suit.UNKOWN;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        // if it is up you are allowed to compare the two objects
        if (obj instanceof MahjongBlock && this.isUp()) {
            MahjongBlock other = (MahjongBlock) obj;
            return this.getRank() == other.getRank() && this.getSuit() == other.getSuit()
                    && other.isUp() && this.isUp();
        }

        return false;
    }

    // toString purpose is to represent block, for debuging and testing
    @NonNull
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("  ");
        builder.append("Status: ");
        builder.append(this.status.toString());

        return builder.toString();
    }
}