import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame {
	
	public static void main(String[] args)
	{
		//Ping p = new Ping();
		//System.out.println(p.ping("dynamodb.us-east-1.amazonaws.com"));
		
		JFrame frame = new JFrame("FN Ping");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(465,550));
		 try {
	            // Set System L&F
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
		 
		Panel panel = new Panel();
		
		frame.setResizable(false);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
