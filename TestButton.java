import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.JarFile;

/**
 * Created by asus on 2017/5/14.
 */
public class TestButton extends JFrame implements ActionListener {
    JPanel jPanel = new JPanel(null);
    JButton jButton = new JButton();
    JButton jButton2 = new JButton();
    public TestButton(){
        jButton.setIcon(new ImageIcon("image/timer_back.png"));
        jButton.setBounds(20,20,60,60);
        jButton2.setIcon(new ImageIcon("image/timer_back.png"));
        jButton2.setBounds(20,100,60,60);
        jButton2.setPressedIcon(new ImageIcon("image/number4.png"));
        jButton.addActionListener(this);
        jPanel.add(jButton);
        jPanel.add(jButton2);
        this.add(jPanel);
        this.setBounds(200,200,800,800);
        this.setVisible(true);
    }
    public static void main(String[] args)
    {
        new TestButton();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jButton.setIcon(new ImageIcon("image/select.png"));
    }
}
