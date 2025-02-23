package com.example.mahjong_tile_game.model.game_elements;

public class TurnMaker extends Block implements Block.NumberSetter {

    public TurnMaker(){
        super(1,Color.PURPLE);
    }

    @Override
    public void incrementNumber() {
        int incrementedNum = this.getNumber() + 1;
        setNumber(incrementedNum, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof TurnMaker) {
            TurnMaker other = (TurnMaker) obj;
            return this.getNumber() == other.getNumber() && this.getColor() == other.getColor();
        }

        return false;
    }
}
