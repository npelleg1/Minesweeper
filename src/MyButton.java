// project NewMinesweeper
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyButton extends JButton {

	public boolean hm, im, hbc, Mo, Co; 
	public int n;
	
	public MyButton(boolean hm, boolean im, boolean hbc, int n, boolean Mo, boolean Co) {
		this.hm = hm;
		this.im = im;
		this.hbc = hbc;
		this.n = n;
		this.Mo = false;
		this.Co = true;
		
	addMouseListener(new MouseAdapter(){
		@Override
		public void mousePressed(MouseEvent e){
			MyButton button = (MyButton) e.getSource();
			if(button.Co == true && button.im == false){
				button.hbc = true;
				if (button.hm == true)
					button.setBackground(Color.RED);
				else if(button.n == 0){
					button.setBackground(Color.GRAY);
				}
				else{
					button.setBackground(Color.GRAY);
					button.setText(Integer.toString(button.n));
				}
				e.setSource(button);
			}
			else if (button.Mo == true){
				if (button.im == false){
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
		}
/*		public void mouseEntered(MouseEvent evt){
			MyButton button = (MyButton) evt.getSource();
			if(button.im == 0)
				button.setBackground(Color.BLUE);
			else if (button.hbc == 1 && button.hm == 1)
				button.setBackground(Color.RED);
			else
				button.setBackground(Color.YELLOW);
			evt.setSource(button);
		}
		public void mouseExited(MouseEvent event){
			MyButton button = (MyButton) event.getSource();
			if (button.im == 1)
				button.setBackground(Color.YELLOW);
			else if (button.hbc == 0)
				button.setBackground(Color.BLACK);
			else if (button.hbc == 1 && button.hm == 1)
				button.setBackground(Color.RED);
			else 
				button.setBackground(Color.GRAY);
			event.setSource(button);
		} */
	});
	}
}
