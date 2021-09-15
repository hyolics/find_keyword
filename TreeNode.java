/* 程式範例: TreeNode.java */ 
public class TreeNode {    // 樹節點類別
   int data;        // 節點資料
   TreeNode left;   // 參考左子樹
   TreeNode right;  // 參考右子樹
   // 建構子
   public TreeNode(int data) {
      this.data = data;
      this.left = this.right = null;
   }
}