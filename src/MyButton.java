// project NewMinesweeper
import java.awt.*;
import javax.swing.*;

public class MyButton extends JButton {
	private static final long serialVersionUID = 1L;
	private boolean hm, im, hbc, Mo, Co; 
	private int n, i, j;
	
	public MyButton(int i, int j) {
		this.hm = false;
		this.im = false;
		this.hbc = false;
		this.n = 0;
		this.Mo = false;
		this.Co = true;
		this.i = i;
		this.j = j;
		setPreferredSize(new Dimension(50,50));
		setBackground(Color.BLACK);
	}
	
	public boolean getHasMine(){
		return hm;
	}
	
	public void setHasMine(boolean b){
		hm = b;
	}
	
	public boolean getIsMarked(){
		return im;
	}
	
	public void setIsMarked(boolean b){
		im = b;
	}
	
	public boolean getHasBeenClicked(){
		return hbc;
	}
	
	public void setHasBeenClicked(boolean b){
		hbc = b;
	}
	
	public boolean getClickOn(){
		return Co;
	}
	
	public void setClickOn(boolean b){
		Co = b;
	}
	
	public boolean getMarkOn(){
		return Mo;
	}
	
	public void setMarkOn(boolean b){
		Mo = b;
	}
	
	public int getN(){
		return n;
	}
	
	public void setN(int i){
		n = i;
	}
	
	public int getI(){
		return i;
	}
	
	public int getJ(){
		return j;
	}
}