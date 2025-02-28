package com.example.mahjong_tile_game.model.mahjong_blocks;

public class StartingTile extends Block implements Block.RankSetter {

    //TODO test creation and toString
    public StartingTile() {
        super(1,Suit.PURPLE);
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

        if (obj instanceof StartingTile) {
            StartingTile other = (StartingTile) obj;
            return this.getRank() == other.getRank() && this.getSuit() == other.getSuit();
        }

        return false;
    }
}
