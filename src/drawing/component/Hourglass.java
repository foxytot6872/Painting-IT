package drawing.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hourglass extends JPanel {

    private ImageIcon[] hourglassImages ={
            new ImageIcon("Project image\\Hourglass 0.PNG"),
            new ImageIcon("Project image\\Hourglass 1.PNG"),
            new ImageIcon("Project image\\Hourglass 2.PNG"),
            new ImageIcon("Project image\\Hourglass 3.PNG"),
            new ImageIcon("Project image\\Hourglass 4.PNG"),
            new ImageIcon("Project image\\Hourglass 5.PNG"),
            new ImageIcon("Project image\\Hourglass spin 1.PNG"),
            new ImageIcon("Project image\\Hourglass spin 2.PNG"),
            new ImageIcon("Project image\\Hourglass spin 3.PNG"),
            new ImageIcon("Project image\\Hourglass spin 4.PNG")
    };
    private  JLabel hourglassPic = new JLabel(hourglassImages[0]);

    public Timer timer = new Timer(200, new ActionListener() {
        private int count = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            count = (count + 1) % hourglassImages.length;
            hourglassPic.setIcon(hourglassImages[count]);
        }
    });
    public Hourglass(){
        setOpaque(false);
        setLayout(new BorderLayout());
        add(hourglassPic, BorderLayout.CENTER);
        timer.start();
    }
    public void pauseTimer() {
        timer.stop();
    }
    public void resumeTimer() {
        timer.start();
    }
}