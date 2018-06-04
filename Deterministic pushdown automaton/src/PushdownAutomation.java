import java.util.*;
public class PushdownAutomation 
{
	public static void main(String args[])
	{
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		String alphabets= s.next();
		int l= alphabets.length();
		char letters[]= new char[l];
		for(int i=0;i<l;i++)
		{
			letters[i]= alphabets.charAt(i);
		}
		HashMap<StateCondition, StateResult> table=new HashMap<>();  // to map the transition function
		while(true)
		{
			int currentState = s.nextInt();
			if(currentState == -1)   //End of transition function entries
				break;
			String rest= s.nextLine(); // rest of the String after the 1st integer of the entry
			char alphabet = rest.charAt(1);
			char finalState = rest.charAt(3);
			int nextState = Character.getNumericValue(rest.charAt(5));
			String value = rest.substring(7);
			StateCondition sc = new StateCondition(currentState, alphabet, finalState);
			StateResult sr = new StateResult(nextState, value);
			table.put(sc, sr);   // Mapping the transitions
		}	
		List<Integer> finalStateList = new LinkedList<>();  // to store the final states
		while(true)
		{
			int finalState = s.nextInt();
			if(finalState == -1)
				break;
			else
				finalStateList.add(finalState);
		}
		int currentStatus = 0;
		Stack<Character> stack = new Stack<>();
		stack.push('$');
		while(true)  // Loop to take input till till user stops giving input
		{
			System.out.print("Current status "+ currentStatus +":"+ stack +",  "+"Enter input:");
			String user_input = s.next();
			if(user_input.equals("."))  //to signify the end of input
			{
				break;
			}
			char input = user_input.charAt(0);
			int currentState = currentStatus;
			char alphabet = input;
			char finalState = stack.peek();
			StateCondition sc = new StateCondition(currentState, alphabet, finalState);
			boolean flag = false;
			StateCondition keyForState=null;
			for (StateCondition key : table.keySet()) 
			{
				if(key.equals(sc))     // If there any key exits for this type of transition
			    {
			    	flag = true;
			    	keyForState = key;
			    	break;
			    }
			}
			if(flag == false)
			{
				break; 
			}
			else
			{
				StateResult valueForState = table.get(keyForState);
				if(valueForState.value.equals("."))
				{
					stack.pop();
					currentStatus = valueForState.nextState;
				}
				else
				{
					stack.push(valueForState.value.charAt(0));	
					currentStatus = valueForState.nextState;
				}
			}	
		}
		if(stack.peek() == '$' && stack.size() == 1)   //At the initial state
		{
			if(finalStateList.contains(currentStatus))   // Final state validation
				System.out.println("String accepted");
			else
				System.out.println("String not accepted");
		}
		else
		{
			System.out.println("String not accpeted");
		}
	}

}
