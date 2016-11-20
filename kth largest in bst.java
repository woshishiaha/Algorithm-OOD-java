//reverse In-order traversal,
// O(n) Time, O(1) Space

  public TreeNode kthLargest(TreeNode root, int k) {
    if (root == null) {
      return null;
    }
    TreeNode result = null;
    helper(root, k, 0, result);
    return result;
  }
  public void helper (TreeNode root, int k, int count, TreeNode result) {
    if (root == null || c > k) {
      return;
    }
    //go right first
    helper (root.right, k, count, result);
    //update count
    count++;
    if (count == k) {
      result = root;
      return;
    }
    helper(root.left, k, count, result);
  }



// kth smallest in BST
public int kthSmallest(TreeNode root, int k) {
       if (root == null) {
            return 0;
        }
        int size = findSize(root.left);
        if (k == size + 1) {
            return root.val;
        } else if (k > size + 1) {
            return kthSmallest(root.right, k - size - 1);
        } else {
            return kthSmallest(root.left, k);
        }
        
    }
    public int findSize (TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + findSize(root.left) + findSize(root.right);
    }
