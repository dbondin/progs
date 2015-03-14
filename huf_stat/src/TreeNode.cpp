#include "TreeNode.hpp"

TreeNode::TreeNode(int _byte, unsigned long int _weight) {
	 type = LEAF;
	 byte = _byte;
	 weight = _weight;
	 right = 0;
	 left = 0;
}

TreeNode::TreeNode(TreeNode * _left, TreeNode * _right) {
	 type = INNER;
	 byte = -1;
	 weight = _left->weight + _right->weight;
	 left = _left;
	 right = _right;
}

TreeNode::TreeNode(const TreeNode & node) {
	type = node.type;
	byte = node.byte;
	weight = node.weight;
	left = node.left;
	right = node.right;
}


unsigned long
TreeNode::getWeight() const {
	return weight;
}

int
TreeNode::getByte() const {
	return byte;
}

TreeNode::TYPE
TreeNode::getType() const {
	return type;
}

TreeNode *
TreeNode::getLeft() const {
	return left;
}

TreeNode *
TreeNode::getRight() const {
	return right;
}
