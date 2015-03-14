#pragma once

class TreeNode {
public:

	enum TYPE {
		LEAF,
		INNER
	};

	TreeNode(int _byte, unsigned long int _weight);
	TreeNode(TreeNode * _left, TreeNode * _right);
	TreeNode(const TreeNode & node);

	unsigned long getWeight() const;
	int getByte() const;
	TreeNode::TYPE getType() const;
	TreeNode * getLeft() const;
	TreeNode * getRight() const;

private:

	TreeNode::TYPE type;
	int byte;
	unsigned long int weight;
	TreeNode * left;
	TreeNode * right;
};
