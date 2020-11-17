// CMPT 275 Assignment 3
// Author: Chin Ho Wan 301308171
// file: MyPanel
// GUI (Panel) drawing Shape (extend JPanel)

package A3;

import java.awt.*;
import javax.swing.*;

// Panel class for drawing the shapes
public class MyPanel extends JPanel{

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;

        // Draw Triangle
        g2D.setColor(Color.orange);
        g2D.fillPolygon(new int[] {50,90,130}, new int[] {180,110,180}, 3);
        g2D.setColor(new Color(255,153,51));
        g2D.drawPolygon(new int[] {50,90,130}, new int[] {180,110,180}, 3);

        // Draw Rectangle
        g2D.setColor(new Color(76,153,0));
        g2D.fillRect(180,110,100,70);
        g2D.setColor(new Color(51,102,0));
        g2D.drawRect(180,110,100,70);

        // Draw ellipse
        g2D.setColor(new Color(0,102,204));
        g2D.fillOval(320,120,100,60);
        g2D.setColor(new Color(0,51,102));
        g2D.drawOval(320,120,100,60);

        // Draw square
        g2D.setColor(new Color(255,255,51));
        g2D.fillRect(475,110,70,70);
        g2D.setColor(new Color(0,102,204));
        g2D.drawRect(475,110,70,70);

        // Draw circle
        g2D.setColor(Color.white);
        g2D.fillOval(610,110,70,70);
        g2D.setColor(new Color(0,102,204));
        g2D.drawOval(610,110,70,70);

    }
}
