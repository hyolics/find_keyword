/* �{���d��: Ch6_4_2.java */
class BTree_PreOrder extends BTree { // �~�ӤG�������O

	String strPreOrder = "";
	String[] numstrPreOrder;

	// �غc�l: �إߤG����
	public BTree_PreOrder(int[] data) {
		super(data);
	}

	// ��k: �G���𪺫e�Ǩ��X
	public void preOrder(TreeNode ptr) {
		if (ptr != null) { // �פ����
			// ��ܸ`�I���e
			System.out.print("[" + ptr.data + "]");
			// System.out.print(ptr.data + ",");
			strPreOrder += ptr.data + ",";

			preOrder(ptr.left); // ���l��
			preOrder(ptr.right); // �k�l��
		}
	}

	// ��k: �e�Ǩ��X��ܤG����
	public void printPreOrder() {
		preOrder(head); // �I�s�e�Ǩ��X��k
		
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
