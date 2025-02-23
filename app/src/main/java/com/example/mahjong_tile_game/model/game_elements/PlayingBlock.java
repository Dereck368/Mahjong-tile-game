package com.example.mahjong_tile_game.model.game_elements;

public class PlayingBlock extends Block{
    private Status status;

    public enum Status {
        UP, DOWN;
    }

    public PlayingBlock(int number, Color color) {
        super(number, color);
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
        if (obj instanceof PlayingBlock && this.isUp()) {
            PlayingBlock other = (PlayingBlock) obj;
            return this.getNumber() == other.getNumber() && this.getColor() == other.getColor()
                    && other.isUp();
        }

        return false;
    }
}