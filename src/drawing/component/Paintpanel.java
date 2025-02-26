package drawing.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class Paintpanel extends JPanel implements  MouseListener, MouseMotionListener {
	int r = 10;
	protected int x = 0;
	protected int y = 0;
	Color currentcolor = Color.black;
	boolean isDrawing = false;
	public boolean isDrawn = false;
	private boolean paintingEnabled = true;
	
	public Paintpanel() {
		setBackground(new Color(255,255,255));

		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

    public void setCurrentColor(Color color) {
        currentcolor = color; 
    }
    public void setSize(int r) {
    	this.r = r;
    }
    public boolean isDrawn() {
    	return isDrawn;
    }

	@Override
	public void mouseDragged(MouseEvent e) {
		if (paintingEnabled) {
			Graphics g = getGraphics();
			g.setColor(currentcolor);

			if (e.getModifiersEx() == InputEvent.BUTTON1_DOWN_MASK) {
				isDrawn = true;
				g.fillOval(x - r, y - r, 2 * r, 2 * r);
			} else {
				g.setColor(new Color(255, 255, 255));
				g.fillOval(x - r, y - r, 2 * r, 2 * r);
			}

			x = e.getX();
			y = e.getY();
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		Graphics g = getGraphics();
//		super.paintComponent(g);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
		y = e.getY();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

    public void setDrawing(boolean isDrawing) {
        this.isDrawing = isDrawing;
    }

	public void setPaintingEnabled(boolean paintingEnabled) {
		this.paintingEnabled = paintingEnabled;
	}
}