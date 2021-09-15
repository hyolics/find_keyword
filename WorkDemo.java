
public class WorkDemo {
    public static void main(String[] args) {
    	WorkQueue wq1 = new WorkQueue();
    	
    	System.out.println("\n---[2016-12-22]_KeyWord---\n");
    	wq1.getKeyWord();
    	
    	System.out.println("\n\n\n");
    	System.out.println("\n1. 產生隨機字串（getRandomString）---");
    	wq1.getRandomString();
    	System.out.println("\n2. 取長度前 1000 的字數---------------");
    	wq1.getCutString();
    	System.out.println("\n3. 放進佇列--------------------------");
		wq1.putString();
		System.out.println("\n4. 從佇列取出等長字元（10 個）---------");
		wq1.takeString();
		/*
		System.out.println("\n5. 計算單字出現次數-------------------");
		wq1.countTotal();
		*/
		System.out.println("\n5. 逐項次數（有誤）-------------------");
		wq1.countEach();
				
//		wq1.countSp();
	}//MAIN
}//END
