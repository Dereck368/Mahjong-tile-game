package com.example.mahjong_tile_game.model.game_elements;

import android.graphics.Point;

public class AndroidPoint implements Coordinate {

    private final Point point;

    public AndroidPoint() {
        point = new Point();
    }

    public AndroidPoint(int x, int y) {
        point = new Point(x, y);
    }

    @Override
    public int getX() {
        return point.x;
    }

    @Override
    public int getY() {
        return point.y;
    }

    @Override
    public void set(int x, int y) {
        point.set(x, y);
    }

    @Override
    public void offset(int x, int y) {

    }
}
