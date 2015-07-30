// project NewMinesweeper
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Board{
	public MyButton[][] board;
	private int mines = 20, placed_mines = 0, neigh_count = 0, click_count = 0, mine_count = 0;
	public boolean hasLost;
	
	public Board(){
		Random rand = new Random();
		board = new MyButton[10][10];
		hasLost = false;
		int i, j;
		for (i = 0; i < 10; i++){
			for (j = 0; j < 10; j++){
				board[i][j] = new MyButton(i, j);
				board[i][j].addMouseListener(new MouseAdapter(){
					@Override
					public void mousePressed(MouseEvent e){
						MyButton button = (MyButton) e.getSource();
						if(click_count == 0){
							int rand1, rand2;
							while (placed_mines < mines){
								rand1 = rand.nextInt(10);
								rand2 = rand.nextInt(10);
								if (board[rand1][rand2].getHasMine() != true && !(button.getI() == rand1 && button.getJ() == rand2)){
									board[rand1][rand2].setHasMine(true);
									placed_mines++;
								}
							}
							for (int k = 0; k < 10; k++){
								for(int l = 0; l < 10; l++){
									neigh_count = 0;
									if(k-1 < 0 || k+1 > 9 || l-1 < 0 || l+1 > 9){
										if(k == 0 && l == 0){
											if(board[k+1][l].getHasMine() == true)
												neigh_count += 1;
											if(board[k+1][l+1].getHasMine() == true)
												neigh_count += 1;
											if(board[k][l+1].getHasMine() == true)
												neigh_count += 1;
										}
										else if (k == 0 && l == 9){
											if(board[k+1][l].getHasMine() == true)
												neigh_count += 1;
											if(board[k+1][l-1].getHasMine() == true)
												neigh_count += 1;
											if(board[k][l-1].getHasMine() == true)
												neigh_count += 1;
										}
										else if (k == 9 && l == 0){
											if(board[k][l+1].getHasMine() == true)
												neigh_count += 1;
											if(board[k-1][l+1].getHasMine() == true)
												neigh_count += 1;
											if(board[k-1][l].getHasMine() == true)
												neigh_count += 1;
										}
										else if (k == 9 && l == 9){
											if(board[k][l-1].getHasMine() == true)
												neigh_count += 1;
											if(board[k-1][l].getHasMine() == true)
												neigh_count += 1;
											if(board[k-1][l-1].getHasMine() == true)
												neigh_count += 1;
										}
										else if (k == 0){
											if(board[k][l-1].getHasMine() == true)
												neigh_count += 1;
											if(board[k][l+1].getHasMine() == true)
												neigh_count += 1;
											if(board[k+1][l-1].getHasMine() == true)
												neigh_count += 1;
											if(board[k+1][l].getHasMine() == true)
												neigh_count += 1;
											if(board[k+1][l+1].getHasMine() == true)
												neigh_count += 1;
										}
										else if (l == 9){
											if(board[k-1][l].getHasMine() == true)
												neigh_count += 1;
											if(board[k+1][l].getHasMine() == true)
												neigh_count += 1;
											if(board[k-1][l-1].getHasMine() == true)
												neigh_count += 1;
											if(board[k][l-1].getHasMine() == true)
												neigh_count += 1;
											if(board[k+1][l-1].getHasMine() == true)
												neigh_count += 1;
										}
										else if (k == 9) {
											if(board[k][l-1].getHasMine() == true)
												neigh_count += 1;
											if(board[k][l+1].getHasMine() == true)
												neigh_count += 1;
											if(board[k-1][l-1].getHasMine() == true)
												neigh_count += 1;
											if(board[k-1][l].getHasMine() == true)
												neigh_count += 1;
											if(board[k-1][l+1].getHasMine() == true)
												neigh_count += 1;
										}
										else if (l == 0){
											if(board[k-1][l].getHasMine() == true)
												neigh_count += 1;
											if(board[k+1][l].getHasMine() == true)
												neigh_count += 1;
											if(board[k+1][l+1].getHasMine() == true)
												neigh_count += 1;
											if(board[k][l+1].getHasMine() == true)
												neigh_count += 1;
											if(board[k-1][l+1].getHasMine() == true)
												neigh_count += 1;
										}
									}
									else{
										if (board[k-1][l-1].getHasMine() == true)
											neigh_count += 1;
										if (board[k][l-1].getHasMine() == true)
											neigh_count += 1;
										if (board[k+1][l-1].getHasMine() == true)
											neigh_count += 1;
										if (board[k-1][l].getHasMine() == true)
											neigh_count += 1;
										if (board[k+1][l].getHasMine() == true)
											neigh_count += 1;
										if (board[k-1][l+1].getHasMine() == true)
											neigh_count += 1;
										if (board[k][l+1].getHasMine() == true)
											neigh_count += 1;
										if (board[k+1][l+1].getHasMine() == true)
											neigh_count += 1;
									}
									if(board[k][l].getHasMine() != true)
										board[k][l].setN(neigh_count);
									else
										board[k][l].setN(10);
								}
							}
						}
						if(button.getClickOn() == true && button.getIsMarked() == false && hasLost == false){
							button.setHasBeenClicked(true);
							if (button.getHasMine() == true){
								button.setBackground(Color.RED);
								hasLost = true;
							}
							else if(button.getN() == 0){
								button.setBackground(Color.GRAY);
								revealZeroes(button.getI(), button.getJ());
							}
							else{
								button.setBackground(Color.GRAY);
								button.setText(Integer.toString(button.getN()));
							}
							e.setSource(button);
						}
						else if (button.getMarkOn() == true && hasLost == false){
							if (button.getIsMarked() == false && button.getHasBeenClicked() == false){
								button.setIsMarked(true);
								button.setBackground(Color.YELLOW);
								e.setSource(button);
							}	
							else if (button.getIsMarked() == true){
								button.setIsMarked(false);
								button.setBackground(Color.BLACK);
								e.setSource(button);
							}
						}
						mine_count = 0;
						click_count = 0;
						for(int i = 0; i < 10; i++){
							for (int j = 0; j < 10; j++){
								if(board[i][j].getHasBeenClicked() == true)
									click_count++;
								if(board[i][j].getHasMine() == true && board[i][j].getHasBeenClicked() == true){
									for (int k = 0; k < 10; k++){
										for (int l = 0; l < 10; l++){
											if(board[k][l].getHasMine() == true){
												board[k][l].setBackground(Color.RED);
											}
										}
									}
								}
								else if(board[i][j].getHasMine() == true && board[i][j].getIsMarked() == true)
									mine_count++;
							}
						}
						if(mine_count == 20 && click_count == 80){
							for(int m = 0; m < 10; m++){
								for(int n = 0; n < 10; n++){
									if(board[m][n].getHasMine() == true && board[m][n].getIsMarked() == true){
										board[m][n].setBackground(Color.GREEN);
									}
								}
							}
						}
					}
				});
			}
		}
	}
	public void revealZeroes(int iindex, int jindex){
		if (iindex - 1 >= 0 && jindex - 1 >= 0) {
			if(board[iindex-1][jindex-1].getHasBeenClicked() == false){
				board[iindex-1][jindex-1].setHasBeenClicked(true);
				click_count++;
				board[iindex-1][jindex-1].setBackground(Color.GRAY);
				if(board[iindex-1][jindex-1].getN() != 0 && board[iindex-1][jindex-1].getN() != 10){
					board[iindex-1][jindex-1].setText(Integer.toString(board[iindex-1][jindex-1].getN()));
				}
				if(board[iindex-1][jindex-1].getN() == 0){
					revealZeroes(iindex-1, jindex-1);
				}
			}
		}
		if (jindex - 1 >= 0){
			if(board[iindex][jindex-1].getHasBeenClicked() == false){
				board[iindex][jindex-1].setHasBeenClicked(true);
				board[iindex][jindex-1].setBackground(Color.GRAY);
				if(board[iindex][jindex-1].getN() != 0 && board[iindex][jindex-1].getN() != 10){
					board[iindex][jindex-1].setText(Integer.toString(board[iindex][jindex-1].getN()));
				}
				click_count++;
				if(board[iindex][jindex-1].getN() == 0){
					revealZeroes(iindex, jindex-1);
				}
			}
		}
		if (iindex + 1 <= 9 && jindex - 1 >= 0){
			if(board[iindex + 1][jindex - 1].getHasBeenClicked() == false){
				board[iindex + 1][jindex - 1].setHasBeenClicked(true);
				board[iindex + 1][jindex - 1].setBackground(Color.GRAY);
				if(board[iindex + 1][jindex - 1].getN() != 0 && board[iindex + 1][jindex - 1].getN() != 10){
					board[iindex + 1][jindex - 1].setText(Integer.toString(board[iindex + 1][jindex - 1].getN()));
				}
				click_count++;
				if(board[iindex+1][jindex-1].getN() == 0){
					revealZeroes(iindex+1, jindex-1);
				}
			}
		}
		if (iindex - 1 >= 0){
			if (board[iindex-1][jindex].getHasBeenClicked() == false){
				board[iindex-1][jindex].setHasBeenClicked(true);
				board[iindex-1][jindex].setBackground(Color.GRAY);
				if(board[iindex-1][jindex].getN() != 0 && board[iindex-1][jindex].getN() != 10)
					board[iindex-1][jindex].setText(Integer.toString(board[iindex-1][jindex].getN()));
				click_count++;
				if(board[iindex-1][jindex].getN() == 0){
					revealZeroes(iindex-1, jindex);
				}
			}
		}
		if (iindex + 1 <= 9){
			if (board[iindex+1][jindex].getHasBeenClicked() == false){
				board[iindex+1][jindex].setHasBeenClicked(true);
				board[iindex+1][jindex].setBackground(Color.GRAY);
				if(board[iindex+1][jindex].getN() != 0 && board[iindex+1][jindex].getN() != 10){
					board[iindex+1][jindex].setText(Integer.toString(board[iindex+1][jindex].getN()));
				}
				click_count++;
				if(board[iindex+1][jindex].getN() == 0){
					revealZeroes(iindex+1, jindex);
				}
			}
		}
		if (iindex - 1 >= 0 && jindex + 1 <= 9){
			if (board[iindex - 1][jindex + 1].getHasBeenClicked() == false){ 
				board[iindex - 1][jindex + 1].setHasBeenClicked(true);
				board[iindex - 1][jindex + 1].setBackground(Color.GRAY);
				if(board[iindex - 1][jindex + 1].getN() != 0 && board[iindex - 1][jindex + 1].getN() != 10){
					board[iindex - 1][jindex + 1].setText(Integer.toString(board[iindex - 1][jindex + 1].getN()));
				}
				click_count++;
				if(board[iindex-1][jindex+1].getN() == 0){
					revealZeroes(iindex-1, jindex+1);
				}
			}
		}
		if (jindex + 1 <= 9){
			if (board[iindex][jindex + 1].getHasBeenClicked() == false){
				board[iindex][jindex + 1].setHasBeenClicked(true);
				board[iindex][jindex + 1].setBackground(Color.GRAY);
				if(board[iindex][jindex + 1].getN() != 0 && board[iindex][jindex + 1].getN() != 10){
					board[iindex][jindex + 1].setText(Integer.toString(board[iindex][jindex + 1].getN()));
				}
				click_count++;
				if(board[iindex][jindex+1].getN() == 0){
					revealZeroes(iindex, jindex+1);
				}
			}
		}
		if (iindex + 1 <= 9 && jindex + 1 <= 9){
			if (board[iindex + 1][jindex + 1].getHasBeenClicked() == false){
				board[iindex + 1][jindex + 1].setHasBeenClicked(true);
				board[iindex + 1][jindex + 1].setBackground(Color.GRAY);
				if(board[iindex + 1][jindex + 1].getN() != 0 && board[iindex + 1][jindex + 1].getN() != 10){
					board[iindex + 1][jindex + 1].setText(Integer.toString(board[iindex+1][jindex+1].getN()));
				}
				click_count++;
				if(board[iindex+1][jindex+1].getN() == 0){
					revealZeroes(iindex+1, jindex+1);
				}
			}
		}
	}
}
