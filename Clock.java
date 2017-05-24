import javax.swing.*;
import java.awt.*;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageProducer;


/**
 * Created by asus on 2017/4/24.
 */
public class Clock extends JPanel implements Runnable{
    Image[] digit;
    Image serialImage;
    ImageIcon imageIcon;
    ImageProducer source;
    CropImageFilter cutImage;
    Image[] images;
    JPanel p;
    JLabel jLabel;
    int i = 9;
    public Image[] dutDigit(){

        digit = new Image[10];
        serialImage = Toolkit.getDefaultToolkit().getImage("image/number4.png");
        source = serialImage.getSource();
        for(int i=0;i<10;i++)
        {
            cutImage = new CropImageFilter(19 * i, 0, 19, 26);
            digit[i] = createImage(new FilteredImageSource(source,cutImage));
        }
        return digit;
    }

    public Clock()
    {
        this.setLayout(null);
        images = dutDigit();
        imageIcon = new ImageIcon(images[i]);
        jLabel = new JLabel(imageIcon);
        JLabel jLabel2 = new JLabel(new ImageIcon("E:\\UI\\57.png"));
        jLabel2.setBounds(20,20,100,100);
        jLabel.setBounds(60,70,20,20);

        this.add(jLabel);
        this.add(jLabel2);
        new Thread(this).start();
    }

    public void run() {
        // TODO Auto-generated method stub
        try{
            while(true)
            {

                if(i==-1)
                    i=9;
                jLabel.setIcon(new ImageIcon(images[i]));
                Thread.sleep(1000);
                i--;
            }
        }catch(InterruptedException ex){

        }

    }

}

