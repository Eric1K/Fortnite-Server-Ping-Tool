import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

public class Panel extends JPanel {
	private JTextField textField;
	
	JButton btnPing = new JButton("Ping");
	
	Ping p = new Ping();
	int pings = 1;
	
	JCheckBox chckbxNewCheckBox = new JCheckBox("Virginia (NAE)");
	JCheckBox chckbxOhionae = new JCheckBox("Ohio (NAE)");
	JCheckBox chckbxCanadanae = new JCheckBox("Canada (NAE)");
	JCheckBox chckbxNewCheckBox_1 = new JCheckBox("California (NAW)");
	JCheckBox chckbxOregonnaw = new JCheckBox("Oregon (NAW)");
	JCheckBox chckbxIrelandeu = new JCheckBox("Ireland (EU)");
	JCheckBox chckbxNewCheckBox_2 = new JCheckBox("London (EU)");
	JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Paris (EU)");
	JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Frankfurt (EU)");
	JCheckBox chckbxBahrainme = new JCheckBox("Bahrain(ME)");
	JCheckBox chckbxSydneyoce = new JCheckBox("Sydney (OCE)");
	JCheckBox chckbxSeoulasia = new JCheckBox("Seoul (AS)");
	JCheckBox chckbxNewCheckBox_5 = new JCheckBox("Osaka (AS)");
	JCheckBox chckbxBrazilbr = new JCheckBox("Brazil (BR)");
	JCheckBox chckbxSingapore = new JCheckBox("Singapore (AS)");
	JCheckBox chckbxNewCheckBox_6 = new JCheckBox("Tokyo (AS)");
	
	JTextArea textArea = new JTextArea();
	
	
	public Panel() {
		setLayout(null);
		
		JLabel lblSelectSeversTo = new JLabel("Select Server(s) to Ping:");
		lblSelectSeversTo.setBounds(166, 8, 117, 14);
		add(lblSelectSeversTo);
		
		
		chckbxNewCheckBox.setBounds(37, 32, 91, 23);
		chckbxNewCheckBox.addActionListener(new PanelListener());
		add(chckbxNewCheckBox);
		
		
		chckbxOhionae.setBounds(130, 32, 79, 23);
		add(chckbxOhionae);
		
		
		chckbxCanadanae.setBounds(211, 32, 97, 23);
		add(chckbxCanadanae);
		
		
		chckbxNewCheckBox_1.setBounds(310, 32, 113, 23);
		add(chckbxNewCheckBox_1);
		
		
		chckbxOregonnaw.setBounds(37, 58, 97, 23);
		add(chckbxOregonnaw);
		
		
		chckbxIrelandeu.setBounds(130, 58, 83, 23);
		add(chckbxIrelandeu);
		
		
		chckbxNewCheckBox_2.setBounds(211, 58, 97, 23);
		add(chckbxNewCheckBox_2);
		
		
		chckbxNewCheckBox_3.setBounds(310, 58, 97, 23);
		add(chckbxNewCheckBox_3);
		
		
		chckbxNewCheckBox_4.setBounds(37, 84, 97, 23);
		add(chckbxNewCheckBox_4);
		
		
		chckbxBahrainme.setBounds(130, 84, 85, 23);
		add(chckbxBahrainme);
		
		
		chckbxSydneyoce.setBounds(310, 84, 97, 23);
		add(chckbxSydneyoce);
		
		
		chckbxSeoulasia.setBounds(37, 110, 97, 23);
		add(chckbxSeoulasia);
		
		
		chckbxNewCheckBox_5.setBounds(130, 110, 79, 23);
		add(chckbxNewCheckBox_5);
		
		
		chckbxBrazilbr.setBounds(211, 84, 97, 23);
		add(chckbxBrazilbr);
		
		
		chckbxSingapore.setBounds(310, 110, 97, 23);
		add(chckbxSingapore);
		
		
		chckbxNewCheckBox_6.setBounds(211, 110, 97, 23);
		add(chckbxNewCheckBox_6);
		
		
		btnPing.setBounds(176, 175, 89, 23);
		btnPing.addActionListener(new PanelListener());
		add(btnPing);
		
		textField = new JTextField("1");
		textField.setBounds(179, 140, 86, 20);
		textField.addActionListener(new PanelListener());
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNumberOfPings = new JLabel("Number of Pings:");
		lblNumberOfPings.setBounds(93, 143, 83, 14);
		add(lblNumberOfPings);
		
		DefaultCaret caret = (DefaultCaret)textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		textArea.setEditable(false);
		textArea.setBounds(10, 209, 430, 87);
		startMessage();
		
		add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setSize(430, 265);
		scrollPane.setLocation(10, 230);
		
		
		
		add(scrollPane);
		
		JLabel lblOutput = new JLabel("Output:");
		lblOutput.setBounds(11, 206, 46, 14);
		add(lblOutput);
		
		
		
		
	}
	
