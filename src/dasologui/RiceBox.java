package dasologui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;

import dasolo.BasketDAO;
import dasolo.BasketVO;
import dasolo.FoodDAO;
import dasolo.FoodVO;
import dasolo.OrderDAO;
import dasolo.OrderVO;
import dasolo.Saveid;
import dasolo.StoreDAO;
import dasolo.StoreVO;
import dasolo.gui_dao;

import java.awt.SystemColor;
import java.awt.CardLayout;

public class RiceBox {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	static DefaultTableModel model;
	static JLabel lblNewLabel_4;
	static int all_price = 0;
	int row;
	int column;
	ArrayList<FoodVO> foodlist;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RiceBox window = new RiceBox();
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
	public RiceBox() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// 바탕 색
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(249, 250, 235));
		frame.setBounds(100, 100, 500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		frame.setResizable(false);

		// #####################여기부터 title################################

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
//	      gbc_lbl_back.ipadx = 15;
		panel_title.add(lbl_back);
		springLayout.putConstraint(SpringLayout.NORTH, lbl_back, 209, SpringLayout.SOUTH, panel_title);
		springLayout.putConstraint(SpringLayout.WEST, lbl_back, 65, SpringLayout.WEST, frame.getContentPane());

		lbl_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {// 뒤로가기
				Order order = new Order();
				frame.setVisible(false);
				Order.main(null);
			}
		});

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

		// 업데이트 버튼
		JLabel lbl_update = new JLabel("");
		sl_panel_title.putConstraint(SpringLayout.NORTH, lbl_update, 0, SpringLayout.NORTH, lbl_back);
		sl_panel_title.putConstraint(SpringLayout.WEST, lbl_update, -58, SpringLayout.EAST, panel_title);
		sl_panel_title.putConstraint(SpringLayout.SOUTH, lbl_update, 0, SpringLayout.SOUTH, lbl_back);
		sl_panel_title.putConstraint(SpringLayout.EAST, lbl_update, 0, SpringLayout.EAST, panel_title);
		lbl_update.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		lbl_update.setIcon(new ImageIcon("./../etcImage/refresh.png"));
		panel_title.add(lbl_update);

		JPanel panel = new JPanel();
		String[] colName = { "상품명", "가격", "수량", "삭제" };
		String[][] data = new String[0][colName.length];
		model = new DefaultTableModel(data, colName);
		table = new JTable(model);
		table.setRowSelectionAllowed(false);
		table.setCellSelectionEnabled(true);

		BasketDAO bdao = new BasketDAO();
		Saveid save = new Saveid();
		ArrayList<BasketVO> bvo = bdao.select(save.getid());
		OrderDAO odao = new OrderDAO();
		// 장바구니db에 있는 값중 주문db에 있는 값을 제외하고 테이블에 추가 시작
		ArrayList<OrderVO> ovolist = odao.select();
		for (int i = 0; i < bvo.size(); i++) {
			int cnt = 0;
			for (int j = 0; j < ovolist.size(); j++) {
				if (ovolist.get(j).getBasket_key().equals(bvo.get(i).getBasketkey())) {
					break;
				} else
					cnt++;

			}
			if (cnt == ovolist.size()) {
				String[] rowData = { bvo.get(i).getFoodName(), bvo.get(i).getMoney() + "", bvo.get(i).getFoodCnt() + "",
						"삭제" };
				model.addRow(rowData);
			}
		}
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				column = table.getSelectedColumn();// 선택한 col 가져오기
				row = table.getSelectedRow();// row 가져오기
				BasketDAO dao = new BasketDAO();
				Saveid save = new Saveid();
				System.out.println(column + " " + row);
				if (column == 3) {// 완료col 누르면 그때의 row 삭제
					all_price -= Integer.parseInt((String) table.getValueAt(row, 1));
					dao.delete(save.getid(), (String) table.getValueAt(row, 0));// 해당row의 id를 가져와 데이터삭제 foodname 추가해야함
					model = (DefaultTableModel) table.getModel();
					model.removeRow(row);//
					lblNewLabel_4.setText(all_price + "");
				}
			}

		});
		panel.setLayout(new CardLayout(0, 0));

		JScrollPane scroll_table = new JScrollPane(table);
		panel.add(scroll_table, "name_13429359067100");

		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 334, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);

		JLabel label_2 = new JLabel("");
		panel.add(label_2, "name_13429376943600");

		JLabel label_3 = new JLabel("");
		panel.add(label_3, "name_13429401859500");

		JLabel label_1 = new JLabel("");
		panel.add(label_1, "name_13429423997300");

		JLabel lblNewLabel_1 = new JLabel("더큰도시락");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 16, SpringLayout.SOUTH, panel_title);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 21, SpringLayout.WEST, frame.getContentPane());
		lblNewLabel_1.setFont(new Font("궁서", Font.PLAIN, 30));
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("대기인원 :");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 11, SpringLayout.NORTH, lblNewLabel_1);
		lblNewLabel_2.setFont(new Font("굴림체", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel_2);

		StoreDAO sdao = new StoreDAO();
		StoreVO svo = sdao.select("더큰도시락");
		JLabel lblNewLabel = new JLabel(svo.getDelaynum() + "");
		lblNewLabel.setForeground(Color.RED);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, -6, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 11, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -28, SpringLayout.EAST, frame.getContentPane());
		lblNewLabel.setFont(new Font("굴림체", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 17, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -160, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, panel, 17, SpringLayout.SOUTH, scrollPane);
		frame.getContentPane().add(scrollPane);

		JPanel menu = new JPanel();
		scrollPane.setViewportView(menu);

		menu.setLayout(new GridLayout(0, 3, 0, 0));
		// 메뉴 추가
		gui_dao gui_dao = new gui_dao();
		FoodDAO food_dao = new FoodDAO();
		foodlist = food_dao.selectStorefood("더큰도시락");
		ArrayList<JPanel> menulist = new ArrayList<JPanel>();
		for (int i = 0; i < foodlist.size(); i++) {
			JPanel panelnow = gui_dao.make_menu(foodlist.get(i));
			menu.add(panelnow);
			menulist.add(panelnow);
		}

		// 전체취소~결제
		JPanel panel_9 = new JPanel();
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, -10, SpringLayout.WEST, panel_9);
		panel_9.setBackground(new Color(249, 250, 235));
		springLayout.putConstraint(SpringLayout.NORTH, panel_9, 0, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_9, 6, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_9, 0, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, panel_9, 134, SpringLayout.EAST, panel);
		frame.getContentPane().add(panel_9);
		SpringLayout sl_panel_9 = new SpringLayout();
		panel_9.setLayout(sl_panel_9);

		lblNewLabel_4 = new JLabel("");
		sl_panel_9.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 0, SpringLayout.NORTH, panel_9);
		sl_panel_9.putConstraint(SpringLayout.WEST, lblNewLabel_4, 57, SpringLayout.WEST, panel_9);
		sl_panel_9.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -85, SpringLayout.SOUTH, panel_9);
		sl_panel_9.putConstraint(SpringLayout.EAST, lblNewLabel_4, 0, SpringLayout.EAST, panel_9);
		lblNewLabel_4.setFont(new Font("굴림체", Font.BOLD, 18));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_4);

		JLabel lblNewLabel_40 = new JLabel("\uC8FC\uBB38\uD558\uAE30");// 주문하기
		sl_panel_9.putConstraint(SpringLayout.NORTH, lblNewLabel_40, 6, SpringLayout.SOUTH, lblNewLabel_4);
		sl_panel_9.putConstraint(SpringLayout.WEST, lblNewLabel_40, 0, SpringLayout.WEST, panel_9);
		sl_panel_9.putConstraint(SpringLayout.EAST, lblNewLabel_40, 0, SpringLayout.EAST, panel_9);
		sl_panel_9.putConstraint(SpringLayout.SOUTH, lblNewLabel_40, 0, SpringLayout.SOUTH, panel_9);

		lblNewLabel_40.setFont(new Font("HY헤드라인M", Font.BOLD, 18));
		lblNewLabel_40.setOpaque(true);
		lblNewLabel_40.setBackground(new Color(242, 183, 5));
		lblNewLabel_40.setForeground(new Color(249, 250, 235));
		lblNewLabel_40.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_40);

		JLabel lblNewLabel_3 = new JLabel("총액 :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		sl_panel_9.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 0, SpringLayout.NORTH, lblNewLabel_4);
		sl_panel_9.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 0, SpringLayout.SOUTH, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 0, SpringLayout.NORTH, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, panel_9);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 0, SpringLayout.SOUTH, lblNewLabel_4);
		panel_9.add(lblNewLabel_3);
		sl_panel_9.putConstraint(SpringLayout.EAST, lblNewLabel_3, -77, SpringLayout.EAST, panel_9);
		lblNewLabel_3.setFont(new Font("HY헤드라인M", Font.BOLD, 18));
		lblNewLabel_3.setBackground(new Color(0, 0, 0));
		sl_panel_9.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel_40);

		lblNewLabel_40.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {// 결제완료창으로 가기
				if (table.getRowCount() == 0) {
					JOptionPane.showMessageDialog(frame, "주문이 하나도 없어요", "경고에요", JOptionPane.ERROR_MESSAGE);
				} else {
					int result = JOptionPane.showConfirmDialog(frame, "이대로 주문 하시겠습니까?", "마지막 선택",
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.CLOSED_OPTION) {
					} // 그냥 껐음
					else if (result == JOptionPane.YES_OPTION) { // 네
						ArrayList<BasketVO> bvo = bdao.select(save.getid());
						OrderDAO odao = new OrderDAO();
						// 장바구니db에 있는 값중 주문db에 있는 값을 제외하고 테이블에 추가 시작
						ArrayList<OrderVO> ovolist = odao.select();
						ArrayList<BasketVO> n_bvo = new ArrayList<BasketVO>();
						for (int i = 0; i < bvo.size(); i++) {
							int cnt = 0;
							for (int j = 0; j < ovolist.size(); j++) {
								if (ovolist.get(j).getBasket_key().equals(bvo.get(i).getBasketkey())) {
									break;
								} else
									cnt++;

							}
							if(cnt == 0) {
								if(ovolist.size() == 0) {
									n_bvo.add(bvo.get(i));
								}
							}
							else if (cnt == ovolist.size()) {
								n_bvo.add(bvo.get(i));
							}
						}
						if(n_bvo.size() != 0 ) {
							odao.insert(n_bvo, "더큰도시락");
						}
						StoreDAO sdao = new StoreDAO();
						sdao.update_cnt_plus("더큰도시락");
						Pay pay = new Pay(all_price, odao.select(n_bvo.get(0).getBasketkey()));
						frame.setVisible(false);
						Pay.main(all_price, odao.select(n_bvo.get(0).getBasketkey()));
					} else {
					} // 아니오
				}

			}
		});

		// ##########수량체크 이벤트##############
		// 상품명, 수량체크

		for (int i = 0; i < menulist.size(); i++) {
			menulist.get(i).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					for (int j = 0; j < menulist.size(); j++)
						if (e.getSource().equals(menulist.get(j))) {
							Count_menu count = new Count_menu(foodlist.get(j));
							Count_menu.main(foodlist.get(j));
							break;
						}

				}
			});
		}

	}
}
