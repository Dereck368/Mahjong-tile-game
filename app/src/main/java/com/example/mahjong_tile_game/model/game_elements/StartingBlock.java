package com.example.mahjong_tile_game.model.game_elements;

public class StartingBlock extends Block implements Block.RankSetter {

    //TODO test creation and toString
    public StartingBlock() {
        super(1,Suit.PURPLE);
    }

    public StartingBlock(Coordinate point) {
        super(1, Suit.PURPLE, point);
    }

    @Override
    public void incrementRank() {
        int incrementedRank = this.getRank() + 1;
        setRank(incrementedRank, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof StartingBlock) {
            StartingBlock other = (StartingBlock) obj;
            return this.getRank() == other.getRank() && this.getSuit() == other.getSuit();
        }

        return false;
    }
}
