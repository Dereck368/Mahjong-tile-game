package com.example.mahjong_tile_game.model.game_elements.Testing;

import com.example.mahjong_tile_game.model.game_elements.Coordinate;

public class MockPoint implements Coordinate {

    private int x;
    private int y;

    public MockPoint() {
        x = 0;
        y = 0;
    }

    public MockPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void offset(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof MockPoint) {
            MockPoint otherPoint = (MockPoint) obj;
            return this.getX() == otherPoint.getX() && this.getY() == otherPoint.getY();
        }

        return false;
    }
}
