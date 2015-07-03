//project NewMinesweeper

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class NewMinesweeper extends JFrame{
	
	private Board minefield;
	public MyButton button[];
	public int click_count;

	public static void main(String[] args) {
		NewMinesweeper game = new NewMinesweeper();
		int mine_count;
		game.pack();
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setVisible(true);
		while(true){
			mine_count = 0;
			game.click_count = 0;
			for(int i = 0; i < 100; i++){
				if(game.button[i].hbc == true){
					game.click_count++;
					if (game.button[i].n == 0){
						game.revealZeroes(game.button[i], i);
					}
				}
				if(game.button[i].hm == true && game.button[i].hbc == true){
					for (int j = 0; j < 100; j++){
						if(game.button[j].hm == true){
							game.button[j].setBackground(Color.RED);
						}
					}
					try{
						Thread.sleep(2000);
						System.exit(0);
					} catch (InterruptedException ie){
					}
				}
				else if(game.button[i].hm == true && game.button[i].im == true){
					mine_count++;
				}
				if(mine_count == 20 && game.click_count == 80){
					for (int l = 1; l < 6; l++){
						for(int k = 0; k < 100; k++){
							if(game.button[k].hm == true && game.button[k].im == true){
								switch (l){
									case 1:	game.button[k].setBackground(Color.ORANGE);
											break;
									case 2: game.button[k].setBackground(Color.GREEN);
											break;
									case 3: game.button[k].setBackground(Color.CYAN);
											break;
									case 4: game.button[k].setBackground(Color.PINK);
											break;
									case 5: game.button[k].setBackground(Color.WHITE);
											break;
								}
							}
						}
						try{
							Thread.sleep(1000);
						} catch (InterruptedException ie){
						}
					}
				System.exit(0);
				}
			}
		}
	} 
	
	public NewMinesweeper(){
		minefield = new Board();
		button = new MyButton[100];
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
					for (int i = 0; i < 100; i++){
						button[i].Co = true;
						button[i].Mo = false;
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
					for (int i = 0; i < 100; i++){
						button[i].Mo = true;
						button[i].Co = false;
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
		int iindex, jindex;
		inner.setLayout(new GridLayout(10,10));
		for (int i = 0; i < 100; i++){
			iindex = i/10;
			jindex = i%10;
			button[i] = new MyButton(minefield.getBoard(iindex, jindex).getHasMine(), minefield.getBoard(iindex, jindex).getIsMarked(), minefield.getBoard(iindex, jindex).getHasBeenClicked(), minefield.getBoard(iindex, jindex).getNeighbors(), minefield.getBoard(iindex,jindex).getMarkOn(), minefield.getBoard(iindex, jindex).getClickOn());
			button[i].setPreferredSize(new Dimension(50,50));
			button[i].setBackground(Color.BLACK);
			inner.add(button[i]);
		}
		return inner;
	}
	
	public Board getMinefield(){
		return minefield;
	}
	
	public void revealZeroes(MyButton b, int index){
		if (index - 11 >= 0) {
			if(button[index-11].hbc == false && index-11 >= 10){
				if (Integer.parseInt(Integer.toString(index-1).substring(1)) != 9){
					button[index-11].hbc = true;
					click_count++;
					button[index-11].setBackground(Color.GRAY);
					if(button[index-11].n != 0 && button[index-11].n != 10){
						button[index-11].setText(Integer.toString(button[index-11].n));
					}
				}
			}
			else if (button[index-11].hbc == false && (index-11) != 9){
				button[index-11].hbc = true;
				button[index-11].setBackground(Color.GRAY);
				if(button[index-11].n != 0 && button[index-11].n != 10){
					button[index-11].setText(Integer.toString(button[index-11].n));
				}
				click_count++;
			}
		}
		if (index - 10 >= 0){
			if(button[index-10].hbc == false){
				button[index-10].hbc = true;
				button[index-10].setBackground(Color.GRAY);
				if(button[index-10].n != 0 && button[index-10].n != 10){
					button[index-10].setText(Integer.toString(button[index-10].n));
				}
				click_count++;
			}
		}
		if (index - 9 >= 0){
			if(button[index-9].hbc == false && (index-9)%10 != 0){
				button[index-9].hbc = true;
				button[index-9].setBackground(Color.GRAY);
				if(button[index-9].n != 0 && button[index-9].n != 10){
					button[index-9].setText(Integer.toString(button[index-9].n));
				}
				click_count++;
			}
		}
		if (index - 1 >= 0){
			if (button[index-1].hbc == false && index-1 >= 10){
				if (Integer.parseInt(Integer.toString(index-1).substring(1)) != 9){
					button[index-1].hbc = true;
					button[index-1].setBackground(Color.GRAY);
					if(button[index-1].n != 0 && button[index-1].n != 10){
						button[index-1].setText(Integer.toString(button[index-1].n));
					}
					click_count++;
				}
			}
			else if (button[index-1].hbc == false && (index-1) != 9){
				button[index-1].hbc = true;
				button[index-1].setBackground(Color.GRAY);
				if(button[index-1].n != 0 && button[index-1].n != 10){
					button[index-1].setText(Integer.toString(button[index-1].n));
				}
				click_count++;
			}
		}
		if (index + 1 < 100){
			if (button[index+1].hbc == false && (index+1)%10 != 0){
				button[index+1].hbc = true;
				button[index+1].setBackground(Color.GRAY);
				if(button[index+1].n != 0 && button[index+1].n != 10){
					button[index+1].setText(Integer.toString(button[index+1].n));
				}
				click_count++;
			}
		}
		if (index + 9 < 100){
			if (button[index+9].hbc == false && index+9 >= 10){ 
				if (Integer.parseInt(Integer.toString(index+9).substring(1)) != 9){
					button[index+9].hbc = true;
					button[index+9].setBackground(Color.GRAY);
					if(button[index+9].n != 0 && button[index+9].n != 10){
						button[index+9].setText(Integer.toString(button[index+9].n));
					}
					click_count++;
				}
			}
		}
		if (index + 10 < 100){
			if (button[index+10].hbc == false){
				button[index+10].hbc = true;
				button[index+10].setBackground(Color.GRAY);
				if(button[index+10].n != 0 && button[index+10].n != 10){
					button[index+10].setText(Integer.toString(button[index+10].n));
				}
				click_count++;
			}
		}
		if (index + 11 < 100){
			if (button[index+11].hbc == false && (index+11)%10 != 0){
				button[index+11].hbc = true;
				button[index+11].setBackground(Color.GRAY);
				if(button[index+11].n != 0 && button[index+11].n != 10){
					button[index+11].setText(Integer.toString(button[index+11].n));
				}
				click_count++;
			}
		}
	}
}
