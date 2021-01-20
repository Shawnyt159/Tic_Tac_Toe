package tic_tac_toe;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JLabel;

public class Board_Logic {
	public static char Has_Won(char[][] board) {
		char character = Check_Rows_For_Win(board);
		if(character == 'o' || character == 'x') {
			return character;
		}
		character = Check_Columns_For_Win(board);
		if(character == 'o' || character == 'x') {
			return character;
		}
		character = Check_Cross_For_Win(board);
		if(character == 'o' || character == 'x') {
			return character;
		}
		character = Check_For_Full_Board(board);
		if(character == 'f') {
			return 'f';
		}
		return '0';
	}
	
	private static char Check_Rows_For_Win(char[][] board) {
		Character[] row_array = new Character[3];
		boolean won = false;
		for(int row = 0; row < 3; row++) {
			for(int column = 0; column < 3; column++) {
				row_array[column] = board[row][column];
				won = Check_Array_For_Win(row_array);
			}
			if(won == true) {
				return row_array[0];
			}
		}
		return '0';
	}
	
	private static char Check_Columns_For_Win(char[][] board) {
		Character[] column_array = new Character[3];
		boolean won = false;
		for(int column = 0; column < 3; column++) {
			for(int row = 0; row < 3; row++) {
				column_array[row] = board[row][column];
				won = Check_Array_For_Win(column_array);
			}
			if(won == true) {
				return column_array[0];
			}
		}
		return '0';
	}
	
	private static char Check_Cross_For_Win(char[][] board) {
		Character[] cross_array = new Character[3];
		cross_array[0] = board[0][0];
		cross_array[1] = board[1][1];
		cross_array[2] = board[2][2];
		if(Check_Array_For_Win(cross_array)) {
			return cross_array[0];
		}
		cross_array[0] = board[0][2];
		cross_array[1] = board[1][1];
		cross_array[2] = board[2][0];
		if(Check_Array_For_Win(cross_array)) {
			return cross_array[0];
		}
		return '0';
	}
	
	private static char Check_For_Full_Board(char[][] board) {
		Character[] flat_array = new Character[9];
		int index = 0;
		for(int row = 0; row < 3; row++) {
			for(int column = 0; column < 3; column++) {
				flat_array[index] = board[row][column];
				index++;
			}
		}
		Set<Character> set = new HashSet<Character>(Arrays.asList(flat_array));
		if(!set.contains('0')) {
			return 'f';
		}
		return '0';
	}
	
	private static boolean Check_Array_For_Win(Character[] possible_array) {
		Set<Character> set = new HashSet<Character>(Arrays.asList(possible_array));
		if(set.size() == 1 && !set.contains('0')) {
			return true;
		}
		
		return false;
	}
	
	public static int[] Find_Index(JLabel[][] board, JLabel label) {
		for(int row = 0; row < 3; row++) {
			for(int column = 0; column < 3; column++) {
				if(label.equals(board[row][column])) {
					return new int[]{row, column};
				}
			}
		}
		return new int[] {4};
	}
	
	public static void Reset_Board(JLabel[][] board, char[][] char_board) {
		for(int row = 0; row < 3; row++) {
			for(int column = 0; column < 3; column++) {
				board[row][column].setIcon(null);
				char_board[row][column] = '0';
			}
		}
	}
	
	public static void Fill_Char_Array(char[][] char_board) {
		for(int row = 0; row < 3; row++) {
			for(int column = 0; column < 3; column++) {
				char_board[row][column] = '0';
			}
		}
	}
}
