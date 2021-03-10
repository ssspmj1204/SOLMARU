package dasologui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dasolo.MessageDAO;
import dasolo.Saveid;

public class Manage_Message {

   private JFrame frame;
   DefaultTableModel model;
   int row;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      MessageDAO mdao = new MessageDAO();
      
      
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Manage_Message window = new Manage_Message();
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
   public Manage_Message() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      
      
      frame = new JFrame();
      frame.getContentPane().setBackground(new Color(244, 245, 247));
      frame.setBounds(100, 100, 500, 600);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      SpringLayout springLayout = new SpringLayout();
      frame.getContentPane().setLayout(springLayout);

      
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
         public void mouseClicked(MouseEvent e) {// 뒤로가기
            Manage_service m_service = new Manage_service();
            frame.setVisible(false);
            m_service.main(null);
         }
      });         
            
      //#############################title end#################################################      

      
      
      JPanel panel_1 = new JPanel();
      springLayout.putConstraint(SpringLayout.NORTH, panel_1, 44, SpringLayout.SOUTH, panel_title);
      springLayout.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.EAST, panel_1, 468, SpringLayout.WEST, frame.getContentPane());
      frame.getContentPane().add(panel_1);

      String[] colName = new String[] {"내용", "작성일" };
      Object[][] data = new Object[colName.length][colName.length];

      
      
      
      JLabel lblNewLabel_3 = new JLabel("\uAE00\uC4F0\uAE30");
      lblNewLabel_3.setOpaque(true);
      lblNewLabel_3.setBackground(new Color(255, 152, 1));
      lblNewLabel_3.setFont(new Font("HY헤드라인M", Font.BOLD, 18));
      lblNewLabel_3.setForeground(new Color(255, 255, 255));
      lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
      springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -18, SpringLayout.NORTH, lblNewLabel_3);
      springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, -51, SpringLayout.SOUTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, -110, SpringLayout.EAST, panel_1);
      springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -10, SpringLayout.SOUTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_3, 0, SpringLayout.EAST, panel_1);
      SpringLayout sl_panel_1 = new SpringLayout();
      panel_1.setLayout(sl_panel_1);
      
      JTextArea textArea = new JTextArea();
      textArea.setText("\uACF5\uC9C0\uD558\uACE0 \uC2F6\uC740 \uB0B4\uC6A9\uC744 \uC791\uC131\uD558\uC138\uC694.");
      textArea.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            //
            //
            //
            //
            
         }
      });
      sl_panel_1.putConstraint(SpringLayout.NORTH, textArea, 10, SpringLayout.NORTH, panel_1);
      sl_panel_1.putConstraint(SpringLayout.WEST, textArea, 10, SpringLayout.WEST, panel_1);
      sl_panel_1.putConstraint(SpringLayout.SOUTH, textArea, 371, SpringLayout.NORTH, panel_1);
      sl_panel_1.putConstraint(SpringLayout.EAST, textArea, 448, SpringLayout.WEST, panel_1);
      panel_1.add(textArea);
      lblNewLabel_3.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {//작성완료 라벨의 리스너함수를 잘못 작성해서 수정해서 올려요.

            //if-else문 : 글이 작성되지 않았을 경우나 디폴트메시지가 있는 상태로 제출을 누르면(if부분)
            //DB에 반영 안되게 다이얼로그 메시지를 띄우고 창을 닫습니다.(창을 닫을지 그냥 열어두게 할지는 오빠가 알아서 결정하세요)
            //if 부분은 제가 작성했고, 아래 else 부분을 완성해주시면 됩니다.
            //조건 : 글 작성한 내용을 얻어와(textArea.getText()) DB에 반영하고 사용자의 message.java에서도 볼 수 있게 해주세요
            
            
            
            
            if(textArea.getText().isEmpty()||textArea.getText().equals("\uACF5\uC9C0\uD558\uACE0 \uC2F6\uC740 \uB0B4\uC6A9\uC744 \uC791\uC131\uD558\uC138\uC694."))
            {
               JOptionPane.showMessageDialog(null, "공지할 글을 작성하고 제출해주세요");
            }else {
               //store_name  == manager.store_name
               
               MessageDAO mdao = new MessageDAO();
            //   mdao.insert(text);
               Saveid sid = new Saveid();
               mdao.insert(textArea.getText(), sid.getid());
               Manage_service m_service = new Manage_service();
               frame.setVisible(false);
               m_service.main(null);
               
            }
         }
      });
      frame.getContentPane().add(lblNewLabel_3);

   }
}