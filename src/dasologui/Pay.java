package dasologui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import dasolo.OrderVO;

public class Pay {

   private JFrame frame;
   
   /**
    * Launch the application.
    */
   public static void main(int all_price,OrderVO ovo) {

      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Pay window = new Pay(all_price,ovo);
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
   public Pay(int all_price,OrderVO ovo) {
      initialize(all_price,ovo);
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize(int all_price,OrderVO ovo) {
      // ****************************여기서부터 수정****************************//

      // 바탕 색
      frame = new JFrame();
      frame.getContentPane().setBackground(new Color(249, 250, 235));
      frame.setBounds(100, 100, 500, 600);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      SpringLayout springLayout = new SpringLayout();
      frame.getContentPane().setLayout(springLayout);

      
      frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
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

      JLabel lbl_logo = new JLabel("");
      sl_panel_title.putConstraint(SpringLayout.WEST, lbl_logo, 124, SpringLayout.WEST, panel_title);
      sl_panel_title.putConstraint(SpringLayout.EAST, lbl_logo, -126, SpringLayout.EAST, panel_title);
      lbl_logo.setForeground(new Color(249, 250, 235));
      lbl_logo.setFont(new Font("동그라미재단B", Font.PLAIN, 30));
      sl_panel_title.putConstraint(SpringLayout.NORTH, lbl_logo, 0, SpringLayout.NORTH, panel_title);
      sl_panel_title.putConstraint(SpringLayout.SOUTH, lbl_logo, 0, SpringLayout.SOUTH, panel_title);
      lbl_logo.setIcon(new ImageIcon("./../etcImage/logo.png"));
      lbl_logo.setHorizontalAlignment(SwingConstants.CENTER);
      panel_title.add(lbl_logo);

      // #####################여기까지 title부분################################

      JButton btnNewButton = new JButton("\uB2EB\uAE30");
      springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 209, SpringLayout.WEST, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -188, SpringLayout.EAST, frame.getContentPane());
      btnNewButton.setFont(new Font("굴림체", Font.BOLD, 20));
      btnNewButton.setBackground(new Color(242,183,5));
      btnNewButton.setForeground(new Color(249,250,235));
      springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -56, SpringLayout.SOUTH, frame.getContentPane());
      btnNewButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
        	 Chinese.all_price = 0;
        	 Cutlet.all_price = 0;
        	 RiceBox.all_price = 0;
        	 Salad.all_price = 0;
            Service service = new Service();
            frame.setVisible(false);
            service.main(null);
         }
      });
      frame.getContentPane().add(btnNewButton);

      JLabel lblNewLabel = new JLabel("\uACB0\uC81C\uAC00 \uC815\uC0C1\uC801\uC73C\uB85C \uC644\uB8CC\uB418\uC5C8\uC2B5\uB2C8\uB2E4.");
      springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -163, SpringLayout.SOUTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -44, SpringLayout.EAST, frame.getContentPane());
      lblNewLabel.setFont(new Font("굴림체", Font.BOLD, 22));
      lblNewLabel.setForeground(Color.BLACK);
      frame.getContentPane().add(lblNewLabel);

      JLabel lblNewLabel_2 = new JLabel("\uC8FC\uBB38\uBC88\uD638 : ");
      springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 107, SpringLayout.WEST, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -36, SpringLayout.NORTH, lblNewLabel);
      springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, btnNewButton);
      lblNewLabel_2.setForeground(Color.RED);
      lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_2.setFont(new Font("굴림체", Font.BOLD, 30));
      frame.getContentPane().add(lblNewLabel_2);

      JLabel lblNewLabel_3 = new JLabel(ovo.getOrder_num()+"");
      springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 6, SpringLayout.EAST, lblNewLabel_2);
      springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_3, -22, SpringLayout.EAST, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, -1, SpringLayout.NORTH, lblNewLabel_3);
      lblNewLabel_3.setForeground(Color.RED);
      lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
      lblNewLabel_3.setFont(new Font("굴림체", Font.BOLD, 30));
      frame.getContentPane().add(lblNewLabel_3);
      
      JLabel label = new JLabel("\uC774\uC6A9\uD574 \uC8FC\uC154\uC11C \uAC10\uC0AC\uD569\uB2C8\uB2E4.");
      springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 43, SpringLayout.SOUTH, label);
      springLayout.putConstraint(SpringLayout.WEST, label, 75, SpringLayout.WEST, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.EAST, label, -84, SpringLayout.EAST, frame.getContentPane());
      label.setForeground(Color.BLACK);
      springLayout.putConstraint(SpringLayout.NORTH, label, 6, SpringLayout.SOUTH, lblNewLabel);
      label.setHorizontalAlignment(SwingConstants.CENTER);
      label.setFont(new Font("굴림체", Font.BOLD, 22));
      frame.getContentPane().add(label);
      
      JLabel lblNewLabel_1 = new JLabel("");
      springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -292, SpringLayout.SOUTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 31, SpringLayout.SOUTH, lblNewLabel_1);
      springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, -168, SpringLayout.EAST, frame.getContentPane());
      lblNewLabel_1.setIcon(new ImageIcon("./../etcImage/receipt.png"));
      frame.getContentPane().add(lblNewLabel_1);
      
      JLabel lblNewLabel_4 = new JLabel("\uACB0\uC81C\uAE08\uC561 : ");
      springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 33, SpringLayout.SOUTH, panel_title);
      springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_4, -224, SpringLayout.EAST, frame.getContentPane());
      lblNewLabel_4.setForeground(Color.BLACK);
      lblNewLabel_4.setFont(new Font("굴림체", Font.BOLD, 20));
      frame.getContentPane().add(lblNewLabel_4);
      
      JLabel lblNewLabel_5 = new JLabel(all_price + "원");
      springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 0, SpringLayout.NORTH, lblNewLabel_4);
      springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_5, 6, SpringLayout.EAST, lblNewLabel_4);
      lblNewLabel_5.setForeground(Color.BLACK);
      lblNewLabel_5.setFont(new Font("굴림체", Font.BOLD, 20));
      frame.getContentPane().add(lblNewLabel_5);
   }
}