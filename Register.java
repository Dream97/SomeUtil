import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Register extends JDialog {
      private JLabel nametext =new JLabel("名字");
     private JLabel passtext = new JLabel("密码	");
     private JLabel phonetext =new JLabel("手机号码");
     private JTextField id = new JTextField(20);
     private JPasswordField pass =new JPasswordField(20);
     private JTextField  phone =new JTextField(20);
     private JButton ok =new JButton("注册");
     JPanel panelmain;
     
     public Register(JFrame frame)
     {
    	 super(frame,"注册窗口",false);
    	 panelmain  =new JPanel(new BorderLayout(10,10));
    	 nametext.setHorizontalAlignment(SwingConstants.RIGHT);
    	 passtext.setHorizontalAlignment(SwingConstants.RIGHT);
    	 phonetext.setHorizontalAlignment(SwingConstants.RIGHT);
    	 
    	/* Box row1  = Box.createHorizontalBox();
    	 row1.add(nametext);
    	 row1.add(id);
    	 
    	 Box row2 = Box.createHorizontalBox();
    	 row2.add(passtext);
    	 row2.add(pass);
    	 
    	 Box row3 =Box.createHorizontalBox();
    	 row3.add(phonetext);
    	 row3.add(phone);
    	 */
    	 Box col =Box.createVerticalBox();
    	 col.add(nametext);
    	 col.add(Box.createVerticalStrut(5));
    	 col.add(passtext);
    	 col.add(Box.createVerticalStrut(5));
    	 col.add(phonetext);
    	 
    	 Box col2 =Box.createVerticalBox();
    	 col2.add(id);
    	 col2.add(Box.createVerticalStrut(5));
    	 col2.add(pass);
    	 col2.add(Box.createVerticalStrut(5));
    	 col2.add(phone);
    	 
    	 Box row = Box.createHorizontalBox();
    	 //row.setAlignmentX(RIGHT_ALIGNMENT);
    	 row.add(col);
    	 row.add(Box.createHorizontalStrut(3));
    	 row.add(col2);
    	 
    /*	 Box col3 = Box.createVerticalBox();
    	 col3.add(row);
    	 
    	 col3.add(Box.createVerticalStrut(8));
    	 col3.add(ok);
    	*/ 
    	 
    	 
    	 this.setPreferredSize(new Dimension(350,300));
    	 Container contentPane =this.getContentPane();
    	  SpringLayout layout = new SpringLayout();
    	  contentPane.setLayout(layout);
    	  contentPane.add(row);
    	  layout.putConstraint(SpringLayout.NORTH,row,20,SpringLayout.NORTH,contentPane);
    	  layout.putConstraint(SpringLayout.WEST, row, 10,SpringLayout.WEST, contentPane);
    	  contentPane.add(ok);
    	  layout.putConstraint(SpringLayout.NORTH,ok,100,SpringLayout.NORTH,contentPane);
    	  layout.putConstraint(SpringLayout.WEST, ok, 65,SpringLayout.WEST, contentPane);
    	  
    	  //���ñ���
    	  JLabel bj =new JLabel(new ImageIcon(Register.class.getResource("/register.jpg")));
    	  contentPane.add(bj);
    	  
    	  
    	// panelmain.add(col);
    	// this.add(panelmain);
    	 Listener(this);
    	 this.setLocation(500,300);
    	 this.pack();
    	// this.setResizable(false);
    	 this.setVisible(true);
    	 
     }

	private void Listener(Register r) {
		// TODO Auto-generated method stub
		ok.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						// r.setVisible(false);
						int flag = JDBCOperation.insert(new User(phone.getText(),id.getText(),pass.getText()));
						JDBCOperation.getAll();
						if(flag==1){
							JOptionPane.showMessageDialog(null, "注册成功");
						}else {
							JOptionPane.showMessageDialog(null, "注册失败");
						}
					}
			
				});
		
	}
	
	private void quit(){
		System.exit(0);
	}
     
}
