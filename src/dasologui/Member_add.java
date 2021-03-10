package dasologui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import dasolo.UserDAO;
import dasolo.UserVO;

import javax.swing.ImageIcon;

public class Member_add {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	int checkid = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Member_add window = new Member_add();
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
	public Member_add() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	// 라벨들의 위치가 조금씩 바꼈으니 그냥 아래 다 복붙 추천해요.(그래서 일부로 라벨이름도 기존 그대로 했어요.)

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 600);
		frame.getContentPane().setBackground(new Color(249, 250, 235));// 배경색 변경
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);

		JPanel panel = new JPanel();// 상단부 패널
		panel.setBackground(new Color(70, 115, 38));// 상단부 패널색 변경
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 111, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 474, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 6, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -95, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, panel);
		panel_1.setBackground(Color.WHITE);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 20, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 104, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 78, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -124, SpringLayout.EAST, panel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.BOLD, 50));
		panel.add(lblNewLabel);
		frame.getContentPane().add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		textField = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField, 66, SpringLayout.NORTH, panel_1);
		panel_1.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, textField_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField_1, 131, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_1, -124, SpringLayout.EAST, panel_1);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField_2, 41, SpringLayout.SOUTH, textField_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField_3, 30, SpringLayout.SOUTH, textField_2);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_3, 0, SpringLayout.EAST, textField);
		panel_1.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("NAME");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, textField_2);
		lblNewLabel_1.setForeground(new Color(185, 122, 87));// 글씨색 변경
		lblNewLabel_1.setFont(new Font("HY헤드라인M", Font.BOLD, 18));
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("ID");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel_2);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 3, SpringLayout.NORTH, textField);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2, 75, SpringLayout.WEST, panel_1);
		lblNewLabel_2.setForeground(new Color(185, 122, 87));
		lblNewLabel_2.setFont(new Font("HY헤드라인M", Font.BOLD, 18));
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("PW");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 3, SpringLayout.NORTH, textField_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel_2);
		lblNewLabel_3.setForeground(new Color(185, 122, 87));
		lblNewLabel_3.setFont(new Font("HY헤드라인M", Font.BOLD, 18));
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("TEL");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 3, SpringLayout.NORTH, textField_3);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel_1);
		lblNewLabel_4.setForeground(new Color(185, 122, 87));// 글씨색 변경
		lblNewLabel_4.setFont(new Font("HY헤드라인M", Font.BOLD, 18));
		panel_1.add(lblNewLabel_4);

		JLabel lbl_id_check = new JLabel("\uD655\uC778");// id체크
		sl_panel_1.putConstraint(SpringLayout.NORTH, lbl_id_check, 1, SpringLayout.NORTH, textField);
		sl_panel_1.putConstraint(SpringLayout.WEST, lbl_id_check, 6, SpringLayout.EAST, textField);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lbl_id_check, -64, SpringLayout.SOUTH, textField_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lbl_id_check, 54, SpringLayout.EAST, textField_1);
		lbl_id_check.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {// DB에 있는 id랑 입력한 id 비교-> 아이디체크
				UserDAO udao = new UserDAO();
				ArrayList<String> idlist = udao.check_id();
				checkid = -1;
				if (idlist.size() > 0) {
					for (int i = 0; i < idlist.size(); i++) {
						if (idlist.get(i).equals(textField.getText())) {
							JOptionPane.showMessageDialog(frame, "이미 있는 아이디 입니다.", "경고에요", JOptionPane.ERROR_MESSAGE);
							checkid = -1;
							break;
						} else {
							checkid = 1;
						}
					}
				} else {
					JOptionPane.showMessageDialog(frame, "사용가능한 아이디 입니다.", "축하해요", JOptionPane.INFORMATION_MESSAGE);
					checkid = 1;
				}
				JOptionPane.showMessageDialog(frame, "사용가능한 아이디 입니다.", "축하해요",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		lbl_id_check.setForeground(new Color(255, 255, 255));
		lbl_id_check.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id_check.setFont(new Font("HY헤드라인M", Font.BOLD, 16));
		lbl_id_check.setOpaque(true);
		lbl_id_check.setBackground(new Color(242, 183, 5));
		panel_1.add(lbl_id_check);

		JLabel tree_img = new JLabel("");// 나무 이미지 라벨(tree_img) 추가
		tree_img.setIcon(new ImageIcon("./../etcImage/sol_tree.png"));
		sl_panel_1.putConstraint(SpringLayout.SOUTH, tree_img, -10, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, tree_img, -10, SpringLayout.EAST, panel_1);
		panel_1.add(tree_img);

		JLabel lblNewLabel_5 = new JLabel("\uB4F1\uB85D");// 등록
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserDAO udao = new UserDAO();

				if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty()
						|| textField_3.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "모든 정보를 작성해 주세요.");
					// 창을 닫을지말지는오빠의 판단에 따르겠습니다. 시러여.
				}

				else {// 입력한 정보를 DB에 추가->창닫기
						// 입력한 정보를 DB에 추가
					if (checkid == 1) {
						UserVO uvo = new UserVO(textField.getText(), textField_1.getText(), textField_2.getText(),
								textField_3.getText());
						udao.insert(uvo);
						JOptionPane.showMessageDialog(frame, "회원가입 완료", "축하해요",
								JOptionPane.INFORMATION_MESSAGE);
						Login login = new Login();
						frame.setVisible(false);
						login.main(null);
					}
					else if(checkid == -1) {
						JOptionPane.showMessageDialog(frame, "아이디 체크를 해주세요", "검사하세요",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setBackground(new Color(242, 183, 5));// 라벨 배경색 변경
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("HY헤드라인M", Font.BOLD, 18));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_5, -47, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_5, -121, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_5, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel_5);
	}

}