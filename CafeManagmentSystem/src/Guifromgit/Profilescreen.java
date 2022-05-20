package Guifromgit;

import EMPLOYEE.Employee;
import EMPLOYEE.GetEmployeeInfo;
import Order.GetOrder;
import Order.Order;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.*;

//ASER to change name mnamn use the constractor by cancling the comment on screen1 or use individualy
//fname use userfirstnamelable.setText();
//lname use userfirstnamelable.setText();
//roleid use userroleidlable.setText();
//age use useragelable.setText();
//salary use usersalarylable.setText(); must have a $_ though
//contrat type use usercontratlable.setText();

public class Profilescreen<ord, size, data, arrySize> extends JFrame implements ActionListener,MouseListener{


	JLayeredPane layer=new JLayeredPane();

	JPanel sidepanel=new JPanel();
	JPanel s2background=new JPanel();

	JLabel logop=new JLabel();
	JLabel infoimagelabel=new JLabel();
	JLabel salaryimagelabel=new JLabel();
	JLabel contratimagelabel=new JLabel();
	JLabel profiletitle=new JLabel();
	JLabel userfirstnamelable=new JLabel();
	JLabel firstnamelable=new JLabel();
	JLabel userlastnamelable=new JLabel();
	JLabel lastnamelable=new JLabel();
	JLabel useragelable=new JLabel();
	JLabel agelable=new JLabel();
	JLabel userroleidlable=new JLabel();
	JLabel roleidlable=new JLabel();
	JLabel usersalarylable=new JLabel();
	JLabel salarylable=new JLabel();
	JLabel usercontratlable=new JLabel();
	JLabel contratlable=new JLabel();

	JButton personbutton=new JButton();
	JButton orderbutton=new JButton();



	JLabel orderrecordtitle=new JLabel();
	JLabel usertotalrevenue=new JLabel();
	JLabel totalrevenue=new JLabel();
	JLabel usertotalorder=new JLabel();
	JLabel totalorder=new JLabel();
	JLabel usertoporder=new JLabel();
	JLabel toporder=new JLabel();
	JLabel orderreport=new JLabel();
	JLabel item=new JLabel();
	JLabel orderid=new JLabel();
	JLabel price=new JLabel();
	JLabel employeename=new JLabel();



    //new labels added by @Aser


	JLabel orderPrice = new JLabel();
	JLabel orderDescription = new JLabel();

	JLabel totrevimagelabel=new JLabel();
	JLabel totordimagelabel=new JLabel();
	JLabel topordimagelabel=new JLabel();



	RoundPanel personclickedbackground=new RoundPanel();
	RoundPanel personclickedbuttonbackground=new RoundPanel();
	RoundPanel personinfopanel=new RoundPanel();
	RoundPanel personsalarypanel=new RoundPanel();
	RoundPanel personcontratpanel=new RoundPanel();
	RoundPanel topspliterpanel=new RoundPanel();
	//new order page

	RoundPanel orderclickedbuttonbackground=new RoundPanel();
	RoundPanel orderclickedbackground=new RoundPanel();
	RoundPanel orderrecordtotalpanel=new RoundPanel();
	RoundPanel orderrecordtotaliteampanel=new RoundPanel();
	RoundPanel orderrecorddatapanel=new RoundPanel();
	RoundPanel orderrecordpopularpanel=new RoundPanel();
	RoundPanel orderrecordspliter=new RoundPanel();

	//new order page




	String[] column = {"Order Id","Order name","catagory","quantity","employee","price"};

	GetOrder o = new GetOrder();
	Order ord[][] = o.hello();

	String[][] data = getData(ord);

	JTable t=new JTable(data,column);

	JScrollPane orderrecordscrollpanel=new JScrollPane(t);


	ImageIcon logo=new ImageIcon("logo.png");


/*

*/


	ImageIcon person=new ImageIcon("person.png");
	ImageIcon personc=new ImageIcon("personc.png");
	ImageIcon scrlog=new ImageIcon("screen_logo.png");
	ImageIcon infopanelimg=new ImageIcon("infoimage.png");
	ImageIcon salarypanelimg=new ImageIcon("salaryimage.png");
	ImageIcon contratpanelimg=new ImageIcon("contratimage.png");


