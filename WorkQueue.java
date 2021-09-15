
public class WorkQueue {

	final static int LENGTH = 1000; // ���r�����
	final static int TIMES = LENGTH / 2; // ����
	// int TIMES = LENGTH / 3; // ����
	static String randomStr = ""; // ���X���H���r��
	static String cutStr = "";
	QueueList qList1 = new QueueList(); // �إߦ�C����

	String[] tenStr = new String[LENGTH]; // �O�������r��
	int countCut = 0; // �C�Q�Ӫ��p�ƾ�

	int index = 0;
	String[] keyword = { "Add", "Edit", "Error" };
	// int[] count = new int[keyword.length];
	

	public void getKeyWord() {
		// �G���𪺸`�I���
		int[] data = { 0, 5, 4, 10, 3, 9, 11, 2, 8, 12, 1, 7, 13, 6, 14, 15 };
		char[] dataChar = { '0', '#', 'd', 'd', 'A', '#', '#', 't', 'i', 'd', 'E', 'r', 'r', 'o', 'r', '#' };

		System.out.println("dataKey: ");
		for (int i = 1; i < data.length; i++) {
			System.out.print("[" + data[i] + "]");
		}
		System.out.println("\n\n Ori dataKey: ");
		for (int i = 1; i < dataChar.length; i++) {
			System.out.print("[" + i + "]");
		}
		System.out.println("");
		for (int i = 1; i < dataChar.length; i++) {
			int tmp = data[i];
			System.out.print("[" + dataChar[tmp] + "]");
		}
		System.out.println("\n\n");

		// �إߤG���𪫥�
		BTree_PreOrder objBT = new BTree_PreOrder(data);
		System.out.println("�e�Ǩ��X���`�I���e : ");
		objBT.printPreOrder();

		int[] numsToInt = new int[objBT.numstrPreOrder.length];
		// System.out.println("\n numsToInt");
		for (int i = 0; i < objBT.numstrPreOrder.length; i++) {
			// System.out.print(objBT.numsPreOrder[i] + " ");
			numsToInt[i] = Integer.parseInt(objBT.numstrPreOrder[i]);
		}
		System.out.println("\n");
		
		/*
		System.out.println("\n  numsToInt ");
		for (int i = 0; i < numsToInt.length; i++) {
			System.out.print(numsToInt[i] + " ");
		}
		System.out.println("\n");	
		*/	

		System.out.println("\n PreOrder Result :");
		String resultTree = "";
		for (int i = 1; i < dataChar.length; i++) {
			int tmp = numsToInt[i];
			System.out.print(dataChar[tmp]);
			resultTree += dataChar[tmp];
		}

		// System.out.println("\nfin: " + resultTree);
		System.out.println("\n");

		String[] keyWord;
		String reStr = "";
		reStr = resultTree.replace("#r", "#Er");
		keyWord = reStr.split("#");

		System.out.println("\n String[] KeyWord : ");
		for (int i = 0; i < keyWord.length; i++) {
			System.out.print(keyWord[i] + " ");
		}
		
		//keyWordLen = keyWord.length;
		//System.out.println("keyWordLen : " + keyWordLen);
	}

	public void getRandomString() {
		String[] seeds = { "Add", "Edit", "Error", "*" };

		for (int i = 0; i < TIMES; i++) {
			randomStr += seeds[(int) (Math.random() * seeds.length)];
		}
		System.out.println("StringLength: " + randomStr.length());
		System.out.println(randomStr);
	}// getRandomString()

	public void getCutString() {
		cutStr = WorkQueue.randomStr.substring(0, LENGTH);
		System.out.println("StringLength: " + cutStr.length());
		System.out.println(cutStr);
	}// getCutString()

	public void putString() {
		char[] input = new char[cutStr.length()]; // �O������J���r��

		// �v�@�r���s�J��C
		for (int i = 0; i < cutStr.length(); i++) {
			input[i] = cutStr.charAt(i);
			qList1.enqueue(input[i]);
			// System.out.println(i + ".) " + input[i]);
		} // end of for

	}// putString()

	public void takeString() {
		char[] output = new char[LENGTH]; // �O����X���r��
		int numOfOutput = 0; // ��X�r���}�C������

		// �����C����
		while (!qList1.isQueueEmpty()) {
			countCut++;
			// System.out.println("after: " + countCut);
			String tmpGet = ""; // �C�Q�ӼȦs
			for (int i = 0; i < 10; i++) {
				// �v�@���X�A�Ȧs
				char tmpDeq = qList1.dequeue();
				// System.out.println("���X���� [" + i + "]�G " + tmpDeq);
				output[numOfOutput++] = tmpDeq; // �s�i�O����X���}�C

				tmpGet += tmpDeq;
				// System.out.println("tmpGet:" + tmpGet);

				tenStr[countCut] = tmpGet;
				// System.out.println("tenStr[countCut]:" + tenStr[countCut]);
			} // end of for
			System.out.println();
		} // end of while
		System.out.println();

		int countSp = 0;
		System.out.println("�L�X���� Get: ");
		for (int i = 1; i <= countCut; i++) {
			System.out.println("[" + i + "]\t: " + tenStr[i]);

		} // end of for

		System.out.println("countSp: " + countSp);
		System.out.println();

		System.out.print("\n���X��C������ Total�G ");
		for (int i = 0; i < numOfOutput; i++) {
			System.out.print(output[i]);
		} // end of for
		System.out.println();

	}// takeString()


	public void countEach() {
		System.out.println("��C���X�p��: ");
		int[] count1 = new int[keyword.length];
				
		for (int j = 1; j <= countCut; j++) {
			
			for(int i = 0; i < keyword.length; i++) {
				
				while((index =  tenStr[j].indexOf(keyword[i],index)) != -1){
					index = index + keyword[i].length();
					count1[i]++;
					//System.out.println("Index: " + index);
			    }// end of while			
//				System.out.println(keyword[i] + "\tCount : " + count1[i]);				
			}//end of for			
		} // end of for
				
		for(int i = 0; i < keyword.length; i++) {
			System.out.println(keyword[i] + "\t" + count1[i]);	
		}//end of for
		
	}//countEach()

}// END
