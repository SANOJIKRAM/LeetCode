/**
 * Definition for a binary tree node.
  * public class TreeNode {
   *     int val;
    *     TreeNode left;
     *     TreeNode right;
      *     TreeNode(int x) { val = x; }
       * }
        */
        
        import java.util.*;
        
        class Solution {
            private Integer prev = null;
                private int count = 1;
                    private int maxCount = 0;
                        private List<Integer> modes = new ArrayList<>();
                        
                            public int[] findMode(TreeNode root) {
                                    inorder(root);
                                            // Convert list to array
                                                    int[] result = new int[modes.size()];
                                                            for (int i = 0; i < modes.size(); i++) {
                                                                        result[i] = modes.get(i);
                                                                                }
                                                                                        return result;
                                                                                            }
                                                                                            
                                                                                                private void inorder(TreeNode node) {
                                                                                                        if (node == null) return;
                                                                                                        
                                                                                                                inorder(node.left);
                                                                                                                
                                                                                                                     
                                                                                                                                if (prev != null) {
                                                                                                                                            if (node.val == prev) {
                                                                                                                                                            count++;
                                                                                                                                                                        } else {
                                                                                                                                                                                        count = 1;
                                                                                                                                                                                                    }
                                                                                                                                                                                                            }
                                                                                                                                                                                                            
                                                                                                                                                                                                                    if (count > maxCount) {
                                                                                                                                                                                                                                maxCount = count;
                                                                                                                                                                                                                                            modes.clear();
                                                                                                                                                                                                                                                        modes.add(node.val);
                                                                                                                                                                                                                                                                } else if (count == maxCount) {
                                                                                                                                                                                                                                                                            modes.add(node.val);
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                    
                                                                                                                                                                                                                                                                                            prev = node.val;
                                                                                                                                                                                                                                                                                            
                                                                                                                                                                                                                                                                                                    inorder(node.right);
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                         