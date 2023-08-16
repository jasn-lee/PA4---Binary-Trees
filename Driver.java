//------------------------------------------------------------------------------------------------------------------------
// Driver
// Parses through Oscar Wilde’s The Picture of Dorian Gray, then maps all words to lower case and removes all
// punctuation characters, then inserts them into a Linked List for information on the text.
//
// Author: Jason Lee
// Date: 08/15/23
// Class: MET CS342
// Issues: 'Depth" count is off by 1, 'Most Frequent' count off by 1, and unable to find to Deepest Node
//
// Description:
// This program parses through a .txt file in the user's local storage, and processes it so that 
// only lowercase letters and numbers remain. It sprts through each word and adds it into nodes of
// a Binary Tree in alphabetical order. An occurance count exists in each node for duplicate words.
//
// Assumptions:
// The user will replace the file path name on Line 33 in the Driver.java file, with the file path of 
// their own Dracula text file. 
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
		
		//Replace file path
		text = (tree.parse("/Users/jasonlee/Downloads/dracula.txt"));
		tree.add(text);
		System.out.println("Text contains : " + tree.size() + " Total words.");
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

}
