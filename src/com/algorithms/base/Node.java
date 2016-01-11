package com.algorithms.base;

import java.util.ArrayList;
import java.util.List;

/**
 * A Generic implementation of node in general tree
 * 
 * @author yaron
 *
 * @param <T>
 *            The value stored in the node
 * 
 */
public class Node<T> {

	// The value stored in the node
	protected T value;

	// The parent node of the node
	protected Node<T> parent;

	// All the direct child-nodes of the node
	protected List<Node<T>> children;

	// Type of node
	protected NodeType type;

	public Node(T value, NodeType type, Node<T> parent) {
		this.parent = parent;
		this.value = value;
		this.type = type;
	}

	public Node(T value, NodeType type) {
		this(value, type, null);
	}

	public Node(T value) {
		this(value, NodeType.Leaf, null);
	}

	Node<T> getParent() {
		return parent;
	}

	void setParent(Node<T> parent) {
		this.parent = parent;
	}

	T getValue() {
		return value;
	}

	void setValue(T value) {
		this.value = value;
	}

	NodeType getType() {
		return type;
	}

	void setType(NodeType type) {
		this.type = type;
	}

	/**
	 * Adds a value to the tree iff the value is not {@code null} and the value
	 * is not already stored in the node. <br>
	 * This method is thread unsafe.
	 * 
	 * @param value
	 *            The value to add to the node
	 * @return The child {@code TreeNode} that holds the value
	 * 
	 */
	public Node<T> add(T value) {

		if (value == null) {
			return null;
		}

		if (children == null) {
			children = new ArrayList<>();
		}

		// If the value already exists we just return it
		for (int i = 0; i < children.size(); i++) {

			Node<T> child = children.get(i);

			if (value.equals(child.value)) {
				return child;
			}
		}

		// This is a new value for this node, add it as new child
		Node<T> node = new Node<T>(value, NodeType.Leaf);
		node.parent = this;

		// Add the new node as child
		children.add(node);

		// Set the type of the current node to Node
		type = NodeType.Node;
		return node;
	}

	public Node<T> get(T value) {

		if (value == null || children == null) {
			return null;
		}

		for (Node<T> node : children) {
			if (value.equals(node.value)) {
				return node;
			}
		}

		return null;
	}

	/**
	 * Removes all the children of the node.
	 */
	void deleteChildren() {

		if (children == null) {
			return;
		}

		// Clear all reference to the parent in order to avoid memory leaks
		for (Node<T> child : children) {
			child.parent = null;
		}

		children = null;
	}

	/**
	 * Returns the number of children of this node
	 * 
	 * @return the number of children of this node
	 */
	public int childCount() {

		if (children == null) {
			return 0;
		}

		return children.size();
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append(Node.class.getSimpleName());
		sb.append('(');
		sb.append(value);
		sb.append(", ");
		sb.append(type.name());
		sb.append(") [");

		if (children != null) {
			for (Node<T> child : children) {
				sb.append(' ');
				sb.append(child.value);
			}
		}

		sb.append(']');

		return sb.toString();
	}
}
