package com.example.mahjong_tile_game.model.mahjong_blocks;

import androidx.annotation.NonNull;

public enum Suit {
    RED, BLUE, PURPLE;

    @NonNull
    @Override
    public String toString() {

        switch (this) {
            case RED:
                return "RED";
            case BLUE:
                return "BLUE";
            case PURPLE:
                return "PURPLE";
        }

        return "";
    }
}