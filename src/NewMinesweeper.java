//project NewMinesweeper

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class NewMinesweeper extends JFrame{
	
	private Board minefield;
	public int click_count;

	public static void main(String[] args) {
		NewMinesweeper game = new NewMinesweeper();
		Board minefield = new Board();
		int mine_count;
		game.pack();
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setVisible(true);
	} 
	
	public NewMinesweeper(){
		minefield = new Board();
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		pane.add(getButtonPanel(), BorderLayout.SOUTH);
		pane.add(getMinePanel(), BorderLayout.CENTER);
	}
	
	private class CheckButton extends JButton {

		public CheckButton(String s){
			this.setText(s);
			addMouseListener(new MouseAdapter(){
				@Override
				public void mousePressed(MouseEvent e){
					for (int i = 0; i < 10; i++){
						for (int j = 0; j < 10; j++){
							minefield.board[i][j].Co = true;
							minefield.board[i][j].Mo = false;
						}
					}
				}
			});
		}
	}
	
	private class MarkButton extends JButton {

		public MarkButton(String s){
			this.setText(s);
			addMouseListener(new MouseAdapter(){
				@Override
				public void mousePressed(MouseEvent e){
					for (int i = 0; i < 10; i++){
						for (int j = 0; j < 10; j++){
							minefield.board[i][j].Mo = true;
							minefield.board[i][j].Co = false;
						}
					}
				}
			});
		}
	}
	
	public JComponent getButtonPanel(){
		JPanel inner = new JPanel();
		inner.setLayout(new GridLayout(1,2));
		inner.add(new CheckButton("CHECK"));
		inner.add(new MarkButton("MARK"));
		return inner;
	}
	
	public JComponent getMinePanel(){
		JPanel inner = new JPanel();
		inner.setLayout(new GridLayout(10,10));
		for (int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				inner.add(minefield.board[i][j]);
			}
		} 
		return inner;
	}
	
	public Board getMinefield(){
		return minefield;
	}
}