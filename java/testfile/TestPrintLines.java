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
		if (lines < 1 || lines > 25) {
			throw new IllegalArgumentException("YOU HAVE FAILED THE TEST.");
		}
		SearchTree<String> tree = new SearchTree<>();
		for (int i = 0; i < lines; i++) {
			tree.insert(lineText);
		}
		for (String i : tree) {
			System.out.println(i);
		}
	}

}

@SuppressWarnings("unchecked")
class SearchTree<E extends Comparable<E>> implements Iterable<E> {

	public SearchTreeNode overallRoot;

	public SearchTree() {
		this.overallRoot = null;
	}

	public SearchTree(E e) {
		this.overallRoot = new SearchTreeNode(e);
	}

	public SearchTree(SearchTreeNode node) {
		this.overallRoot = node.deepCopy();
	}

	public SearchTree<E> getCopy() {
		return new SearchTree<E>(this.overallRoot);
	}

	public SearchTreeNode getRoot() {
		return this.overallRoot.deepCopy();
	}

	public void insert(E e) {
		if (this.overallRoot == null) {
			this.overallRoot = new SearchTreeNode(e);
			return;
		}
		this.insert(e, this.overallRoot);
	}

	private void insert(E e, SearchTreeNode node) {
		if (e.compareTo(node.data) < 0) {
			if (node.left != null) {
				this.insert(e, node.left);
			} else {
				node.left = new SearchTreeNode(e);
			}
		} else if (e.compareTo(node.data) >= 0) {
			if (node.right != null) {
				this.insert(e, node.right);
			} else {
				node.right = new SearchTreeNode(e);
			}
		}
	}

	public void printInorder() {
		this.printInorder(this.overallRoot);
		System.out.println();
	}

	private void printInorder(SearchTreeNode node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			this.printInorder(node.left);
		}

		System.out.print(node.data.toString() + " ");

