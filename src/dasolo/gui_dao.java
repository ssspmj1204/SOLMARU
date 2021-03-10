package dasolo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class gui_dao {

	public JPanel make_menu(FoodVO VO) {
	
		JPanel panel1 = new JPanel();
//	TitledBorder  tit= new TitledBorder(new LineBorder(Color.black));
		panel1.setLayout(new GridLayout(2, 0, 0, 0));
//	panel1.setBorder(tit);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(VO.getFoodimage()));
		lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 10));
		panel1.add(lblNewLabel_5);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel1.add(panel_1);
		panel_1.setLayout(new GridLayout(3, 0, 0, 0));

		JLabel lblNewLabel_14 = new JLabel(VO.getFoodName()+"("+ VO.getCal() +")");
		lblNewLabel_14.setBackground(new Color(255, 255, 255));
		lblNewLabel_14.setForeground(new Color(0, 0, 0));
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("가격 : " + VO.getPrice() + "원");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_15);

		JLabel lblNewLabel_16 = new JLabel("조리시간 : " + VO.getFoodtime() + "분" );
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_16);

		return panel1;
	}

}
