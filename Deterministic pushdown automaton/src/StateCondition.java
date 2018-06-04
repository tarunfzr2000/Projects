public class StateCondition 
{
	int currentState;
	char alphabet;
	char finalState;
	public StateCondition(int currentState, char alphabet, char finalState)
	{
		this.currentState = currentState;
		this.alphabet = alphabet;
		this.finalState = finalState;
	}
	public boolean equals(StateCondition stateCondition2)
	{
		if(stateCondition2.currentState == currentState)
		{
			if(stateCondition2.alphabet == alphabet)
			{
				if(stateCondition2.finalState == finalState)
					return true;
				else
					return false;
			}
			else
				return false;
		}
		else
			return false;
	}
}
