package drawing.component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Toolspanel extends JLayeredPane implements ActionListener {
    JPanel topic_panel = new JPanel();
    JLabel lb_topic = new JLabel("Topic");
    JSlider slider_size = new JSlider(0, 20);
    JButton bt_clear = new JButton(" ");
    JButton bt_next = new JButton(" ");
    Paintpanel paintPanel;
    private static ArrayList<String> topicList = new ArrayList<String>();
    private String currentTopic;

    public boolean listEmpty = false;

    public Toolspanel(Paintpanel paintpanel) {

        this.paintPanel = paintpanel;
        setLayout(new FlowLayout());

        topic_panel.add(lb_topic);
        topic_panel.setOpaque(false);
        this.add(topic_panel);

        this.add(slider_size);
        slider_size.setPreferredSize(new Dimension(200, 20));
        slider_size.setOpaque(false);
        slider_size.setMinimum(2);
        slider_size.setMaximum(50);
        slider_size.setPaintTicks(true);
        slider_size.setPaintLabels(true);
        slider_size.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (e.getSource() == slider_size) {
                    int size = slider_size.getValue();
                    paintPanel.setSize(size);
                }
            }
        });

        this.add(bt_next);
        bt_next.setIcon(new ImageIcon("Project image\\Next button 2.PNG"));
        bt_next.setBorderPainted(false);
        bt_next.setContentAreaFilled(false);

        this.add(bt_clear);
        bt_clear.setIcon(new ImageIcon("Project image\\Clear button 2.PNG"));
        bt_clear.setBorderPainted(false);
        bt_clear.setContentAreaFilled(false);


        bt_clear.addActionListener(this);
        bt_next.addActionListener(this);


        topicList.add("Keyboard");
        topicList.add("Mouse");
        topicList.add("Car");
        topicList.add("Laptop");
        topicList.add("Tablet");
        topicList.add("Guitar");
        topicList.add("Barak Obama");
        topicList.add("Twitter");
        topicList.add("Elon Musk");
        topicList.add("SIIT Logo");
        topicList.add("Desk");
        topicList.add("Chair");
        topicList.add("Among us Red");
        validate();


        lb_topic.setFont(new Font("Monospaced", Font.BOLD, 15));
        if (!topicList.isEmpty()) {
            int index = (int) (Math.random() * topicList.size());
            currentTopic = topicList.remove(index);
            lb_topic.setText(currentTopic);
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == bt_clear) {
            Graphics g = paintPanel.getGraphics();
            g.setColor(new Color(255, 255, 255));
            g.fillRect(0, 0, paintPanel.getWidth(), paintPanel.getHeight());
            paintPanel.repaint();
        } else if (e.getSource() == bt_next) {
            if (paintPanel.isDrawn()) {
                if (!topicList.isEmpty()) {
                    int index = (int) (Math.random() * topicList.size());
                    currentTopic = topicList.remove(index);
                    lb_topic.setText(currentTopic);
                    Graphics g = paintPanel.getGraphics();
                    g.setColor(new Color(255, 255, 255));
                    g.fillRect(0, 0, paintPanel.getWidth(), paintPanel.getHeight());
                    paintPanel.isDrawn = false;
                    paintPanel.repaint();
                } else {
                    listEmpty = true;
                }

            }
        }
    }


}
