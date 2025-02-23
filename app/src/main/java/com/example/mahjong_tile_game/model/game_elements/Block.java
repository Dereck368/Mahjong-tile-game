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
    private int number;
    private final Color color;

    /**
     * nested interface used to control access to the {@code setNumber} method.
     */
    protected interface NumberSetter {
        void incrementNumber();
    }

    public Block(int number, Color color) {
        this.number = number;
        this.color = color;
    }

    public final int getNumber() {
        return number;
    }

    public final Color getColor() {
        return color;
    }

    protected final void setNumber(int number, NumberSetter setter) {
        if (setter != null) {
            this.number = number;
        }
    }

    @Override
    public abstract boolean equals(Object obj);

    @NonNull
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("block number: ");
        builder.append(number);
        builder.append("  ");
        builder.append("block color: ");

        switch (color) {
            case RED:
                builder.append("RED");
                break;
            case BLUE:
                builder.append("BLUE");
                break;
            case PURPLE:
                builder.append("PURPLE");
                break;
        }

        return builder.toString();
    }
}