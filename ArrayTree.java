
public class ArrayTree {
	
	// NOTE:
	// root * 2 + 1 = root's left child
	// root * 2 + 2 = root's right child
	
	private int count;
	private Integer []array;
	private static final int TREE_SIZE = 32;
	
	public ArrayTree() {
		array = new Integer[TREE_SIZE];
	}
	
	public boolean add(Integer data) {
		if (count == 0) {
			array[0] = data;
			count = 1;
			return true;
		}
		
		return internalAdd(0, data);
	}
	
	private boolean internalAdd(int root, Integer data) {
		if (array[root] == null) {
			// This should not happen
			return false;
		}
		
		if (data < array[root]) {
			// Go left
			// Make sure the array can hold it
			// If you were going to resize, this is where it happens.
			if (root*2+1 >= array.length-1) {
				return false;
			}
			if (array[root*2+1] == null) {
				// Add this here.
				array[root*2+1] = data;
				count++;
				return true;
			} else {
				return internalAdd(root*2+1, data);
			}
		} else {
			// Go right
			// Make sure the array can hold it
			// If you were going to resize, this is where it happens.
			if (root*2+2 >= array.length-1) {
				return false;
			}
			if (array[root*2+2] == null) {
				// Add this here.
				array[root*2+2] = data;
				count++;
				return true;
			} else {
				return internalAdd(root*2+2, data);
			}
		}
	}
	
	public boolean delete(Integer data) {
		return false;
	}
	
	public String preOrder() {
		StringBuilder result = new StringBuilder("");
		recPreOrder(0, result);
		return result.toString();
	}
	
	private void recPreOrder(int root, StringBuilder result) {
		
		// BASE Case
		if (array[root] == null) {
			return;
		}
		
		result.append(array[root] + " ");
		// Make sure we don't fall of the end of the array
		if ((root * 2 + 1) >= array.length-1) {
			System.out.println("Array about to fall out of bounds, root = " + root);
			return;
		}
		recPreOrder(root* 2 + 1, result);
		recPreOrder(root* 2 + 2, result);
	}

	public String inOrder() {
		StringBuilder result = new StringBuilder("");
		recInOrder(0, result);
		return result.toString();
	}
	
	private void recInOrder(int root, StringBuilder result) {
		
		// BASE Case
		if (array[root] == null) {
			return;
		}
		// Make sure we don't fall of the end of the array
		
		if ((root * 2 + 1) < array.length) {
			recInOrder(root* 2 + 1, result);
		}

		result.append(array[root] + " ");
		
		if ((root * 2 + 2) < array.length) {
			recInOrder(root* 2 + 2, result);
		}
	}

	public String postOrder() {
		StringBuilder result = new StringBuilder("");
		recPostOrder(0, result);
		return result.toString();
	}
	
	private void recPostOrder(int root, StringBuilder result) {
		
		// BASE Case
		if (array[root] == null) {
			return;
		}
		
		if ((root * 2 + 2) < array.length) {
			recPostOrder(root* 2 + 1, result);
			recPostOrder(root* 2 + 2, result);
		}
		
		result.append(array[root] + " ");
	}
	
	public String toString() {
		return inOrder();
	}

}