	ImageIcon orderr=new ImageIcon("orderr.png");
	ImageIcon orderrc=new ImageIcon("orderrc.png");

	ImageIcon totalrevenueimg=new ImageIcon("total.png");
	ImageIcon totalordersimg=new ImageIcon("totalorder.png");
	ImageIcon toporderimg=new ImageIcon("toporder.png");


	Color darkblue =new Color(31,29,43);
	Color lightred=new Color(234,124,105);
	Color lightdarkblue=new Color(37,40,54);
	Color lightgray=new Color(163,178,186);
	public Profilescreen(int loggedId) throws SQLException {
		Employee e;

		e = new Employee();
		GetEmployeeInfo getInfo = new GetEmployeeInfo();
		e = getInfo.getEmployeeInfo(loggedId);

		// TODO Auto-generated constructor stub


		personbutton.setIcon(personc);
		personbutton.setContentAreaFilled(false);
		personbutton.setFocusable(false);
		personbutton.setBorderPainted(false);
		personbutton.setBounds(21,116,54,54);
		personbutton.addActionListener(this);
		personbutton.addMouseListener(this);

		profiletitle.setText("profile");
		profiletitle.setFont(new Font(null,Font.BOLD,33));
		profiletitle.setBounds(138,33,120,33);
		profiletitle.setForeground(Color.white);



		orderbutton.setIcon(orderr);
		orderbutton.setContentAreaFilled(false);
		orderbutton.setFocusable(false);
		orderbutton.setBorderPainted(false);
		orderbutton.setBounds(21,216,54,54);
		orderbutton.addActionListener(this);
		orderbutton.addMouseListener(this);

		orderclickedbackground.setBackground(lightred);
		orderclickedbackground.setRoundTopLeft(11);
		orderclickedbackground.setRoundTopRight(11);
		orderclickedbackground.setRoundBottomLeft(11);
		orderclickedbackground.setRoundBottomRight(11);
		orderclickedbackground.setBounds(21,216,54,54);
		orderclickedbackground.setVisible(false);

		orderclickedbuttonbackground.setBounds(11,206,89,75);
		orderclickedbuttonbackground.setBackground(lightdarkblue);
		orderclickedbuttonbackground.setRoundTopLeft(18);
		orderclickedbuttonbackground.setRoundTopRight(18);
		orderclickedbuttonbackground.setRoundBottomLeft(18);
		orderclickedbuttonbackground.setRoundBottomRight(18);

		orderclickedbuttonbackground.setVisible(false);

		orderrecordtitle.setText("Order Record");
		orderrecordtitle.setFont(new Font(null,Font.BOLD,33));
		orderrecordtitle.setBounds(138,33,500,33);
		orderrecordtitle.setForeground(Color.white);
		orderrecordtitle.setVisible(false);



		topspliterpanel.setBackground(new Color(57,60,73));
		topspliterpanel.setBounds(138,95,889,3);


		orderrecordspliter.setBackground(new Color(57,60,73));
		orderrecordspliter.setBounds(120,405,932,1);
		orderrecordspliter.setVisible(false);




		personclickedbackground.setBackground(lightred);
		personclickedbackground.setRoundTopLeft(11);
		personclickedbackground.setRoundTopRight(11);
		personclickedbackground.setRoundBottomLeft(11);
		personclickedbackground.setRoundBottomRight(11);
		personclickedbackground.setBounds(21,116,54,54);

		personclickedbuttonbackground.setBounds(11,105,89,75);
		personclickedbuttonbackground.setBackground(lightdarkblue);
		personclickedbuttonbackground.setRoundTopLeft(18);
		personclickedbuttonbackground.setRoundTopRight(18);
		personclickedbuttonbackground.setRoundBottomLeft(18);
		personclickedbuttonbackground.setRoundBottomRight(18);

		topspliterpanel.setBackground(new Color(57,60,73));
		topspliterpanel.setBounds(138,95,889,3);

		infoimagelabel.setIcon(infopanelimg);
		infoimagelabel.setBounds(197,181,184,178);

		salaryimagelabel.setIcon(salarypanelimg);
		salaryimagelabel.setBounds(534,182,85,85);

		contratimagelabel.setIcon(contratpanelimg);
		contratimagelabel.setBounds(523,460,85,85);


		totrevimagelabel.setIcon(totalrevenueimg);
		totrevimagelabel.setBounds(156,133,34,34);
		totrevimagelabel.setVisible(false);

		totordimagelabel.setIcon(totalordersimg);
		totordimagelabel.setBounds(487,133,34,34);
		totordimagelabel.setVisible(false);

		topordimagelabel.setIcon(toporderimg);
		topordimagelabel.setBounds(793,133,34,34);
		topordimagelabel.setVisible(false);



		userfirstnamelable.setText(e.firstName);
		userfirstnamelable.setForeground(Color.white);
		userfirstnamelable.setFont(new Font(null,Font.BOLD,27));
		userfirstnamelable.setBounds(197,393,250,27);

		firstnamelable.setText("First Name");
		firstnamelable.setForeground(lightgray);
		firstnamelable.setFont(new Font(null,Font.BOLD,13));
		firstnamelable.setBounds(197,422,250,13);

		userlastnamelable.setText(e.lastName);
		userlastnamelable.setForeground(Color.white);
		userlastnamelable.setFont(new Font(null,Font.BOLD,27));
		userlastnamelable.setBounds(197,458,250,27);

		lastnamelable.setText("Last Name");
		lastnamelable.setForeground(lightgray);
		lastnamelable.setFont(new Font(null,Font.BOLD,13));
		lastnamelable.setBounds(197,488,250,13);

		useragelable.setText(String.valueOf(e.age));
		useragelable.setForeground(Color.white);
		useragelable.setFont(new Font(null,Font.BOLD,27));
		useragelable.setBounds(197,525,250,27);

		agelable.setText("Age");
		agelable.setForeground(lightgray);
		agelable.setFont(new Font(null,Font.BOLD,13));
		agelable.setBounds(197,556,250,13);

		userroleidlable.setText(String.valueOf(e.id));
		userroleidlable.setForeground(Color.white);
		userroleidlable.setFont(new Font(null,Font.BOLD,27));
		userroleidlable.setBounds(197,591,250,27);

		roleidlable.setText("User ID");
		roleidlable.setForeground(lightgray);
		roleidlable.setFont(new Font(null,Font.BOLD,13));
		roleidlable.setBounds(197,621,250,13);

		usersalarylable.setText(String.valueOf(e.salary));
		usersalarylable.setForeground(Color.white);
		usersalarylable.setFont(new Font(null,Font.BOLD,54));
		usersalarylable.setBounds(533,292,500,80);

		salarylable.setText("Salary");
		salarylable.setForeground(lightgray);
		salarylable.setFont(new Font(null,Font.BOLD,34));
		salarylable.setBounds(648,236,300,40);

		usercontratlable.setText(e.contratType);
		usercontratlable.setForeground(Color.white);
		usercontratlable.setFont(new Font(null,Font.BOLD,54));
		usercontratlable.setBounds(533,562,500,80);

		contratlable.setText("Contrat type");
		contratlable.setForeground(lightgray);
		contratlable.setFont(new Font(null,Font.BOLD,34));
		contratlable.setBounds(640,512,300,40);






		usertotalorder.setText("500");
		usertotalorder.setForeground(Color.white);
		usertotalorder.setFont(new Font(null,Font.BOLD,27));
		usertotalorder.setBounds(489,172,300,27);
		usertotalorder.setVisible(false);

		totalorder.setText("Total Orders");
		totalorder.setForeground(lightgray);
		totalorder.setFont(new Font(null,Font.BOLD,13));
		totalorder.setBounds(489,218,250,13);
		totalorder.setVisible(false);

		usertotalrevenue.setText("$20,000");
		usertotalrevenue.setForeground(Color.white);
		usertotalrevenue.setFont(new Font(null,Font.BOLD,27));
		usertotalrevenue.setBounds(158,172,300,27);
		usertotalrevenue.setVisible(false);

		totalrevenue.setText("Total Revenue");
		totalrevenue.setForeground(lightgray);
		totalrevenue.setFont(new Font(null,Font.BOLD,13));
		totalrevenue.setBounds(158,218,250,13);
		totalrevenue.setVisible(false);

		usertoporder.setText("Tibs");
		usertoporder.setForeground(Color.white);
		usertoporder.setFont(new Font(null,Font.BOLD,27));
		usertoporder.setBounds(793,172,300,27);
		usertoporder.setVisible(false);

		toporder.setText("Top Orders");
		toporder.setForeground(lightgray);
		toporder.setFont(new Font(null,Font.BOLD,13));
		toporder.setBounds(793,218,250,13);
		toporder.setVisible(false);

		orderreport.setText("Order Report");
		orderreport.setForeground(Color.white);
		orderreport.setFont(new Font(null,Font.BOLD,18));
		orderreport.setBounds(145,315,250,18);
		orderreport.setVisible(false);

		item.setText("Order Id");
		item.setForeground(Color.white);
		item.setFont(new Font(null,Font.BOLD,13));
		item.setBounds(123,379,250,13);
		item.setVisible(false);

		orderid.setText("Order Name");
		orderid.setForeground(Color.white);
		orderid.setFont(new Font(null,Font.BOLD,13));
		orderid.setBounds(270,379,250,13);
		orderid.setVisible(false);

		price.setText("Catagory");
		price.setForeground(Color.white);
		price.setFont(new Font(null,Font.BOLD,13));
		price.setBounds(430,379,250,13);
		price.setVisible(false);

		employeename.setText("Quantity");
		employeename.setForeground(Color.white);
		employeename.setFont(new Font(null,Font.BOLD,13));
		employeename.setBounds(580,379,250,13);
		employeename.setVisible(false);


		orderPrice.setText("Price");
		orderPrice.setForeground(Color.white);
		orderPrice.setFont(new Font(null,Font.BOLD,13));
		orderPrice.setBounds(730,379,250,13);
		orderPrice.setVisible(false);




		orderDescription.setText("Cashier");
		orderDescription.setForeground(Color.white);
		orderDescription.setFont(new Font(null,Font.BOLD,13));
		orderDescription.setBounds(880,379,250,13);
		orderDescription.setVisible(false);


//		String[] column = {"Order Id","Order name","catagory","quantity","employee","price"};








		personinfopanel.setBackground(darkblue);
		personinfopanel.setBounds(127,141,322,613);
		personinfopanel.setRoundTopLeft(78);
		personinfopanel.setRoundTopRight(78);
		personinfopanel.setRoundBottomLeft(78);
		personinfopanel.setRoundBottomRight(78);

		personsalarypanel.setBackground(darkblue);
		personsalarypanel.setBounds(492,141,538,260);
		personsalarypanel.setRoundTopLeft(68);
		personsalarypanel.setRoundTopRight(68);
		personsalarypanel.setRoundBottomLeft(68);
		personsalarypanel.setRoundBottomRight(68);

		personcontratpanel.setBackground(darkblue);
		personcontratpanel.setBounds(492,418,538,339);
		personcontratpanel.setRoundTopLeft(68);
		personcontratpanel.setRoundTopRight(68);
		personcontratpanel.setRoundBottomLeft(68);
		personcontratpanel.setRoundBottomRight(68);






		orderrecordpopularpanel.setBackground(darkblue);
		orderrecordpopularpanel.setBounds(777,120,278,136);
		orderrecordpopularpanel.setRoundTopLeft(17);
		orderrecordpopularpanel.setRoundTopRight(17);
		orderrecordpopularpanel.setRoundBottomLeft(17);
		orderrecordpopularpanel.setRoundBottomRight(17);
		orderrecordpopularpanel.setVisible(false);

		orderrecorddatapanel.setBackground(darkblue);
		orderrecorddatapanel.setBounds(120,290,932,485);
		orderrecorddatapanel.setRoundTopLeft(18);
		orderrecorddatapanel.setRoundTopRight(18);
		orderrecorddatapanel.setRoundBottomLeft(18);
		orderrecorddatapanel.setRoundBottomRight(18);
		orderrecorddatapanel.setVisible(false);

		orderrecordtotaliteampanel.setBackground(darkblue);
		orderrecordtotaliteampanel.setBounds(456,120,283,136);
		orderrecordtotaliteampanel.setRoundTopLeft(17);
		orderrecordtotaliteampanel.setRoundTopRight(17);
		orderrecordtotaliteampanel.setRoundBottomLeft(17);
		orderrecordtotaliteampanel.setRoundBottomRight(17);
		orderrecordtotaliteampanel.setVisible(false);

		orderrecordtotalpanel.setBackground(darkblue);
		orderrecordtotalpanel.setBounds(120,120,283,136);
		orderrecordtotalpanel.setRoundTopLeft(17);
		orderrecordtotalpanel.setRoundTopRight(17);
		orderrecordtotalpanel.setRoundBottomLeft(17);
		orderrecordtotalpanel.setRoundBottomRight(17);
		orderrecordtotalpanel.setVisible(false);

		t.setTableHeader(null);
		t.setForeground(lightgray);
		t.setFont(new Font(null,Font.BOLD,13));
		t.setBackground(darkblue);
		t.setRowHeight(50);
		t.setShowGrid(false);
		t.setBorder(BorderFactory.createEmptyBorder());



		orderrecordscrollpanel.setBackground(darkblue);
		orderrecordscrollpanel.getViewport().setBackground(darkblue);
		orderrecordscrollpanel.setBounds(120,407,932,364);
		orderrecordscrollpanel.setBorder(null);
		orderrecordscrollpanel.setVisible(false);






		logop.setIcon(logo);
		logop.setBounds(20,21,55,55);

		sidepanel.setBackground(darkblue);
		sidepanel.setBounds(0, 0, 94, 800);
		sidepanel.setLayout(null);
		sidepanel.add(logop);

		s2background.setBackground(lightdarkblue);
		s2background.setBounds(0,0,1081,800);

		layer.setBounds(0, 0, 1081, 800);
		layer.add(personbutton);
		layer.add(personclickedbackground);
		layer.add(personclickedbuttonbackground);

		layer.add(orderbutton);
		layer.add(orderclickedbackground);
		layer.add(orderclickedbuttonbackground);

		layer.add(sidepanel);
		layer.add(topspliterpanel);


		layer.add(userfirstnamelable);
		layer.add(firstnamelable);
		layer.add(userlastnamelable);
		layer.add(lastnamelable);
		layer.add(useragelable);
		layer.add(agelable);
		layer.add(userroleidlable);
		layer.add(roleidlable);
		layer.add(salarylable);
		layer.add(usersalarylable);
		layer.add(contratlable);
		layer.add(usercontratlable);


		layer.add(infoimagelabel);
		layer.add(salaryimagelabel);
		layer.add(contratimagelabel);

		layer.add(personinfopanel);
		layer.add(personsalarypanel);
		layer.add(personcontratpanel);
		layer.add(profiletitle);


		layer.add(orderrecordscrollpanel);
		layer.add(employeename);
		layer.add(orderPrice);
		layer.add(orderDescription);
		layer.add(price);
		layer.add(orderid);
		layer.add(item);
		layer.add(orderreport);
		layer.add(orderrecordspliter);
		layer.add(toporder);
		layer.add(usertoporder);
		layer.add(totalrevenue);
		layer.add(usertotalrevenue);
		layer.add(totalorder);
		layer.add(usertotalorder);
		layer.add(topordimagelabel);
		layer.add(totordimagelabel);
		layer.add(totrevimagelabel);
		layer.add(orderrecordpopularpanel);
		layer.add(orderrecorddatapanel);
		layer.add(orderrecordtotalpanel);
		layer.add(orderrecordtotaliteampanel);
		layer.add(orderrecordtitle);

		layer.add(s2background);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setIconImage(scrlog.getImage());
		this.setSize(1081,825);
		this.setLayout(null);
		this.setResizable(true);
		this.setTitle("Cafe Managment System");
		this.add(layer);
	}


