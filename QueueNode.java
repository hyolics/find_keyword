/*
 * # CH5_2_2
 * 使用鏈結串列建立佇列 
 */

class QueueNode {                       // 節點類別
	char data;             // 節點資料
    QueueNode next;       // 下一個結點
    
    public QueueNode(char data) {        // 建構子
    	this.data = data;
    	next = null;
    }// end of QueueNode
    
}//END