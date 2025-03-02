package com.example.mahjong_tile_game.model.game_elements;

import androidx.annotation.NonNull;

// grey suit is for when you don't know
public enum Suit {
    RED, BLUE, PURPLE, UNKOWN;

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