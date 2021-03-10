package dasologui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import dasolo.DAO;
import dasolo.StoreDAO;
import dasolo.StoreVO;

public class Order {
	String 제라진돈까스 = "제라진돈까스";
	String salady = "salady";
	String 더큰도시락 = "더큰도시락";
	String 중화가정 = "중화가정";
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		DAO dao = new DAO();
		dao.connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order window = new Order();
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
	public Order() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(249, 250, 235));
		frame.setBounds(100, 100, 500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		frame.setResizable(false);
		
		//#####################여기부터 title################################
		
		
		JPanel panel_title = new JPanel();
		panel_title.setBackground(new Color(70, 115, 38));
		springLayout.putConstraint(SpringLayout.NORTH, panel_title, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_title, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_title, 50, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_title, 488, SpringLayout.WEST, frame.getContentPane());
		
		frame.getContentPane().add(panel_title);
		SpringLayout sl_panel_title = new SpringLayout();
		panel_title.setLayout(sl_panel_title);

		JLabel lbl_back = new JLabel("");
		sl_panel_title.putConstraint(SpringLayout.WEST, lbl_back, 10, SpringLayout.WEST, panel_title);
		sl_panel_title.putConstraint(SpringLayout.SOUTH, lbl_back, 50, SpringLayout.NORTH, panel_title);
		sl_panel_title.putConstraint(SpringLayout.EAST, lbl_back, 105, SpringLayout.WEST, panel_title);
		lbl_back.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_back.setIcon(new ImageIcon("./../etcImage/back.png"));
//		gbc_lbl_back.ipadx = 15;
		panel_title.add(lbl_back);
		springLayout.putConstraint(SpringLayout.NORTH, lbl_back, 209, SpringLayout.SOUTH, panel_title);
		springLayout.putConstraint(SpringLayout.WEST, lbl_back, 65, SpringLayout.WEST, frame.getContentPane());


		JLabel lbl_logo = new JLabel("");
		lbl_logo.setForeground(new Color(249, 250, 235));
		lbl_logo.setFont(new Font("동그라미재단B", Font.PLAIN, 30));
		sl_panel_title.putConstraint(SpringLayout.NORTH, lbl_logo, 0, SpringLayout.NORTH, panel_title);
		sl_panel_title.putConstraint(SpringLayout.WEST, lbl_logo, 19, SpringLayout.EAST, lbl_back);
		sl_panel_title.putConstraint(SpringLayout.SOUTH, lbl_logo, 0, SpringLayout.SOUTH, panel_title);
		sl_panel_title.putConstraint(SpringLayout.EAST, lbl_logo, -126, SpringLayout.EAST, panel_title);
		sl_panel_title.putConstraint(SpringLayout.NORTH, lbl_back, 0, SpringLayout.NORTH, lbl_logo);
		lbl_logo.setIcon(new ImageIcon("./../etcImage/logo.png"));
		lbl_logo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_title.add(lbl_logo);

		lbl_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {// 뒤로가기
				Service service = new Service();
				frame.setVisible(false);
				service.main(null);
			}
		});


		//#####################여기까지 title부분################################

		
		
		
		
		JPanel panel = new JPanel();
		
		//nownownow
		panel.setBackground(new Color(208,31,37));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chinese chinese= new Chinese();
				frame.setVisible(false);
				chinese.main(null);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, panel, 123, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 40, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 286, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 220, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Salad salad = new Salad();
				frame.setVisible(false);
				salad.main(null);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 35, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, 0, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 215, SpringLayout.EAST, panel);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_2, 25, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_2, 0, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_2, -70, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_2, 220, SpringLayout.WEST, frame.getContentPane());
		panel_2.setBackground(Color.WHITE);
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RiceBox ricebox = new RiceBox();
				frame.setVisible(false);
				ricebox.main(null);
			}
		});
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, -180, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -10, SpringLayout.EAST, panel);
		lblNewLabel.setIcon(new ImageIcon("./../etcImage/chinese.png"));
		panel.add(lblNewLabel);
		frame.getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_3, 25, SpringLayout.SOUTH, panel_1);
		springLayout.putConstraint(SpringLayout.WEST, panel_3, 35, SpringLayout.EAST, panel_2);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_3, -70, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_3, -43, SpringLayout.EAST, frame.getContentPane());
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cutlet cutlet = new Cutlet();
				frame.setVisible(false);
				cutlet.main(null);
			}
		});
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 53, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_4, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -48, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_4, -10, SpringLayout.EAST, panel_2);
		lblNewLabel_4.setIcon(new ImageIcon("./../etcImage/lunch.png"));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_4);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -27, SpringLayout.SOUTH, panel_1);
		lblNewLabel_2.setIcon(new ImageIcon("./../etcImage/salady.png"));
		panel_1.add(lblNewLabel_2);
		frame.getContentPane().add(panel_3);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);
		
		JLabel lblNewLabel_6 = new JLabel("");
		sl_panel_3.putConstraint(SpringLayout.NORTH, lblNewLabel_6, -153, SpringLayout.SOUTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel_6, 10, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, -10, SpringLayout.SOUTH, panel_3);
		lblNewLabel_6.setIcon(new ImageIcon("./../etcImage/don.png"));
		panel_3.add(lblNewLabel_6);
	}

}