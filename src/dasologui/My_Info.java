package dasologui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import dasolo.Saveid;
import dasolo.UserDAO;
import dasolo.UserVO;

public class My_Info {

   JFrame frame;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               My_Info window = new My_Info();
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
   public My_Info() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.getContentPane().setFont(new Font("굴림체", Font.BOLD, 15));
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
      
      JPanel panel = new JPanel();
      panel.setBackground(new Color(242,183,5));
      frame.getContentPane().add(panel);
      
      panel.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {//로그아웃
            Login login = new Login();
            frame.setVisible(false);
            login.main(null);
            
         }
      });
      GridBagLayout gbl_panel = new GridBagLayout();
      gbl_panel.columnWidths = new int[]{45, 77};
      gbl_panel.rowHeights = new int[]{60};
      gbl_panel.columnWeights = new double[]{0.0, 0.0};
      gbl_panel.rowWeights = new double[]{0.0};
      panel.setLayout(gbl_panel);
      
      
      JLabel lblNewLabel_4 = new JLabel("");
      lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_4.setIcon(new ImageIcon("./../etcImage/logout.png"));
      GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
      gbc_lblNewLabel_4.fill = GridBagConstraints.HORIZONTAL;
      gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
      gbc_lblNewLabel_4.gridx = 0;
      gbc_lblNewLabel_4.gridy = 0;
      panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
      
      JPanel panel_1 = new JPanel();
      springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -38, SpringLayout.SOUTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.WEST, panel, 66, SpringLayout.EAST, panel_1);
      springLayout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, panel_1);
      springLayout.putConstraint(SpringLayout.EAST, panel_1, -274, SpringLayout.EAST, frame.getContentPane());
      
      JLabel lblNewLabel_3 = new JLabel("\uB85C\uADF8\uC544\uC6C3 ");
      lblNewLabel_3.setForeground(new Color(255, 255, 255));
      lblNewLabel_3.setFont(new Font("HY헤드라인M", Font.BOLD, 18));
      lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
      GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
      gbc_lblNewLabel_3.fill = GridBagConstraints.HORIZONTAL;
      gbc_lblNewLabel_3.gridx = 1;
      gbc_lblNewLabel_3.gridy = 0;
      panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
      panel_1.setBackground(new Color(242,183,5));
      frame.getContentPane().add(panel_1);
      GridBagLayout gbl_panel_1 = new GridBagLayout();
      gbl_panel_1.columnWidths = new int[]{45, 77};
      gbl_panel_1.rowHeights = new int[]{60};
      gbl_panel_1.columnWeights = new double[]{0.0, 0.0};
      gbl_panel_1.rowWeights = new double[]{0.0};
      panel_1.setLayout(gbl_panel_1);
      
      JLabel label = new JLabel("");
      label.setIcon(new ImageIcon("./../etcImage/document.png"));
      label.setHorizontalAlignment(SwingConstants.CENTER);
      GridBagConstraints gbc_label = new GridBagConstraints();
      gbc_label.fill = GridBagConstraints.HORIZONTAL;
      gbc_label.insets = new Insets(0, 0, 0, 5);
      gbc_label.gridx = 0;
      gbc_label.gridy = 0;
      panel_1.add(label, gbc_label);
      
      panel_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {//수정하는 창 오픈
            Edit_MyInfo edit_Info = new Edit_MyInfo();
            frame.setVisible(true);//창 사라지지 않고 유지
            edit_Info.main(null);
         }
      });
      
      JLabel lbl_edit_Info = new JLabel("\uC218\uC815\uD558\uAE30 ");//수정하기
      lbl_edit_Info.setFont(new Font("HY헤드라인M", Font.BOLD, 18));
      lbl_edit_Info.setForeground(new Color(255, 255, 255));
      GridBagConstraints gbc_lbl_edit_Info = new GridBagConstraints();
      gbc_lbl_edit_Info.anchor = GridBagConstraints.WEST;
      gbc_lbl_edit_Info.gridx = 1;
      gbc_lbl_edit_Info.gridy = 0;
      panel_1.add(lbl_edit_Info, gbc_lbl_edit_Info);
      springLayout.putConstraint(SpringLayout.NORTH, lbl_edit_Info, -323, SpringLayout.SOUTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.WEST, lbl_edit_Info, 85, SpringLayout.WEST, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.EAST, lbl_edit_Info, -261, SpringLayout.EAST, frame.getContentPane());
      
      lbl_edit_Info.setHorizontalAlignment(SwingConstants.LEFT);
      
      JPanel panel_2 = new JPanel();
      springLayout.putConstraint(SpringLayout.NORTH, panel_1, 46, SpringLayout.SOUTH, panel_2);
      springLayout.putConstraint(SpringLayout.NORTH, panel, 46, SpringLayout.SOUTH, panel_2);
      springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, panel_2);
      springLayout.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, panel_2);
      springLayout.putConstraint(SpringLayout.WEST, panel_2, 83, SpringLayout.WEST, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.SOUTH, panel_2, -127, SpringLayout.SOUTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.EAST, panel_2, -81, SpringLayout.EAST, frame.getContentPane());
      //panel_2.setForeground(new Color(185,122,87));
      panel_2.setBackground(new Color(249, 250, 235));
      TitledBorder tb = new TitledBorder(new LineBorder(new Color(70,115,38)));
      panel_2.setBorder(tb);
      springLayout.putConstraint(SpringLayout.NORTH, panel_2, 226, SpringLayout.SOUTH, panel_title);
      frame.getContentPane().add(panel_2);
      GridBagLayout gbl_panel_2 = new GridBagLayout();
      gbl_panel_2.columnWidths = new int[]{138,200};
      gbl_panel_2.rowHeights = new int[]{52, 52, 52};
      gbl_panel_2.columnWeights = new double[]{1.0, 0.0};
      gbl_panel_2.rowWeights = new double[]{1.0, 1.0, 1.0};
      panel_2.setLayout(gbl_panel_2);
      
      JPanel panel_3 = new JPanel();
      panel_3.setBackground(new Color(70,115,38));
      GridBagConstraints gbc_panel_3 = new GridBagConstraints();
      gbc_panel_3.insets = new Insets(0, 0, 5, 5);
      gbc_panel_3.fill = GridBagConstraints.BOTH;
      gbc_panel_3.gridx = 0;
      gbc_panel_3.gridy = 0;
      panel_2.add(panel_3, gbc_panel_3);
      panel_3.setLayout(new GridLayout(1, 0, 0, 0));
      
      JLabel lblNewLabel = new JLabel("\uC774     \uB984");
      lblNewLabel.setForeground(new Color(249, 250, 235));
      lblNewLabel.setBackground(new Color(255, 102, 102));
      lblNewLabel.setFont(new Font("굴림체", Font.BOLD, 15));
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      panel_3.add(lblNewLabel);
      
      
      
      /////
      UserDAO udao = new UserDAO();
      Saveid sid = new Saveid();
      UserVO uvo = udao.get_usrinfo(sid.getid());
      /////      
      
      
      
      
      
      
      
      JLabel label_6 = new JLabel(uvo.getUsrname());
      label_6.setForeground(new Color(185,122,87));
      label_6.setFont(new Font("굴림체", Font.BOLD, 15));
      GridBagConstraints gbc_label_6 = new GridBagConstraints();
      gbc_label_6.insets = new Insets(0, 0, 5, 0);
      gbc_label_6.gridx = 1;
      gbc_label_6.gridy = 0;
      panel_2.add(label_6, gbc_label_6);
      
      JPanel panel_4 = new JPanel();
      panel_4.setBackground(new Color(70,115,38));
      GridBagConstraints gbc_panel_4 = new GridBagConstraints();
      gbc_panel_4.insets = new Insets(0, 0, 5, 5);
      gbc_panel_4.fill = GridBagConstraints.BOTH;
      gbc_panel_4.gridx = 0;
      gbc_panel_4.gridy = 1;
      panel_2.add(panel_4, gbc_panel_4);
      panel_4.setLayout(new GridLayout(0, 1, 0, 0));
      
      JLabel label_1 = new JLabel("\uC544  \uC774  \uB514");
      label_1.setBackground(new Color(249, 250, 235));
      label_1.setHorizontalAlignment(SwingConstants.CENTER);
      label_1.setForeground(new Color(249, 250, 235));
      label_1.setFont(new Font("굴림체", Font.BOLD, 15));
      panel_4.add(label_1);
      
      JLabel label_4 = new JLabel(uvo.getUsrid());
      label_4.setForeground(new Color(185,122,87));
      label_4.setFont(new Font("굴림체", Font.BOLD, 15));
      GridBagConstraints gbc_label_4 = new GridBagConstraints();
      gbc_label_4.insets = new Insets(0, 0, 5, 0);
      gbc_label_4.gridx = 1;
      gbc_label_4.gridy = 1;
      panel_2.add(label_4, gbc_label_4);
      
      JPanel panel_5 = new JPanel();
      panel_5.setBackground(new Color(70,115,38));
      GridBagConstraints gbc_panel_5 = new GridBagConstraints();
      gbc_panel_5.insets = new Insets(0, 0, 0, 5);
      gbc_panel_5.fill = GridBagConstraints.BOTH;
      gbc_panel_5.gridx = 0;
      gbc_panel_5.gridy = 2;
      panel_2.add(panel_5, gbc_panel_5);
      panel_5.setLayout(new GridLayout(0, 1, 0, 0));
      
      JLabel label_2 = new JLabel("전 화 번 호");
      label_2.setBackground(new Color(70,115,38));
      panel_5.add(label_2);
      springLayout.putConstraint(SpringLayout.WEST, label_2, 81, SpringLayout.WEST, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.SOUTH, label_2, -66, SpringLayout.NORTH, panel_2);
      label_2.setHorizontalAlignment(SwingConstants.CENTER);
      label_2.setForeground(new Color(249, 250, 235));
      label_2.setFont(new Font("굴림체", Font.BOLD, 15));
      
      JLabel label_5 = new JLabel(uvo.getUsrtel());
      label_5.setForeground(new Color(185,122,87));
      label_5.setFont(new Font("굴림체", Font.BOLD, 15));
      GridBagConstraints gbc_label_5 = new GridBagConstraints();
      gbc_label_5.gridx = 1;
      gbc_label_5.gridy = 2;
      panel_2.add(label_5, gbc_label_5);
      
      JLabel lblNewLabel_1 = new JLabel("");
      springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -19, SpringLayout.NORTH, panel_2);
      springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, -149, SpringLayout.EAST, frame.getContentPane());
      lblNewLabel_1.setIcon(new ImageIcon("./../etcImage/My_info.jpg"));
      frame.getContentPane().add(lblNewLabel_1);
   }
}