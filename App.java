package currencyExchange;


import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.PopupMenu;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;

public class App extends JFrame implements ActionListener,MouseListener {
	public static void main(String s[]) {

		new App ().setVisible(true);

	}

	DefaultListModel dm = new DefaultListModel();

	ArrayList<currancy> list = new ArrayList<currancy>();
	ArrayList<Item> list2 = new ArrayList<Item>();
	ArrayList<Item> list3 = new ArrayList<Item>();

	private JPanel panel1, panel2, panel3, panel4, panel5;

	// first panel
	private JLabel symbol;
	private JLabel currencyName;
	private JTextField symb, currency;
	private JButton AddCurrency;

	// second panel
	private JLabel oneCurrency;
	private JComboBox currencyExchangeFrom;
	private JTextField number;
	private JComboBox currencyExchangeTo;
	private JButton AddRate;

	// third panel
	private JLabel rateToUpdate;
	private JComboBox currencyExchangeUpdate;
	private JLabel newRatel;
	private JTextField newRate;
	private JButton Update;

	// fourth panel
	private JLabel amount;
	private JTextField amountCurrency;
	private JLabel Rate;
	private JComboBox currencyExchange;
	private JButton Add;

	// Fifth panel
	private JButton Remove;
boolean flag;
	private GridLayout grid;
	private Border bord;
	javax.swing.JList amountCurrencyExchange;

	// constructor
	public App () {
		super("Currency Exchange");

		setSize(1000, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		grid = new GridLayout(5, 1);
		setLayout(grid);
		bord = BorderFactory.createLineBorder(Color.BLACK);
		bord= BorderFactory.createMatteBorder(1, 0,0 , 0, Color.black);
		// panel 11
		panel1 = new JPanel();

		symbol = new JLabel("Symbol");
		symb = new JTextField(5);
		currencyName = new JLabel("Currency Name");
		currency = new JTextField(25);
		AddCurrency = new JButton("Add Currency");
		panel1.add(symbol);
		panel1.add(symb);
		panel1.add(currencyName);
		panel1.add(currency);
		panel1.add(AddCurrency);
		panel1.setBorder(bord);
		add(panel1);
		AddCurrency.addActionListener(this);
		// panel 2
		
		panel2 = new JPanel();
		oneCurrency = new JLabel("1");
		currencyExchangeFrom = new JComboBox();
		number = new JTextField(8);
		currencyExchangeTo = new JComboBox();
		currencyExchangeFrom.setPreferredSize(new Dimension(300,25));
		AddRate = new JButton("Add Rate");
		panel2.add(oneCurrency);
		currencyExchangeTo.setPreferredSize(new Dimension(300,25));

		
		panel2.add(currencyExchangeFrom);

		panel2.add(number);
		panel2.add(currencyExchangeTo);
		panel2.add(AddRate);
		panel2.setBorder(bord);
		add(panel2);
		// edit ComboBox;
		AddRate.addActionListener(this);
		// panel 3
		panel3 = new JPanel();
		
		rateToUpdate = new JLabel("Rate to Update");
		currencyExchangeUpdate = new JComboBox();
		newRatel = new JLabel("New Rate");
		newRate = new JTextField(10);
		currencyExchangeUpdate.setPreferredSize(new Dimension(300,25));

		Update = new JButton("Update");
		panel3.add(rateToUpdate);
		panel3.add(currencyExchangeUpdate);
		panel3.add(newRatel);
		panel3.add(newRate);
		panel3.add(Update);
		panel3.setBorder(bord);
		add(panel3);
		Update.addActionListener(this);
		// panel 4
		panel4 = new JPanel();
		amount = new JLabel("Amount");
		amountCurrency = new JTextField(8);
		Rate = new JLabel("Rate");
		
		currencyExchange = new JComboBox();
		currencyExchange.setPreferredSize(new Dimension(300,25));

		Add = new JButton("Add");
		panel4.add(amount);
		panel4.add(amountCurrency);
		panel4.add(Rate);
		panel4.add(currencyExchange);
		panel4.add(Add);
		panel4.setBorder(bord);
		add(panel4);

		Add.addActionListener(this);
		// panel 5
		panel5 = new JPanel();
		amountCurrencyExchange = new javax.swing.JList<>();
		amountCurrencyExchange.setVisibleRowCount(4);
        amountCurrencyExchange.setFixedCellWidth(350);
        amountCurrencyExchange.setFixedCellHeight(20);

		Remove = new JButton("Remove");
		JScrollPane sc = new JScrollPane(amountCurrencyExchange);
		panel5.add(sc);
		amountCurrencyExchange.setVisible(true);
		panel5.add(Remove);
		panel5.setBorder(bord);
		add(panel5);
		AddRate.setEnabled(false);
		 Update.setEnabled(false);
		 Add.setEnabled(false);
		 Remove.setEnabled(false);
		Remove.addActionListener(this);

	   panel2.addMouseListener(this);
	   panel3.addMouseListener(this);
	   panel4.addMouseListener(this);
	   panel5.addMouseListener(this);
	   panel1.addMouseListener(this);

	   amountCurrencyExchange.addListSelectionListener(new ListSelectionListener() {
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			
			
			Remove.setEnabled(true);
			if( amountCurrencyExchange.getSelectedIndex()==-1)
				Remove.setEnabled(false);
		}
		
	});
	  
	   currencyExchangeFrom.addItemListener(new ItemListener() {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(currencyExchangeFrom.getSelectedIndex()!=currencyExchangeTo.getSelectedIndex()) {
				AddRate.setEnabled(true);
			}
			if(currencyExchangeFrom.getSelectedIndex()==currencyExchangeTo.getSelectedIndex()) {
				AddRate.setEnabled(false);
			}
			
		}
	});
	   currencyExchangeTo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(currencyExchangeFrom.getSelectedIndex()!=currencyExchangeTo.getSelectedIndex()) {
					AddRate.setEnabled(true);
				}
				if(currencyExchangeFrom.getSelectedIndex()==currencyExchangeTo.getSelectedIndex()) {
					AddRate.setEnabled(false);
				}
				
			}
		});


	   
	}
	

	public void mouseExited(MouseEvent e) {
		
		
		
	}
