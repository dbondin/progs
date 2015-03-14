#include "TreeNodePtrComparator.hpp"

bool
TreeNodePtrComparator::operator ()(const TreeNode * x, const TreeNode * y) const {
	return x->getWeight() < y->getWeight();
}
