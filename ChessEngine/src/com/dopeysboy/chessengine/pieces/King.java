package com.dopeysboy.chessengine.pieces;

public class King extends ChessPiece{
	
	
	public King(boolean isWhite, int[][] position) {
		this.isWhite = isWhite;
		this.position = position;
		
		if(isWhite) {
			this.image = "\u2654";
		} else {
			this.image = "\u265A";
		}
	}
}
