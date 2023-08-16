//------------------------------------------------------------------------------------------------------------------------
// Driver
// Parses through Oscar Wilde’s The Picture of Dorian Gray, then maps all words to lower case and removes all
// punctuation characters, then inserts them into a Linked List for information on the text.
//
// Author: Jason Lee
// Date: 07/18/23
// Class: MET CS342
// Issues: 
//
// Description:
// This program parses through a .txt file in the user's local storage, and processes it so that 
// only lowercase letters and numbers remain. It concatonates it all into a string (book), and uses that 
// string (book) to call methods inside the LinkedList class and inserst them into a linked list. It 
// has the ability to search for specific words, and return the count for those words. 
//
// Assumptions:
// The user will replace the file path name on Line 69 in the LinkedList.java file, with the file path of 
// their own Dorian Gray text file. 
//------------------------------------------------------------------------------------------------------------------------

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}
	
	private void doIt() {
		LinkedTree tree = new LinkedTree();
		String text = null;
		
		//System.out.println(tree);
		
		text = (tree.parse("/Users/jasonlee/Downloads/dracula.txt"));
		tree.add(text);
		/* 
		tree.add(50);
		tree.add(25);
		tree.add(80);
		tree.add(12);
		tree.add(37);
		tree.add(60);
		tree.add(100);
		tree.add(30);
		tree.add(90);
		
		tree.preOrderTraversal();
		tree.inOrderTraversal();
		tree.postOrderTraversal();

		System.out.println("toString");
		System.out.println(tree);
		
		System.out.println();
		System.out.println("Tree depth is " + tree.maxDepth());
		
		tree.delete(25);
		System.out.println(tree);
		*/
		System.out.println(tree);
		System.out.println(tree.size());
		tree.wordsInText("transylvania");
		tree.wordsInText("harker");
		tree.wordsInText("renfield");
		tree.wordsInText("vampire");
		tree.wordsInText("expostulate");
		System.out.println("Tree is : " + tree.maxDepth() + " nodes deep");
		System.out.println("Tree contains : " + tree.differentWords() + " distinct words");
		System.out.println("Word at root is : " + tree.whatIsRoot());
		System.out.println("Total word count : " + tree.totalWordCount());
		tree.mostFrequent();
		//tree.maxDepthWord();
		tree.preOrderTraversal();
		tree.inOrderTraversal();
		tree.postOrderTraversal();

		
		
	}
	private void doIt2() {
		ArrayTree tree = new ArrayTree();
		
		System.out.println(tree);
		
		tree.add(50);
		tree.add(25);
		tree.add(80);
		tree.add(12);
		tree.add(37);
		tree.add(60);
		tree.add(100);
		tree.add(30);
		tree.add(90);
		
		tree.preOrder();
		tree.inOrder();
		tree.postOrder();

		System.out.println("toString");
		System.out.println(tree);
		
		tree.delete(25);
		System.out.println(tree);
	}

}