	private String[][] getData(Order ord[][]) {
		int size = ord[0][0].arrySize;
		String[][] data = new String [size][6];

		for (int i = 0; i < size; i++) {
			data[i][0] = String.valueOf(ord[i][0].id);
			data[i][1] = ord[i][0].name;
			data[i][2] = ord[i][0].catagory;
			data[i][3] = String.valueOf(ord[i][0].quantity);
			data[i][4] = String.valueOf(ord[i][0].singlePrice * ord[i][0].quantity);
			data[i][5] = ord[i][0].cashierName;
		}
		return data;
	}


	void profilescreenr() {
		psvisible(true);
		osvisible(false);

	}
	void psvisible(boolean x) {
		profiletitle.setVisible(x);
		userfirstnamelable.setVisible(x);
		firstnamelable.setVisible(x);
		userlastnamelable.setVisible(x);
		lastnamelable.setVisible(x);
		useragelable.setVisible(x);
		agelable.setVisible(x);
		userroleidlable.setVisible(x);
		roleidlable.setVisible(x);
		salarylable.setVisible(x);
		usersalarylable.setVisible(x);
		contratlable.setVisible(x);
		usercontratlable.setVisible(x);
		infoimagelabel.setVisible(x);
		salaryimagelabel.setVisible(x);
		contratimagelabel.setVisible(x);
		personinfopanel.setVisible(x);
		personsalarypanel.setVisible(x);
		personcontratpanel.setVisible(x);
		personclickedbuttonbackground.setVisible(x);
		personclickedbackground.setVisible(x);
		if (x==true) {
			personclickedbackground.setBackground(lightred);
			personbutton.setIcon(personc);
		}
		else {
			personbutton.setIcon(person);
		}
	}


