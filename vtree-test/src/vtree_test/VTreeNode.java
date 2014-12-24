package vtree_test;

import java.util.List;

public interface VTreeNode {
	VTreeNode getParentNode();
	List<VTreeNode> getChildNodes();
	void addChildNode();
}
