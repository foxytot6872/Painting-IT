package drawing.component;

import menu.component.Menupanel;
import menu.component.Pausepanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gamepanel extends JPanel {
    public static JLayeredPane gamepane = new JLayeredPane();
    JLabel pause = new JLabel(new ImageIcon("Project image\\Pause banner.PNG"));
    JButton bt_pause = new JButton(new ImageIcon("Project image\\Pause button 2.PNG"));
    JButton bt_info = new JButton(new ImageIcon("Project image\\QuestionMark 2.PNG"));
    JButton bt_mainmenu = new JButton(new ImageIcon("Project image\\Mainmenu button.PNG"));
    JButton bt_resume = new JButton(new ImageIcon("Project image\\Resume button.PNG"));
    JLabel gameover = new JLabel(new ImageIcon("C:\\Users\\foxyt\\Desktop\\NotScribble\\Project image\\Gameover.PNG"));
    JLabel timerLabel = new JLabel("04:00", SwingConstants.CENTER);
    Hourglass hourglass = new Hourglass();

    Trophy trophy = new Trophy();
    Toolspanel tools;
    Paintpanel paint;
    Colorpanel color;


    Timer gameTimer = new Timer(1000, new ActionListener() {
        int remainingTime = 240;

        @Override
        public void actionPerformed(ActionEvent e) {
            remainingTime--;
            if (remainingTime >= 0) {
                int minutes = remainingTime / 60;
                int seconds = remainingTime % 60;
                timerLabel.setText(String.format("%02d:%02d", minutes, seconds));
            } else {
                gameTimer.stop();
                hourglass.pauseTimer();
                ((Paintpanel) paint).setPaintingEnabled(false);
                gameover.setVisible(true);

            }
            checkWin();
        }
    });

    public Gamepanel() {
        JLabel background = new JLabel(new ImageIcon("Project image/Background.PNG"));

        Pausepanel pausepanel = new Pausepanel();
        paint = new Paintpanel();
        color = new Colorpanel(paint);
        tools = new Toolspanel(paint);

        gameover.setFont(new Font("Monospaced", Font.BOLD, 50));
        gameover.setForeground(Color.RED);
        gameover.setBounds(0, 0, 800, 600);
        gameover.setVisible(false);
        gamepane.add(gameover, JLayeredPane.POPUP_LAYER);

        gameTimer.start();
        timerLabel.setFont(new Font("Monospaced", Font.BOLD, 18));

        background.setVisible(true);
        background.setOpaque(true);
        background.setBounds(0, 0, 800, 600);

        gamepane.setBounds(0, 0, 800, 600);
        tools.setBounds(20, 500, 640, 100);
        color.setBounds(669, 30, 100, 400);
        paint.setBounds(25, 25, 606, 440);
        timerLabel.setBounds(660, 505, 100, 50);
        hourglass.setBounds(600, 500, 100, 64);
        trophy.setBounds(184,280,432,264);
        pause.setBounds(248, 60, 304, 432);
        bt_pause.setBounds(760, 5, 32, 32);


        gamepane.add(timerLabel, JLayeredPane.MODAL_LAYER);
        gamepane.add(hourglass, JLayeredPane.MODAL_LAYER);
        gamepane.add(color, JLayeredPane.MODAL_LAYER);
        gamepane.add(tools, JLayeredPane.MODAL_LAYER);
        gamepane.add(paint, JLayeredPane.MODAL_LAYER);
        gamepane.add(background, JLayeredPane.PALETTE_LAYER);
        gamepane.add(bt_pause, JLayeredPane.MODAL_LAYER);
        gamepane.add(bt_info, JLayeredPane.MODAL_LAYER);
        gamepane.add(pause, JLayeredPane.POPUP_LAYER);
        pause.setVisible(false);

        add(gamepane);
        revalidate();
        repaint();


        bt_pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameTimer.stop();
                pause.setVisible(true);
                hourglass.pauseTimer();
                ((Paintpanel) paint).setPaintingEnabled(false);

                bt_resume.setBounds(275, 280, 250, 80);
                bt_resume.setBorderPainted(false);
                bt_resume.setOpaque(false);
                bt_resume.setContentAreaFilled(false);
                bt_resume.setFocusPainted(false);
                gamepane.add(bt_resume, JLayeredPane.DRAG_LAYER);
                bt_resume.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(gamepane);
                        ((Paintpanel) paint).setPaintingEnabled(true);
                        pause.setVisible(false);
                        hourglass.resumeTimer();
                        gameTimer.start();
                        gamepane.remove(bt_resume);
                        gamepane.remove(bt_mainmenu);
                        frame.revalidate();
                        frame.repaint();

                    }
                });
            }
        });

    }

    private void checkWin() {
        if (tools.listEmpty) {
            JLabel gameWin = new JLabel(new ImageIcon("Project image\\Win.PNG"));
            gameWin.setFont(new Font("Monospaced", Font.BOLD, 50));
            gameWin.setForeground(Color.GREEN);
            gameWin.setBounds(0, 0, 800, 600);
            gamepane.add(gameWin, JLayeredPane.POPUP_LAYER);
            gamepane.add(trophy, JLayeredPane.DRAG_LAYER);
            gameWin.setVisible(true);
            gameTimer.stop();
            revalidate();
            repaint();
        }
    }

    public static Component getGamepane() {
        return gamepane;
    }
}


