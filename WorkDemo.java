
public class WorkDemo {
    public static void main(String[] args) {
    	WorkQueue wq1 = new WorkQueue();
    	
    	System.out.println("\n---[2016-12-22]_KeyWord---\n");
    	wq1.getKeyWord();
    	
    	System.out.println("\n\n\n");
    	System.out.println("\n1. �����H���r��]getRandomString�^---");
    	wq1.getRandomString();
    	System.out.println("\n2. �����׫e 1000 ���r��---------------");
    	wq1.getCutString();
    	System.out.println("\n3. ��i��C--------------------------");
		wq1.putString();
		System.out.println("\n4. �q��C���X�����r���]10 �ӡ^---------");
		wq1.takeString();
		/*
		System.out.println("\n5. �p���r�X�{����-------------------");
		wq1.countTotal();
		*/
		System.out.println("\n5. �v�����ơ]���~�^-------------------");
		wq1.countEach();
				
//		wq1.countSp();
	}//MAIN
}//END