public void mouseEntered(MouseEvent e) {
	if(e.getSource()==panel1) {
	panel1.setBackground(Color.red);
	panel2.setBackground(Color.red);
	panel3.setBackground(Color.red);
	panel4.setBackground(Color.red);
	panel5.setBackground(Color.red);
	
	
	}
	else if(e.getSource()==panel2) {
		panel1.setBackground(Color.blue);
		panel2.setBackground(Color.blue);
		panel3.setBackground(Color.blue);
		panel4.setBackground(Color.blue);
		panel5.setBackground(Color.blue);
		setForeground(Color.red);}
	else  if(e.getSource()==panel3) {
		panel1.setBackground(Color.pink);
		panel2.setBackground(Color.pink);
		panel3.setBackground(Color.pink);
		panel4.setBackground(Color.pink);
		panel5.setBackground(Color.pink);
	}
	else  if(e.getSource()==panel4) {
			panel1.setBackground(Color.black);
			panel2.setBackground(Color.black);
			panel3.setBackground(Color.black);
			panel4.setBackground(Color.black);
			panel5.setBackground(Color.black);
			setForeground(Color.red);
		
	}
		else {
			panel1.setBackground(Color.green);
			panel2.setBackground(Color.green);
			panel3.setBackground(Color.green);
			panel4.setBackground(Color.green);
			panel5.setBackground(Color.green);
		}
}
public void mouseReleased(MouseEvent e) {
	
}
public void mouseClicked(MouseEvent e) {
	setBackground(Color.red);
	setForeground(Color.red);
}
public void mousePressed(MouseEvent e) {
	
}
public boolean isNumber(int i) {
	if(i==1) {
	if(number.getText().matches("\\d+(\\.\\d+)?"))
		return true;
	else 
		return false;}
	else if(i==2)
	{
		if(amountCurrency.getText().matches("\\d+(\\.\\d+)?"))
			return true;
		else
			return false;
		
	}
	else 
		if(newRate.getText().matches("\\d+(\\.\\d+)?"))
			return true;
		else
			return false;
		
	
}



	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == AddCurrency) {
			String s = symb.getText();
			String name = currency.getText();
			boolean flag = true;
			String item = "";
			currancy c = new currancy(name,s);
			
			for (int i = 0; i < list.size(); i++) {
	
		
				if (list.get(i).name.equals(name)){
					flag = false;
					JOptionPane.showMessageDialog(this, "this currency is already exist");	
				}
			}
			if (flag) {
				
				item = c.name + "(" + c.symbol + ")";
				list.add(c);
				currencyExchangeFrom.addItem(item);
				currencyExchangeTo.addItem(item);
				panel1.setBackground(Color.yellow);
				panel2.setBackground(Color.yellow);
				panel3.setBackground(Color.yellow);
				panel4.setBackground(Color.yellow);
				panel5.setBackground(Color.yellow);
				
			}
		}

		if (evt.getSource() == AddRate) {
		
			if(!isNumber(1))
				JOptionPane.showMessageDialog(this, "please make sure the rate is a number");
			
			else {
				
			String cuurencyfrom = currencyExchangeFrom.getSelectedItem() + "";
			String cuurencyto = currencyExchangeTo.getSelectedItem() + "";
			boolean f=true;
		for(int i=0;i<list2.size();i++) {
				if(list2.get(i).currancy1.equals(cuurencyfrom)&&list2.get(i).currancy2.equals(cuurencyto)) {
						JOptionPane.showMessageDialog(this, "this rate is already exist");	
				f=false;}
			}
		
			
			if (!cuurencyfrom.equals(cuurencyto)&&f) {
				Update.setEnabled(true);
				 Add.setEnabled(true); 
				currencyExchangeUpdate.addItem(cuurencyfrom + "=" + number.getText() + cuurencyto);
				currencyExchange.addItem(cuurencyfrom + "=" + number.getText() + cuurencyto);
				list2.add(new Item(cuurencyfrom, cuurencyto, Double.parseDouble(number.getText())));
				for (int i = 0; i < list2.size(); i++) {
					System.out.println(currencyExchangeUpdate.getSelectedItem());
					System.out.println(list2.get(i).currancy1 + "=" + list2.get(i).value + list2.get(i).currancy2);

					if ((list2.get(i).currancy1 + "=" + list2.get(i).value + list2.get(i).currancy2)
							.equals(currencyExchangeUpdate.getSelectedItem())) {
				list3.add(new Item(list2.get(i).currancy1, list2.get(i).currancy2, list2.get(i).value));}}

				panel1.setBackground(new Color(127,232,12));
				panel2.setBackground(new Color(127,232,12));
				panel3.setBackground(new Color(127,232,12));
				panel4.setBackground(new Color(127,232,12));
				panel5.setBackground(new Color(127,232,12));
				
			}
			}
		}
	
		

		if (evt.getSource() == Update) {
			int i;
			if(!isNumber(3))
				JOptionPane.showMessageDialog(this, "please make sure the rate is a number");
			else {
			
			int index = currencyExchangeUpdate.getSelectedIndex();
			Double value = Double.parseDouble(newRate.getText());
			for (i = 0; i < list2.size(); i++) {
				System.out.println(currencyExchangeUpdate.getSelectedItem());
				System.out.println(list2.get(i).currancy1 + "=" + list2.get(i).value + list2.get(i).currancy2);

				if ((list2.get(i).currancy1 + "=" + list2.get(i).value + list2.get(i).currancy2)
						.equals(currencyExchangeUpdate.getSelectedItem())) {
					System.out.println(currencyExchangeFrom.getSelectedItem());
					System.out.println(list2.get(i).currancy1 + "=" + list2.get(i).value + list2.get(i).currancy2);
					list2.get(i).value = value;
					currencyExchangeUpdate.removeItemAt(index);
					currencyExchange.removeItemAt(index);

					currencyExchange.addItem(list2.get(i).currancy1 + "=" + value + list2.get(i).currancy2);
					currencyExchangeUpdate.addItem(list2.get(i).currancy1 + "=" + value + list2.get(i).currancy2);
					list3.add(new Item(list2.get(i).currancy1, list2.get(i).currancy2, value));
					panel1.setBackground(new Color(127,127,122));
					panel2.setBackground(new Color(127,127,122));
					panel3.setBackground(new Color(127,127,122));
					panel4.setBackground(new Color(127,127,122));
					panel5.setBackground(new Color(127,127,122));

				}

			}}

		} else if (evt.getSource() == Add) {
			
			if(!isNumber(2))
				JOptionPane.showMessageDialog(this, "please make sure the rate is a number");
			
			else {
			Double Totalvalue;
			PopupMenu p = new PopupMenu();
			System.out.println(list3.size());
			for (int i = 0; i < list3.size(); i++) {
				if ((list3.get(i).currancy1 + "=" + list2.get(i).value + list2.get(i).currancy2)
						.equals(currencyExchange.getSelectedItem())) {
					list3.get(i).value = Double.parseDouble(amountCurrency.getText());
					Totalvalue = Double.parseDouble(amountCurrency.getText()) * list2.get(i).value;
					// jComboBox5.addItem(jTextField5.getText()+list3.get(i).currancy1+"="+Totalvalue+list2.get(i).currancy2);
					dm.addElement(amountCurrency.getText() + list3.get(i).currancy1 + "=" + Totalvalue
							+ list2.get(i).currancy2);
					amountCurrencyExchange.setModel(dm);
					panel1.setBackground(new Color(20,40,70));
					panel2.setBackground(new Color(20,40,70));
					panel3.setBackground(new Color(20,40,70));
					panel4.setBackground(new Color(20,40,70));
					panel5.setBackground(new Color(20,40,70));

				}
			}}
		} 
		else if (evt.getSource() == Remove) {
			dm.removeElementAt(amountCurrencyExchange.getSelectedIndex());
			// System.out.print(jComboBox5.getSelectedIndex());
			amountCurrencyExchange.setModel(dm);
			panel1.setBackground(new Color(100,30,90));
			panel2.setBackground(new Color(100,30,90));
			panel3.setBackground(new Color(100,30,90));
			panel4.setBackground(new Color(100,30,90));
			panel5.setBackground(new Color(100,30,90));
		}

	}

	class currancy {
		String symbol;
		String name;

		currancy(String n, String s) {
			name = n;
			symbol = s;
		}

	}

	class Item {
		String currancy1;
		String currancy2;
		Double value;

		Item(String n, String s, Double v) {
			currancy1 = n;
			currancy2 = s;
			value = v;

		}
	}
}