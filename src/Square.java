//project NewMinesweeper
public class Square {
	private boolean hasMine;
	private boolean isMarked;
	private boolean hasBeenClicked;
	private int neighbors;
	private boolean MarkOn;
	private boolean ClickOn;
		
	public Square(){
		hasMine = false;
		isMarked = false;
		hasBeenClicked = false;
		neighbors = 0;
		MarkOn = false;
		ClickOn = true;
	}
	
	public boolean getMarkOn(){
		return MarkOn;
	}
	
	public void setMarkOn(boolean MarkOn){
		this.MarkOn = MarkOn;
	}
	
	public boolean getClickOn(){
		return ClickOn;
	}
	
	public void setClickOn(boolean ClickOn){
		this.ClickOn = ClickOn;
	}
	
	public boolean getHasMine(){
		return hasMine;
	}
	
	public void setHasMine (boolean hasMine){
		this.hasMine = hasMine;
	}
	
	public boolean getIsMarked(){
		return isMarked;
	}
	
	public void setIsMarked(boolean isMarked){
		this.isMarked = isMarked;
	}
	
	public boolean getHasBeenClicked(){
		return hasBeenClicked;
	}
	
	public void setHasBeenClicked(boolean hasBeenClicked){
		this.hasBeenClicked = hasBeenClicked;
	}
	
	public int getNeighbors(){
		return neighbors;
	}
	
	public void setNeighbors(int neighbors){
		this.neighbors = neighbors;
	}
}
