package dasologui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Manage_service {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_service window = new Manage_service();
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
	public Manage_service() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(249, 250, 235));//배경색변경
		frame.setBounds(100, 100, 500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		frame.setResizable(false);
		

		//#####################여기부터 title################################
		//sol_1의 서비스 title 과 같음(패널 색 변경)
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
		lbl_back.setIcon(new ImageIcon(""));
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

		

				
		//#####################여기까지 title부분################################

		
		
		

		JPanel panel = new JPanel();
		panel.setBackground(new Color(185, 122, 87));//패널 색 변경
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrderList orderlist = new OrderList();
				frame.setVisible(false);
				orderlist.main(null);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, panel, 123, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 40, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 286, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 220, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(185, 122, 87));//패널 색 변경
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Manage_Store store = new Manage_Store();
				frame.setVisible(false);
				store.main(null);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 35, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, 0, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 215, SpringLayout.EAST, panel);
		frame.getContentPane().add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(185, 122, 87));//패널 색 변경

		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Manage_Message m_msg = new Manage_Message();
				frame.setVisible(false);
				m_msg.main(null);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, panel_2, 25, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_2, 40, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_2, 188, SpringLayout.SOUTH, panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JLabel lblNewLabel = new JLabel("");
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -53, SpringLayout.EAST, panel);
		lblNewLabel.setIcon(new ImageIcon("./../etcImage/check-list.png"));//상대경로로 변경
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uC8FC\uBB38\uC870\uD68C");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -27, SpringLayout.NORTH, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1, -42, SpringLayout.EAST, panel);
		lblNewLabel_1.setFont(new Font("HY헤드라인M", Font.BOLD, 22));
		lblNewLabel_1.setForeground(Color.WHITE);
		panel.add(lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.EAST, panel_2, 220, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(185, 122, 87));//패널 색 변경
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageInfo m_info = new ManageInfo();
				frame.setVisible(false);
				m_info.main(null);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, panel_3, 25, SpringLayout.SOUTH, panel_1);
		springLayout.putConstraint(SpringLayout.WEST, panel_3, 35, SpringLayout.EAST, panel_2);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_3, 0, SpringLayout.SOUTH, panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("./../etcImage/email.png"));//상대경로로 변경
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("\uBA54\uC2DC\uC9C0");
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel_5);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -24, SpringLayout.NORTH, lblNewLabel_5);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, -10, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_5, -53, SpringLayout.EAST, panel_2);
		lblNewLabel_5.setFont(new Font("HY헤드라인M", Font.BOLD, 22));
		lblNewLabel_5.setForeground(Color.WHITE);
		panel_2.add(lblNewLabel_5);
		springLayout.putConstraint(SpringLayout.EAST, panel_3, 0, SpringLayout.EAST, panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2, -57, SpringLayout.EAST, panel_1);
		lblNewLabel_2.setIcon(new ImageIcon("./../etcImage/process.png"));//상대경로로 변경
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uB9E4\uC7A5\uAD00\uB9AC");
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -22, SpringLayout.NORTH, lblNewLabel_3);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_3, 43, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -10, SpringLayout.SOUTH, panel_1);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("HY헤드라인M", Font.BOLD, 22));
		panel_1.add(lblNewLabel_3);
		frame.getContentPane().add(panel_3);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("./../etcImage/avatar.png"));//상대경로로 변경
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel_6, 58, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, -68, SpringLayout.SOUTH, panel_3);
		panel_3.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("\uB0B4 \uC815\uBCF4");
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel_7, 49, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, lblNewLabel_7, -10, SpringLayout.SOUTH, panel_3);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("HY헤드라인M", Font.BOLD, 22));
		panel_3.add(lblNewLabel_7);
	}

}