import javax.swing.*;
import java.awt.*;

/**
 * Created by asus on 2017/4/24.
 */
public class MainActivity {

    private JFrame jFrame;
    private JLabel jLabel;
    private JPanel jPanel;
    ImageIcon imageIcon ;
    public MainActivity()
    {
        imageIcon = new ImageIcon();
        jFrame = new JFrame();
        jFrame.setTitle("测试窗口");
        jPanel = new JPanel();
        //一个标签

        Clock clock = new Clock();
//        Image[] images = clock.dutDigit();
//        imageIcon.setImage(images[1]);
//        jLabel = new JLabel(new ImageIcon(images[1]));
//        //jLabel.setIcon(imageIcon);
//        jLabel.setText("嘿");
//
//        JLabel bj =new JLabel(new ImageIcon(MainActivity.class.getResource("image/number4.png")));
//        jPanel.add(jLabel,BorderLayout.CENTER);
        jFrame.add(clock,BorderLayout.CENTER);
        jFrame.setBounds(200,200,500,500);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainActivity();
    }
}