		if (node.right != null) {
			this.printInorder(node.right);
		}
	}

	public void printPreorder() {
		this.printPreorder(this.overallRoot);
		System.out.println();
	}

	private void printPreorder(SearchTreeNode node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data.toString() + " ");

		if (node.left != null) {
			this.printPreorder(node.left);
		}

		if (node.right != null) {
			this.printPreorder(node.right);
		}
	}

	public void printPostorder() {
		this.printPostorder(this.overallRoot);
		System.out.println();
	}

	private void printPostorder(SearchTreeNode node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			this.printPostorder(node.left);
		}

		if (node.right != null) {
			this.printPostorder(node.right);
		}

		System.out.print(node.data.toString() + " ");
	}

	public E highestValue() {
		return this.highestValue(this.overallRoot);
	}

	private E highestValue(SearchTreeNode node) {
		if (node.right == null) {
			return node.data;
		}
		return this.highestValue(node.right);
	}

	public E lowestValue() {
		return this.lowestValue(this.overallRoot);
	}

	private E lowestValue(SearchTreeNode node) {
		if (node.left == null) {
			return node.data;
		}
		return this.lowestValue(node.left);
	}

	public void printFullTree() {
		this.printFullTree(this.overallRoot, 0);
		System.out.println();
	}

	private void printFullTree(SearchTreeNode node, int level) {
		if (node == null) {
			return;
		}
		if (node.right != null) {
			this.printFullTree(node.right, level + 1);
		} else {
			System.out.println();
		}
		for (int i = 0; i < level; i++) {
			System.out.print("    ");
		}
		System.out.println(node.data);
		if (node.left != null) {
			this.printFullTree(node.left, level + 1);
		} else {
			System.out.println();
		}
	}

	public int getSize() {
		return this.getSize(this.overallRoot);
	}

	private int getSize(SearchTreeNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + this.getSize(node.left) + this.getSize(node.right);
	}

	@Override
	public boolean equals(Object other) {
		if ( !(other instanceof SearchTree)) {
			return false;
		}
		SearchTree<E> otherTree = (SearchTree<E>) other;
		return this.overallRoot.equals(otherTree.getRoot());
	}

	public int count(E e) {
		return this.count(e, this.overallRoot);
	}

	private int count(E e, SearchTreeNode node) {
		if (node == null) {
			return 0;
		}
		if (e.compareTo(node.data) == 0) {
			return 1 + this.count(e, node.left) + this.count(e, node.right);
		}
		return this.count(e, node.left) + this.count(e, node.right);
	}

	public boolean contains(E e) {
		return this.contains(e, this.overallRoot);
	}

	private boolean contains(E e, SearchTreeNode node) {
		return (node == null) ? false : (node.data.compareTo(e) == 0 || this.contains(e, node.left) || this
				.contains(e, node.right));
	}

	public E[] toArray() {
		Comparable<?>[] arr = new Comparable[this.getSize()];
		this.toArray(arr, this.overallRoot, 0);
		return (E[]) arr;
	}

	private int toArray(Comparable<?>[] arr, SearchTreeNode node, int index) {
		if (index >= arr.length) {
			return 0;
		}
		int newIndex = index;
		if (node == null) {
			return index;
		}
		if (node.left != null) {
			newIndex = this.toArray(arr, node.left, index);
		}
		arr[newIndex] = node.data;
		if (node.right != null) {
			newIndex = this.toArray(arr, node.right, newIndex + 1);
			return newIndex;
		}
		return newIndex + 1;
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
			return this.deepCopy(this);
		}

		public SearchTreeNode deepCopy(SearchTreeNode node) {
			if (node == null) {
				return null;
			}
			SearchTreeNode newNode = new SearchTreeNode(node.data);
			newNode.left = this.deepCopy(node.left);
			newNode.right = this.deepCopy(node.right);
			return newNode;
		}

		@Override
		public String toString() {
			return "" + this.data;
		}

		public boolean equals(SearchTreeNode node) {
			if (node == null) {
				return false;
			}
			return (this.data.compareTo(node.data) == 0)
					&& ((this.left != null) ? this.left.equals(node.left) : (node.left == null))
					&& ((this.right != null) ? this.right.equals(node.right) : (node.right == null));
		}

	}

	/*
	 * private SearchTreeNode lowestNode(SearchTreeNode node) { return (node == null) ?
	 * null : ((node.left == null) ? node : lowestNode(node.left)); }
	 */

	public void resetAccesses() {
		this.resetAccesses(this.overallRoot);
	}

	private void resetAccesses(SearchTreeNode node) {
		if (node != null) {
			node.accessed = false;
			this.resetAccesses(node.left);
			this.resetAccesses(node.right);
		}
	}

	@Override
	public Iterator<E> iterator() {
		// return new SearchTreeArrayIterator<E>();
		return new SearchTreeArrayIterator<E>();
	}

	private class SearchTreeArrayIterator<T extends E> implements Iterator<E> {

		private int current = 0;

		private Comparable<?>[] elements = SearchTree.this.toArray();

		@Override
		public boolean hasNext() {
			return this.current < this.elements.length;
		}

		@Override
		public T next() {
			return (T) this.elements[this.current++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Removal is not yet supported");
		}

	}

	/*
	 * private class SearchTreeIterator implements Iterator<E> {
	 *
	 * { SearchTree.this.resetAccesses(); }
	 *
	 * private SearchTreeNode currentNode = lowestNode(SearchTree.this.overallRoot);
	 *
	 * public boolean hasNext() { return currentNode != null; }
	 *
	 * private SearchTreeNode nextNode(SearchTreeNode node) { if (node == null) return
	 * null; if (node.left != null && !node.left.accessed) return nextNode(node.left); if
	 * (!node.accessed) return node; if (node.right != null && !node.right.accessed) return
	 * nextNode(node.right); return nextNode(node.parent); }
	 *
	 * public E next() { SearchTreeNode retNode = currentNode; retNode.accessed = true;
	 * currentNode = nextNode(retNode); return retNode.data; }
	 *
	 * public void remove() { throw new
	 * UnsupportedOperationException("Removal is not yet supported"); }
	 *
	 * }
	 */

}
