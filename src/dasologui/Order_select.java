package dasologui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import dasolo.BasketDAO;
import dasolo.BasketVO;
import dasolo.OrderDAO;
import dasolo.OrderVO;
import dasolo.Saveid;
import dasolo.UserDAO;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Order_select {

	private JFrame frame;
	private JTable table;
	DefaultTableModel model;
	//MemberDAO dao;//사용할 dao
	int row;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order_select window = new Order_select();
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
	public Order_select() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 600);
		frame.getContentPane().setBackground(new Color(249, 250, 235));
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
		springLayout.putConstraint(SpringLayout.NORTH, panel, 141, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 62, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -47, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -63, SpringLayout.EAST, frame.getContentPane());
		panel.setOpaque(true);
		panel.setBackground(new Color(135, 206, 250));
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		//만들어진dao로 교체하기
		//dao = new MemberDAO();
		//ArrayList<MemberVO> list = dao.select();
		String[] colName = { "주문번호", "상품명", "수량", "대기인원"};
		

		String[][] data = new String[0][colName.length];

		
		model = new DefaultTableModel(data, colName);
		
		table = new JTable(model);
		Saveid sid = new Saveid();
		OrderDAO odao = new OrderDAO();
		BasketDAO bdao = new BasketDAO();
		ArrayList<OrderVO> ovolist = odao.find_usr_order(sid.getid());
		int j=5;
		for(int i = 0 ; i < ovolist.size() ; i ++) {
			BasketVO bvo = odao.get_basket(ovolist.get(i));
			String [] rowData = {ovolist.get(i).getOrder_num()+"",bvo.getFoodName(),bvo.getFoodCnt()+"",(j++)+""}; 
			model.addRow(rowData);
		}
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int column = table.getSelectedColumn();//선택한 col 가져오기
				row = table.getSelectedRow();// row 가져오기


			}
		});
//		panel.a	
		JLabel lblNewLabel = new JLabel("\uB4A4\uB85C");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, frame.getContentPane());
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Service service = new Service();
				frame.setVisible(false);
				service.main(null);
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel);
//		getContentPane();
//		frame.getContentPane().add(lblNewLabel);
		JScrollPane scorll = new JScrollPane(table);
		panel.add(scorll);
		
		JLabel lblNewLabel_1 = new JLabel("\uB2D8\uC758 \uC8FC\uBB38\uC870\uD68C");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 18, SpringLayout.SOUTH, panel_title);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 207, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -440, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, -107, SpringLayout.EAST, frame.getContentPane());
		lblNewLabel_1.setFont(new Font("굴림체", Font.BOLD, 25));
		frame.getContentPane().add(lblNewLabel_1);
		
		UserDAO udao = new UserDAO();
		JLabel lblNewLabel_2 = new JLabel(udao.get_usrinfo(sid.getid()).getUsrname());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 5, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 102, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -15, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, -8, SpringLayout.WEST, lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				///////////////////////업데이트 버튼
				//////////////////////// DB에서 대기번호 기능 넣어주세요
				//////////////////////
				//////////////////////
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon("./../etcImage/refresh.png"));
		sl_panel_title.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 10, SpringLayout.NORTH, panel_title);
		sl_panel_title.putConstraint(SpringLayout.EAST, lblNewLabel_3, -10, SpringLayout.EAST, panel_title);
		panel_title.add(lblNewLabel_3);
		lblNewLabel_2.setFont(new Font("굴림체", Font.BOLD, 25));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel_2);
	}
}