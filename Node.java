//Class:  Node
//
// Description:
// Defines Instance Vraiables for Tree Node's data(words) and the occurances each word has, 
// and their Right and Left children
//
// Author: Jason Lee
// Date: 08/15/23
// Class: MET CS342
//
import java.io.Serializable;

public class Node implements Serializable {
	private String data;
	private Integer occurance = 0;
	private Node lChild;
	private Node rChild;
	//occurance = 0;
	
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
