/* 程式範例: Ch6_4_2.java */
class BTree_PreOrder extends BTree { // 繼承二元樹類別

	String strPreOrder = "";
	String[] numstrPreOrder;

	// 建構子: 建立二元樹
	public BTree_PreOrder(int[] data) {
		super(data);
	}

	// 方法: 二元樹的前序走訪
	public void preOrder(TreeNode ptr) {
		if (ptr != null) { // 終止條件
			// 顯示節點內容
			System.out.print("[" + ptr.data + "]");
			// System.out.print(ptr.data + ",");
			strPreOrder += ptr.data + ",";

			preOrder(ptr.left); // 左子樹
			preOrder(ptr.right); // 右子樹
		}
	}

	// 方法: 前序走訪顯示二元樹
	public void printPreOrder() {
		preOrder(head); // 呼叫前序走訪方法
		
		System.out.println();
		//System.out.println(strPreOrder);

		numstrPreOrder = strPreOrder.split(",");

		/*
		for (int i = 0; i < numsPreOrder.length; i++) {
			System.out.print(numsPreOrder[i] + " ");
		}
		System.out.println("\n");
		*/

	}// end of printPreOrder
}// END
