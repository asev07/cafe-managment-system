package Guifromgit;

import Authentication.Aut;

import java.awt.Color;import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class screen1 extends JFrame implements ActionListener,MouseListener {

	 int id;

	JLayeredPane layers=new JLayeredPane();
	
	JLabel backgroundscreen = new JLabel();//background image holder label
	JLabel screen1title = new JLabel();//title label
	JLabel twitter = new JLabel();//twitter image label
	JLabel google = new JLabel();//googel image label
	JLabel instagram = new JLabel();//instagram image label
	JLabel screenlogo = new JLabel();//logo lable
	JLabel usernametext = new JLabel();//user name label
	JLabel passwordtext = new JLabel();//password label
	
	JTextField useridfild =new JTextField();//user name input field
	JPasswordField passwordfild=new JPasswordField(); //password input field
	
	//all are pictures of certain content  
	ImageIcon backgroundimg=new ImageIcon("img.png");
	/*
	ImageIcon inspic=new ImageIcon("instagram.png");
	ImageIcon twipic=new ImageIcon("twitter.png");
	ImageIcon goopic=new ImageIcon("google.png");
	*/
	ImageIcon scrlog=new ImageIcon("screen_logo.png");
	ImageIcon back=new ImageIcon("back.png");
		
	//all are panels that are rounded for certain content
	RoundPanel loginp = new RoundPanel();
	RoundPanel loginpborder = new RoundPanel();
	RoundPanel loginbp = new RoundPanel();
	RoundPanel enternp = new RoundPanel();

	//all are buttons
	JButton loginbutton = new JButton();
	JButton enterbutton = new JButton();
	JButton backbutton = new JButton();
	
	//color to use in the code
	Color lightred=new Color(226,120,103);
	Color blueblack=new Color(31,29,43);
	Color lightblue=new Color(95,180,254);
	Color lightblueblack=new Color(45,48,62);
	
	public screen1() {
		screen1title.setText("Cafe Managment System");
		screen1title.setForeground(Color.white);
		screen1title.setBounds(40,37,500,100);
		screen1title.setFont(new Font(null, Font.PLAIN, 20));
		
		screenlogo.setIcon(scrlog);
		screenlogo.setBounds(115,120,70,70);
		
		instagram.setText("Power");
		instagram.setBounds(80,468,38,38);
		
		google.setText("Computing");
		google.setBounds(151,468,69,38);
		
		twitter.setText("of");
		twitter.setBounds(127,468,30,38);
			
		backgroundscreen.setIcon(backgroundimg);
		backgroundscreen.setBounds(0,0,800,592);
		 
		backbutton.setIcon(back);
		backbutton.setBounds(10,20,40,40);
		backbutton.setFocusable(false);
		backbutton.setContentAreaFilled(false);
		backbutton.setBorderPainted(false);
		backbutton.addActionListener(this);
		backbutton.addMouseListener(this);
		backbutton.setVisible(false); 
		
		loginpborder.setBounds(246,22,307,519);
		loginpborder.setBackground(lightred);
		loginpborder.setRoundBottomLeft(61);
		loginpborder.setRoundBottomRight(61);
		loginpborder.setRoundTopLeft(61);
		loginpborder.setRoundTopRight(61);
			
		loginbp.setBackground(lightred);
		loginbp.setBounds(49,318,200,52);
		loginbp.setRoundBottomLeft(61);
		loginbp.setRoundBottomRight(61);
		loginbp.setRoundTopLeft(61);
		loginbp.setRoundTopRight(61);
		loginbp.setLayout(null);
		loginbp.add(loginbutton);
		
		loginbutton.setText("LOGIN");
		loginbutton.setContentAreaFilled(false); 
		loginbutton.setBorderPainted(false);
		loginbutton.setFocusable(false);
		loginbutton.setBounds(0,0,200,52);
		loginbutton.setFont(new Font(null,Font.BOLD,17));
		loginbutton.setForeground(Color.white);
		loginbutton.addActionListener(this);
		loginbutton.addMouseListener(this);
		
		usernametext.setText("User ID");
		usernametext.setFont(new Font(null,Font.BOLD,17));
		usernametext.setForeground(lightblue);
		usernametext.setBounds(24,242,100,30);
		usernametext.setVisible(false);
		
		useridfild.setBounds(42,272,209,46);
		useridfild.setBackground(lightblueblack);
		useridfild.setForeground(lightred);
		useridfild.setFont(new Font(null,Font.PLAIN,26));
		useridfild.setCaretColor(lightred);
		useridfild.setVisible(false);
			
		passwordtext.setText("Password");
		passwordtext.setFont(new Font(null,Font.BOLD,17));
		passwordtext.setForeground(lightblue);
		passwordtext.setBounds(24,317,100,30);
		passwordtext.setVisible(false);
		
		passwordfild.setBounds(42,346,209,46);
		passwordfild.setBackground(lightblueblack);
		passwordfild.setForeground(lightred);
		passwordfild.setFont(new Font(null,Font.PLAIN,26));
		passwordfild.setCaretColor(lightred);
		passwordfild.setVisible(false);	
		
		enterbutton.setText("Enter");
		enterbutton.setForeground(Color.white);
		enterbutton.setFont(new Font(null,Font.BOLD,18));
		enterbutton.setBounds(0,0,90,41);
		enterbutton.setContentAreaFilled(false);
		enterbutton.setBorderPainted(false);
		enterbutton.setEnabled(false);
		enterbutton.setFocusable(false);
		enterbutton.addActionListener(this);
		enterbutton.addMouseListener(this);
		
		enternp.setBackground(lightred);
		enternp.setBounds(93,405,90,41);
		enternp.setRoundBottomLeft(40);
		enternp.setRoundBottomRight(40);
		enternp.setRoundTopLeft(40);
		enternp.setRoundTopRight(40);
		enternp.setLayout(null);
		enternp.add(enterbutton);
		enternp.setVisible(false);
		
		loginp.setBounds(250,25,300,513);
		loginp.setBackground(blueblack);
		loginp.setLayout(null);
		loginp.setRoundBottomLeft(61);
		loginp.setRoundBottomRight(61);
		loginp.setRoundTopLeft(61);
		loginp.setRoundTopRight(61);
		loginp.add(backbutton);
		loginp.add(screen1title);
		loginp.add(instagram);
		loginp.add(google);
		loginp.add(twitter);
		loginp.add(screenlogo);
		loginp.add(loginbp);
		loginp.add(passwordtext);
		loginp.add(usernametext);
		loginp.add(useridfild);
		loginp.add(passwordfild);
		loginp.add(enternp);
		
		layers.setBounds(0,0,800,591);
		layers.add(loginp);
		layers.add(loginpborder);
		layers.add(backgroundscreen);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(scrlog.getImage());
		this.setVisible(true);
		this.setSize(800,591);
		this.setLayout(null);
		this.setResizable(false);
		this.setTitle("Cafe Managment System");
		this.add(layers);
		
		
	}
	
	void screen2() {
		loginbp.setVisible(false);
		loginbutton.setEnabled(false);
		backbutton.setVisible(true);
		usernametext.setVisible(true);
		passwordtext.setVisible(true);
		useridfild.setVisible(true);
		passwordfild.setVisible(true);
		enterbutton.setEnabled(true);
		enternp.setVisible(true);
		
	}

	void screen1r() {
		loginbp.setVisible(true);
		loginbutton.setEnabled(true);
		backbutton.setVisible(false);
		usernametext.setVisible(false);
		passwordtext.setVisible(false);
		useridfild.setVisible(false);
		passwordfild.setVisible(false);
		enterbutton.setEnabled(true);
		enternp.setVisible(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource()==loginbutton){
			screen2();
		}


		if(e.getSource()==enterbutton) {

			String userId = useridfild.getText().trim();
			boolean result = userId.matches("[a-zA-Z]+");
			if (passwordfild.getText().isEmpty() && useridfild.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Enter Username and Password", "Error", JOptionPane.INFORMATION_MESSAGE);
			}
			else if (useridfild.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Enter A Username", "Error", JOptionPane.INFORMATION_MESSAGE);
			}
			else if (result ) {
				JOptionPane.showMessageDialog(null, "user Id accepts numbers only !!!", "Error", JOptionPane.INFORMATION_MESSAGE);
			}

			else if (passwordfild.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Enter A Password", "Error", JOptionPane.INFORMATION_MESSAGE);
			}

			boolean success = false;
			Aut aut = new Aut();
			id=Integer.parseInt(useridfild.getText().trim());
				try {
					success = aut.authentication(id, passwordfild.getText());
				} catch (SQLException ex) {
					ex.printStackTrace();
				}

			if(success)
				{
					this.dispose();
					try {
						 Profilescreen p = new Profilescreen(id);
					} catch (SQLException ex) {
						ex.printStackTrace();
					}

				}
			else
				JOptionPane.showMessageDialog(null, "Wrong Username or Password", "error", JOptionPane.INFORMATION_MESSAGE);



		}
		if(e.getSource()==backbutton) {
			screen1r();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==loginbutton) {
			loginbp.setBackground(new Color(240,168,156));
		}
		if(e.getSource()==enterbutton) {
			enternp.setBackground(new Color(240,168,156));
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==loginbutton) {
			loginbp.setBackground(new Color(156,75,74));
		}
		if(e.getSource()==enterbutton) {
			enternp.setBackground(new Color(156,75,74));
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==backbutton) {
			backbutton.setContentAreaFilled(true);
			backbutton.setBackground(lightblueblack);
		}
		if(e.getSource()==loginbutton) {
			loginbp.setBackground(new Color(156,75,74));
		}
		if(e.getSource()==enterbutton) {
			enternp.setBackground(new Color(156,75,74));
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==backbutton) {
			backbutton.setContentAreaFilled(false);
		}
		if(e.getSource()==loginbutton) {
			loginbp.setBackground(lightred);
		}
		if(e.getSource()==enterbutton) {
			enternp.setBackground(lightred);
		}
	}
	
}
