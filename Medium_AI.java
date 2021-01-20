package tic_tac_toe;

import java.util.Random;

public class Medium_AI extends AI{
	private char player;
	public Medium_AI(char player) {
		this.player = player;
	}
	
	public int[] Make_Move(char[][] board){
		int[] possible_move = Row_Has_Two(board);
		if(possible_move[0] != 3) {
			return possible_move;
		}
		possible_move = Column_Has_Two(board);
		if(possible_move[0] != 3) {
			return possible_move;
		}
		possible_move = Cross_Has_Two(board);
		if(possible_move[0] != 3) {
			return possible_move;
		}
		
		boolean move_made = false;
		Random rand = new Random();
		while(move_made == false) {
			int index1 = rand.nextInt(3);
			int index2 = rand.nextInt(3);
			if(board[index1][index2] == '0') {
				return new int[] {index1, index2};
			}
		}
		return new int[] {4,4};
	}
	
	private int[] Row_Has_Two(char[][] board){
		char[] row_array = new char[3];
		String indexes = "";
		for(int row = 0; row < 3; row++) {
			for(int column = 0; column < 3; column++) {
				row_array[column] = board[row][column];
				indexes += Integer.toString(row) + "" + Integer.toString(column);
			}
			int[] possible_move = Check_Array_For_Two(row_array, indexes);
			if(possible_move[0] != 3) {
				return possible_move;
			}
			indexes = "";
		}
		return new int[] {3};
	}
	
	private int[] Column_Has_Two(char[][] board) {
		char[] column_array = new char[3];
		String indexes = "";
		for(int column = 0; column < 3; column++) {
			for(int row = 0; row < 3; row++) {
				column_array[row] = board[row][column];
				indexes += Integer.toString(row) + "" + Integer.toString(column);
			}
			int[] possible_move = Check_Array_For_Two(column_array, indexes);
			if(possible_move[0] != 3) {
				return possible_move;
			}
			indexes = "";
		}
		return new int[] {3};
	}
	
	private int[] Cross_Has_Two(char[][] board) {
		char[] cross_array = new char[] {board[0][0], board[1][1], board[2][2]};
		String indexes = "001122";
		int[] possible_move = Check_Array_For_Two(cross_array, indexes);
		if(possible_move[0] != 3) {
			return possible_move;
		}
		cross_array = new char[] {board[0][2], board[1][1], board[2][0]};
		indexes = "021120";
		possible_move = Check_Array_For_Two(cross_array, indexes);
		if(possible_move[0] != 3) {
			return possible_move;
		}
		return new int[] {3};
	}
	
	private int[] Check_Array_For_Two(char[] array, String indexes) {
		boolean array_is_full = true;
		for(int i = 0; i < array.length; i++) {
			if(array[i] == '0') {
				array_is_full = false;
			}
		}
		if(array_is_full == true) {
			return new int[] {3};
		}
		int location = Location_Of_Two_Spot(array);
		
		if(location == 3) {
			return new int[] {3};
		}
		else {
			return Get_Index_From_String(location, indexes);
		}
	}
	
	
	private int Location_Of_Two_Spot(char[] array) {
		if(array[0] == player && array[1] == player) {
			return 2;
		}
		else if(array[1] == player && array[2] == player) {
			return 0;
		}
		else if(array[0] == player && array[2] == player) {
			return 1;
		}
		return 3;
	}
	
	private int[] Get_Index_From_String(int location, String indexes) {
		if(location == 0) {
			indexes = indexes.substring(0,2);
		}
		else if(location == 1) {
			indexes = indexes.substring(2,4);
		}
		else if(location == 2) {
			indexes = indexes.substring(4);
		}
		int row = Integer.parseInt(String.valueOf(indexes.charAt(0)));
		int column = Integer.parseInt(String.valueOf(indexes.charAt(1)));
		return new int[] {row, column};
	}
	
}
