package tic_tac_toe;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class tic_tac_toe_board implements MouseListener{

	private JFrame frame;
	private String board_file_path = "/images/board.png";
	private String x_file_path = "/images/X.png";
	private String o_file_path = "/images/O.png";
	private String player_file_path;
	private String ai_file_path;
	private AI ai_logic;
	private char player;
	private char ai;
	private JLabel[][] board = new JLabel[3][3];
	private char[][] char_board = new char[3][3];

	/**
	 * Create the application.
	 */
	public tic_tac_toe_board(JFrame previous_frame, int player_letter, int ai_logic) {
		initialize(previous_frame);
		Set_Up_Player_And_AI_Settings(player_letter, ai_logic);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame previous_frame) {
		frame = new JFrame();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(100, 100, 800, 700);
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel title_label = new JLabel("Tic-Tac-Toe");
		title_label.setForeground(Color.WHITE);
		title_label.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 20));
		title_label.setBounds(10, 10, 766, 54);
		title_label.setHorizontalAlignment(SwingConstants.CENTER);
		title_label.setOpaque(true);
		title_label.setBackground(Color.blue);
		frame.getContentPane().add(title_label);
		
		JPanel board_panel = new JPanel();
		board_panel.setBounds(10, 69, 766, 539);
		frame.getContentPane().add(board_panel);
		board_panel.setLayout(null);
		
		JLabel board_label = new JLabel("");
		board_label.setBounds(0, 0, 766, 535);
		set_image_to_label(board_label, this.board_file_path);
		board_panel.add(board_label);
		
		JPanel x_o_panel = new JPanel();
		x_o_panel.setBounds(10, 10, 756, 525);
		board_panel.add(x_o_panel);
		x_o_panel.setLayout(null);
		
		JLabel label_0_0 = new JLabel("");
		label_0_0.setBounds(41, 10, 172, 136);
		x_o_panel.add(label_0_0);
		
		JLabel label_0_1 = new JLabel("");
		label_0_1.setBounds(290, 10, 172, 136);
		x_o_panel.add(label_0_1);
		
		JLabel label_0_2 = new JLabel("");
		label_0_2.setBounds(557, 10, 172, 136);
		x_o_panel.add(label_0_2);
		
		JLabel label_1_0 = new JLabel("");
		label_1_0.setBounds(46, 188, 172, 136);
		x_o_panel.add(label_1_0);
		
		JLabel label_1_1 = new JLabel("");
		label_1_1.setBounds(291, 188, 172, 136);
		x_o_panel.add(label_1_1);
		
		JLabel label_1_2 = new JLabel("");
		label_1_2.setBounds(533, 190, 172, 136);
		x_o_panel.add(label_1_2);
		
		JLabel label_2_0 = new JLabel("");
		label_2_0.setBounds(30, 379, 172, 136);
		x_o_panel.add(label_2_0);
		
		JLabel label_2_1 = new JLabel("");
		label_2_1.setBounds(290, 356, 172, 136);
		x_o_panel.add(label_2_1);
		
		JLabel label_2_2 = new JLabel("");
		label_2_2.setBounds(539, 362, 172, 136);
		x_o_panel.add(label_2_2);
		
		/**
		 * Setting up the board JLabels, and char board.
		 */
		Set_Up_Boards(x_o_panel);
		
		JPanel option_panel = new JPanel();
		option_panel.setBounds(10, 618, 766, 35);
		frame.getContentPane().add(option_panel);
		option_panel.setLayout(null);
		
		JButton quit_button = new JButton("QUIT");
		quit_button.setBounds(308, 10, 85, 21);
		quit_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				previous_frame.setVisible(true);
				frame.dispose();
			}
			
		});
		option_panel.add(quit_button);
		
		this.frame.setVisible(true);
	}
	
	/**
	 * Setting up the board JLabels, and char board.
	 */
	private void Set_Up_Boards(JPanel x_o_panel) {
		int row_index = 0;
		int column_index = 0;
		for(Component label: x_o_panel.getComponents()) {
			this.board[row_index][column_index] = (JLabel) label;
			if(column_index == 2) {
				column_index = 0;
				row_index++;
				label.addMouseListener(this);
				continue;
			}
			column_index++;
			label.addMouseListener(this);
		}
		Board_Logic.Fill_Char_Array(this.char_board);
	}
	
	/**
	 * Initializing the player letter, and the AI logic to use.
	 */
	private void Set_Up_Player_And_AI_Settings(int player_letter, int ai_logic) {
		if(player_letter == 0) {
			this.player = 'x';
			this.ai = 'o';
			this.player_file_path = this.x_file_path;
			this.ai_file_path = this.o_file_path;
		}
		else {
			this.player = 'o';
			this.ai = 'x';	
			this.player_file_path = this.o_file_path;
			this.ai_file_path = this.x_file_path;
		}
		if(ai_logic == 0) {
			this.ai_logic = new Easy_AI(this.player);
		}
		else if(ai_logic == 1) {
			this.ai_logic = new Medium_AI(this.player);
		}
		else {
			this.ai_logic = new Hard_AI(this.player);
		}
	}
	
	/**
	 * Sets an image to a JLabel.
	 */
	private void set_image_to_label(JLabel image_label, String file_name) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResource(file_name));
			Image dimg = image.getScaledInstance(image_label.getWidth(), image_label.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(dimg);
			image_label.setIcon(imageIcon);
		}catch(Exception e) {
			System.out.println("error: "+ e );
		}
	}

	/**
	 * Mouse clicked event, added to the JLabels in the GUI which represent the board.
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		JLabel label = (JLabel) arg0.getSource();
		if(label.getIcon() == null) {
			Player_Move(label);
			if(Check_For_Win() == false) {
				AI_Move();
			}
			Check_For_Win();
		}
	}
	/**
	 * Showing player move on the board.
	 */
	private void Player_Move(JLabel label) {
		set_image_to_label(label, this.player_file_path);
		int[] index = Board_Logic.Find_Index(this.board, label);
		this.char_board[index[0]][index[1]] = this.player;
	}
	
	/**
	 * Showing AI move.
	 */
	private void AI_Move() {
		int[] index = ai_logic.Make_Move(this.char_board);
		set_image_to_label(this.board[index[0]][index[1]], this.ai_file_path);
		this.char_board[index[0]][index[1]] = this.ai;
	}
	
	/**
	 * Check the board for win. 
	 */
	private boolean Check_For_Win() {
		char possible_win = Board_Logic.Has_Won(this.char_board);
		if(possible_win == 'x' || possible_win == 'o') {
			JOptionPane.showMessageDialog(null, possible_win + " HAS WON!");
			Board_Logic.Reset_Board(this.board, this.char_board);
			this.ai_logic.Reset();
			return true;
		}
		else if(possible_win =='f') {
			JOptionPane.showMessageDialog(null, "TIE!");
			Board_Logic.Reset_Board(this.board, this.char_board);
			this.ai_logic.Reset();
			return true;
		}
		return false;
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
