
public class Nodo {
	private int info;
	private Nodo link;
	
	public Nodo () {
		link = null;
		info = 0;
	}
	
	public Nodo (int info) {
		link = null;
		this.info = info;
	}
	
	// Metodi Getter e Setter
	public void setInfo(int info) {this.info = info;}
	public int getInfo() {return info;}
	public void setLink(Nodo link) {this.link = link;}
	public Nodo getLink() {return link;}
	
	public String toString() {
		return Integer.toString(info);
	}
}
