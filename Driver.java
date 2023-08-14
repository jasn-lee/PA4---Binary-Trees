
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}
	
	private void doIt() {
		LinkedTree tree = new LinkedTree();
		String text = null;
		
		System.out.println(tree);
		
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
