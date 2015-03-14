/*
 * TreeNodePtrComparator.hpp
 *
 *  Created on: Mar 14, 2015
 *      Author: dbondin
 */

#ifndef TREENODEPTRCOMPARATOR_HPP_
#define TREENODEPTRCOMPARATOR_HPP_

#include "TreeNode.hpp"

class TreeNodePtrComparator {
public:
	bool operator ()(const TreeNode * x, const TreeNode * y) const;
};

#endif /* TREENODEPTRCOMPARATOR_HPP_ */
