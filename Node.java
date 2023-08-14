//hi

import java.io.Serializable;

public class Node implements Serializable {
	private String data;
	private Integer occurance;
	private Node lChild;
	private Node rChild;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public void setOccurance() {
		occurance = 0;
	}
	public Integer getOccurance() {
		return occurance;
	}
	public void updateOccurance() {
		occurance++;
	}
	public Node getlChild() {
		return lChild;
	}
	public void setlChild(Node lChild) {
		this.lChild = lChild;
	}
	public Node getrChild() {
		return rChild;
	}
	public void setrChild(Node rChild) {
		this.rChild = rChild;
	}

}
