// project NewMinesweeper
import java.util.*;

public class Board{
	private Square[][] board;
	private int mines = 20, placed_mines = 0, neigh_count = 0;
	
	public Square getBoard(int i, int j){
		return board[i][j];
	}
	
	public Board(){
		Random rand = new Random();
		board = new Square[10][10];
		int rand1, rand2, i, j;
		for (i = 0; i < 10; i++){
			for (j = 0; j < 10; j++){
				board[i][j] = new Square();
			}
		}
		while (placed_mines < mines){
			rand1 = rand.nextInt(10);
			rand2 = rand.nextInt(10);
			if (board[rand1][rand2].getHasMine() != true){
				board[rand1][rand2].setHasMine(true);
				placed_mines++;
			}
		}
		for (i = 0; i < 10; i++){
			for(j = 0; j < 10; j++){
				neigh_count = 0;
				if(i-1 < 0 || i+1 > 9 || j-1 < 0 || j+1 > 9){
					if(i == 0 && j == 0){
						if(board[i+1][j].getHasMine() == true)
							neigh_count += 1;
						if(board[i+1][j+1].getHasMine() == true)
							neigh_count += 1;
						if(board[i][j+1].getHasMine() == true)
							neigh_count += 1;
					}
					else if (i == 0 && j == 9){
						if(board[i+1][j].getHasMine() == true)
							neigh_count += 1;
						if(board[i+1][j-1].getHasMine() == true)
							neigh_count += 1;
						if(board[i][j-1].getHasMine() == true)
							neigh_count += 1;
					}
					else if (i == 9 && j == 0){
						if(board[i][j+1].getHasMine() == true)
							neigh_count += 1;
						if(board[i-1][j+1].getHasMine() == true)
							neigh_count += 1;
						if(board[i-1][j].getHasMine() == true)
							neigh_count += 1;
					}
					else if (i == 9 && j == 9){
						if(board[i][j-1].getHasMine() == true)
							neigh_count += 1;
						if(board[i-1][j].getHasMine() == true)
							neigh_count += 1;
						if(board[i-1][j-1].getHasMine() == true)
							neigh_count += 1;
					}
					else if (i == 0){
						if(board[i][j-1].getHasMine() == true)
							neigh_count += 1;
						if(board[i][j+1].getHasMine() == true)
							neigh_count += 1;
						if(board[i+1][j-1].getHasMine() == true)
							neigh_count += 1;
						if(board[i+1][j].getHasMine() == true)
							neigh_count += 1;
						if(board[i+1][j+1].getHasMine() == true)
							neigh_count += 1;
					}
					else if (j == 9){
						if(board[i-1][j].getHasMine() == true)
							neigh_count += 1;
						if(board[i+1][j].getHasMine() == true)
							neigh_count += 1;
						if(board[i-1][j-1].getHasMine() == true)
							neigh_count += 1;
						if(board[i][j-1].getHasMine() == true)
							neigh_count += 1;
						if(board[i+1][j-1].getHasMine() == true)
							neigh_count += 1;
					}
					else if (i == 9) {
						if(board[i][j-1].getHasMine() == true)
							neigh_count += 1;
						if(board[i][j+1].getHasMine() == true)
							neigh_count += 1;
						if(board[i-1][j-1].getHasMine() == true)
							neigh_count += 1;
						if(board[i-1][j].getHasMine() == true)
							neigh_count += 1;
						if(board[i-1][j+1].getHasMine() == true)
							neigh_count += 1;
					}
					else if (j == 0){
						if(board[i-1][j].getHasMine() == true)
							neigh_count += 1;
						if(board[i+1][j].getHasMine() == true)
							neigh_count += 1;
						if(board[i+1][j+1].getHasMine() == true)
							neigh_count += 1;
						if(board[i][j+1].getHasMine() == true)
							neigh_count += 1;
						if(board[i-1][j+1].getHasMine() == true)
							neigh_count += 1;
					}
				}
				else{
					if (board[i-1][j-1].getHasMine() == true)
						neigh_count += 1;
					if (board[i][j-1].getHasMine() == true)
						neigh_count += 1;
					if (board[i+1][j-1].getHasMine() == true)
						neigh_count += 1;
					if (board[i-1][j].getHasMine() == true)
						neigh_count += 1;
					if (board[i+1][j].getHasMine() == true)
						neigh_count += 1;
					if (board[i-1][j+1].getHasMine() == true)
						neigh_count += 1;
					if (board[i][j+1].getHasMine() == true)
						neigh_count += 1;
					if (board[i+1][j+1].getHasMine() == true)
						neigh_count += 1;
				}
				if(board[i][j].getHasMine() != true)
					board[i][j].setNeighbors(neigh_count);
				else
					board[i][j].setNeighbors(10);
					
			}
		}
	}
}
