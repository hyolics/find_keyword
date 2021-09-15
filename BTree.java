/* 程式範例: BTree.java */ 
public class BTree {       // 二元樹類別
   public TreeNode head;   // 參考樹的根節點
   // 建構子: 使用陣列建立二元樹
   public BTree(int[] array) {
      int i;
      // 使用迴圈以插入方式建立樹狀結構
      for ( i = 0; i < array.length; i++ )
         insertBTreeNode(array[i]);
   }
   // 方法: 檢查二元樹是否是空的
   boolean isBTreeEmpty() {
      if ( head == null ) return true;
      else                return false;
   }
   // 方法: 在二元樹插入節點
   public void insertBTreeNode(int data) {
      if ( isBTreeEmpty() ) {  // 建立根節點
         head = new TreeNode(data);
         return;
      }
      // 建立二元樹
      TreeNode current = head;
      while (true) {
         if ( data < current.data ) {  // 在左子樹
            if ( current.left == null ) {
               current.left = new TreeNode(data);
               return;
            }
            else  current = current.left;
         }
         else {  // 在右子樹
            if ( current.right == null ) {
               current.right = new TreeNode(data);
               return;
            }
            else  current = current.right;
         }
      }
   }
   // 方法: 顯示二元樹的節點資料
   public void printBTree() {
      TreeNode ptr;
      System.out.println("根節點: [" + head.data + "]");
      ptr = head.left;      // 左子樹的指標
      System.out.print("左子樹: ");
      while ( ptr != null ) {
         System.out.print("["+ptr.data+"]"); // 顯示節點
         ptr = ptr.left;    // 左子節點
      }
      System.out.print("\n右子樹: ");
      ptr = head.right;     // 右子樹的指標
      while ( ptr != null ) {
         System.out.print("["+ptr.data+"]"); // 顯示節點
         ptr = ptr.right;   // 右子節點
      }
      System.out.println();
   }
}