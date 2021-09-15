
public class WorkQueue {

	final static int LENGTH = 1000; // 取字串長度
	final static int TIMES = LENGTH / 2; // 次數
	// int TIMES = LENGTH / 3; // 次數
	static String randomStr = ""; // 產出的隨機字串
	static String cutStr = "";
	QueueList qList1 = new QueueList(); // 建立佇列物件

	String[] tenStr = new String[LENGTH]; // 記錄等長字串
	int countCut = 0; // 每十個的計數器

	int index = 0;
	String[] keyword = { "Add", "Edit", "Error" };
	// int[] count = new int[keyword.length];
	

	public void getKeyWord() {
		// 二元樹的節點資料
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

		// 建立二元樹物件
		BTree_PreOrder objBT = new BTree_PreOrder(data);
		System.out.println("前序走訪的節點內容 : ");
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
		char[] input = new char[cutStr.length()]; // 記錄欲輸入的字元

		// 逐一字元存入佇列
		for (int i = 0; i < cutStr.length(); i++) {
			input[i] = cutStr.charAt(i);
			qList1.enqueue(input[i]);
			// System.out.println(i + ".) " + input[i]);
		} // end of for

	}// putString()

	public void takeString() {
		char[] output = new char[LENGTH]; // 記錄輸出的字元
		int numOfOutput = 0; // 輸出字元陣列的索引

		// 直到佇列為空
		while (!qList1.isQueueEmpty()) {
			countCut++;
			// System.out.println("after: " + countCut);
			String tmpGet = ""; // 每十個暫存
			for (int i = 0; i < 10; i++) {
				// 逐一取出，暫存
				char tmpDeq = qList1.dequeue();
				// System.out.println("取出元素 [" + i + "]： " + tmpDeq);
				output[numOfOutput++] = tmpDeq; // 存進記錄輸出的陣列

				tmpGet += tmpDeq;
				// System.out.println("tmpGet:" + tmpGet);

				tenStr[countCut] = tmpGet;
				// System.out.println("tenStr[countCut]:" + tenStr[countCut]);
			} // end of for
			System.out.println();
		} // end of while
		System.out.println();

		int countSp = 0;
		System.out.println("印出等長 Get: ");
		for (int i = 1; i <= countCut; i++) {
			System.out.println("[" + i + "]\t: " + tenStr[i]);

		} // end of for

		System.out.println("countSp: " + countSp);
		System.out.println();

		System.out.print("\n取出佇列的元素 Total： ");
		for (int i = 0; i < numOfOutput; i++) {
			System.out.print(output[i]);
		} // end of for
		System.out.println();

	}// takeString()


	public void countEach() {
		System.out.println("佇列取出計數: ");
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
