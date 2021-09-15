/*
 * # CH5_2_2
 * �ϥ��쵲��C�إߦ�C 
 */
public class QueueList {     
    private QueueNode front;    // �e�ݡA���V��C���Ĥ@�Ӹ`�I
    private QueueNode rear;     // ����
    
    public QueueList() {                    // �غc�l�A��l�Ȭ���
    	front = null;
    	rear = null;
    }// end of QueueList
    
    // �s�J��C��ơA�N�`�I���J������C���̫�@�Ӹ`�I
    public boolean enqueue(char data) {        
    	// Step1�G�إ߸`�I����A�s�J��C��ơF
    	QueueNode newNode = new QueueNode(data);    
    	
    	// Step2�G�ˬd��C�O�_���š]rear == null�^�A��ܬO�Ĥ@���s�J��� �F
    	if ( rear == null ) {                       
    		// Step2-1�G�p�G��C���šA���J��Ʀ����Ĥ@�Ӹ`�I�A�N�e�ݫ��Ы��V�s�`�I�F
    		front = newNode;    		            
    	} else {                                  
    		// Step2-2�G�p�G��C�����šA���J��Ʀ����̫�@�Ӹ`�I�A�N���ݫ��Щҫ��`�I�� next ���Ы��V�s�`�I�C
    		rear.next = newNode;    		        
    	} // end of if-else
    	// Step3�G�N���ݫ��Ы��V�s�`�I�C
    	rear = newNode;                             
    	return true;
    }// end of enqueue
    
    // ���X��C��ơA�R����C���Ĥ@�Ӹ`�I
    public char dequeue() {                   
    	char d;
    	
//    	if ( ! isQueueEmpty() ) {              // �p�G��C���O�Ū�
    		// Step1�G�p�G�e�� == ��ݫ��СA��ܥu�Ѥ@�Ӹ`�I�A�N���ݳ]���šF
    		if (front == rear) {               
    			rear = null;                   
    		}
    		
    		d = front.data;                    // ���o��C���
    		
    		// Step2�G�N��C���e�ݫ��Ы��V�U�@�Ӹ`�I�F
    		front = front.next;                // �R���Ĥ@�Ӹ`�I
    		// Step3�G���X�Ĥ@�Ӹ`�I���e�A�Ǧ^�`�I��ơC
    		return d;                              	
//    	} // end of if-else
    	
    }// end of dequeue
    
    // �ˬd��C�O�_�O�Ū�
    public boolean isQueueEmpty() { return front == null; }
    
}//END