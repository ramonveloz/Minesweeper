import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyJFrame extends JFrame{

	//private JButton[][] bombs;
	private JPanel myJP;
	private grid newG;
	
	public MyJFrame() {
		setTitle("Minesweeper                            Bombs: 25");
		
		myJP = new JPanel();
		myJP.setLayout(new BorderLayout());
		
		newG = new grid();
		
		myJP.add(newG, BorderLayout.CENTER);
		
		this.add(myJP);
		
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private class grid extends JPanel implements ActionListener {
		private int nonBombs = 0;
		private JButton[][] bombs;
		private Grid g = new Grid();
		
		public grid() {
		setLayout(new GridLayout(10, 10));
		populateBoard();
		}
		public void populateBoard() {
		
		bombs = new JButton[g.getNumRows()][g.getNumColumns()];
		
		for(int i = 0; i < bombs.length;i++) {
			for(int j = 0; j < bombs[i].length; j++) {
				String s = Integer.toString(g.getCountAtLocation(i, j));
				bombs[i][j] = new JButton(s);
				
				System.out.print(g.isBombAtLocation(i, j) + "|");
				
				bombs[i][j].setForeground(Color.WHITE);
				bombs[i][j].addActionListener(this);
				bombs[i][j].setEnabled(true);
				this.add(bombs[i][j]);
				
				
		
			}//inside for loop
			System.out.println();
		}//outer for loop
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btnClicked = (JButton) e.getSource();
		
		if(btnClicked.getForeground().equals(Color.WHITE)) {
			btnClicked.setForeground(Color.RED);
		}
		
		//|| btnClicked.getText().equals("0")
		
		else {
		for(int i = 0; i < bombs.length;i++) {
			for(int j = 0; j < bombs[i].length; j++) {
				if(bombs[i][j].equals(btnClicked)) {
					if(g.isBombAtLocation(i, j)) {
						String result = "YOU JUST GOT BOMBED";
						ImageIcon temp = new ImageIcon("Images/png-transparent-black-bomb-icon-illustration-bomb-land-mine-nuclear-weapon-cartoon-bombs-cartoon-character-explosion-cartoons.png");
						
						ImageIcon bomb = new ImageIcon(temp.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
						
						
						
						
						btnClicked.setIcon(bomb);
						btnClicked.setEnabled(false);
						
						int answer = JOptionPane.showConfirmDialog(null, 
								"Want to start over?", result, 
						        JOptionPane.YES_NO_OPTION);

						if (answer == JOptionPane.NO_OPTION) {
							setVisible(false); 
							dispose();
						} else if(answer == JOptionPane.YES_OPTION) {
							setVisible(false); 
							dispose();
							MyJFrame f = new MyJFrame();
						}
					}
					else {
						nonBombs++;
						btnClicked.setEnabled(false);
						
					}
				}
			}//inside for loop
		}//outer for loop
		btnClicked.setEnabled(false);
		}
		
		if(nonBombs == 75) {
			String result = "Congrats!!! You won";
			
			int answer = JOptionPane.showConfirmDialog(null, 
					"Want to start over?", result, 
			        JOptionPane.YES_NO_OPTION);

			if (answer == JOptionPane.NO_OPTION) {
				setVisible(false); 
				dispose();
			} 
			else if(answer == JOptionPane.YES_OPTION) {
				setVisible(false); 
				dispose();
				MyJFrame f = new MyJFrame();
			}
		}
		
		
		
	}
	}
}//class
