package dasologui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import dasolo.FoodDAO;
import dasolo.FoodVO;
import dasolo.ManageDAO;
import dasolo.ManageVO;
import dasolo.Saveid;

public class Menu_add {

   private JFrame frame;
   private JTextField txt_name;
   private JTextField txt_time;
   private JTextField txt_price;
   private JTextField textField;
   String path;
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Menu_add window = new Menu_add();
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
   public Menu_add() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.getContentPane().setBackground(new Color(249, 250, 235));//배경색 변경
      frame.setBounds(100, 100, 450, 512);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      SpringLayout springLayout = new SpringLayout();
      frame.getContentPane().setLayout(springLayout);
      frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);//창닫기 방지
      frame.setResizable(false);//창 조절x
      
      //#################################################################################
      

      
      
      JPanel panel = new JPanel();
      springLayout.putConstraint(SpringLayout.SOUTH, panel, 402, SpringLayout.NORTH, frame.getContentPane());
      panel.setBackground(new Color(249, 250, 235));//배경색 변경
      springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.EAST, panel, 418, SpringLayout.WEST, frame.getContentPane());
      frame.getContentPane().add(panel);
      GridBagLayout gbl_panel = new GridBagLayout();
      gbl_panel.columnWidths = new int[]{154, 254, 0};
      gbl_panel.rowHeights = new int[]{59, 59, 59, 59,59, 0};
      gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
      gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
      panel.setLayout(gbl_panel);
      
      JLabel lbl_add_name = new JLabel("\uC0C1\uD488\uBA85");
      lbl_add_name.setFont(new Font("굴림체", Font.BOLD, 18));
      lbl_add_name.setForeground(new Color(185, 122, 87));// 글씨색 변경
      GridBagConstraints gbc_lbl_add_name = new GridBagConstraints();
      gbc_lbl_add_name.anchor = GridBagConstraints.EAST;
      gbc_lbl_add_name.fill = GridBagConstraints.VERTICAL;
      gbc_lbl_add_name.insets = new Insets(0, 0, 5, 5);
      gbc_lbl_add_name.gridx = 0;
      gbc_lbl_add_name.gridy = 0;
      panel.add(lbl_add_name, gbc_lbl_add_name);
      
      
      


      
      FoodDAO fdao = new FoodDAO();
      
      Saveid sid = new Saveid();
      String id = sid.getid();
      ManageDAO mdao = new ManageDAO();
      ManageVO mvo = mdao.get_maninfo(id);
      String store_name = mvo.getManstore();

      
      
      
      
      
      txt_name = new JTextField();   //상품명
      GridBagConstraints gbc_txt_name = new GridBagConstraints();
      gbc_txt_name.insets = new Insets(0, 0, 5, 0);
      gbc_txt_name.gridx = 1;
      gbc_txt_name.gridy = 0;
      panel.add(txt_name, gbc_txt_name);
      txt_name.setColumns(10);
      
      JLabel lbl_add_time = new JLabel("\uC870\uB9AC\uC2DC\uAC04");
      lbl_add_time.setFont(new Font("굴림체", Font.BOLD, 18));
      lbl_add_time.setForeground(new Color(185, 122, 87));// 글씨색 변경
      GridBagConstraints gbc_lbl_add_time = new GridBagConstraints();
      gbc_lbl_add_time.anchor = GridBagConstraints.EAST;
      gbc_lbl_add_time.fill = GridBagConstraints.VERTICAL;
      gbc_lbl_add_time.insets = new Insets(0, 0, 5, 5);
      gbc_lbl_add_time.gridx = 0;
      gbc_lbl_add_time.gridy = 1;
      panel.add(lbl_add_time, gbc_lbl_add_time);
      
      txt_time = new JTextField();     //조리시간
      GridBagConstraints gbc_txt_time = new GridBagConstraints();
      gbc_txt_time.insets = new Insets(0, 0, 5, 0);
      gbc_txt_time.gridx = 1;
      gbc_txt_time.gridy = 1;
      panel.add(txt_time, gbc_txt_time);
      txt_time.setColumns(10);
      
      JLabel lbl_add_price = new JLabel("\uAC00\uACA9");
      lbl_add_price.setFont(new Font("굴림체", Font.BOLD, 18));
      lbl_add_price.setForeground(new Color(185, 122, 87));// 글씨색 변경
      GridBagConstraints gbc_lbl_add_price = new GridBagConstraints();
      gbc_lbl_add_price.anchor = GridBagConstraints.EAST;
      gbc_lbl_add_price.fill = GridBagConstraints.VERTICAL;
      gbc_lbl_add_price.insets = new Insets(0, 0, 5, 5);
      gbc_lbl_add_price.gridx = 0;
      gbc_lbl_add_price.gridy = 2;
      panel.add(lbl_add_price, gbc_lbl_add_price);
      
      txt_price = new JTextField();         //가격
      GridBagConstraints gbc_txt_price = new GridBagConstraints();
      gbc_txt_price.insets = new Insets(0, 0, 5, 0);
      gbc_txt_price.gridx = 1;
      gbc_txt_price.gridy = 2;
      panel.add(txt_price, gbc_txt_price);
      txt_price.setColumns(10);
      
      JLabel lblNewLabel = new JLabel("칼로리");
      lblNewLabel.setForeground(new Color(185, 122, 87));// 글씨색 변경
      lblNewLabel.setFont(new Font("굴림체", Font.BOLD, 18));
      GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
      gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
      gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;      
      gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
      gbc_lblNewLabel.gridx = 0;
      gbc_lblNewLabel.gridy = 3;
      panel.add(lblNewLabel, gbc_lblNewLabel);
      

      textField = new JTextField();             //칼로리
      GridBagConstraints gbc_textField = new GridBagConstraints();
      gbc_textField.insets = new Insets(0, 0, 5, 0);
      gbc_textField.gridx = 1;
      gbc_textField.gridy = 3;
      panel.add(textField, gbc_textField);
      textField.setColumns(10);
      
      JLabel lblNewLabel_2 = new JLabel("이미지 경로");
      lblNewLabel_2.setFont(new Font("굴림체", Font.BOLD, 18));
      lblNewLabel_2.setForeground(new Color(185, 122, 87));// 글씨색 변경
      lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
      GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
      gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
      gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
      gbc_lblNewLabel_2.gridx = 0;
      gbc_lblNewLabel_2.gridy = 4;
      panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
      
      JLabel lblNewLabel_3 = new JLabel("Image Path");
      lblNewLabel_3.setOpaque(true);
      lblNewLabel_3.setBackground(new Color(242, 183, 5));
      GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
      lblNewLabel_3.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            
               // file chooser
               JFileChooser chooser = new JFileChooser();
               int returnVal = chooser.showOpenDialog(lblNewLabel_3);
               if(returnVal == JFileChooser.APPROVE_OPTION)
               {
                path = chooser.getSelectedFile().getPath();
               }
               System.out.println(path);
            
            
         }
      });
      gbc_lblNewLabel_3.gridx = 1;
      gbc_lblNewLabel_3.gridy = 4;
      panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
      
      
      
      
      
      JLabel lbl_submit = new JLabel("\uC644\uB8CC");
      lbl_submit.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {// 수정완료
            // 수정할 정보가 입력되어있다면 회원 DB업데이트
            FoodVO fvo = new FoodVO(txt_name.getText(), Integer.parseInt(txt_price.getText()), Integer.parseInt(txt_time.getText())
                  , store_name, textField.getText(), path);   
            fdao.insert(fvo);
            
            

            if (txt_name.getText().isEmpty()||txt_time.getText().isEmpty()||txt_price.getText().isEmpty()) {// 새 비밀번호가 입력되어있다면
               // 모든정보가 들어있지 않다면 경고창 보이기
               JOptionPane.showMessageDialog(null, "모든 정보를 입력해 주세요.");
            }
             else {//수정할 내용 없을 때
                // DB 업데이트
               frame.setVisible(false);
            }
         }
      });
      lbl_submit.setHorizontalAlignment(SwingConstants.CENTER);
      springLayout.putConstraint(SpringLayout.NORTH, lbl_submit, -35, SpringLayout.SOUTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.WEST, lbl_submit, -53, SpringLayout.EAST, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.SOUTH, lbl_submit, -10, SpringLayout.SOUTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.EAST, lbl_submit, -10, SpringLayout.EAST, frame.getContentPane());
      lbl_submit.setOpaque(true);
      lbl_submit.setBackground(new Color(242, 183, 5));// 라벨 색 변경
      lbl_submit.setFont(new Font("HY헤드라인M", Font.BOLD, 16));
      lbl_submit.setForeground(new Color(255, 255, 255));
      frame.getContentPane().add(lbl_submit);
      
      JLabel label = new JLabel("\uB2EB\uAE30");//닫기
      label.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            frame.dispose();
         }
      });
      springLayout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, lbl_submit);
      springLayout.putConstraint(SpringLayout.WEST, label, -49, SpringLayout.WEST, lbl_submit);
      springLayout.putConstraint(SpringLayout.SOUTH, label, 0, SpringLayout.SOUTH, lbl_submit);
      springLayout.putConstraint(SpringLayout.EAST, label, -6, SpringLayout.WEST, lbl_submit);
      label.setOpaque(true);
      label.setHorizontalAlignment(SwingConstants.CENTER);
      label.setForeground(Color.WHITE);
      label.setFont(new Font("HY헤드라인M", Font.BOLD, 16));
      label.setBackground(new Color(242, 183, 5));
      frame.getContentPane().add(label);
      
      
      
   }
}