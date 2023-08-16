import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Array;

public class LinkedTree {

	private Node root;
	int wordCount = 0;
	int nodeCount = 0;
	public boolean maxChildLR = true;
	public boolean found = false;

	Integer frequentCount = 0;
	String frequentWord = null;

	String preOrder = "";
	String inOrder = "";
	String postOrder = "";

	String children = "";
	// int [] storage;
	// storage = new int[100];
	// int storageIndex = 0;
	

	public String parse(String filepath) {
		String text = null;
		String pointer;

		File file;
		BufferedReader infile;
		infile = null;

		try {
			file = new File (filepath);
			infile = new BufferedReader(new FileReader(file));

		} catch (Exception e) {
			e.getStackTrace();
		}
		try {
			while ((pointer = infile.readLine()) != null) {
			//adding to phrase string
			text += (" " + pointer.replaceAll("\\p{Punct}", "").replaceAll("\\u201C", "")
			.replaceAll("\\u201D", "").replaceAll("\\u2018", "")
            .replaceAll("\\u2019", "").replaceAll("\\u2122", "")
            .replaceAll("﻿", "").replaceAll("(?m)^\\s+$", "")
			.replaceAll("\\p{Sc}", "").replaceAll("[\\p{P}\\p{S}]", "")
			.trim().toLowerCase());
			}
			}  catch (Exception e) {
				e.getStackTrace();
			}
			for (String word : text.split("\\s+")){
				//count++;
			}
			//System.out.println(text);
			//System.out.println("words: "+ count);
			
			//String s1 = "the";
			//String s2 = "pro";
			//System.out.println(s2.compareTo(s1));
			return text;
		}
/* 
		public int compareTo(Node emp) {
			return this.getData().compareTo(emp.getData());
		 }
	
	
	public int compareTo(String s) {
		String word; 
		if (word == s) {
			return 0;
		} else if (word >= s) {
			return 1;
		} else {
			return -1;
		}
	}
	*/
	public void add(String text) {
		for (String word : text.split("\\s+")){
			if (!"null".equals(word)) {
				// If its the first node handle it.
				if (root == null) {
					Node newNode = new Node();
					newNode.setData(word);
					root = newNode;
					//wordCount = 1;
					//nodeCount++;
					//return;
				} else {
					// Otherwise look to see if it already exists
					//Node tmp = internalSearch(word);
		
					//if (tmp != null) {
						// It is already in the tree
						//return;
					//}
					// Add it to the tree
					internalAdd(root, word);

				}
				
			}
		}
	}
	
	private void internalAdd(Node root, String word) {
		if (root == null) {
			System.out.println("OUCH: Root is null, and that shouldn't happen (internalAdd)");
			return;
		}
		
		if (word.compareTo(root.getData()) < 0) {
			// recurse down the left side
			if (root.getlChild() == null) {
				// This is where we add the data
				Node newNode = new Node();
				newNode.setData(word);
				newNode.updateOccurance();
				root.setlChild(newNode);
				wordCount++;
				nodeCount++;
				return;
			} else {
				internalAdd(root.getlChild(), word);
			}
		} else if (word.compareTo(root.getData()) == 0) {
			root.updateOccurance();
			wordCount++;
		} else {
			// recurse down the right side
			if (root.getrChild() == null) {
				// Add the data here
				Node newNode = new Node();
				newNode.setData(word);
				newNode.updateOccurance();
				root.setrChild(newNode);
				wordCount++;
				nodeCount++;
				return;
			} else {
				internalAdd(root.getrChild(), word);
			}
		}
	}
	
	public boolean remove(Integer data) {
		return false;
	}

	public Integer differentWords() {
		return nodeCount;
	}
	
	public String whatIsRoot() {
		return (root.getData());
	}

	public void wordsInText(String word) {
		//Integer result = null;
		internalSearch(root, word);
		//System.out.println((word + " occurs " + result + " times"));
	}
	
	private void internalSearch(Node root, String word) {
		if (root == null) {
			System.out.println("OUCH: Root is null, and that shouldn't happen (internalAdd)");
			return;
		}
		
		if (word.compareTo(root.getData()) < 0) {
			// recurse down the left side
			if (root.getlChild() == null) {
				internalSearch(root.getrChild(), word);
				
			} else {
				internalSearch(root.getlChild(), word);
			}
		} else if (word.compareTo(root.getData()) == 0) {
			System.out.println((root.getData() + " occurs " + root.getOccurance() + " times"));
			
			return;
		} else {
			// recurse down the right side
			if (root.getrChild() == null) {
				internalSearch(root.getlChild(), word);
			} else {
				internalSearch(root.getrChild(), word);
			}
		}
		return;
	}
	
	public boolean search(Integer data) {
		return false;
	}
	
	public int countOccurrences(Node root) {
		return -1;
	}
	
	public void preOrderTraversal() {
		internalPreOrderTraversal(root);
		System.out.println();
		for (String word : preOrder.split("\\s+")) {
			System.out.println("first word in pre Order: " + word);
			break;
		}
	}
	
	public void inOrderTraversal() {
		internalInOrderTraversal(root);
		System.out.println();
		System.out.println();
		for (String word : inOrder.split("\\s+")) {
			System.out.println("first word in In- Order: " + word);
			break;
		}
	}
	
	public void postOrderTraversal() {
		internalPostOrderTraversal(root);
		System.out.println();
		System.out.println();
		for (String word : postOrder.split("\\s+")) {
			System.out.println("first word in post Order: " + word);
			break;
		}
	}
	
