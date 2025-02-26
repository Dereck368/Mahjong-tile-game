package com.example.mahjong_tile_game.model.mahjong_blocks;

public class MahjongBlock extends Block{
    private Status status;

    public enum Status {
        UP, DOWN
    }

    public MahjongBlock(int rank, Suit suit) {
        super(rank, suit);
        status = Status.DOWN;
    }

    public boolean isUp() {
        return status == Status.UP;
    }

    public void setStatusUp() {
        status = Status.UP;
    }

    //TODO might rename
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        // if it is up you are allowed to compare the two objects
        if (obj instanceof MahjongBlock && this.isUp()) {
            MahjongBlock other = (MahjongBlock) obj;
            return this.getRank() == other.getRank() && this.getSuit() == other.getSuit()
                    && other.isUp();
        }

        return false;
    }
}