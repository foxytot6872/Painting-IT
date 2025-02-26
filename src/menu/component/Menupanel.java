package menu.component;

import drawing.component.Gamepanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menupanel extends JPanel  {
	public static JLayeredPane menu_pane = new JLayeredPane();



//	JFrame frame2 = new JFrame();
	JLabel paintITbg = new JLabel(new ImageIcon("C:\\Users\\foxyt\\Desktop\\NotScribble\\Project image\\Paint IT.PNG"));
	JButton bt_play = new JButton(new ImageIcon("Project image\\Play button.PNG"));
	JButton bt_setting = new JButton(new ImageIcon("Project image\\Setting button.PNG"));
	JButton bt_quit = new JButton(new ImageIcon("Project image\\Quit button.PNG"));

	public Menupanel(){

		Gamepanel gamepanel = new Gamepanel();


		paintITbg.setVisible(true);
		paintITbg.setOpaque(true);
		paintITbg.setBounds(0,0,800,600);

		bt_play.setBounds(304,230,192,100);
		bt_play.setBorderPainted(false);
		bt_play.setOpaque(false);
		bt_play.setContentAreaFilled(false);
		bt_play.setFocusPainted(false);
		bt_play.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(menu_pane);
				frame.remove(menu_pane);
				frame.remove(Pausepanel.pause_pane);
				frame.add(Gamepanel.gamepane);
//				frame.add(Gamepanel.getGamepane());
				frame.revalidate();
				frame.repaint();
			}
		});


		bt_quit.setBounds(304,370,192,70);
		bt_quit.setBorderPainted(false);
		bt_quit.setOpaque(false);
		bt_quit.setContentAreaFilled(false);
		bt_quit.setFocusPainted(false);
		bt_quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		menu_pane.setBounds(0,0,800,600);
		menu_pane.add(bt_play);
		menu_pane.add(bt_quit);
		menu_pane.add(bt_setting);
		menu_pane.add(paintITbg);
		menu_pane.setVisible(true);

	}
}

