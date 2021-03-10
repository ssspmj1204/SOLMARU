package dasologui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Edit_MyInfo {

	JFrame frame;
	private JTextField txt_new_pw;
	private JTextField txt_new_tel;
	private JTextField txt_now_pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit_MyInfo window = new Edit_MyInfo();
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
	public Edit_MyInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(620, 100, 500, 600);// 옆에 띄워지게
		frame.getContentPane().setBackground(new Color(249, 250, 235));// 배경색 변경
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);//창닫기 방지
		frame.setResizable(false);//창 조절x

		// ##########################title start###############################

		JPanel panel_title = new JPanel();
		panel_title.setBackground(new Color(70, 115, 38));// 상단부 패널색 변경
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
//				gbc_lbl_back.ipadx = 15;
		panel_title.add(lbl_back);
		springLayout.putConstraint(SpringLayout.NORTH, lbl_back, 209, SpringLayout.SOUTH, panel_title);
		springLayout.putConstraint(SpringLayout.WEST, lbl_back, 65, SpringLayout.WEST, frame.getContentPane());

		JLabel lbl_logo = new JLabel("");
		sl_panel_title.putConstraint(SpringLayout.NORTH, lbl_logo, 0, SpringLayout.NORTH, panel_title);
		sl_panel_title.putConstraint(SpringLayout.WEST, lbl_logo, 19, SpringLayout.EAST, lbl_back);
		sl_panel_title.putConstraint(SpringLayout.SOUTH, lbl_logo, 0, SpringLayout.SOUTH, panel_title);
		sl_panel_title.putConstraint(SpringLayout.EAST, lbl_logo, -126, SpringLayout.EAST, panel_title);
		sl_panel_title.putConstraint(SpringLayout.NORTH, lbl_back, 0, SpringLayout.NORTH, lbl_logo);
		lbl_logo.setIcon(new ImageIcon("./../etcImage/logo.png"));
		lbl_logo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_title.add(lbl_logo);

		// #############################title end#################################################

		//제출 라벨
		JLabel lbl_submit = new JLabel("\uC218\uC815\uC644\uB8CC");
		springLayout.putConstraint(SpringLayout.NORTH, lbl_submit, -52, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lbl_submit, -111, SpringLayout.EAST, frame.getContentPane());
		lbl_submit.setOpaque(true);
		lbl_submit.setBackground(new Color(242, 183, 5));// 라벨 색 변경
		lbl_submit.setFont(new Font("HY헤드라인M", Font.BOLD, 20));// 글씨 크기 20으로
		lbl_submit.setForeground(Color.WHITE);
		lbl_submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {// 수정완료
				// 수정할 정보가 입력되어있다면 회원 DB업데이트

				if (!(txt_new_pw.getText().isEmpty())) {// 새 비밀번호가 입력되어있다면
					// DB 업데이트
				} else if (!(txt_new_tel.getText().isEmpty())) {// 새 전호번호가 입력되어있다면
					// DB 업데이트
				} else {//수정할 내용 없을 때
					frame.setVisible(false);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, lbl_submit, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lbl_submit, -10, SpringLayout.EAST, frame.getContentPane());
		lbl_submit.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lbl_submit);

		
		// 정보 패널
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 76, SpringLayout.SOUTH, panel_title);
		springLayout.putConstraint(SpringLayout.WEST, panel, 61, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -98, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -5, SpringLayout.WEST, lbl_submit);
		panel.setBackground(new Color(249, 250, 235));// 배경색 변경
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 130, 164 };
		gbl_panel.rowHeights = new int[] { 67, 67, 67, 67, 67, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lbl_name = new JLabel("\uC774\uB984");
		lbl_name.setFont(new Font("굴림체", Font.BOLD, 20));
		lbl_name.setForeground(new Color(185, 122, 87));// 글씨색 변경
		GridBagConstraints gbc_lbl_name = new GridBagConstraints();
		gbc_lbl_name.fill = GridBagConstraints.BOTH;
		gbc_lbl_name.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_name.gridx = 0;
		gbc_lbl_name.gridy = 0;
		panel.add(lbl_name, gbc_lbl_name);
		springLayout.putConstraint(SpringLayout.WEST, lbl_name, 23, SpringLayout.WEST, frame.getContentPane());
		lbl_name.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lbl_id = new JLabel("\uC544\uC774\uB514");
		lbl_id.setFont(new Font("굴림체", Font.BOLD, 20));
		lbl_id.setForeground(new Color(185, 122, 87));// 글씨색 변경
		GridBagConstraints gbc_lbl_id = new GridBagConstraints();
		gbc_lbl_id.fill = GridBagConstraints.BOTH;
		gbc_lbl_id.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_id.gridx = 0;
		gbc_lbl_id.gridy = 1;
		panel.add(lbl_id, gbc_lbl_id);
		springLayout.putConstraint(SpringLayout.WEST, lbl_id, 83, SpringLayout.WEST, frame.getContentPane());
		lbl_id.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lbl_getName = new JLabel("New label");
		lbl_getName.setFont(new Font("굴림체", Font.BOLD, 20));
		lbl_getName.setForeground(new Color(185, 122, 87));// 글씨색 변경
		GridBagConstraints gbc_lbl_getName = new GridBagConstraints();
		gbc_lbl_getName.fill = GridBagConstraints.BOTH;
		gbc_lbl_getName.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_getName.gridx = 1;
		gbc_lbl_getName.gridy = 0;
		panel.add(lbl_getName, gbc_lbl_getName);
		springLayout.putConstraint(SpringLayout.NORTH, lbl_name, 0, SpringLayout.NORTH, lbl_id);

		JLabel lbl_getId = new JLabel("New label");
		lbl_getId.setFont(new Font("굴림체", Font.BOLD, 20));
		lbl_getId.setForeground(new Color(185, 122, 87));// 글씨색 변경
		GridBagConstraints gbc_lbl_getId = new GridBagConstraints();
		gbc_lbl_getId.fill = GridBagConstraints.BOTH;
		gbc_lbl_getId.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_getId.gridx = 1;
		gbc_lbl_getId.gridy = 1;
		panel.add(lbl_getId, gbc_lbl_getId);

		JLabel lbl_Pw = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lbl_Pw.setFont(new Font("굴림체", Font.BOLD, 20));
		lbl_Pw.setForeground(new Color(185, 122, 87));// 글씨색 변경
		lbl_Pw.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lbl_Pw = new GridBagConstraints();
		gbc_lbl_Pw.fill = GridBagConstraints.BOTH;
		gbc_lbl_Pw.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_Pw.gridx = 0;
		gbc_lbl_Pw.gridy = 2;
		panel.add(lbl_Pw, gbc_lbl_Pw);
		springLayout.putConstraint(SpringLayout.WEST, lbl_Pw, 61, SpringLayout.WEST, frame.getContentPane());

		txt_now_pw = new JTextField();
		GridBagConstraints gbc_txt_now_pw = new GridBagConstraints();
		gbc_txt_now_pw.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_now_pw.insets = new Insets(0, 0, 5, 0);
		gbc_txt_now_pw.gridx = 1;
		gbc_txt_now_pw.gridy = 2;
		panel.add(txt_now_pw, gbc_txt_now_pw);
		txt_now_pw.setColumns(10);

		JLabel lbl_newPw = new JLabel("\uC0C8 \uBE44\uBC00\uBC88\uD638");
		lbl_newPw.setFont(new Font("굴림체", Font.BOLD, 20));
		lbl_newPw.setForeground(new Color(185, 122, 87));// 글씨색 변경
		lbl_newPw.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lbl_newPw = new GridBagConstraints();
		gbc_lbl_newPw.fill = GridBagConstraints.BOTH;
		gbc_lbl_newPw.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_newPw.gridx = 0;
		gbc_lbl_newPw.gridy = 3;
		panel.add(lbl_newPw, gbc_lbl_newPw);

		txt_new_pw = new JTextField();
		GridBagConstraints gbc_txt_new_pw = new GridBagConstraints();
		gbc_txt_new_pw.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_new_pw.insets = new Insets(0, 0, 5, 0);
		gbc_txt_new_pw.gridx = 1;
		gbc_txt_new_pw.gridy = 3;
		panel.add(txt_new_pw, gbc_txt_new_pw);
		springLayout.putConstraint(SpringLayout.EAST, txt_new_pw, -25, SpringLayout.WEST, lbl_submit);
		txt_new_pw.setColumns(10);

		JLabel lbl_newTel = new JLabel("\uC0C8 \uC804\uD654\uBC88\uD638");
		lbl_newTel.setFont(new Font("굴림체", Font.BOLD, 20));
		lbl_newTel.setForeground(new Color(185, 122, 87));// 글씨색 변경
		lbl_newTel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lbl_newTel = new GridBagConstraints();
		gbc_lbl_newTel.fill = GridBagConstraints.BOTH;
		gbc_lbl_newTel.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_newTel.gridx = 0;
		gbc_lbl_newTel.gridy = 4;
		panel.add(lbl_newTel, gbc_lbl_newTel);
		springLayout.putConstraint(SpringLayout.WEST, lbl_newTel, 117, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lbl_Pw, 3, SpringLayout.NORTH, txt_new_tel);

		txt_new_tel = new JTextField();
		GridBagConstraints gbc_txt_new_tel = new GridBagConstraints();
		gbc_txt_new_tel.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_new_tel.gridx = 1;
		gbc_txt_new_tel.gridy = 4;
		panel.add(txt_new_tel, gbc_txt_new_tel);
		springLayout.putConstraint(SpringLayout.WEST, txt_new_tel, 161, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txt_new_tel, -26, SpringLayout.NORTH, lbl_submit);
		springLayout.putConstraint(SpringLayout.EAST, txt_new_tel, -78, SpringLayout.EAST, frame.getContentPane());
		txt_new_tel.setColumns(10);

		JLabel lbl_checkPw = new JLabel("\uD655\uC778");
		springLayout.putConstraint(SpringLayout.WEST, lbl_checkPw, 8, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.EAST, lbl_checkPw, -64, SpringLayout.EAST, frame.getContentPane());
		lbl_checkPw.setOpaque(true);
		lbl_checkPw.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_checkPw.setForeground(new Color(255, 255, 255));
		lbl_checkPw.setBackground(new Color(242, 183, 5));// 라벨 색 변경
		lbl_checkPw.setFont(new Font("HY헤드라인M", Font.BOLD, 18));
		springLayout.putConstraint(SpringLayout.NORTH, lbl_checkPw, 229, SpringLayout.SOUTH, panel_title);
		springLayout.putConstraint(SpringLayout.SOUTH, lbl_checkPw, -207, SpringLayout.NORTH, lbl_submit);
		frame.getContentPane().add(lbl_checkPw);
		
		JLabel label = new JLabel("\uB2EB\uAE30");//닫기 버튼
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, lbl_submit);
		springLayout.putConstraint(SpringLayout.WEST, label, -97, SpringLayout.WEST, lbl_submit);
		springLayout.putConstraint(SpringLayout.SOUTH, label, 0, SpringLayout.SOUTH, lbl_submit);
		springLayout.putConstraint(SpringLayout.EAST, label, -6, SpringLayout.WEST, lbl_submit);
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		label.setBackground(new Color(242, 183, 5));
		frame.getContentPane().add(label);

		lbl_checkPw.addMouseListener(new MouseAdapter() {// 현재 비밀번호와 일치 유무에 따른 다이얼로그 메시지
			@Override
			public void mouseClicked(MouseEvent arg0) {
//				if(list.get(i).getPw().equals(textField.getText()))
//					JOptionPane.showMessageDialog(null, "정확한 비밀번호를 입력해주세요.");
//			else
				JOptionPane.showMessageDialog(null, "비밀번호 확인 완료");

			}
		});

	}
}
