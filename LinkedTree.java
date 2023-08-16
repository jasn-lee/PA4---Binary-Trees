//Class:  LinkedTree
//
// Description:
// This program parses through a .txt file in the user's local storage, and processes it so that 
// only lowercase letters and numbers remain. It sprts through each word and adds it into nodes of
// a Binary Tree in alphabetical order. An occurance count exists in each node for duplicate words.
//
// Author: Jason Lee
// Date: 08/15/23
// Class: MET CS342
//

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

	//variables for finding the most Frequent Word in text
	Integer frequentCount = 0;
	String frequentWord = null;

	//variables for Pre-Order, In-Order, Post-Order Traversals
	String preOrder = "";
	String inOrder = "";
	String postOrder = "";

	String children = "";

	//Depth of Tree
	int depth = 0;
	int maxDepth = 0;


/// parse () ///
/// Input : a string of the filepath to the dracula .txt file ///
/// Output: a string of all the text altered (mapped all words to lower case, and removed all punctuation characters 
///         (only numbers or letters remain) removed characters are eaten ///
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
			return text;
		}

/// add () ///
/// Input : string of the pre-processed words ///
/// Output:  Parses through text, for each word, creates the root Node of the Tree, 
///          Calls the private internalAdd method to add to Tree         
/// A public method accessing the private variant to add to Tree. 
	public void add(String text) {
		for (String word : text.split("\\s+")){
			if (!"null".equals(word)) {
				// If its the first node handle it.
				if (root == null) {
					Node newNode = new Node();
					newNode.setData(word);
					root = newNode;
				} else {
					internalAdd(root, word);

				}
			}
		}
	}
	
/// internalAdd () ///
/// Input : Node of root in this instance, and the word in the text ///
/// Output:  Adds nodes to Tree. Compares the words lexigraphically to go 
///			 left or right. Updates occurances if already found. Updates
///          total word count.
	private void internalAdd(Node root, String word) {
		if (root == null) {
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
	

/// differentWords() ///
/// Input : n/a ///
/// Output:  returns the count of how many nodes exist in the tree
	public Integer differentWords() {
		return nodeCount;
	}

/// whatIsRoot() ///
/// Input : n/a ///
/// Output:  returns the word in the root of the tree
	public String whatIsRoot() {
		return (root.getData());
	}

/// whatIsRoot() ///
/// Input : The word you wantto find ///
/// Output:  calls and returns from the private instance internalSearch method
	public void wordsInText(String word) {
		internalSearch(root, word);

	}
	
/// internalSearch() ///
/// Input : The root of the tree, and the word you want to find ///
/// Output:  the occurance count of the word you want's node
	private void internalSearch(Node root, String word) {
		if (root == null) {
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
			System.out.println((root.getData() + " occurs : " + root.getOccurance() + " times"));
			
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
	

/// preOrderTraversal() ///
/// Input : n/a ///
/// Output:  calls the private/internal PreOrderTraversal method. Formats and prints out result
	public void preOrderTraversal() {
		internalPreOrderTraversal(root);
		for (String word : preOrder.split("\\s+")) {
			System.out.println("first word in Pre-Order: " + word);
			break;
		}
	}

/// inOrderTraversal() ///
/// Input : n/a ///
/// Output:  calls the private/internal inOrderTraversal method. Formats and prints out result
	public void inOrderTraversal() {
		internalInOrderTraversal(root);
		for (String word : inOrder.split("\\s+")) {
			System.out.println("first word in In-Order: " + word);
			break;
		}
	}

/// postOrderTraversal() ///
/// Input : n/a ///
/// Output:  calls the private/internal postOrderTraversal method. Formats and prints out result
	public void postOrderTraversal() {
		internalPostOrderTraversal(root);
		for (String word : postOrder.split("\\s+")) {
			System.out.println("first word in Post-Order: " + word);
			break;
		}
	}

/// internalPreOrderTraversal() ///
/// Input : Node of root ///
/// Output:  traverses the Tree Node - Left - Right
	private void internalPreOrderTraversal(Node root) {
		// Base Case
		if (root == null) {
			return;
		}
		preOrder += (root.getData() + " ");
		
		internalPreOrderTraversal(root.getlChild());
		internalPreOrderTraversal(root.getrChild());
	}

/// internalInOrderTraversal() ///
/// Input : Node of root ///
/// Output:  traverses the Tree Left - Node - Right
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

/// internalPostOrderTraversal() ///
/// Input : Node of root ///
/// Output:  traverses the Tree Left -  Right - Node 

	private void internalPostOrderTraversal(Node root) {
		// Base Case
		if (root == null) {
			return;
		}
		internalPostOrderTraversal(root.getlChild());
		internalPostOrderTraversal(root.getrChild());

		postOrder += (root.getData() + " ");
	}
	
/// size() ///
/// Input : Node of root ///
/// Output:  returns out the size of tree
	public int size() {
		return wordCount;
	}
	
/// maxDepth() ///
/// Input : n/a ///
/// Output:  calls the private/internal maxDepth method. 
	public int maxDepth() {
		depth = maxDepth(root, depth);
		maxDepth = depth;
		
		return maxDepth;
	}

/// maxDepth() ///
/// Input : n/a ///
/// Output:  returns an int of the maximum depth of the tree 
	private int maxDepth(Node root, int depth) {
		if (root == null) {
			return depth - 1;
		}
		int lcd = maxDepth(root.getlChild(), depth+1);
		int rcd = maxDepth(root.getrChild(), depth+1);
		if (lcd > rcd) {
			return lcd;
		} else {
			return rcd;			
		}
		
	}
/// totalWordCount
/// Input : n/a ///
/// Output:  formats and prints out the total count
	public int totalWordCount() {
		return (wordCount);
	}

/// mostFrequent
/// Input : n/a ///
/// Output:  calls the private method to find most frequent word
	public void mostFrequent() {
		mostFrequent(root);
		System.out.println("Most Frequent is : '" + frequentWord + "' occuring " + frequentCount + " times");
	}

/// mostFrequent
/// Input : Node root ///
/// Output:  the most frequently occuring word
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

	
}
