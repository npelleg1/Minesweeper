// project NewMinesweeper
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board{
	public MyButton[][] board;
	private int mines = 20, placed_mines = 0, neigh_count = 0, click_count = 0, mine_count = 0;
	public boolean hasLost;
	
	public Board(){
		Random rand = new Random();
		board = new MyButton[10][10];
		hasLost = false;
		int rand1, rand2, i, j;
		for (i = 0; i < 10; i++){
			for (j = 0; j < 10; j++){
				board[i][j] = new MyButton(i, j);
				board[i][j].addMouseListener(new MouseAdapter(){
					@Override
					public void mousePressed(MouseEvent e){
						MyButton button = (MyButton) e.getSource();
						if(button.Co == true && button.im == false && hasLost == false){
							button.hbc = true;
							if (button.hm == true){
								button.setBackground(Color.RED);
								hasLost = true;
							}
							else if(button.n == 0){
								button.setBackground(Color.GRAY);
								revealZeroes(button.i, button.j);
							}
							else{
								button.setBackground(Color.GRAY);
								button.setText(Integer.toString(button.n));
							}
							e.setSource(button);
						}
						else if (button.Mo == true && hasLost == false){
							if (button.im == false && button.hbc == false){
								button.im = true;
								button.setBackground(Color.YELLOW);
								e.setSource(button);
							}	
							else if (button.im == true){
								button.im = false;
								button.setBackground(Color.BLACK);
								e.setSource(button);
							}
						}
						mine_count = 0;
						click_count = 0;
						for(int i = 0; i < 10; i++){
							for (int j = 0; j < 10; j++){
								if(board[i][j].hbc == true)
									click_count++;
								if(board[i][j].hm == true && board[i][j].hbc == true){
									for (int k = 0; k < 10; k++){
										for (int l = 0; l < 10; l++){
											if(board[k][l].hm == true){
												board[k][l].setBackground(Color.RED);
											}
										}
									}
								}
								else if(board[i][j].hm == true && board[i][j].im == true)
									mine_count++;
							}
						}
						if(mine_count == 20 && click_count == 80){
							for(int m = 0; m < 10; m++){
								for(int n = 0; n < 10; n++){
									if(board[m][n].hm == true && board[m][n].im == true){
										board[m][n].setBackground(Color.GREEN);
									}
								}
							}
						}
					}
				});
			}
		}
		while (placed_mines < mines){
			rand1 = rand.nextInt(10);
			rand2 = rand.nextInt(10);
			if (board[rand1][rand2].hm != true){
				board[rand1][rand2].hm = true;
				placed_mines++;
			}
		}
		for (i = 0; i < 10; i++){
			for(j = 0; j < 10; j++){
				neigh_count = 0;
				if(i-1 < 0 || i+1 > 9 || j-1 < 0 || j+1 > 9){
					if(i == 0 && j == 0){
						if(board[i+1][j].hm == true)
							neigh_count += 1;
						if(board[i+1][j+1].hm == true)
							neigh_count += 1;
						if(board[i][j+1].hm == true)
							neigh_count += 1;
					}
					else if (i == 0 && j == 9){
						if(board[i+1][j].hm == true)
							neigh_count += 1;
						if(board[i+1][j-1].hm == true)
							neigh_count += 1;
						if(board[i][j-1].hm == true)
							neigh_count += 1;
					}
					else if (i == 9 && j == 0){
						if(board[i][j+1].hm == true)
							neigh_count += 1;
						if(board[i-1][j+1].hm == true)
							neigh_count += 1;
						if(board[i-1][j].hm == true)
							neigh_count += 1;
					}
					else if (i == 9 && j == 9){
						if(board[i][j-1].hm == true)
							neigh_count += 1;
						if(board[i-1][j].hm == true)
							neigh_count += 1;
						if(board[i-1][j-1].hm == true)
							neigh_count += 1;
					}
					else if (i == 0){
						if(board[i][j-1].hm == true)
							neigh_count += 1;
						if(board[i][j+1].hm == true)
							neigh_count += 1;
						if(board[i+1][j-1].hm == true)
							neigh_count += 1;
						if(board[i+1][j].hm == true)
							neigh_count += 1;
						if(board[i+1][j+1].hm == true)
							neigh_count += 1;
					}
					else if (j == 9){
						if(board[i-1][j].hm == true)
							neigh_count += 1;
						if(board[i+1][j].hm == true)
							neigh_count += 1;
						if(board[i-1][j-1].hm == true)
							neigh_count += 1;
						if(board[i][j-1].hm == true)
							neigh_count += 1;
						if(board[i+1][j-1].hm == true)
							neigh_count += 1;
					}
					else if (i == 9) {
						if(board[i][j-1].hm == true)
							neigh_count += 1;
						if(board[i][j+1].hm == true)
							neigh_count += 1;
						if(board[i-1][j-1].hm == true)
							neigh_count += 1;
						if(board[i-1][j].hm == true)
							neigh_count += 1;
						if(board[i-1][j+1].hm == true)
							neigh_count += 1;
					}
					else if (j == 0){
						if(board[i-1][j].hm == true)
							neigh_count += 1;
						if(board[i+1][j].hm == true)
							neigh_count += 1;
						if(board[i+1][j+1].hm == true)
							neigh_count += 1;
						if(board[i][j+1].hm == true)
							neigh_count += 1;
						if(board[i-1][j+1].hm == true)
							neigh_count += 1;
					}
				}
				else{
					if (board[i-1][j-1].hm == true)
						neigh_count += 1;
					if (board[i][j-1].hm == true)
						neigh_count += 1;
					if (board[i+1][j-1].hm == true)
						neigh_count += 1;
					if (board[i-1][j].hm == true)
						neigh_count += 1;
					if (board[i+1][j].hm == true)
						neigh_count += 1;
					if (board[i-1][j+1].hm == true)
						neigh_count += 1;
					if (board[i][j+1].hm == true)
						neigh_count += 1;
					if (board[i+1][j+1].hm == true)
						neigh_count += 1;
				}
				if(board[i][j].hm != true)
					board[i][j].n = neigh_count;
				else
					board[i][j].n = 10;
			}
		}
	}
	public void revealZeroes(int iindex, int jindex){
		if (iindex - 1 >= 0 && jindex - 1 >= 0) {
			if(board[iindex-1][jindex-1].hbc == false){
				board[iindex-1][jindex-1].hbc = true;
				click_count++;
				board[iindex-1][jindex-1].setBackground(Color.GRAY);
				if(board[iindex-1][jindex-1].n != 0 && board[iindex-1][jindex-1].n != 10){
					board[iindex-1][jindex-1].setText(Integer.toString(board[iindex-1][jindex-1].n));
				}
				if(board[iindex-1][jindex-1].n == 0){
					revealZeroes(iindex-1, jindex-1);
				}
			}
		}
		if (jindex - 1 >= 0){
			if(board[iindex][jindex-1].hbc == false){
				board[iindex][jindex-1].hbc = true;
				board[iindex][jindex-1].setBackground(Color.GRAY);
				if(board[iindex][jindex-1].n != 0 && board[iindex][jindex-1].n != 10){
					board[iindex][jindex-1].setText(Integer.toString(board[iindex][jindex-1].n));
				}
				click_count++;
				if(board[iindex][jindex-1].n == 0){
					revealZeroes(iindex, jindex-1);
				}
			}
		}
		if (iindex + 1 <= 9 && jindex - 1 >= 0){
			if(board[iindex + 1][jindex - 1].hbc == false){
				board[iindex + 1][jindex - 1].hbc = true;
				board[iindex + 1][jindex - 1].setBackground(Color.GRAY);
				if(board[iindex + 1][jindex - 1].n != 0 && board[iindex + 1][jindex - 1].n != 10){
					board[iindex + 1][jindex - 1].setText(Integer.toString(board[iindex + 1][jindex - 1].n));
				}
				click_count++;
				if(board[iindex+1][jindex-1].n == 0){
					revealZeroes(iindex+1, jindex-1);
				}
			}
		}
		if (iindex - 1 >= 0){
			if (board[iindex-1][jindex].hbc == false){
				board[iindex-1][jindex].hbc = true;
				board[iindex-1][jindex].setBackground(Color.GRAY);
				if(board[iindex-1][jindex].n != 0 && board[iindex-1][jindex].n != 10)
					board[iindex-1][jindex].setText(Integer.toString(board[iindex-1][jindex].n));
				click_count++;
				if(board[iindex-1][jindex].n == 0){
					revealZeroes(iindex-1, jindex);
				}
			}
		}
		if (iindex + 1 <= 9){
			if (board[iindex+1][jindex].hbc == false){
				board[iindex+1][jindex].hbc = true;
				board[iindex+1][jindex].setBackground(Color.GRAY);
				if(board[iindex+1][jindex].n != 0 && board[iindex+1][jindex].n != 10){
					board[iindex+1][jindex].setText(Integer.toString(board[iindex+1][jindex].n));
				}
				click_count++;
				if(board[iindex+1][jindex].n == 0){
					revealZeroes(iindex+1, jindex);
				}
			}
		}
		if (iindex - 1 >= 0 && jindex + 1 <= 9){
			if (board[iindex - 1][jindex + 1].hbc == false){ 
				board[iindex - 1][jindex + 1].hbc = true;
				board[iindex - 1][jindex + 1].setBackground(Color.GRAY);
				if(board[iindex - 1][jindex + 1].n != 0 && board[iindex - 1][jindex + 1].n != 10){
					board[iindex - 1][jindex + 1].setText(Integer.toString(board[iindex - 1][jindex + 1].n));
				}
				click_count++;
				if(board[iindex-1][jindex+1].n == 0){
					revealZeroes(iindex-1, jindex+1);
				}
			}
		}
		if (jindex + 1 <= 9){
			if (board[iindex][jindex + 1].hbc == false){
				board[iindex][jindex + 1].hbc = true;
				board[iindex][jindex + 1].setBackground(Color.GRAY);
				if(board[iindex][jindex + 1].n != 0 && board[iindex][jindex + 1].n != 10){
					board[iindex][jindex + 1].setText(Integer.toString(board[iindex][jindex + 1].n));
				}
				click_count++;
				if(board[iindex][jindex+1].n == 0){
					revealZeroes(iindex, jindex+1);
				}
			}
		}
		if (iindex + 1 <= 9 && jindex + 1 <= 9){
			if (board[iindex + 1][jindex + 1].hbc == false){
				board[iindex + 1][jindex + 1].hbc = true;
				board[iindex + 1][jindex + 1].setBackground(Color.GRAY);
				if(board[iindex + 1][jindex + 1].n != 0 && board[iindex + 1][jindex + 1].n != 10){
					board[iindex + 1][jindex + 1].setText(Integer.toString(board[iindex+1][jindex+1].n));
				}
				click_count++;
				if(board[iindex+1][jindex+1].n == 0){
					revealZeroes(iindex+1, jindex+1);
				}
			}
		}
	}
}
