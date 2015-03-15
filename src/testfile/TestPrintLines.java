package testfile;

import java.util.Iterator;
import java.util.Scanner;

public class TestPrintLines {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int lines = 0;
		System.out.print("Enter a number: ");
		lines = console.nextInt();
		String lineText = null;
		System.out.print("Type a line of text: ");
		lineText = console.next() + console.nextLine();
		console.close();
		if (lines < 1 || lines > 25)
			throw new IllegalArgumentException("YOU HAVE FAILED THE TEST.");
		SearchTree<String> tree = new SearchTree<>();
		for (int i = 0; i < lines; i++)
			tree.insert(lineText);
		for (String i : tree)
			System.out.println(i);
	}

}   

@SuppressWarnings("unchecked")

class SearchTree<E extends Comparable<E>> implements Iterable<E>{

	public SearchTreeNode overallRoot;

	public SearchTree() {
		overallRoot = null;
	}   

	public SearchTree(E e) {
		overallRoot = new SearchTreeNode(e);
	}

	public SearchTree(SearchTreeNode node) {
		overallRoot = node.deepCopy();
	}

	public SearchTree<E> getCopy() {
		return new SearchTree<E>(overallRoot);
	}         

	public SearchTreeNode getRoot() {
		return overallRoot.deepCopy();
	}   

	public void insert(E e) {
		if (overallRoot == null) {
			overallRoot = new SearchTreeNode(e);
			return;
		}   
		insert(e, overallRoot);
	}

	private void insert(E e, SearchTreeNode node) {
		if (e.compareTo(node.data) < 0) {
			if (node.left != null) {
				insert(e, node.left);
			}
			else {
				node.left = new SearchTreeNode(e);
			}
		}
		else if (e.compareTo(node.data) >= 0) {
			if (node.right != null) {
				insert(e, node.right);
			}
			else {
				node.right = new SearchTreeNode(e);
			}
		}
	}

	public void printInorder() {
		printInorder(overallRoot);
		System.out.println();
	}

	private void printInorder(SearchTreeNode node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			printInorder(node.left);
		}

		System.out.print(node.data.toString()+" ");

