import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class Checker extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	public String check = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checker frame = new Checker();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Checker() {
		// String check = "";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		textArea = new JTextArea();

		JButton btnCheckButton = new JButton("Check");
		btnCheckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// String check = "";
				Stack<Character> stk = new Stack<Character>();
				boolean stackCheck = true;
				check = textField.getText();
				char[] CharArray = check.toCharArray();
				if(startCheck(CharArray)) {
					textArea.setText("True");
				}
				else {
					textArea.setText("False");
				}
				// int len = CharArray.length();
				
				/*
				 * for (int i = 0; i < CharArray.length; i++) { //char ch = check.charAt(i); //
				 * if (CharArray[i] != '(') { // stackCheck = false; // } if (CharArray[i] ==
				 * '(' ) { stk.push(CharArray[i]); } if (CharArray[i] == ')') { if
				 * (stk.isEmpty()) { textArea.setText("False1"); } else if ( !Match(stk.pop(),
				 * CharArray[i]) ) { textArea.setText("False2"); } }
				 * 
				 * 
				 * while (!stk.isEmpty() ) { //System.out.println("'(' at index "+(stk.pop()
				 * +1)+" is unmatched"); textArea.setText("False"); }
				 * 
				 * } // fix if (stk.isEmpty() && stackCheck) textArea.setText("True1"); else {
				 * textArea.setText("False3"); }
				 */
			}
		});
		panel.add(btnCheckButton);

		contentPane.add(textArea, BorderLayout.SOUTH);
	}

	public boolean startCheck(char[] CharArray) {
		Stack<Character> stk = new Stack<Character>();
		for (int i = 0; i < CharArray.length; i++) {
			// char ch = check.charAt(i);
//			if (CharArray[i] != '(') {
//				stackCheck = false;
//			}
			if (CharArray[i] == '(') {
				stk.push(CharArray[i]);
			}
			if (CharArray[i] == ')') {
				if (stk.isEmpty()) {
					//textArea.setText("False1");
					return false;
				} else if (!Match(stk.pop(), CharArray[i])) {
					//textArea.setText("False2");
					return false;
				}
			}

			/*
			 * while (!stk.isEmpty() ) { //System.out.println("'(' at index "+(stk.pop()
			 * +1)+" is unmatched"); textArea.setText("False"); }
			 */
		}
		// fix
		if (stk.isEmpty()) {
			//textArea.setText("True1");
			return true;
		}
		else {
			//textArea.setText("False3");
			return false;
		}
	}

	public boolean Match(char character1, char character2) {
		if (character1 == '(' && character2 == ')')
			return true;
		else
			return false;
	}

}
