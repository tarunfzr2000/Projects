// your implementation of Sequence interface
// header comments here
import java.util.TreeSet;
public class MySequence<T extends Comparable<T>> implements Sequence<T>
{

	// you decide the internal design of your class:
	//  - it must implement the provided Sequence interface
	//  - it cannot have any other public members (attributes or method) other than
	//    the public constructor and the methods defined in Sequence interface
	private TreeSet<T> seq;
	
	public MySequence()
	{
		seq = new TreeSet<>();
	}
	
	public boolean insert (T v)
	{
		if(seq.contains(v))
			return false;
		else
		{	
			seq.add(v);
			return true;
		}
	}
	
	public boolean remove (T v)
	{
		if(seq.contains(v))
		{
			seq.remove(v);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean contains (T v)
	{
		if(seq.contains(v))
			return true;
		else
			return false;
	}
	
	public int countNoSmallerThan (T v)
	{
		int count = 0;
		for(T index: seq)
		{
			if(index.compareTo(v) >= 0 )
			{
				count++;
			}
		}
		return count;
	}
	
	public int size()
	{
		return seq.size();
	}
	
	public String toStringAscendingOrder()
	{
		String string="";
		for(T index: seq)
		{
			string = string + index + " ";
		}
		return string;
	}
	
	// make sure you implement all methods in Sequence interface


	//------------------------------------
	// example test code... edit this as much as you want!
	public static void main(String[] args)
	{
		MySequence<Integer> seq = new MySequence<Integer>();
		System.out.println(seq.size()==0);
		System.out.println(!seq.contains(11));
		System.out.println(seq.countNoSmallerThan(10) == 0);
		System.out.println(seq.toStringAscendingOrder());
		
		if(seq.size()==0 && !seq.contains(11) && seq.countNoSmallerThan(10) == 0 
			&& seq.toStringAscendingOrder().equals("")) 	{
			System.out.println("Yay 1");
		}
		
		seq.insert(11);
		seq.insert(5);
		
		if(seq.insert(200) && seq.size()==3 && seq.contains(11) 
			&& seq.countNoSmallerThan(10) == 2 && !seq.remove(20)) 	{
			System.out.println("Yay 2");
		}
		
		seq.insert(112);
		seq.insert(50);
		seq.insert(20);
		
		if(seq.remove(20) && !seq.contains(20) && !seq.insert(200)
			&& seq.countNoSmallerThan(50) == 3 
			&& seq.toStringAscendingOrder().equals("5 11 50 112 200 ")) 	{
			System.out.println("Yay 3");
		}
		System.out.println(seq.toStringAscendingOrder());

	}
}


