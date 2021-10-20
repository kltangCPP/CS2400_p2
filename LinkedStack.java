import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T> {
	private Node topNode; // references the first node in the chain
	
	public LinkedStack() {
		topNode = null;
	} // end default constructor
	
	public void push(T newEntry) {
		topNode= new Node(newEntry, topNode); 
	} // end push
	
	public T pop() {
		T top= peek();  // Might throw EmptyStackException
		// Assertion: topNode!= null
		topNode= topNode.getNextNode();
		
		return top;
	} // end pop
	
	public T peek() {
		if(isEmpty())
			throw new EmptyStackException();
		else
			return topNode.getData();
	} // end peek
	
	public boolean isEmpty(){
		return topNode== null;
	} // end isEmpty
	
	public void clear(){
		topNode= null;
	} // end clear
	
	private static int getPriority(char c) {
    	switch(c) {
        	case '(': return 0;
        	case '/': case '*': return 2;
        	case '+': case '-': return 1;
        	default: return 999;
    	} // end switch
	} // end getPriority

	public String convertToPostfix(String infix) {
		infix = infix + ")"; 

		LinkedStack<Character> operatorStack = new LinkedStack<Character>();

		operatorStack.push('(');

		String postfix = "";

		for(int i = 0; i < infix.length(); i++) {
			char nextCharacter = infix.charAt(i);

			if(Character.isLetter(nextCharacter)) {
				postfix = postfix + nextCharacter + " ";
			} else if(nextCharacter == '(') {
				operatorStack.push(nextCharacter);
			} else if (nextCharacter == ')') {
				while(operatorStack.peek() != '(') {
					postfix = postfix + operatorStack.peek() + " ";
					operatorStack.pop();
				} // end while
				operatorStack.pop();
			} else {
				int precedenceForNext = getPriority(nextCharacter);
				int precedenceForStack = getPriority(operatorStack.peek());

				while(precedenceForNext <= precedenceForStack) {
					postfix = postfix + operatorStack.peek() + " ";
					operatorStack.pop();
					precedenceForStack = getPriority(operatorStack.peek());

				} // end while
				operatorStack.push(nextCharacter);
			} // end else
		} // end for loop
		
		if(!operatorStack.isEmpty())
			System.out.println("Invalid expression");

		return postfix;
	} // end convertToPostfix
	
	private class Node {
		private T data; // entry in stack
		private Node next; // link to next node
		
		private Node (T dataPortion) {
			this(dataPortion, null);
		}
		
		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}
		
		private T getData() {
			return data;
		}
		
		private Node getNextNode() {
			return next;
		}
	} // end Node

	@Override
	public int evaluatePostfix(String postfix) {
		// TODO Auto-generated method stub
		return 0;
	}
} // end LinkedStack
