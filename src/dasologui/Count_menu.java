package dasologui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import dasolo.BasketDAO;
import dasolo.BasketVO;
import dasolo.FoodVO;
import dasolo.Saveid;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SpringLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.SpinnerNumberModel;

public class Count_menu {

   private JFrame frame;

   /**
    * Launch the application.
    */
   public static int main(FoodVO vo) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Count_menu window = new Count_menu(vo);
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
      return 0;
   }

   /**
    * Create the application.
    */
   public Count_menu(FoodVO vo) {
      initialize(vo);
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize(FoodVO vo) {
      frame = new JFrame();
      frame.getContentPane().setBackground(new Color(249, 250, 235));
      frame.setBounds(100, 100, 500, 323);
      SpringLayout springLayout = new SpringLayout();
      frame.getContentPane().setLayout(springLayout);
      frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
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
      
      JPanel panel = new JPanel();
      panel.setBackground(new Color(249, 250, 235));
      springLayout.putConstraint(SpringLayout.NORTH, panel, 6, SpringLayout.SOUTH, panel_title);
      springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.SOUTH, panel, 224, SpringLayout.SOUTH, panel_title);
      springLayout.putConstraint(SpringLayout.EAST, panel, 474, SpringLayout.WEST, frame.getContentPane());
      frame.getContentPane().add(panel);
      SpringLayout sl_panel = new SpringLayout();
      panel.setLayout(sl_panel);
      
      JLabel lblNewLabel = new JLabel("상품명 : ");
      sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 42, SpringLayout.NORTH, panel);
      sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 42, SpringLayout.WEST, panel);
      sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -320, SpringLayout.EAST, panel);
      lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
      lblNewLabel.setBackground(Color.BLACK);
      panel.add(lblNewLabel);
      
      JLabel lblNewLabel_1 = new JLabel("수량 : ");
      sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 29, SpringLayout.SOUTH, lblNewLabel);
      sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 42, SpringLayout.WEST, panel);
      sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1, -320, SpringLayout.EAST, panel);
      lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
      panel.add(lblNewLabel_1);
      
      JLabel lblNewLabel_2 = new JLabel(vo.getFoodName());
      sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 6, SpringLayout.EAST, lblNewLabel);
      sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 42, SpringLayout.NORTH, panel);
      lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 25));
      panel.add(lblNewLabel_2);
      
      JSpinner spinner = new JSpinner();
      sl_panel.putConstraint(SpringLayout.NORTH, spinner, 3, SpringLayout.NORTH, lblNewLabel_1);
      sl_panel.putConstraint(SpringLayout.WEST, spinner, 29, SpringLayout.EAST, lblNewLabel_1);
      sl_panel.putConstraint(SpringLayout.EAST, spinner, -189, SpringLayout.EAST, panel);
      spinner.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
      spinner.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
      panel.add(spinner);
      
      JPanel panel_1 = new JPanel();
      sl_panel.putConstraint(SpringLayout.SOUTH, spinner, -39, SpringLayout.NORTH, panel_1);
      sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, panel_1);
      sl_panel.putConstraint(SpringLayout.NORTH, panel_1, -44, SpringLayout.SOUTH, panel);
      sl_panel.putConstraint(SpringLayout.WEST, panel_1, 347, SpringLayout.WEST, panel);
      sl_panel.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, panel);
      panel_1.setBackground(new Color(242,183,5));
      sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -10, SpringLayout.SOUTH, panel);
      panel.add(panel_1);
      panel_1.setLayout(new CardLayout(0, 0));
      
      JLabel lblNewLabel_3 = new JLabel("선택완료");
      lblNewLabel_3.setForeground(Color.WHITE);
      lblNewLabel_3.setBackground(Color.WHITE);
      lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
      panel_1.add(lblNewLabel_3, "name_349067030047600");
      sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 0, SpringLayout.NORTH, lblNewLabel_1);
      sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_3, -34, SpringLayout.EAST, panel);
      lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      

         lblNewLabel_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               Saveid save = new Saveid();
               int cnt = (int) spinner.getValue();
               BasketVO VO = new BasketVO(save.getid(), vo.getFoodName(), vo.getPrice() * cnt,
                     save.getid() + "_" + vo.getFoodName(), cnt);
               BasketDAO DAO = new BasketDAO();
               if (DAO.select(save.getid(), vo.getFoodName()) == null) {
                  DAO.insert(VO);
                  String[] rowData = { vo.getFoodName(), vo.getPrice() * cnt + "", cnt + "", "" };
                  if (Chinese.model != null) {
                     Chinese.model.addRow(rowData);
                     Chinese.all_price += vo.getPrice() * cnt;
                     Chinese.lblNewLabel_4.setText(Chinese.all_price + "");

                  }
                  if (Salad.model != null) {
                     Salad.model.addRow(rowData);
                     Salad.all_price += vo.getPrice() * cnt;
                     Salad.lblNewLabel_4.setText(Salad.all_price + "");
                  }
                  if (RiceBox.model != null) {
                     RiceBox.model.addRow(rowData);
                     RiceBox.all_price += vo.getPrice() * cnt;
                     RiceBox.lblNewLabel_4.setText(RiceBox.all_price + "");
                  }
                  if (Cutlet.model != null) {
                     Cutlet.model.addRow(rowData);
                     Cutlet.all_price += vo.getPrice() * cnt;
                     Cutlet.lblNewLabel_4.setText(Cutlet.all_price + "");
                  }
               }
               else {
                  JOptionPane.showMessageDialog(frame, "같은 음식은 주문 못해요", "경고에요", JOptionPane.ERROR_MESSAGE);
               }
               frame.setVisible(false);

            }
         });
   }
}