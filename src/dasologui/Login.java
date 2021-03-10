package dasologui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;


import dasolo.DAO;
import dasolo.ManageDAO;
import dasolo.Saveid;
import dasolo.UserDAO;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JRadioButton rdbtn_user;
	private JRadioButton rdbtn_clerk;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		DAO dao = new DAO();
		dao.connect();
		dao.close();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(249, 250, 235));//배경색 변경
		frame.setBounds(100, 100, 500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		frame.setResizable(false);//창 조절x

		JPanel panel = new JPanel();
		panel.setBackground(new Color(249, 250, 235));//배경색 변경
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 16, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 130, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 480, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 120, SpringLayout.NORTH, panel);
		lblNewLabel_1.setIcon(new ImageIcon("./../etcImage/pop_img.GIF"));//광고
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, -1, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1, 463, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 130, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -4, SpringLayout.EAST, frame.getContentPane());
		panel_1.setBackground(new Color(249, 250, 235));//배경색 변경
		frame.getContentPane().add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JLabel lblNewLabel = new JLabel("");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, panel_1);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("./../etcImage/sol_login.png"));//솔마루글씨이미지
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 60));
		panel_1.add(lblNewLabel);

		textField = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.WEST, textField, 124, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, textField, -192, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField, -113, SpringLayout.EAST, panel_1);
		textField.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
			}
		});
		textField.setText(" \uC544\uC774\uB514");
		panel_1.add(textField);
		textField.setColumns(10);

		JButton btnNewButton_1 = new JButton("\uB85C\uADF8\uC778");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnNewButton_1, 310, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnNewButton_1, 181, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnNewButton_1, -174, SpringLayout.EAST, panel_1);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(242,183,5));
		
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel_1.add(btnNewButton_1);
		
				JButton btnNewButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
				sl_panel_1.putConstraint(SpringLayout.WEST, btnNewButton, 86, SpringLayout.WEST, panel_1);
				btnNewButton.setForeground(new Color(255, 255, 255));
				btnNewButton.setBackground(new Color(242,183,5));//라벨 배경색 변경
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Member_add add = new Member_add();
						frame.setVisible(false);//창 유지
						add.main(null);
					}
				});
				btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
				panel_1.add(btnNewButton);

		JRadioButton rdbtn_user = new JRadioButton("\uC0AC\uC6A9\uC790");
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField, 30, SpringLayout.SOUTH, rdbtn_user);
		sl_panel_1.putConstraint(SpringLayout.NORTH, rdbtn_user, 18, SpringLayout.SOUTH, lblNewLabel);
		rdbtn_user.setBackground(new Color(249, 250, 235));
		rdbtn_user.setSelected(true);
		panel_1.add(rdbtn_user);

		JRadioButton rdbtn_clerk = new JRadioButton("\uC810\uC8FC");
		sl_panel_1.putConstraint(SpringLayout.EAST, rdbtn_user, -30, SpringLayout.WEST, rdbtn_clerk);
		sl_panel_1.putConstraint(SpringLayout.NORTH, rdbtn_clerk, 0, SpringLayout.NORTH, rdbtn_user);
		sl_panel_1.putConstraint(SpringLayout.EAST, rdbtn_clerk, 0, SpringLayout.EAST, btnNewButton_1);
		rdbtn_clerk.setBackground(new Color(249, 250, 235));
		panel_1.add(rdbtn_clerk);

		// 라디오버튼 그룹화를 위한 버튼그룹 설정
		ButtonGroup group = new ButtonGroup();

		// 같은 그룹끼리는 그룹중에 1개만 선택된다.
		group.add(rdbtn_user);
		group.add(rdbtn_clerk);

		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserDAO udao = new UserDAO();
				ManageDAO mdao = new ManageDAO();
				if (rdbtn_user.isSelected() == true) {
					int result = udao.login(textField.getText(), textField_1.getText());
					if (result == 1) {// -1 아이디 없음 0 비밀번호 틀림 1 성공
						Service service = new Service();
						frame.setVisible(false);
						service.main(null);
						Saveid save = new Saveid();
						save.saveid(textField.getText());
					}
					else if(result == 0) {
						JOptionPane.showMessageDialog(frame, "비번이 틀렸어요.", "pw failed", JOptionPane.ERROR_MESSAGE);
					}
					else if(result == -1) {
						JOptionPane.showMessageDialog(frame, "아이디가 없습니다.", "id failed", JOptionPane.ERROR_MESSAGE);
					}
					else {//로그인이 return하는것중에 없을때
						JOptionPane.showMessageDialog(frame, "해킹하지 마세요", "어케했누", JOptionPane.ERROR_MESSAGE);
					}
				}
				if (rdbtn_clerk.isSelected() == true) {
					 int result = mdao.login(textField.getText(), textField_1.getText());
		               if (result == 1) {// -1 아이디 없음 0 비밀번호 틀림 1 성공
		                  Service service = new Service();
		                  frame.setVisible(false);
		                  Manage_service.main(null);
		                  Saveid save = new Saveid();
		                  save.saveid(textField.getText());
		               }
		               else if(result == 0) {
		                  JOptionPane.showMessageDialog(frame, "비번이 틀렸어요.", "pw failed", JOptionPane.ERROR_MESSAGE);
		               }
		               else if(result == -1) {
		                  JOptionPane.showMessageDialog(frame, "아이디가 없습니다.", "id failed", JOptionPane.ERROR_MESSAGE);
		               }
		               else {//로그인이 return하는것중에 없을때
		                  JOptionPane.showMessageDialog(frame, "해킹하지 마세요", "어케했누", JOptionPane.ERROR_MESSAGE);
		               }
				}

			}
		});
		
		JButton btnNewButton_2 = new JButton("\uACC4\uC815\uCC3E\uAE30");
		sl_panel_1.putConstraint(SpringLayout.EAST, btnNewButton, -38, SpringLayout.WEST, btnNewButton_2);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnNewButton_2, 244, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnNewButton_2, -102, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, btnNewButton_2);
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnNewButton_2, 17, SpringLayout.SOUTH, btnNewButton_1);
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(242,183,5));//라벨 배경색 변경
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Member_find find = new Member_find();
				frame.setVisible(true);
				find.main(null);
			}
		});
		btnNewButton_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 20, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2, 334, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -86, SpringLayout.NORTH, textField);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel, -6, SpringLayout.WEST, lblNewLabel_2);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2, -21, SpringLayout.EAST, panel_1);
		lblNewLabel_2.setIcon(new ImageIcon("./../etcImage/sol_tree.png"));//솔마루나무
		panel_1.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField_1, 11, SpringLayout.SOUTH, textField);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, textField_1, 281, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_1, -113, SpringLayout.EAST, panel_1);
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setText(" \uBE44\uBC00\uBC88\uD638");
		textField_1.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_1.setText("");
			}
		});
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, btnNewButton);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\yoons\\Desktop\\sol\\etcImage\\user.png"));
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -17, SpringLayout.NORTH, lblNewLabel_4);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_1, 14, SpringLayout.EAST, lblNewLabel_4);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 0, SpringLayout.NORTH, textField_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, btnNewButton);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\yoons\\Desktop\\sol\\etcImage\\locked.png"));
		panel_1.add(lblNewLabel_4);
		
		

	}
}