	void osvisible(boolean x) {
		orderrecordtitle.setVisible(x);
		orderrecordspliter.setVisible(x);
		totrevimagelabel.setVisible(x);
		totordimagelabel.setVisible(x);
		topordimagelabel.setVisible(x);
		usertotalorder.setVisible(x);
		totalorder.setVisible(x);
		usertotalrevenue.setVisible(x);
		totalrevenue.setVisible(x);
		usertoporder.setVisible(x);
		toporder.setVisible(x);
		orderreport.setVisible(x);
		item.setVisible(x);
		orderid.setVisible(x);
		price.setVisible(x);
		employeename.setVisible(x);
		orderDescription.setVisible(x);
		orderPrice.setVisible(x);
		orderrecordpopularpanel.setVisible(x);
		orderrecorddatapanel.setVisible(x);
		orderrecordtotaliteampanel.setVisible(x);
		orderrecordtotalpanel.setVisible(x);
		orderrecordscrollpanel.setVisible(x);
		orderclickedbackground.setVisible(x);
		orderclickedbuttonbackground.setVisible(x);

		if(x==false) {
			orderbutton.setIcon(orderr);
		}else {
			orderbutton.setIcon(orderrc);
			orderclickedbackground.setBackground(lightred);
		}

	}
	void orderrecordscreen() {
		psvisible(false);
		osvisible(true);



	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==personbutton&&personclickedbackground.isVisible()==false) {
			personclickedbackground.setBackground(new Color(37,40,54));
			personclickedbackground.setVisible(true);
		}
		if(e.getSource()==orderbutton&&orderclickedbackground.isVisible()==false) {
			orderclickedbackground.setBackground(new Color(37,40,54));
			orderclickedbackground.setVisible(true);
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==personbutton&&personclickedbackground.getBackground()!=lightred) {
			personclickedbackground.setVisible(false);
		}
		if(e.getSource()==orderbutton&&orderclickedbackground.getBackground()!=lightred) {
			orderclickedbackground.setVisible(false);
		}

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==personbutton) {
			profilescreenr();
		}
		if (e.getSource()==orderbutton) {
			orderrecordscreen();
		}

	}
}
