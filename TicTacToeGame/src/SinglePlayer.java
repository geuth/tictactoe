import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;

public class SinglePlayer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton buttonOne;
	private JButton buttonTwo;
	private JButton buttonThree;
	private JLabel player1;
	private JLabel score1;
	private JButton buttonFour;
	private JButton buttonFive;
	private JButton buttonSix;
	private JLabel player2;
	private JLabel score2;
	private JButton buttonSeven;
	private JButton buttonEight;
	private JButton buttonNine;
	private JLabel result;
	ArrayList<JButton> list = new ArrayList<JButton>();
	private Random randomElement;
	int winnerPlayer = 0;
	int winnerComp = 0;

	public void check() {

		if ((buttonOne.getText() == "X" && buttonTwo.getText() == "X" && buttonThree.getText() == "X")
				|| (buttonOne.getText() == "X" && buttonFive.getText() == "X" && buttonNine.getText() == "X")
				|| (buttonOne.getText() == "X" && buttonFour.getText() == "X" && buttonSeven.getText() == "X")
				|| (buttonTwo.getText() == "X" && buttonFive.getText() == "X" && buttonEight.getText() == "X")
				|| (buttonThree.getText() == "X" && buttonSix.getText() == "X" && buttonNine.getText() == "X")
				|| (buttonThree.getText() == "X" && buttonFive.getText() == "X" && buttonSeven.getText() == "X")
				|| (buttonFour.getText() == "X" && buttonFive.getText() == "X" && buttonSix.getText() == "X")
				|| (buttonSeven.getText() == "X" && buttonEight.getText() == "X" && buttonNine.getText() == "X")) {
			winnerPlayer++;
			score1.setText(String.valueOf(winnerPlayer));
			result.setText("Player Won!");
			buttonOne.setEnabled(false);
			buttonTwo.setEnabled(false);
			buttonThree.setEnabled(false);
			buttonFour.setEnabled(false);
			buttonFive.setEnabled(false);
			buttonSix.setEnabled(false);
			buttonSeven.setEnabled(false);
			buttonEight.setEnabled(false);
			buttonNine.setEnabled(false);
			
		}else if ((buttonOne.getText() == "O" && buttonTwo.getText() == "O" && buttonThree.getText() == "O")
				|| (buttonOne.getText() == "O" && buttonFive.getText() == "O" && buttonNine.getText() == "O")
				|| (buttonOne.getText() == "O" && buttonFour.getText() == "O" && buttonSeven.getText() == "O")
				|| (buttonTwo.getText() == "O" && buttonFive.getText() == "O" && buttonEight.getText() == "O")
				|| (buttonThree.getText() == "O" && buttonSix.getText() == "O" && buttonNine.getText() == "O")
				|| (buttonThree.getText() == "O" && buttonFive.getText() == "O" && buttonSeven.getText() == "O")
				|| (buttonFour.getText() == "O" && buttonFive.getText() == "O" && buttonSix.getText() == "O")
				|| (buttonSeven.getText() == "O" && buttonEight.getText() == "O" && buttonNine.getText() == "O")) {
			winnerComp++;
			score2.setText(String.valueOf(winnerComp));
			result.setText("Computer Won!");
			buttonOne.setEnabled(false);
			buttonTwo.setEnabled(false);
			buttonThree.setEnabled(false);
			buttonFour.setEnabled(false);
			buttonFive.setEnabled(false);
			buttonSix.setEnabled(false);
			buttonSeven.setEnabled(false);
			buttonEight.setEnabled(false);
			buttonNine.setEnabled(false);
		}
		if(list.size()== 0 && result.getText()== "") {
			result.setText("This is a draw!");
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinglePlayer frame = new SinglePlayer();
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
	public SinglePlayer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel title = new JLabel("Single Player");
		panel.add(title);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 3 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		buttonOne = new JButton("");
		buttonOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (buttonOne.getText().equals("")) {
					buttonOne.setText("X");
					buttonOne.setForeground(Color.RED);
					buttonOne.setEnabled(false);
					int findElement = list.indexOf(buttonOne);
					list.remove(findElement);
					check();
					if (list.size()>1) {
						randomElement = new Random();
						int index = randomElement.nextInt(list.size() - 1);
						
						list.get(index).setText("O");
						list.get(index).setForeground(Color.BLUE);
						list.get(index).setEnabled(false);
						list.remove(index);
						check();
					}
				}
				
				

			}
		});
		GridBagConstraints gbc_buttonOne = new GridBagConstraints();
		gbc_buttonOne.fill = GridBagConstraints.BOTH;
		gbc_buttonOne.insets = new Insets(0, 0, 5, 5);
		gbc_buttonOne.gridx = 2;
		gbc_buttonOne.gridy = 0;
		panel_1.add(buttonOne, gbc_buttonOne);

		buttonTwo = new JButton("");
		buttonTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (buttonTwo.getText().equals("")) {
					buttonTwo.setText("X");
					buttonTwo.setForeground(Color.RED);
					buttonTwo.setEnabled(false);
					int findElement = list.indexOf(buttonTwo);
					list.remove(findElement);
					check();
					if (list.size() >1) {
						randomElement = new Random();
						int index = randomElement.nextInt(list.size() - 1);
						list.get(index).setText("O");
						list.get(index).setForeground(Color.BLUE);
						list.get(index).setEnabled(false);
						list.remove(index);
						check();
					}
				}
				
				
			}
			
		});
		GridBagConstraints gbc_buttonTwo = new GridBagConstraints();
		gbc_buttonTwo.fill = GridBagConstraints.BOTH;
		gbc_buttonTwo.insets = new Insets(0, 0, 5, 5);
		gbc_buttonTwo.gridx = 3;
		gbc_buttonTwo.gridy = 0;
		panel_1.add(buttonTwo, gbc_buttonTwo);

		buttonThree = new JButton("");
		buttonThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (buttonThree.getText().equals("")) {
					buttonThree.setText("X");
					buttonThree.setForeground(Color.RED);
					buttonThree.setEnabled(false);
					int findElement = list.indexOf(buttonThree);
					list.remove(findElement);
					check();
					if (list.size() >1) {
						randomElement = new Random();
						int index = randomElement.nextInt(list.size() - 1);
						list.get(index).setText("O");
						list.get(index).setForeground(Color.BLUE);
						list.get(index).setEnabled(false);
						list.remove(index);
						check();
					}
				}
				
				
			}
		});
		GridBagConstraints gbc_buttonThree = new GridBagConstraints();
		gbc_buttonThree.fill = GridBagConstraints.BOTH;
		gbc_buttonThree.insets = new Insets(0, 0, 5, 5);
		gbc_buttonThree.gridx = 4;
		gbc_buttonThree.gridy = 0;
		panel_1.add(buttonThree, gbc_buttonThree);

		player1 = new JLabel("Player 1");
		GridBagConstraints gbc_player1 = new GridBagConstraints();
		gbc_player1.insets = new Insets(0, 0, 5, 5);
		gbc_player1.gridx = 5;
		gbc_player1.gridy = 0;
		panel_1.add(player1, gbc_player1);

		score1 = new JLabel("0");
		GridBagConstraints gbc_score1 = new GridBagConstraints();
		gbc_score1.insets = new Insets(0, 0, 5, 5);
		gbc_score1.gridx = 6;
		gbc_score1.gridy = 0;
		panel_1.add(score1, gbc_score1);

		buttonFour = new JButton("");
		buttonFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (buttonFour.getText().equals("")) {
					buttonFour.setText("X");
					buttonFour.setForeground(Color.RED);
					buttonFour.setEnabled(false);
					int findElement = list.indexOf(buttonFour);
					list.remove(findElement);
					check();
					if (list.size()>1) {
						randomElement = new Random();
						int index = randomElement.nextInt(list.size() - 1);
						list.get(index).setText("O");
						list.get(index).setForeground(Color.BLUE);
						list.get(index).setEnabled(false);
						list.remove(index);
						check();
					}
				}
				
			
			}
		});
		GridBagConstraints gbc_buttonFour = new GridBagConstraints();
		gbc_buttonFour.fill = GridBagConstraints.BOTH;
		gbc_buttonFour.insets = new Insets(0, 0, 5, 5);
		gbc_buttonFour.gridx = 2;
		gbc_buttonFour.gridy = 1;
		panel_1.add(buttonFour, gbc_buttonFour);

		buttonFive = new JButton("");
		buttonFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (buttonFive.getText().equals("")) {
					buttonFive.setText("X");
					buttonFive.setForeground(Color.RED);
					buttonFive.setEnabled(false);
					int findElement = list.indexOf(buttonFive);
					list.remove(findElement);
					check();
					if (list.size()>1) {
						randomElement = new Random();
						int index = randomElement.nextInt(list.size() - 1);
						list.get(index).setText("O");
						list.get(index).setForeground(Color.BLUE);
						list.get(index).setEnabled(false);
						list.remove(index);
						check();
					}
				}
				
				
			}
		});
		GridBagConstraints gbc_buttonFive = new GridBagConstraints();
		gbc_buttonFive.fill = GridBagConstraints.BOTH;
		gbc_buttonFive.insets = new Insets(0, 0, 5, 5);
		gbc_buttonFive.gridx = 3;
		gbc_buttonFive.gridy = 1;
		panel_1.add(buttonFive, gbc_buttonFive);

		buttonSix = new JButton("");
		buttonSix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (buttonSix.getText().equals("")) {
					buttonSix.setText("X");
					buttonSix.setForeground(Color.RED);
					buttonSix.setEnabled(false);
					int findElement = list.indexOf(buttonSix);
					list.remove(findElement);
					check();
					if (list.size()  >1) {
						randomElement = new Random();
						int index = randomElement.nextInt(list.size() - 1);
						list.get(index).setText("O");
						list.get(index).setForeground(Color.BLUE);
						list.get(index).setEnabled(false);
						list.remove(index);
						check();
					}
				}
				
				check();
			}
		});
		GridBagConstraints gbc_buttonSix = new GridBagConstraints();
		gbc_buttonSix.fill = GridBagConstraints.BOTH;
		gbc_buttonSix.insets = new Insets(0, 0, 5, 5);
		gbc_buttonSix.gridx = 4;
		gbc_buttonSix.gridy = 1;
		panel_1.add(buttonSix, gbc_buttonSix);

		player2 = new JLabel("Computer");
		GridBagConstraints gbc_player2 = new GridBagConstraints();
		gbc_player2.insets = new Insets(0, 0, 5, 5);
		gbc_player2.gridx = 5;
		gbc_player2.gridy = 1;
		panel_1.add(player2, gbc_player2);

		score2 = new JLabel("0");
		GridBagConstraints gbc_score2 = new GridBagConstraints();
		gbc_score2.insets = new Insets(0, 0, 5, 5);
		gbc_score2.gridx = 6;
		gbc_score2.gridy = 1;
		panel_1.add(score2, gbc_score2);

		buttonSeven = new JButton("");
		buttonSeven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (buttonSeven.getText().equals("")) {
					buttonSeven.setText("X");
					buttonSeven.setForeground(Color.RED);
					buttonSeven.setEnabled(false);
					int findElement = list.indexOf(buttonSeven);
					list.remove(findElement);
					check();
					if (list.size() >1) {
						randomElement = new Random();
						int index = randomElement.nextInt(list.size() - 1);
						list.get(index).setText("O");
						list.get(index).setForeground(Color.BLUE);
						list.get(index).setEnabled(false);
						list.remove(index);
						check();
					}
				}
				
			
			}
		});
		GridBagConstraints gbc_buttonSeven = new GridBagConstraints();
		gbc_buttonSeven.fill = GridBagConstraints.VERTICAL;
		gbc_buttonSeven.insets = new Insets(0, 0, 0, 5);
		gbc_buttonSeven.gridx = 2;
		gbc_buttonSeven.gridy = 2;
		panel_1.add(buttonSeven, gbc_buttonSeven);

		buttonEight = new JButton("");
		buttonEight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (buttonEight.getText().equals("")) {
					buttonEight.setText("X");
					buttonEight.setForeground(Color.RED);
					buttonEight.setEnabled(false);
					int findElement = list.indexOf(buttonEight);
					list.remove(findElement);
					check();
					if (list.size()>1) {
						randomElement = new Random();
						int index = randomElement.nextInt(list.size() - 1);
						list.get(index).setText("O");
						list.get(index).setForeground(Color.BLUE);
						list.get(index).setEnabled(false);
						list.remove(index);
						check();
					}
				}
				
				
			}
		});
		GridBagConstraints gbc_buttonEight = new GridBagConstraints();
		gbc_buttonEight.fill = GridBagConstraints.VERTICAL;
		gbc_buttonEight.insets = new Insets(0, 0, 0, 5);
		gbc_buttonEight.gridx = 3;
		gbc_buttonEight.gridy = 2;
		panel_1.add(buttonEight, gbc_buttonEight);

		buttonNine = new JButton("");
		buttonNine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (buttonNine.getText().equals("")) {
					buttonNine.setText("X");
					buttonNine.setForeground(Color.RED);
					buttonNine.setEnabled(false);
					int findElement = list.indexOf(buttonNine);
					list.remove(findElement);
					check();
					if (list.size()>1) {
						randomElement = new Random();
						int index = randomElement.nextInt(list.size() - 1);
						list.get(index).setText("O");
						list.get(index).setForeground(Color.BLUE);
						list.get(index).setEnabled(false);
						list.remove(index);
						check();
					}
				}
				

			}
		});
		GridBagConstraints gbc_buttonNine = new GridBagConstraints();
		gbc_buttonNine.insets = new Insets(0, 0, 0, 5);
		gbc_buttonNine.fill = GridBagConstraints.VERTICAL;
		gbc_buttonNine.gridx = 4;
		gbc_buttonNine.gridy = 2;
		panel_1.add(buttonNine, gbc_buttonNine);

		JButton menuButton = new JButton("Menu");
		menuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu menuFrameMenu = new Menu();
				menuFrameMenu.setVisible(true);
			}
		});
		GridBagConstraints gbc_menuButton = new GridBagConstraints();
		gbc_menuButton.insets = new Insets(0, 0, 0, 5);
		gbc_menuButton.gridx = 5;
		gbc_menuButton.gridy = 2;
		panel_1.add(menuButton, gbc_menuButton);

		JButton restartButton = new JButton("Restart");
		restartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonOne.setEnabled(true);
				buttonTwo.setEnabled(true);
				buttonThree.setEnabled(true);
				buttonFour.setEnabled(true);
				buttonFive.setEnabled(true);
				buttonSix.setEnabled(true);
				buttonSeven.setEnabled(true);
				buttonEight.setEnabled(true);
				buttonNine.setEnabled(true);
				
				buttonOne.setText("");
				buttonTwo.setText("");
				buttonThree.setText("");
				buttonFour.setText("");
				buttonFive.setText("");
				buttonSix.setText("");
				buttonSeven.setText("");
				buttonEight.setText("");
				buttonNine.setText("");
				
				list.add(buttonOne);
				list.add(buttonTwo);
				list.add(buttonThree);
				list.add(buttonFour);
				list.add(buttonFive);
				list.add(buttonSix);
				list.add(buttonSeven);
				list.add(buttonEight);
				list.add(buttonNine);
				
				result.setText("");
			}
		});
		GridBagConstraints gbc_restartButton = new GridBagConstraints();
		gbc_restartButton.insets = new Insets(0, 0, 0, 5);
		gbc_restartButton.gridx = 6;
		gbc_restartButton.gridy = 2;
		panel_1.add(restartButton, gbc_restartButton);

		result = new JLabel("");
		result.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(result, BorderLayout.SOUTH);
		list.add(buttonOne);
		list.add(buttonTwo);
		list.add(buttonThree);
		list.add(buttonFour);
		list.add(buttonFive);
		list.add(buttonSix);
		list.add(buttonSeven);
		list.add(buttonEight);
		list.add(buttonNine);

	}

}