	private void internalPreOrderTraversal(Node root) {
		// Base Case
		if (root == null) {
			return;
		}
		//System.out.print(root.getData());
		//return;
		//System.out.print(root.getData() + " ");
		preOrder += (root.getData() + " ");
		
		internalPreOrderTraversal(root.getlChild());
		internalPreOrderTraversal(root.getrChild());
		
	}

	private void internalInOrderTraversal(Node root) {
		// Base Case
		if (root == null) {
			return;
		}				
		
		internalInOrderTraversal(root.getlChild());
		//System.out.print(root.getData() + " ");
		inOrder += (root.getData() + " ");
		internalInOrderTraversal(root.getrChild());
	}

	private void internalPostOrderTraversal(Node root) {
		// Base Case
		if (root == null) {
			return;
		}
		
		internalPostOrderTraversal(root.getlChild());
		internalPostOrderTraversal(root.getrChild());
		//System.out.print(root.getData() + " ");
		postOrder += (root.getData() + " ");
	}
	
	//to do: need to add occurance - fix internal search
	private String toStringInOrderTraversal(Node root) {
		// Base Case
		if (root == null) {
			return "";
		}				
		
		String rtn = "";
		rtn += toStringInOrderTraversal(root.getlChild());
		rtn +=  root.getData() + " " + root.getOccurance() + " ";
		rtn += toStringInOrderTraversal(root.getrChild());
		
		return rtn;
	}
	
	public int size() {
		System.out.println("words: "+ wordCount);
		return wordCount;
	}
	
	public int maxDepth() {
		int depth = 0;
		return maxDepth(root, depth);
	}

	private int maxDepth(Node root, int depth) {
		// if (depth == 31) {
		// 	System.out.println(root.getData());
		// 	return depth - 1;
		// }
		if (root == null) {
			return depth - 1;
		}
		
		//depth++;
		int lcd = maxDepth(root.getlChild(), depth+1);
		int rcd = maxDepth(root.getrChild(), depth+1);
		if (lcd > rcd) {
			//boolean maxChildLR = true;
			if (lcd == 32) {
				System.out.println("YOOOOY");
			}
			return lcd;
		} else {
			//boolean maxChildLR = false;
			if (rcd == 32) {
				
				System.out.println(root.getData());
				children += (root.getData() + " ");
				
			}
			return rcd;			
		}
		
	}

	public void maxDepthWord() {
		//int depth = 0;
			for (String leaf : children.split("\\s+")) {
				System.out.println("Deepest word(s) is/are : " + leaf);
				break;
		}
		
	}

	public int totalWordCount() {
		return (wordCount);
	}

	public void mostFrequent() {
		mostFrequent(root);
		System.out.println("Most Frequent is : " + frequentWord + "occuring" + frequentCount);
	}


	private void mostFrequent(Node root) {
		// Base Case
		if (root == null) {
			return;
		}
		if (root.getOccurance() > frequentCount) {
			frequentCount = (root.getOccurance());
			frequentWord = root.getData();

		}
		
		mostFrequent(root.getlChild());
		mostFrequent(root.getrChild());
		

	}

	// private String maxDepthWord(Node root) {
		
		
	// 	//depth++;
	// 	if (maxChildLR == true) {
	// 		if ((root.getrChild() == null) || (root.getlChild() == null)) {
	// 			return root.getData();
	// 		}
	// 		String lcd = maxDepthWord(root.getlChild());
	// 		String rcd = maxDepthWord(root.getrChild());
	// 		return lcd;
	// 	} else {
	// 		if ((root.getrChild() == null) || (root.getlChild() == null)) {
	// 			return root.getData();
	// 		}
	// 		String lcd = maxDepthWord(root.getlChild());
	// 		String rcd = maxDepthWord(root.getrChild());
			
	// 		return rcd;

	// 	}
		
	// }
	
	private int delCount = 0;
	public void delete(Integer data) {
		delCount = 0;
		int size = size();
		root = recDelete(root, data);
		
		// If the size of the tree changed, we deleted something
		if (size != size()) {
			wordCount = size-1;
		}
		
		System.out.println("Delete recursed " + delCount + " times");
	}
	
	private Node recDelete(Node root, Integer data) {
		
		delCount++;
		// Base Case
		if (root == null) {
			return root;
		}
		
		// Recurse down the tree
		if (data < root.getData()) {
			root.setlChild(recDelete(root.getlChild(), data));
		} else if (data > root.getData()) {
			root.setrChild(recDelete(root.getrChild(), data));
		} else {
			// If the data is the same, delete this node
			wordCount--;
			// see if node has one child or no children
			if (root.getlChild() == null) {
				return root.getrChild();
			} else if (root.getrChild() == null) {
				return root.getlChild();
			}
			
			// The Node has two children, get the smallest in the right subtree.
			root.setData(getMinValue(root.getrChild()));
			
			// Delete the in-Order successor
			root.setrChild(recDelete(root.getrChild(), root.getData()));
			
		}
		
		return root;
	}

	private Integer getMinValue(Node root) {
		int minv = root.getData();
		
		while(root.getlChild() != null) {
			minv = root.getlChild().getData();
			root = root.getlChild();
		}
		
		return minv;
	}
	
	public String toString() {
		return toStringInOrderTraversal(root);
	}
}
