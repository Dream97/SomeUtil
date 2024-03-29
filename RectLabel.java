import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Created by asus on 2017/5/14.
 */

public class RectLabel extends JLabel {

    private int x1 = 0;
    private int y1 = 0;
    private int x2 = 0;
    private int y2 = 0;
    private boolean current = true;

    public RectLabel() {
        super();
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent event) {
                Point p = event.getPoint();
                x1 = (int) p.getX();
                y1 = (int) p.getY();
            }

            public void mouseReleased(MouseEvent event) {
                Point p = event.getPoint();
                x2 = (int) p.getX();
                y2 = (int) p.getY();
                current = true;
                repaint();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent event) {
                Point p = event.getPoint();
                x2 = (int) p.getX();
                y2 = (int) p.getY();
                current = false;
                repaint();
            }
        });
    }

    // 画圆的背景和标签
    protected void paintComponent(Graphics g) {
        if (!current)
            return;
        g.setColor(new Color(64, 64, 64,10));

        g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2),
                Math.abs(y1 - y2));

        super.paintComponent(g);
    }

    // 用简单的弧画按钮的边界。
    protected void paintBorder(Graphics g) {
        if (current)
            return;
        g.setColor(getForeground());
        g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2),
                Math.abs(y1 - y2));
    }

    public static void main(String[] args) {
        JLabel test = new RectLabel();

        JFrame frame = new JFrame();
        frame.getContentPane().add(test);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }
}
