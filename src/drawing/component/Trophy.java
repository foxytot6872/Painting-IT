package drawing.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Trophy extends JPanel{
    private ImageIcon[] TrophyImages ={
            new ImageIcon("Project image\\Trophy1.PNG"),
            new ImageIcon("Project image\\Trophy2.PNG"),
            new ImageIcon("Project image\\Trophy3.PNG"),
            new ImageIcon("Project image\\Trophy4.PNG"),
            new ImageIcon("Project image\\Trophy5.PNG"),
            new ImageIcon("Project image\\Trophy6.PNG"),
            new ImageIcon("Project image\\Trophy7.PNG"),
            new ImageIcon("Project image\\Trophy8.PNG"),

    };
    private  JLabel Trophy = new JLabel(TrophyImages[0]);

    public Timer timer = new Timer(200, new ActionListener() {
        private int count = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            count = (count + 1) % TrophyImages.length;
            Trophy.setIcon(TrophyImages[count]);
        }
    });
    public Trophy(){
        setOpaque(false);
        setLayout(new BorderLayout());
        add(Trophy, BorderLayout.CENTER);
        timer.start();
    }
    public void pauseTimer() {
        timer.stop();
    }
    public void resumeTimer() {
        timer.start();
    }
}

