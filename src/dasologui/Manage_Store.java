package dasologui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dasolo.FoodDAO;
import dasolo.FoodVO;
import dasolo.ManageDAO;
import dasolo.ManageVO;
import dasolo.Saveid;

public class Manage_Store {

   private JFrame frame;
   private JTable table;
   DefaultTableModel model;
//   MemberDAO dao;
   int row;
   int column;
   ArrayList<FoodVO> list;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Manage_Store window = new Manage_Store();
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
   public Manage_Store() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.setBounds(100, 100, 500, 600);
      frame.getContentPane().setBackground(new Color(249, 250, 235));//배경색 변경
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      SpringLayout springLayout = new SpringLayout();
      frame.getContentPane().setLayout(springLayout);
      
      frame.setResizable(false);
      
      //##########################title start###############################
      
      JPanel panel_title = new JPanel();
      panel_title.setBackground(new Color(70, 115, 38));//상단부 패널색 변경
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
//      gbc_lbl_back.ipadx = 15;
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
         public void mouseClicked(MouseEvent e) {
            Manage_service m_service = new Manage_service();
            frame.setVisible(false);
            m_service.main(null);
         }
      });
            
            
      //#############################title end#################################################      

      
      
      JPanel tablePanel = new JPanel();
      springLayout.putConstraint(SpringLayout.NORTH, tablePanel, 160, SpringLayout.NORTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.WEST, tablePanel, 56, SpringLayout.WEST, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.SOUTH, tablePanel, -28, SpringLayout.SOUTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.EAST, tablePanel, -69, SpringLayout.EAST, frame.getContentPane());
      frame.getContentPane().add(tablePanel);
      tablePanel.setLayout(new CardLayout(0, 0));
      
      //만들교체하기
//      dao = new MemberDAO();
//      ArrayList<MemberVO> list = dao.select();
//      String[] colName = { "상품명", "시간", "가격", "삭제"};
//      String[][] data = new String[20][colName.length];
      
//      public FoodVO(String foodName, int price, int foodtime
//            , String storeName, String cal, String foodimage) 
      FoodDAO fdao = new FoodDAO();
      Saveid sid = new Saveid();
      ManageDAO mdao = new ManageDAO();
      ManageVO mvo = mdao.get_maninfo(sid.getid());
      list = fdao.selectStorefood(mvo.getManstore());   
      
      String[] colName = { "상품명", "시간", "가격", "삭제"};
      String[][] data = new String[list.size()][colName.length];
      
      
      for (int i = 0; i < list.size(); i++) {
         for (int j = 0; j < colName.length; j++) {
            if (j == 0) {
               data[i][j] = list.get(i).getFoodName();
            } else if (j == 1) {
               data[i][j] = list.get(i).getFoodtime() + "";
            } else if (j == 2) {
               data[i][j] = list.get(i).getPrice()+"";
            } else if (j == 3) {
               data[i][j] = "X";
            }
         }
      }   
      model = new DefaultTableModel(data, colName);
      
      table = new JTable(model);
      
      
      
      table.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            column = table.getSelectedColumn();//선택한 col 가져오기
            row = table.getSelectedRow();// row 가져오기
            
            if(column==3) {//완료col 누르면 그때의 row 삭제
               //dao.delete(list.get(row).getId());//해당row의 id를 가져와 데이터삭제
               
               FoodDAO fdao = new FoodDAO();
               //fdao.delete(Store_name, Food_name);
               //System.out.println(row);   
               fdao.delete(list.get(row).getStoreName(), list.get(row).getFoodName());
               
               model = (DefaultTableModel)table.getModel();
               model.removeRow(row);//      
            }
         }
      });
      table.getColumnModel().getColumn(0).setPreferredWidth(180);
      table.getColumnModel().getColumn(1).setPreferredWidth(30);
      table.getColumnModel().getColumn(2).setPreferredWidth(50);
      table.getColumnModel().getColumn(3).setPreferredWidth(20);

      
      
      
//      getContentPane();
//      frame.getContentPane().add(lblNewLabel);
      JScrollPane scorll = new JScrollPane(table);
      tablePanel.add(scorll);

      //현재 메뉴목록(?)이라 적힌 타이틀 아래에 있던 라벨 삭제했어요.
      
//#####################추가된 부분##############################33
      
      
      JLabel lbl_add_menu = new JLabel("\uCD94\uAC00");//추가
      lbl_add_menu.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {//메뉴 추가 클래스 이동
            Menu_add add = new Menu_add();
            frame.setVisible(true);
            add.main(null);
         }
      });
      springLayout.putConstraint(SpringLayout.NORTH, lbl_add_menu, -27, SpringLayout.NORTH, tablePanel);
      springLayout.putConstraint(SpringLayout.WEST, lbl_add_menu, -109, SpringLayout.EAST, frame.getContentPane());
      lbl_add_menu.setOpaque(true);
      lbl_add_menu.setBackground(new Color(242, 183, 5));// 라벨 색 변경
      lbl_add_menu.setFont(new Font("HY헤드라인M", Font.BOLD, 16));
      lbl_add_menu.setForeground(new Color(255, 255, 255));
      lbl_add_menu.setHorizontalAlignment(SwingConstants.CENTER);
      springLayout.putConstraint(SpringLayout.SOUTH, lbl_add_menu, -6, SpringLayout.NORTH, tablePanel);
      springLayout.putConstraint(SpringLayout.EAST, lbl_add_menu, -69, SpringLayout.EAST, frame.getContentPane());
      frame.getContentPane().add(lbl_add_menu);
      
      
      
      
      
      
      
      
   }
}