import java.util.function.Function;

public class List<T> extends OurList<T>  {
    public Node head = null;
    public int anzhalelemente =0;
    @Override
    public void insert(T ele) {
        Node node = new Node<T>(ele);
        node.next=this.head;
        this.head=node;
        anzhalelemente++;
    }

    @Override
    public void insert(T ele, int pos) {
        Node currentNode = head;

        if((pos <= 0) || (head == null)){
            insert(ele);
            return;
        }

        int idx = 1;
        Node ptr = head;
        Node temp = new Node<T>(ele);
        while((ptr.next != null) && ( idx < pos)){
            ptr=ptr.next;
            idx+=1;
        }

        temp.next= ptr.next;
        ptr.next=temp;
        this.anzhalelemente++;

        //  if(pos==anzhalelemente){
        //     for(int i = 0; i<anzhalelemente-1; i++){
        //         currentNode = currentNode.next;
        //     }
        //     Node node = new Node<T>(ele);
        //     node.next=null;
        //     currentNode.next=node;
        //     this.anzhalelemente++;
        //      return;
        // }
        // if(pos<anzhalelemente){
        //     for(int i = 0; i<pos-1; i++){
        //         currentNode = currentNode.next;
        //     }
        //     Node node = new Node<T>(ele);
        //     node.next=currentNode.next;
        //     currentNode.next=node;
        //     this.anzhalelemente++;
        // } else{
        //     System.out.println("IndexOutOfBoundsException");
        // }
    }

    @Override
    public Boolean delete(Function<T, Boolean> func) {
        
        if(func.apply((T)head.getData())){
            this.head= this.head.next;
            this.anzhalelemente--;
        }

        Node previous = this.head;
        Node currentNode = this.head.next;
        boolean deleted= false;

        while(currentNode != null){
            if(func.apply((T) currentNode.getData())){
                previous.next = currentNode.next;
                this.anzhalelemente--;
                deleted=true;
            }
            previous = currentNode;
            currentNode = currentNode.next;
        }
        return deleted;
    }

    @Override
    public String toString() {
        Node currentNode = this.head;
        String res = "";
        while(currentNode != null){
                res = res +"<"+currentNode.getData() +">";
                currentNode = currentNode.next;
        }
        return res;
    }

    class Node<T> {
        private T data;
        public Node<T> next;

        public Node(T data){
            this.data=data;
        }

        public T getData(){
            return this.data;
        }

        public void setData(T data){
            this.data=data;
        }
    }
    
}