	private class PanelListener implements ActionListener
	{
		boolean anySelected;
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == textField)
			{
				pings = Integer.parseInt(textField.getText());
			}
			
			if(e.getSource() == btnPing)
			{
			
					if(pings < 0)
					{
						//System.out.println("Error: Invalid ping amount");
						//textArea.append("Invalid ping amount" + "\n");
						appendText("Error: Invalid ping amount");
					}else
					{
						anySelected = false;
						//Virginia
						if(chckbxNewCheckBox.isSelected() == true)
						{
							ping(Servers.NAE1);
						}
						//Ohio
						if(chckbxOhionae.isSelected() == true)
						{
							ping(Servers.NAE2);
						}
						if(chckbxCanadanae.isSelected() == true)
						{
							ping(Servers.NAE3);
						}
						if(chckbxNewCheckBox_1.isSelected() == true)
						{
							ping(Servers.NAW1);
						}
						if(chckbxOregonnaw.isSelected() == true)
						{
							ping(Servers.NAW2);
						}
						if(chckbxIrelandeu.isSelected() == true)
						{
							ping(Servers.EU1);
						}
						if(chckbxNewCheckBox_2.isSelected() == true)
						{
							ping(Servers.EU2);
						}
						if(chckbxNewCheckBox_3.isSelected() == true)
						{
							ping(Servers.EU3);
						}
						if(chckbxNewCheckBox_4.isSelected() == true)
						{
							ping(Servers.EU4);
						}
						if(chckbxBahrainme.isSelected() == true)
						{
							ping(Servers.ME1);
						}
						if(chckbxBrazilbr.isSelected() == true)
						{
							ping(Servers.BR1);
						}
						if(chckbxSydneyoce.isSelected() == true)
						{
							ping(Servers.OCE1);
						}
						if(chckbxSeoulasia.isSelected() == true)
						{
							ping(Servers.ASIA1);
						}
						if(chckbxNewCheckBox_5.isSelected() == true)
						{
							ping(Servers.ASIA2);
						}
						if(chckbxSingapore.isSelected() == true)
						{
							ping(Servers.ASIA3);
						}
						if(chckbxNewCheckBox_6.isSelected() == true)
						{
							ping(Servers.ASIA4);
						}
						if(anySelected == false) {
							//System.out.println("Error: No server chosen!");
							//textArea.append("Error: No server chosen!" + "\n");
							appendText("Error: No server chosen!");
							
						}
					}
					

			}
		}
		
		private void ping(String hostAddress)
		{
			long temp =0;
			anySelected = true;
			String serverName = p.getLocation(hostAddress);
			
			for(int i =0; i< pings; i++)
			{
				//textArea.append(p.ping(hostAddress));
				//textArea.append("\n");
				appendText(p.ping(hostAddress));
				temp+= p.getLastPing();
			}
			
			if(pings > 1)
			{
				long avg = temp/pings;
				//textArea.append("Average of " + pings + " pings to " + serverName + " server: " + avg + " ms" + "\n");
				appendText("Average of " + pings + " pings to " + serverName + " server: " + avg + " ms");
				
			}
			
		}
		
	}
	
	public void startMessage()
	{
		appendText("Welcome to SecretlyGod's Fortnite ping tool!");
	}
	
	public void appendText(String message)
	{
		textArea.append(message + "\n");
	}
}
