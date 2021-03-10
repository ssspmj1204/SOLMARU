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

import dasolo.MessageDAO;
import dasolo.MessageVO;

public class Message {
   static String text;
   private JFrame frame;
   private JTable table;
   DefaultTableModel model;
   int row;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Message window = new Message();
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
   public Message() {
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
      
      //##########################title start###############################
      
      
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
         public void mouseClicked(MouseEvent e) {// 뒤로가기
            Service service = new Service();
            frame.setVisible(false);
            service.main(null);
         }
      });

      
      //########################## title end ###############################
      JPanel panel_1 = new JPanel();
      springLayout.putConstraint(SpringLayout.NORTH, panel_1, -427, SpringLayout.SOUTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.WEST, panel_1, 47, SpringLayout.WEST, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -49, SpringLayout.SOUTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.EAST, panel_1, 441, SpringLayout.WEST, frame.getContentPane());
      frame.getContentPane().add(panel_1);
      panel_1.setLayout(new CardLayout(0, 0));
///////////////
      String[] colName = new String[] { "번호", "내용", "작성자", "작성일" };
      String[][] data = new String[22][colName.length];
      // for문으로 값 가져오기
      // 테이블
      MessageDAO mdao = new MessageDAO();
      ArrayList<MessageVO> list = mdao.select();
//      int message_num;
//      String message_time;
//      String notice;
//      String store_name;

      for (int i = 0; i < list.size(); i++) {
         for (int j = 0; j < colName.length; j++) {
            if (j == 0) {
               data[i][j] = list.get(i).getMessage_num()+"";
            } else if (j == 1) {
               data[i][j] = list.get(i).getNotice();
            } else if (j == 2) {
               data[i][j] = list.get(i).getStore_name();
            } else if (j == 3) {
               data[i][j] = list.get(i).getMessage_time();

            }
         }
      }
//////////////

      table = new JTable(new DefaultTableModel( data,colName));

      table.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            int column = table.getSelectedColumn();// 선택한 col 가져오기
            row = table.getSelectedRow();// row 가져오기
            
            text = data[row][1];
            
            if(column==1) {//특정 열의 내용부분 칼럼 선택->해당 내용 가져오기
               Message_detail msg_detail = new Message_detail();
               msg_detail.main(null);
            }
               

         }
      });
      table.getColumnModel().getColumn(0).setPreferredWidth(40);
      table.getColumnModel().getColumn(1).setPreferredWidth(200);


      JScrollPane scorll = new JScrollPane(table);
      panel_1.add(scorll, "name_2975279848375900");
      
      JLabel lblNewLabel = new JLabel("\uACF5\uC9C0\uC0AC\uD56D");
      springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 22, SpringLayout.SOUTH, panel_title);
      springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 139, SpringLayout.WEST, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -18, SpringLayout.NORTH, panel_1);
      springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 340, SpringLayout.WEST, frame.getContentPane());
      lblNewLabel.setFont(new Font("굴림체", Font.BOLD, 25));
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setIcon(null);
      frame.getContentPane().add(lblNewLabel);

      
      
      


   }
}