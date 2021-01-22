package tic_tac_toe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Multiplayer_Menu_GUI {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public Multiplayer_Menu_GUI(JFrame previous_frame) {
		initialize(previous_frame);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame previous_frame) {
		frame = new JFrame();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(100, 100, 450, 345);
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel option_panel = new JPanel();
		option_panel.setBackground(new Color(245, 245, 220));
		option_panel.setBounds(10, 10, 416, 288);
		frame.getContentPane().add(option_panel);
		option_panel.setLayout(null);
		
		JLabel title_label = new JLabel("Tic-Tac-Toe");
		title_label.setForeground(Color.WHITE);
		title_label.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 20));
		title_label.setBounds(10, 10, 396, 65);
		title_label.setHorizontalAlignment(SwingConstants.CENTER);
		title_label.setOpaque(true);
		title_label.setBackground(Color.blue);
		option_panel.add(title_label);
		
		JComboBox<String> x_or_o_comboBox = new JComboBox<String>();
		x_or_o_comboBox.setFont(new Font("Times New Roman", Font.BOLD, 15));
		x_or_o_comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"X", "O"}));
		x_or_o_comboBox.setBounds(195, 85, 39, 21);
		option_panel.add(x_or_o_comboBox);
		
		JLabel x_or_o_label = new JLabel("Player 1, Choose X or O:");
		x_or_o_label.setFont(new Font("Times New Roman", Font.BOLD, 15));
		x_or_o_label.setBounds(10, 85, 175, 13);
		option_panel.add(x_or_o_label);
		
		JButton play_button = new JButton("PLAY");
		play_button.setForeground(Color.BLACK);
		play_button.setBackground(new Color(135, 206, 250));
		play_button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		play_button.setBounds(165, 185, 85, 30);
		play_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				tic_tac_toe_board_Multiplayer new_game = new tic_tac_toe_board_Multiplayer(frame, x_or_o_comboBox.getSelectedIndex());
				frame.setVisible(false);
			}
			
		});
		option_panel.add(play_button);
		
		JButton back_button = new JButton("BACK");
		back_button.setForeground(Color.BLACK);
		back_button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		back_button.setBackground(new Color(135, 206, 250));
		back_button.setBounds(165, 225, 85, 30);
		back_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				previous_frame.setVisible(true);
			}
			
		});
		option_panel.add(back_button);
		
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	}
	
	public void Set_Frame_Visibile() {
		this.frame.setVisible(true);
	}

}
