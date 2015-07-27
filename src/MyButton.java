// project NewMinesweeper
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyButton extends JButton {

	public boolean hm, im, hbc, Mo, Co; 
	public int n, i, j;
	
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
}