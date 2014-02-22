package com.solovyev.cs;

import java.util.ArrayList;
import java.util.List;

public class Tree<T extends Comparable<T>>
{
	private T key;
	private Tree<T> parent;
	private Tree<T> left;
	private Tree<T> right;
	
	public Tree()
	{
	}
	
	private Tree(T key, Tree<T> parent)
	{
		this.key = key;
		this.parent = parent;
	}

	public void insert(T insertKey)
	{
		if(key == null)
		{
			key = insertKey;
		}
		else if(insertKey.compareTo(key) < 0)
		{
			if(left == null)
				left = new Tree<T>(insertKey, this);
			else
				left.insert(insertKey);
		}
		else
		{
			if(right == null)
				right = new Tree<T>(insertKey, this);
			else
				right.insert(insertKey);
		}
	}
	
	public List<T> getKeys()
	{
		ArrayList<T> res = new ArrayList<T>();
		
		if(left != null)
			res.addAll(left.getKeys());
		
		if(key != null)
			res.add(key);
		
		if(right != null)
			res.addAll(right.getKeys());
		
		return res;
	}
	
	public T getKey(T searchKey)
	{
		return getKeyTree(searchKey).key;
	}
	
	private Tree<T> getKeyTree(T searchKey)
	{
		Tree<T> res;
		
		if(key == null)
		{
			res = null;
		}
		else if(searchKey.compareTo(key) == 0)
		{
			res = this;
		}
		else if(searchKey.compareTo(key) < 0)
		{
			if(left == null)
				res = null;
			else
				res = left.getKeyTree(searchKey);
		}
		else
		{
			if(right == null)
				res = null;
			else
				res = right.getKeyTree(searchKey);
		}
		
		return res;		
	}
	
	private Tree<T> getMinTree()
	{
		if(key == null)
		{
			return null;
		}
		else if(left == null)
		{
			return this;
		}
		else
		{
			return left.getMinTree();
		}
	}

	private Tree<T> getMaxTree()
	{
		if(key == null)
		{
			return null;
		}
		else if(right == null)
		{
			return this;
		}
		else
		{
			return right.getMaxTree();
		}		
	}

	public T getMin()
	{
		return getMinTree().key;
	}
	
	public T getMax()
	{
		return getMaxTree().key;
	}
		
	private Tree<T> getSuccessorTree(Tree<T> tree)
	{
		if(tree == null)
		{
			return null;
		}
		else if(tree.right != null)
		{
			return tree.right.getMinTree();
		}
		else
		{
			while(true)
			{
				if(tree.parent == null)
				{
					return null;
				}
				else if(tree == tree.parent.left)
				{
					return tree.parent;
				}
				else
				{	
					tree = tree.parent;
				}
			}
		}
	}
	
	public T getSuccessor(T searchKey)
	{
		Tree<T> tree = getSuccessorTree(getKeyTree(searchKey));
		if(tree == null)
			return null;
		else
			return tree.key;
	}
	
	private Tree<T> getPredecessorTree(Tree<T> tree)
	{
		if(tree == null)
		{
			return null;
		}
		else if(tree.left != null)
		{
			return tree.left.getMaxTree();
		}
		else
		{
			while(true)
			{
				if(tree.parent == null)
				{
					return null;
				}
				else if(tree == tree.parent.right)
				{
					return tree.parent;
				}
				else
				{	
					tree = tree.parent;
				}
			}
		}
	}

	public T getPredecessor(T searchKey)
	{		
		Tree<T> tree = getPredecessorTree(getKeyTree(searchKey));
		if(tree == null)
			return null;
		else
			return tree.key;
	}
	
	private void replaceTree(Tree<T> replaced, Tree<T> replacement)
	{
		if(replaced.parent == null)
		{
			if(replacement != null)
			{
				replaced.key = replacement.key;
				replaced.left = replacement.left;
				replaced.right = replacement.right;
				if(replacement.left != null)
					replacement.left.parent = replaced;
				if(replacement.right != null)
					replacement.right.parent = replaced;
			}
			else
			{
				replaced.key = null;
				replaced.left = null;
				replaced.right = null;
			}
		}
		else
		{
			if(replacement != null)
				replacement.parent = replaced.parent;

			if(replaced == replaced.parent.left)
				replaced.parent.left = replacement;
			else if(replaced == replaced.parent.right)
				replaced.parent.right = replacement;
			else
				throw new RuntimeException("tree structure error");
		}
	}

	public void delete(T deleteKey)
	{
		Tree<T> tree = getKeyTree(deleteKey);
		
		// key not found
		if(tree == null)
			return;

		Tree<T> replaced;
		Tree<T> replacement;
		// no children
		if(tree.left == null && tree.right == null)
		{
			replaced = tree;
			replacement = null;
		}
		// left child
		else if(tree.left != null && tree.right == null)
		{
			replaced = tree;
			replacement = tree.left;
		}
		// right child
		else if(tree.left == null && tree.right != null)
		{
			replaced = tree;
			replacement = tree.right;
		}
		// two children
		else
		{
			Tree<T> successorTree = getSuccessorTree(tree);
			tree.key = successorTree.key;
			replaced = successorTree;
			replacement = successorTree.right;
		}
		replaceTree(replaced, replacement);
	}

	private String stringRep(Tree<T> tree)
	{
		if(tree == null)
			return "null";
		else
			return "" + tree.hashCode();
	}
	
	@Override
	public String toString()
	{
		return "Tree [key=" + key + " this=" + hashCode() + " parent=" + stringRep(parent) + " left=" + stringRep(left) + " right=" + stringRep(right) + "]";
	}
}