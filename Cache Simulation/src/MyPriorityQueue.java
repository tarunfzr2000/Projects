// your implementation of PriorityQueue interface
// header comments here
// One additional requirement is the value type T must be Comparable.
// When two items are compared to determine the order in priority queue, follow the rules below:
//  1. use the priority of them to determine the order 
//  2. if they are of the same priority, use their values (of type T) to determine the order
//  3. if they are of the same priority and same value, any order is fine

class Node<T extends Comparable<T>>   //Nodes to store in the Priority Queue
{
	int p;//priority
	T v; //value
	Node(int p, T v)       // Constructor for the node to initialize priority and the value
	{
		this.p=p;
		this.v=v;
	}
	int compareTo(Node<T> node2)   // Overriding the function to compare Node's priority and value
	{
		 if(this.p > node2.p)    // comparing priority
	        return 1;
	     else if(this.p < node2.p)
	        return -1;
	     else // If priorities are same, check for values
	     {
	    	 return (this.v).compareTo(node2.v); //comparing value
	     }
	}
}

public class MyPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T>
{
	
	// you decide the internal design of your class:
	//  - it must implement the provided PriorityQueue interface
	//  - it cannot have any other public members (attributes or method) other than
	//    the public constructor and the methods defined in PriorityQueue interface

	private Node[] pq;    // priority queue as Heapified array
	private int size; // Number of elements at a particular time
	static final int INF = Integer.MAX_VALUE; // the max priority to use: infinity
	
    public MyPriorityQueue()
    {
    	pq = new Node[100]; //Let the initial capacity be 100 for now and we shall change it if required using doubling technique
        size = 0;  // Initial size is 0
    }
    
    public int size()
    {
    	return size;
    }
    
    public T peek()
    {
    	if(size == 0)
    		return null;
    	else
    		return (T)pq[0].v; // return the peek's value
    }

	public T remove()
	{
		if (size == 0) 
			return null;
        T remove_T= (T)pq[0].v;
        exchange(0, size-1);  //exchange the first and last element of array to (the ideal way to remove a node in Heap)
        pq[size-1] = null; // deleted the last element which earlier was the top element with highest priority
        size--;
        percolateDown(0);  // Now, percolate down the replaced element from last downwards in the heap
        return remove_T;
	}
	
	private void resize(int capacity)
	{
        Node[] copy = new Node[capacity];
        for(int i = 0; i < size; i++)
            copy[i] = pq[i];
        pq = copy;
    }
	
	private void exchange(int i, int j)
	{
		Node temp = pq[i];
	    pq[i] = pq[j];
	    pq[j] = temp;
    }

	
	private void percolateDown(int i)  // Heapifying the element at location i to fit in the heap correctly
	{
        int l,r,max,temp;
        l = LeftChild(i);
        r = RightChild(i);
        if(l!=-1 && (pq[l].compareTo(pq[i])>0))
        	max = l;
        else
        	max = i;
        if(r != -1 && (pq[r].compareTo(pq[max])>0))
        	max = r;
        if(max != i)
        {
        	exchange(i, max);
        }
	}
	
	private int LeftChild(int i)   // Get the position of left child of Node at i index
	{
		int left = 2*i + 1;
		if(left > (size-1))
			return -1;
		return left;
	}
	
	private int RightChild(int i)  //Get the position of right child of Node at i index
	{
		int right = 2*i + 2;
		if(right > (size-1))
			return -1;
		else
			return right;
	}
	
	public void insert(T v, int p)
	{
		if (size == pq.length) 
			resize(2*size);   // Using doubling technique to resize the array if it's fully occupied
		Node new_Node =new Node(p,v);  // Creating new instance of Node to insert as value v and priority p
		size++;
		int i = size-1;      // indexes are starting from 0 and size from 1, so the last index is always equal to size-1
		pq[i] = new_Node;      // Storing the new node in the end and then we percolate it up
		while(i >= 0 && ((i-1)/2)>=0)    //Percolating up to store the new node at the right position
		{
			if((pq[i].compareTo(pq[(i-1)/2])>0))
			{	
				exchange(i,(i-1)/2);
				i = (i-1)/2;
			}
			else
			{
				break;
			}
		}
	}
	
	public void updatePriority(T v, int p)
	{
		for(int i=0;i<size;i++)
		{
			if(pq[i].v == v)
			{
				pq[i].p = p;
			}
			else
			{
				if(pq[i].p <= p)
				{
					pq[i].p--;
				}
			}
		}
		buildHeap(pq, size);
	}
	
	void buildHeap(Node[] arr, int size)    //Correcting the heap when updated
	{
		for(int i = (size-1)/2; i>=0; i--)
		{
			percolateDown(i);
		}
	}
	
	
	public boolean contains(T v, int p)
	{
		boolean k = false;
		for(int i=0;i<size;i++)
		{
			if(pq[i].v == v && pq[i].p == p)
			{
				k = true;
				break;
			}
		}
		return k;
		
	}
	
	
	
    
	// make sure you implement all methods in PriorityQueue interface

	//------------------------------------
	// example test code... edit this as much as you want!
	// note: you might want to add a method like printPQ() for debugging purpose
	
	public static void main(String[] args)
	{
		MyPriorityQueue<String> pq = new MyPriorityQueue<String>();
		
		if(pq.size()==0 && pq.remove()==null && !pq.contains("a", 4)) 	
		{
			System.out.println("Yay 1");
		}

		pq.insert("a",4);
		pq.insert("b",10);
		pq.insert("h",2);

		
		
		if(pq.size()==3 && (pq.peek()).equals("b") && pq.contains("a", 4) && pq.contains("h", 2)
			&& pq.contains("b",10)) 
		{
			System.out.println("Yay 2");
		}

		if((pq.remove()).equals("b") && !pq.contains("b",10) & pq.size()==2 
			&& (pq.peek().equals("a")) ) {
			System.out.println("Yay 3");
		}

		pq.insert("d",4);
		if ((pq.peek()).equals("d")) {System.out.println("Yay 4");}
				
		pq.insert("b",10);
		pq.insert("f",3);
		pq.updatePriority("a",3);
		if (pq.size() == 5 && pq.contains("a",3) && pq.contains("b",10) && pq.contains("d",4) 
			&& pq.contains("f",2) && pq.contains("h",1)) {
			System.out.println("Yay 5");
		}


	}


}




