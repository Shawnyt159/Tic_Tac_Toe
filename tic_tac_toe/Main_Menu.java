package tic_tac_toe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Main_Menu implements MouseListener{

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Menu window = new Main_Menu();
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
	public Main_Menu() {
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
		
		JButton play_button = new JButton("PLAY");
		play_button.setForeground(Color.BLACK);
		play_button.setBackground(new Color(135, 206, 250));
		play_button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		play_button.setBounds(165, 138, 85, 30);
		play_button.addMouseListener(this);
		option_panel.add(play_button);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		@SuppressWarnings("unused")
		Player_Amount_GUI next_page = new Player_Amount_GUI();
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
