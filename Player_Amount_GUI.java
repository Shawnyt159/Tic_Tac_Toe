package tic_tac_toe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Player_Amount_GUI implements MouseListener{

	private JFrame frame;
	private boolean single_player_frame_exists = false;
	private boolean multiplayer_menu_exists = false;
	private Single_Player_Menu_GUI single_player_menu;
	private Multiplayer_Menu_GUI multiplayer_menu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Player_Amount_GUI window = new Player_Amount_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Player_Amount_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(100, 100, 450, 345);
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		
		JButton single_player_button = new JButton("Single Player");
		single_player_button.setForeground(Color.BLACK);
		single_player_button.setBackground(new Color(135, 206, 250));
		single_player_button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		single_player_button.setBounds(155, 138, 129, 30);
		single_player_button.addMouseListener(this);
		option_panel.add(single_player_button);
		
		JButton multiplayer_button = new JButton("Multiplayer");
		multiplayer_button.setForeground(Color.BLACK);
		multiplayer_button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		multiplayer_button.setBackground(new Color(135, 206, 250));
		multiplayer_button.setBounds(155, 178, 129, 30);
		multiplayer_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(multiplayer_menu_exists == false) {
					multiplayer_menu = new Multiplayer_Menu_GUI(frame);
					multiplayer_menu_exists = true;
				}
				else {
					multiplayer_menu.Set_Frame_Visibile();
				}
				frame.setVisible(false);
			}
			
		});
		option_panel.add(multiplayer_button);
		
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(this.single_player_frame_exists == false) {
			Single_Player_Menu_GUI single_player_page = new Single_Player_Menu_GUI(this.frame);
			this.single_player_menu = single_player_page;
			this.single_player_frame_exists = true;
		}
		else {
			this.single_player_menu.Set_Frame_Visible();
		}
		this.frame.setVisible(false);
		
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
