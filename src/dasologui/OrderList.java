package dasologui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.ServerSocket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import dasolo.BasketDAO;
import dasolo.ManageDAO;
import dasolo.ManageVO;
import dasolo.OrderDAO;
import dasolo.OrderVO;
import dasolo.Saveid;
import dasolo.StoreDAO;
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
import listner.MyEventHandler;
import listner.MyEventListener;
import soket.ServerSoket;

public class OrderList{

	private JFrame frame;
	private JTable table;
	DefaultTableModel model;
//	MemberDAO dao;
	int row;
	int column;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderList window = new OrderList();
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
	public OrderList() {
		//MyEventHandler.addListener(this);
		initialize();
	}
	public void refresh() {
		OrderDAO odao = new OrderDAO();
		Saveid sid = new Saveid();
		String id = sid.getid();
		ManageDAO mdao = new ManageDAO();
		ManageVO mvo = mdao.select(id);
		ArrayList<OrderVO> ovolist = odao.find_store_order(mvo.getManstore());

		// string 주면 orderlist가져올수 있게
		model.setRowCount(0);
		for (int i = 0; i < ovolist.size(); i++) {
			String[] rowData = { ovolist.get(i).getOrder_num() + "", odao.get_basket(ovolist.get(i)).getFoodName(),
					odao.get_basket(ovolist.get(i)).getFoodCnt()+"","완료" };
			// { "주문번호", "상품명", "수량", "완료"};
			model.addRow(rowData);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 600);
		frame.getContentPane().setBackground(new Color(249, 250, 235));// 배경색 변경
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		frame.setResizable(false);

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
				Manage_service m_service = new Manage_service();
				frame.setVisible(false);
				m_service.main(null);
			}
		});

		JLabel lbl_logout = new JLabel("");
		sl_panel_title.putConstraint(SpringLayout.NORTH, lbl_logout, 0, SpringLayout.NORTH, lbl_back);
		sl_panel_title.putConstraint(SpringLayout.WEST, lbl_logout, 6, SpringLayout.EAST, lbl_logo);
		sl_panel_title.putConstraint(SpringLayout.SOUTH, lbl_logout, 0, SpringLayout.SOUTH, panel_title);
		sl_panel_title.putConstraint(SpringLayout.EAST, lbl_logout, -20, SpringLayout.EAST, panel_title);
		lbl_logout.setFont(new Font("Georgia", Font.BOLD, 14));
		lbl_logout.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_logout.setIcon(new ImageIcon("./../etcImage/refresh.png"));
//		gbc_lbl_logout.ipadx = 15;
		panel_title.add(lbl_logout);
		springLayout.putConstraint(SpringLayout.WEST, lbl_logout, 152, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lbl_logout, -338, SpringLayout.SOUTH, frame.getContentPane());

		lbl_logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {// 주문들어온 목록 갱신
				refresh();
			}
		});

		// #############################title
		// end#################################################

		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 160, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 56, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -28, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -69, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));

		// 만들교체하기
//		dao = new MemberDAO();
//		ArrayList<MemberVO> list = dao.select();
		String[] colName = { "주문번호", "상품명", "수량", "완료" };
		String[][] data = new String[0][colName.length];
//		
//		for (int i = 0; i < list.size(); i++) {
//			for (int j = 0; j < colName.length; j++) {
//				if (j == 0) {
//					data[i][j] = list.get(i).getId();
//				} else if (j == 1) {
//					data[i][j] = list.get(i).getPw();
//				} else if (j == 2) {
//					data[i][j] = list.get(i).getAge() + "";
//				} else if (j == 3) {
//					data[i][j] = "X";
//				}
//			}
//		}
//		
		model = new DefaultTableModel(data, colName);

		table = new JTable(model);
		OrderDAO odao = new OrderDAO();
		Saveid sid = new Saveid();
		String id = sid.getid();
		ManageDAO mdao = new ManageDAO();
		ManageVO mvo = mdao.select(id);
		ArrayList<OrderVO> ovolist = odao.find_store_order(mvo.getManstore());

		// string 주면 orderlist가져올수 있게
		for (int i = 0; i < ovolist.size(); i++) {

			String[] rowData = { ovolist.get(i).getOrder_num() + "", odao.get_basket(ovolist.get(i)).getFoodName(),
					odao.get_basket(ovolist.get(i)).getFoodCnt()+"","완료" };
			// { "주문번호", "상품명", "수량", "완료"};
			model.addRow(rowData);
		}
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				column = table.getSelectedColumn();// 선택한 col 가져오기
				row = table.getSelectedRow();// row 가져오기
				OrderDAO odao = new OrderDAO();
				if (column == 3) {// 완료col 누르면 그때의 row 삭제
					StoreDAO sdao = new StoreDAO();
					ManageVO mvo = mdao.select(id);
					sdao.update_cnt_minus(mvo.getManstore());
					System.out.println(Integer.parseInt((String) table.getValueAt(row, 0)));
					odao.delete(Integer.parseInt((String) table.getValueAt(row, 0)));
					// dao.delete(list.get(row).getId());//해당row의 id를 가져와 데이터삭제
					model = (DefaultTableModel) table.getModel();
					System.out.println(model.getRowCount());
					for(int i = (int)model.getRowCount() ; i>0; i--) {
						if(Integer.parseInt((String) table.getValueAt(i-1, 0)) == Integer.parseInt((String) table.getValueAt(row, 0))) {
							model.removeRow(i-1);
						}
					}
				}
			}
		});

//		getContentPane();
//		frame.getContentPane().add(lblNewLabel);
		JScrollPane scorll = new JScrollPane(table);
		panel.add(scorll);
		Saveid saveid = new Saveid();
		UserDAO udao = new UserDAO();
	
		JLabel lblNewLabel = new JLabel(mvo.getManstore());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, panel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 35));
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("주문현황");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 22, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -18, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 35));
		frame.getContentPane().add(lblNewLabel_1);
		
		
//		while(true) {
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			//refresh();
//		}
	}

	
}
