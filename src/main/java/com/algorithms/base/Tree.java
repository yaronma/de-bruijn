package com.algorithms.base;

/**
 * This is a simple implementation for near-full general purpose tree.
 * <p>
 * 
 * This implementation is space-efficient achieved by deleting the full sub tree
 * and replacing it with a special node.
 * <p>
 * 
 * @author yaron
 *
 * @param <T> The value stored in the tree nodes
 */
public class Tree<T> {

	// The alphabet symbols stored in this tree
	protected T alphabet[];

	// The length (number of symbols) of value stored in the tree.
	protected int elementLenght;

	// The root node
	protected Node<T> root;

	// Indicates if this tree has duplicate values
	protected boolean hasDuplicates;

	/**
	 * Tree constructor
	 * 
	 * @param alphabet
	 * @param elementLenght
	 */
	public Tree(T alphabet[], int elementLenght) {
		this.alphabet = alphabet;
		this.elementLenght = elementLenght;

		// By default we allow any alphabet
		root = new Node<T>(null);
	}

	/**
	 * Add a value (list of symbols) to the tree.
	 * 
	 * @param value
	 *            The value (list of symbols) to store in the tree.
	 */
	public void add(T[] value) {

		Node<T> current = root;

		// Go over all the symbols in the given value and find a path in the
		// tree to store it
		for (int i = 0; i < value.length; i++) {

			// We have reached a complete branch. this means that we have
			// processed this value before and we don't have to do anything else
			if (current.type == NodeType.Full) {
				hasDuplicates = true;
				return;
			}

			// The current node is a regular/leaf node. Add the new value and
			// check if we got a full sub-tree
			Node<T> child = current.get(value[i]);

			if (child == null) {

				if (current.type == NodeType.Leaf) {
					current.type = NodeType.Node;
				}

				// Add all remaining values in the value array to the tree
				for (;i < value.length; i++) {
					current = current.add(value[i]);
				}

				break;
			}

			current = child;
		}

		// We added value (the symbols array) to the tree. We need to check
		// whether we create a full node and operate accordingly.
		// We Traverse the the tree from the leaf upwards to the root and check
		// the highest level where we have a complete branch
		checkFullSubTree(current.parent);
	}

	// Check for the highest level where we have a complete sub tree. Delete all
	// the nodes in the sub tree.
	private void checkFullSubTree(Node<T> node) {

		while (node != null) {

			if (node.childCount() != alphabet.length) {
				return;
			}

			for (Node<T> child : node.children) {
				if (child.type == NodeType.Node) {
					return;
				}
			}

			node.deleteChildren();
			node.setType(NodeType.Full);
			node = node.parent;
		}
	}

	public boolean contains(T[] perm) {

		if (perm == null) {
			throw new IllegalArgumentException();
		}

		if (perm.length != elementLenght) {
			throw new IllegalArgumentException(
					"Permutation lenght is different from permitations stored in the search tree");
		}

		Node<T> currentNode = root;

		// Iterate over all the characters in the permutation and
		for (int i = 0; i < elementLenght; i++) {

			currentNode = currentNode.get(perm[i]);

			if (currentNode == null) {
				return false;
			}

			if (currentNode.getType() == NodeType.Full) {
				return true;
			}
		}

		return true;
	}

	/**
	 * Returns {@code true} if the tree is full; {@code false} otherwise.
	 * 
	 * @return {@code true} if the tree is full; {@code false} otherwise.
	 */
	public boolean isFull() {
		if (root == null || root.type == NodeType.Full) {
			return true;
		}

		return false;
	}

	public boolean hasDuplicates() {
		return hasDuplicates;
	}
}
