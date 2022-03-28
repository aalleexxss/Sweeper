package sweeper;

public class cell {
	int number;
	boolean visible;
	boolean marked;
	
	cell() {
		this.number = 0;
		this.visible = false;
		this.marked = false;
	}
	
	public void mark() {
		this.marked = true;
	}
	public void unMark() {
		this.marked = false;
	}
	public void makeVisible() {
		this.visible = true;
	}
	public void setNum(int n) {
		this.number = n;
	}
	public void plus1() {
		this.number++;
	}
	public int getNum() {
		return this.number;
	}
	
}
