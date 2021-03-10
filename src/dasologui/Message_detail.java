package dasologui;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Message_detail {

   private JFrame frame;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Message_detail window = new Message_detail();
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
   public Message_detail() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.getContentPane().setBackground(new Color(249, 250, 235));//배경색 변경
      frame.setBounds(600, 100, 500, 450);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      
      SpringLayout springLayout = new SpringLayout();
      frame.getContentPane().setLayout(springLayout);
      
      frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);//창닫기 방지
      frame.setResizable(false);//창 조절x
      
      //##################################################
      
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
      lbl_back.setIcon(new ImageIcon(""));
//      gbc_lbl_back.ipadx = 15;
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
      // panel_title.setPreferredSize(30);

   
   
      
//#####################여기까지 title부분################################
      
      JPanel panel = new JPanel();
      panel.setBackground(new Color(255, 255, 255));
      springLayout.putConstraint(SpringLayout.NORTH, panel, 3, SpringLayout.SOUTH, panel_title);
      springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.SOUTH, panel, 274, SpringLayout.SOUTH, panel_title);
      springLayout.putConstraint(SpringLayout.EAST, panel, 488, SpringLayout.WEST, frame.getContentPane());
      frame.getContentPane().add(panel);
      SpringLayout sl_panel = new SpringLayout();
      panel.setLayout(sl_panel);
      
      JLabel lblNewLabel_1 = new JLabel(Message.text);
      lblNewLabel_1.setFont(new Font("휴먼고딕", Font.PLAIN, 16));
      lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
      sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 10, SpringLayout.NORTH, panel);
      sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, panel);
      sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 261, SpringLayout.NORTH, panel);
      sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1, 465, SpringLayout.WEST, panel);
      panel.add(lblNewLabel_1);
      
      JLabel lblNewLabel = new JLabel("\uB2EB\uAE30");//닫기라고 내용 수정함
      lblNewLabel.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            frame.dispose();
         }
      });
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, -45, SpringLayout.SOUTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, -73, SpringLayout.EAST, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -10, SpringLayout.SOUTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -10, SpringLayout.EAST, frame.getContentPane());
      lblNewLabel.setFont(new Font("HY헤드라인M", Font.BOLD, 18));
      lblNewLabel.setOpaque(true);
      lblNewLabel.setBackground(new Color(242,183,5));
      lblNewLabel.setForeground(new Color(255, 255, 255));
      frame.getContentPane().add(lblNewLabel);
      
      
      

   }
}