		if (node.right != null) {
			printInorder(node.right);
		}
	}

	public void printPreorder() {
		printPreorder(overallRoot);
		System.out.println();
	}

	private void printPreorder(SearchTreeNode node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data.toString()+" ");

		if (node.left != null) {
			printPreorder(node.left);
		}

		if (node.right != null) {
			printPreorder(node.right);
		}
	}

	public void printPostorder() {
		printPostorder(overallRoot);
		System.out.println();
	}

	private void printPostorder(SearchTreeNode node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			printPostorder(node.left);
		}

		if (node.right != null) {
			printPostorder(node.right);
		}

		System.out.print(node.data.toString()+" ");
	}

	public E highestValue() {
		return highestValue(overallRoot);
	}

	private E highestValue(SearchTreeNode node) {
		if (node.right == null) {
			return node.data;
		}
		return highestValue(node.right);
	}

	public E lowestValue() {
		return lowestValue(overallRoot);
	}

	private E lowestValue(SearchTreeNode node) {
		if (node.left == null) {
			return node.data;
		}
		return lowestValue(node.left);
	}

	public void printFullTree() {
		printFullTree(overallRoot, 0);
		System.out.println();
	}

	private void printFullTree(SearchTreeNode node, int level) {
		if (node == null) {
			return;
		}
		if (node.right != null) {
			printFullTree(node.right, level+1);
		}
		else {
			System.out.println();
		}
		for (int i = 0; i < level; i++) {
			System.out.print("    ");
		}
		System.out.println(node.data);
		if (node.left != null) {
			printFullTree(node.left, level+1);
		}
		else {
			System.out.println();
		}
	} 

	public int getSize() {
		return getSize(overallRoot);
	}

	private int getSize(SearchTreeNode node) {
		if (node == null)
			return 0;
		return 1 + getSize(node.left) + getSize(node.right);
	}

	public boolean equals(Object other) {
		if (!(other instanceof SearchTree))
			return false;
		SearchTree<E> otherTree = (SearchTree<E>) other;
		return this.overallRoot.equals(otherTree.getRoot());
	}   

	public int count(E e) {
		return count(e, overallRoot);
	}

	private int count(E e, SearchTreeNode node) {
		if (node == null)
			return 0;
		if (e.compareTo(node.data) == 0)
			return 1 + count(e, node.left) + count(e, node.right);
		return count(e, node.left) + count(e, node.right);
	}

	public boolean contains(E e) {
		return contains(e, overallRoot);
	}

	private boolean contains(E e, SearchTreeNode node) {
		return (node == null) ? false : (node.data.compareTo(e) == 0 || contains(e, node.left) || contains(e, node.right));
	} 

	public E[] toArray() {
		Comparable<?>[] arr = new Comparable[this.getSize()];
		toArray(arr, overallRoot, 0);
		return (E[]) arr;
	}

	private int toArray(Comparable<?>[] arr, SearchTreeNode node, int index) {
		if (index >= arr.length)
			return 0;
		int newIndex = index;
		if (node == null)
			return index;
		if (node.left != null)
			newIndex = toArray(arr, node.left, index);
		arr[newIndex] = node.data;
		if (node.right != null) {
			newIndex = toArray(arr, node.right, newIndex+1);
			return newIndex;
		}   
		return newIndex+1;
	} 

	public class SearchTreeNode {
		public E data;
		public boolean accessed = false;
		public SearchTreeNode left;
		public SearchTreeNode right;
		public SearchTreeNode parent;

		public SearchTreeNode() {
			this.left = null;
			this.right = null;
		}

		public SearchTreeNode(E e) {
			this(e, null, null);
		}

		public SearchTreeNode(E e, SearchTreeNode leftNode, SearchTreeNode rightNode) {
			this.data = e;
			this.left = leftNode;
			this.right = rightNode;
		}  

		public SearchTreeNode deepCopy() {
			return deepCopy(this);
		}   

		public SearchTreeNode deepCopy(SearchTreeNode node) {
			if (node == null)
				return null;
			SearchTreeNode newNode = new SearchTreeNode(node.data);
			newNode.left = deepCopy(node.left);
			newNode.right = deepCopy(node.right);
			return newNode;
		}

		public String toString() {
			return "" + this.data;
		}

		public boolean equals(SearchTreeNode node) {
			if (node == null)
				return false;
			return (this.data.compareTo(node.data) == 0) && ((this.left != null) ? this.left.equals(node.left) : (node.left == null)) && ((this.right != null) ? this.right.equals(node.right) : (node.right == null));
		}     

	}   

	/*
	private SearchTreeNode lowestNode(SearchTreeNode node) {
		return (node == null) ? null : ((node.left == null) ? node : lowestNode(node.left));
	}
	*/

	public void resetAccesses() {
		resetAccesses(overallRoot);
	}

	private void resetAccesses(SearchTreeNode node) {
		if (node != null) {
			node.accessed = false;
			resetAccesses(node.left);   
			resetAccesses(node.right); 
		}
	} 

	public Iterator<E> iterator() {
		//return new SearchTreeArrayIterator<E>();
		return new SearchTreeArrayIterator<E>();
	}        

	private class SearchTreeArrayIterator<T extends E> implements Iterator<E> {

		private int current = 0;

		private Comparable<?>[] elements = SearchTree.this.toArray();

		public boolean hasNext() {
			return current < elements.length;
		}

		public T next() {
			return (T) elements[current++];
		}

		public void remove() { throw new UnsupportedOperationException("Removal is not yet supported"); }

	} 

	/*
   private class SearchTreeIterator implements Iterator<E> {

      {
         SearchTree.this.resetAccesses();
      }

      private SearchTreeNode currentNode = lowestNode(SearchTree.this.overallRoot);

      public boolean hasNext() { 
         return currentNode != null; }

      private SearchTreeNode nextNode(SearchTreeNode node) {
         if (node == null)
            return null;
         if (node.left != null && !node.left.accessed)
            return nextNode(node.left);
         if (!node.accessed)
            return node;
         if (node.right != null && !node.right.accessed)
            return nextNode(node.right);
         return nextNode(node.parent);           
      }

      public E next() {
         SearchTreeNode retNode = currentNode;
         retNode.accessed = true;
         currentNode = nextNode(retNode);
         return retNode.data;
      }

      public void remove() {
         throw new UnsupportedOperationException("Removal is not yet supported");
      }   

   }
	 */   

}