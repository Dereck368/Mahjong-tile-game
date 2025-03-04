package com.example.mahjong_tile_game.model.game_elements;

public interface Coordinate {
    int getX();
    int getY();
    void set(int x, int y);
    void offset(int x, int y);
}
