package drawing.component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class Colorpanel extends JPanel implements ActionListener {
	JPanel panel_color = new JPanel();
	JPanel panel_timer = new JPanel();

	JLabel lb_timer = new JLabel("Timer");
	JButton bt_red = new JButton();
	JButton bt_blu = new JButton();
	JButton bt_cyn = new JButton();
	JButton bt_grn = new JButton();
	JButton bt_yel = new JButton();
	JButton bt_pnk = new JButton();
	JButton bt_blk = new JButton();
	JButton bt_gry = new JButton();
	JButton bt_orng = new JButton();
	JButton bt_purp = new JButton();
	JLabel lb_red = new JLabel("Red");
	JLabel lb_blu = new JLabel("Blue");
	JLabel lb_cyn = new JLabel("Cyan");
	JLabel lb_grn = new JLabel("Green");
	JLabel lb_yel = new JLabel("Yellow");
	JLabel lb_pnk = new JLabel("Pink");
	JLabel lb_blk = new JLabel("Black");
	JLabel lb_gry = new JLabel("Gray");
	JLabel lb_orng = new JLabel("Orange");
	JLabel lb_purp = new JLabel("Purple");
	Paintpanel paintPanel;

	public Colorpanel(Paintpanel paintPanel) {

		this.paintPanel = paintPanel;
		panel_color.setLayout(new GridLayout(10,2));
		panel_color.setOpaque(false);
		setLayout(new BorderLayout());
		add(panel_color,BorderLayout.CENTER);
		setOpaque(false);

		panel_color.add(bt_pnk);
		bt_pnk.setBackground(Color.magenta);
		bt_pnk.setOpaque(true);
		panel_color.add(lb_pnk);
		lb_pnk.setFont(new Font("Monospaced", Font.BOLD,12));

		panel_color.add(bt_red);
		bt_red.setBackground(Color.red);
		bt_red.setOpaque(true);
		panel_color.add(lb_red);
		lb_red.setFont(new Font("Monospaced", Font.BOLD,12));

		panel_color.add(bt_orng);
		bt_orng.setBackground(Color.orange);
		bt_orng.setOpaque(true);
		panel_color.add(lb_orng);
		lb_orng.setFont(new Font("Monospaced", Font.BOLD,12));

		panel_color.add(bt_yel);
		bt_yel.setBackground(Color.yellow);
		bt_yel.setOpaque(true);
		panel_color.add(lb_yel);
		lb_yel.setFont(new Font("Monospaced", Font.BOLD,12));

		panel_color.add(bt_grn);
		bt_grn.setBackground(Color.green);
		bt_grn.setOpaque(true);
		panel_color.add(lb_grn);
		lb_grn.setFont(new Font("Monospaced",Font.BOLD,12));

		panel_color.add(bt_cyn);
		bt_cyn.setBackground(Color.cyan);
		bt_cyn.setOpaque(true);
		panel_color.add(lb_cyn);
		lb_cyn.setFont(new Font("Monospaced", Font.BOLD,12));

		panel_color.add(bt_blu);
		bt_blu.setBackground(Color.blue);
		bt_blu.setOpaque(true);
		panel_color.add(lb_blu);
		lb_blu.setFont(new Font("Monospaced", Font.BOLD,12));

		panel_color.add(bt_purp);
		bt_purp.setBackground(new Color(160, 32, 240));
		bt_purp.setOpaque(true);
		panel_color.add(lb_purp);
		lb_purp.setFont(new Font("Monospaced", Font.BOLD,12));

		panel_color.add(bt_gry);
		bt_gry.setBackground(Color.gray);
		bt_gry.setOpaque(true);
		panel_color.add(lb_gry);
		lb_gry.setFont(new Font("Monospaced", Font.BOLD,12));

		panel_color.add(bt_blk);
		bt_blk.setBackground(Color.black);
		bt_blk.setOpaque(true);
		panel_color.add(lb_blk);
		lb_blk.setFont(new Font("Monospaced", Font.BOLD,12));



		bt_red.addActionListener(this);
		bt_blu.addActionListener(this);
		bt_grn.addActionListener(this);
		bt_yel.addActionListener(this);
		bt_pnk.addActionListener(this);
		bt_blk.addActionListener(this);
		bt_gry.addActionListener(this);
		bt_orng.addActionListener(this);
		bt_purp.addActionListener(this);
		bt_cyn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt_red) {
			paintPanel.setCurrentColor(Color.RED);
		} else if (e.getSource() == bt_blu) {
			paintPanel.setCurrentColor(Color.BLUE);
		} else if (e.getSource() == bt_grn) {
			paintPanel.setCurrentColor(Color.GREEN);
		} else if (e.getSource() == bt_yel) {
			paintPanel.setCurrentColor(Color.YELLOW);
		} else if (e.getSource() == bt_pnk) {
			paintPanel.setCurrentColor(Color.MAGENTA);
		} else if (e.getSource() == bt_blk) {
			paintPanel.setCurrentColor(Color.BLACK);
		} else if (e.getSource() == bt_purp) {
			paintPanel.setCurrentColor(new Color(160, 32, 240));
		} else if (e.getSource() == bt_orng) {
			paintPanel.setCurrentColor(new Color(255, 165, 0));
		} else if (e.getSource() == bt_gry) {
			paintPanel.setCurrentColor(Color.GRAY);
		} else if (e.getSource() == bt_cyn) {
			paintPanel.setCurrentColor(Color.CYAN);
		}
	}
}