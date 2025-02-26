package menu.component;

import drawing.component.Gamepanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pausepanel extends JPanel {
    public static JLayeredPane pause_pane = new JLayeredPane();
    JLabel pause_panebg = new JLabel(new ImageIcon("Project image\\Pause.PNG"));
    JButton bt_mainmenu = new JButton(new ImageIcon("Project image\\Mainmenu button.PNG"));

    JButton bt_resume = new JButton(new ImageIcon("Project image\\Resume button.PNG"));

    public Pausepanel() {

        bt_resume.setBounds(272, 200, 125, 40);
        bt_resume.setBorderPainted(false);
        bt_resume.setOpaque(false);
        bt_resume.setContentAreaFilled(false);
        bt_resume.setFocusPainted(false);
        pause_pane.add(bt_resume);
//        bt_resume.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("resume");
//                gamepanel.remove(pause_pane);
//            }
//        });


        bt_mainmenu.setBounds(272, 260, 256, 256);
        bt_mainmenu.setBorderPainted(false);
        bt_mainmenu.setOpaque(false);
        bt_mainmenu.setContentAreaFilled(false);
        bt_mainmenu.setFocusPainted(false);
        pause_pane.add(bt_mainmenu);
        bt_mainmenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(pause_pane);
                frame.remove(Gamepanel.gamepane);
                frame.remove(pause_pane);
                frame.add(Menupanel.menu_pane);
                frame.revalidate();
                frame.repaint();

            }
        });


        pause_panebg.setBounds(0, 0, 800, 600);
        pause_pane.setBounds(0, 0, 800, 600);


        pause_pane.add(pause_panebg);


    }


}
