/*
 * # CH5_2_2
 * 使用鏈結串列建立佇列 
 */
public class QueueList {     
    private QueueNode front;    // 前端，指向串列的第一個節點
    private QueueNode rear;     // 尾端
    
    public QueueList() {                    // 建構子，初始值為空
    	front = null;
    	rear = null;
    }// end of QueueList
    
    // 存入佇列資料，將節點插入成為串列的最後一個節點
    public boolean enqueue(char data) {        
    	// Step1：建立節點物件，存入佇列資料；
    	QueueNode newNode = new QueueNode(data);    
    	
    	// Step2：檢查佇列是否為空（rear == null），表示是第一次存入資料 ；
    	if ( rear == null ) {                       
    		// Step2-1：如果佇列為空，插入資料成為第一個節點，將前端指標指向新節點；
    		front = newNode;    		            
    	} else {                                  
    		// Step2-2：如果佇列不為空，插入資料成為最後一個節點，將尾端指標所指節點的 next 指標指向新節點。
    		rear.next = newNode;    		        
    	} // end of if-else
    	// Step3：將尾端指標指向新節點。
    	rear = newNode;                             
    	return true;
    }// end of enqueue
    
    // 取出佇列資料，刪除串列的第一個節點
    public char dequeue() {                   
    	char d;
    	
//    	if ( ! isQueueEmpty() ) {              // 如果佇列不是空的
    		// Step1：如果前端 == 後端指標，表示只剩一個節點，將尾端設為空；
    		if (front == rear) {               
    			rear = null;                   
    		}
    		
    		d = front.data;                    // 取得佇列資料
    		
    		// Step2：將佇列的前端指標指向下一個節點；
    		front = front.next;                // 刪除第一個節點
    		// Step3：取出第一個節點內容，傳回節點資料。
    		return d;                              	
//    	} // end of if-else
    	
    }// end of dequeue
    
    // 檢查佇列是否是空的
    public boolean isQueueEmpty() { return front == null; }
    
}//END