package dasologui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JPanel;

public class Member_find {

	private JFrame frame;
	private JTextField txt_tel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Member_find window = new Member_find();
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
	public Member_find() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 277);
		frame.getContentPane().setBackground(new Color(249, 250, 235));//배경색 변경

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);//창닫기 방지
		frame.setResizable(false);//창 조절x
		
		
		txt_tel = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txt_tel, 86, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txt_tel, 186, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txt_tel, -129, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(txt_tel);
		txt_tel.setColumns(10);
		
		JLabel lbl_infoText = new JLabel("\uB4F1\uB85D\uD55C \uC804\uD654\uBC88\uD638\uB97C \uC785\uB825\uD558\uC138\uC694.");
		springLayout.putConstraint(SpringLayout.NORTH, lbl_infoText, 22, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lbl_infoText, 94, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lbl_infoText, -178, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lbl_infoText, -81, SpringLayout.EAST, frame.getContentPane());
		lbl_infoText.setForeground(Color.BLACK);// 글씨색 변경
		lbl_infoText.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		lbl_infoText.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lbl_infoText);
		
		JLabel lbl_tel = new JLabel("tel");
		springLayout.putConstraint(SpringLayout.NORTH, lbl_tel, 91, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lbl_tel, -46, SpringLayout.WEST, txt_tel);
		springLayout.putConstraint(SpringLayout.SOUTH, txt_tel, 0, SpringLayout.SOUTH, lbl_tel);
		lbl_tel.setForeground(Color.BLACK);
		lbl_tel.setFont(new Font("HY헤드라인M", Font.BOLD, 18));
		frame.getContentPane().add(lbl_tel);
		
		JLabel lbl_search = new JLabel("\uC870\uD68C");
		springLayout.putConstraint(SpringLayout.NORTH, lbl_search, -8, SpringLayout.NORTH, txt_tel);
		springLayout.putConstraint(SpringLayout.EAST, lbl_search, -44, SpringLayout.EAST, frame.getContentPane());
		lbl_search.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_search.setOpaque(true);
		lbl_search.setBackground(new Color(242,183,5));//라벨 배경색 변경
		lbl_search.setFont(new Font("HY헤드라인M", Font.BOLD, 18));
		lbl_search.setForeground(new Color(255, 255, 255));
		
		
		
		
		//추가한 부분
		//###################조회했을 때 보여줄 내용(id, pw)################################
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 128, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 113, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -47, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -131, SpringLayout.EAST, frame.getContentPane());
		panel.setBackground(new Color(249, 250, 235));
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lbl_id = new JLabel("id");
		panel.add(lbl_id);
		springLayout.putConstraint(SpringLayout.NORTH, lbl_id, 27, SpringLayout.SOUTH, lbl_search);
		springLayout.putConstraint(SpringLayout.EAST, lbl_id, -10, SpringLayout.EAST, frame.getContentPane());
		lbl_id.setFont(new Font("HY헤드라인M", Font.BOLD, 18));
		lbl_id.setForeground(Color.BLACK);
		
		JLabel lbl_getId = new JLabel("New label");
		panel.add(lbl_getId);
		springLayout.putConstraint(SpringLayout.NORTH, lbl_getId, 6, SpringLayout.SOUTH, txt_tel);
		springLayout.putConstraint(SpringLayout.EAST, lbl_getId, -28, SpringLayout.EAST, frame.getContentPane());
		lbl_getId.setForeground(Color.BLACK);// 글씨색 변경
		lbl_getId.setFont(new Font("HY헤드라인M", Font.BOLD, 18));
		
		JLabel lbl_pw = new JLabel("pw");
		panel.add(lbl_pw);
		springLayout.putConstraint(SpringLayout.EAST, lbl_pw, 0, SpringLayout.EAST, lbl_infoText);
		lbl_pw.setFont(new Font("HY헤드라인M", Font.BOLD, 18));
		lbl_pw.setForeground(Color.BLACK);
		
		JLabel lbl_getPw = new JLabel("New label");
		panel.add(lbl_getPw);
		springLayout.putConstraint(SpringLayout.NORTH, lbl_getPw, 33, SpringLayout.SOUTH, txt_tel);
		springLayout.putConstraint(SpringLayout.EAST, lbl_getPw, 0, SpringLayout.EAST, lbl_infoText);
		lbl_getPw.setForeground(Color.BLACK);// 글씨 색 변경
		lbl_getPw.setFont(new Font("HY헤드라인M", Font.BOLD, 18));
		springLayout.putConstraint(SpringLayout.NORTH, lbl_pw, 6, SpringLayout.SOUTH, lbl_getPw);
		
		panel.setVisible(false);//패널 숨기기
		
		//전에 코드 위쪽에 있던 조회 이벤트함수 아래로 옮겨뒀어요.
		lbl_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(txt_tel.getText().equals(txt_tel.getText())) {//입력한 번호가 번호 칼럼에 존재하는지 확인하고 있다면 패널 내용(조회한 id, pw)을 보여줌
					//해당번호의 아이디,비번을 가져와 라벨의 텍스트를 설정하고
					panel.setVisible(true);//결과를 담은 패널을 보여줍니다.
				}
				else {//없다면
					JOptionPane.showMessageDialog(null, "이 전화번호는 등록되지 않은 번호입니다.\n다시 입력하거나 회원가입을 하세요.");
				}
			}
		});
		frame.getContentPane().add(lbl_search);
		
		JLabel label = new JLabel("\uB2EB\uAE30");
		springLayout.putConstraint(SpringLayout.WEST, lbl_search, 0, SpringLayout.WEST, label);
		springLayout.putConstraint(SpringLayout.SOUTH, lbl_search, -92, SpringLayout.NORTH, label);
		springLayout.putConstraint(SpringLayout.WEST, label, 394, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, label, -13, SpringLayout.EAST, frame.getContentPane());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.NORTH, label, -42, SpringLayout.SOUTH, frame.getContentPane());
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, label, -10, SpringLayout.SOUTH, frame.getContentPane());
		label.setOpaque(true);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("HY헤드라인M", Font.BOLD, 18));
		label.setBackground(new Color(242, 183, 5));
		frame.getContentPane().add(label);
		
	}
}
