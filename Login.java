import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.Container;

import javax.swing.*;
public class Login {
    JFrame jf = new JFrame("登录");
    JLabel nametext = new JLabel("名字");
    JLabel passtext = new JLabel("密码");
    JTextField name = new JTextField(20);
    JPasswordField pass = new JPasswordField(20);
    JButton login = new JButton("登录");
    JButton register=new JButton("注册");

    ImageIcon background =new ImageIcon("ico/Login.jpg");
     
    
    /**
     *
     */
    public void init()
    {
        jf.setResizable(true);
        nametext.setForeground(Color.WHITE);
        passtext.setForeground(Color.WHITE);
         //�������Ҷ���
        nametext.setHorizontalAlignment(SwingConstants.RIGHT);
        passtext.setHorizontalAlignment(SwingConstants.RIGHT);
        //���ִ���
        Box center =Box.createHorizontalBox();
        center.add(nametext);
        center.add(Box.createHorizontalStrut(3));
        center.add(name);
        
        Box center2 =Box.createHorizontalBox();
        center2.add(passtext);
        center2.add(Box.createHorizontalStrut(3));
        center2.add(pass);
        
        Box center3 =Box.createHorizontalBox();
        center3.add(login);
        center3.add(Box.createHorizontalStrut(8));
        center3.add(register);
        
        
        Box button =Box.createVerticalBox();
        button.add(center);
        button.add(Box.createVerticalStrut(10));
        button.add(center2);
        button.add(Box.createVerticalStrut(10));
        button.add(center3);

       // p.add(button);
       // JPanel p2 =new JPanel();
        jf.setPreferredSize(new Dimension(700,400));
       // p2.add(p, BorderLayout.NORTH);

        Container contentPane =jf.getContentPane();
        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);
        contentPane.add(button);
        
        
        layout.putConstraint(SpringLayout.WEST,button,50,SpringLayout.WEST,contentPane);
        layout.putConstraint(SpringLayout.NORTH,button,150,SpringLayout.NORTH,contentPane);
        //����
        JLabel bgLabel = new JLabel(new ImageIcon(Login.class.getResource("/Login.jpg")));
        contentPane.add(bgLabel);//ȫ���ǹ�����
        listener();//����
        jf.setLocation(500,300);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] main)
    {
        new Login().init();
    }
    
    
    //��Ӽ����¼�
    public void listener()
    {
    	 login.addActionListener(new ActionListener()
 		{

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
                    Integer flag = JDBCOperation.select(name.getText(),pass.getText());
                    if(flag == 1){
                        JOptionPane.showMessageDialog(null, "登录成功");
                    }else {
                        JOptionPane.showMessageDialog(null, "登录失败");
                    }
				}
 		});
    	 register.addActionListener(new ActionListener()
    			 {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
					   new Register(jf);
					}
    		 
    			 });  	 
    }
    

}