import java.util.Arrays;
import java.util.EmptyStackException;

/** A class of stacks whose entries are stored in an array.*/
public final class ResizeableArrayStack<T> implements StackInterface<T> {
	private T[] stack;    // Array of stack entries
	private int topIndex; // Index of top entry
	private static final int DEFAULT_CAPACITY = 50;
	
	public ResizeableArrayStack() {
		this(DEFAULT_CAPACITY);
	} // end default constructor
	
	public ResizeableArrayStack (int initialCapacity) {	
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempStack= (T[])new Object[initialCapacity];
		stack = tempStack;
		topIndex= -1;
	} // end constructor
	
	public void push(T newEntry) {
		ensureCapacity();
		stack[topIndex+ 1] = newEntry;
		topIndex++;
	} // end push
	
	public T pop() {		
		if(isEmpty())
			throw new EmptyStackException();
		else{
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		} // end if
	} // end pop
	
	public T peek() {	
		if(isEmpty())
			throw new EmptyStackException();
		else 
			return stack[topIndex];
	} // end peek
	
	public boolean isEmpty() {
		return topIndex < 0;
	} // end isEmpty
	
	public void clear() {
		// Remove references to the objects in the stack,
		// but do not deallocate the array
		while(topIndex > -1){
			stack[topIndex] = null;
			topIndex--;
		} // end while//Assertion: topIndexis -1
	} // end clear
	
	private void ensureCapacity() {
		if(topIndex >= stack.length-1) { // If array is full, double its size
			int newLength= 2* stack.length;
			stack = Arrays.copyOf(stack, newLength);
			} // end if
	} // end ensureCapacity
	
	private static int mathEvaluate(char op, int a, int b) {
    	int result = -1;
    	
        if (op == '+') // if operator is addition
        	return a + b;
        else if (op == '-') // if operator is subtraction
        	return a - b;
        else if (op == '*') // if operator is multiplication
        	return a * b;
        else if (op == '/') // if operator is division
        	return a / b;
        else if (op == '^') // if operator is power
        	return (int) Math.pow(a, b);
        
        return result;
	} // end mathEvaluate
	
	public int evaluatePostfix(String postfix) {
		ResizeableArrayStack<Integer> valueStack = new ResizeableArrayStack<Integer>(postfix.length());

	    int i = 0;
	    while (i < postfix.length()) {
	    	char nextCharacter = postfix.charAt(i); // checks at each character of postfix
	    	
	    	switch (nextCharacter) {
	        	case 'a' :
	            	valueStack.push(2); // a = 2
	                break;
	            case 'b' :
	                valueStack.push(3); // b = 3
	                break;
	            case 'c' :
	                valueStack.push(4); // c = 4
	                break;
	            case 'd' :
	                valueStack.push(5); // d = 5
	                break;
	            case 'e' :
	                valueStack.push(6); // e = 6
	                break;
	            case '+' : case '-' : case '*' : case '/' : case '^' :
	                int operandTwo = (int)valueStack.pop();
	                int operandOne = (int)valueStack.pop();
	                int result = mathEvaluate(nextCharacter, operandOne, operandTwo);
	                valueStack.push(result);
	                break;
	            default: break; //Ignore unexpected characters
	        } // end switch
	        i++; // continues loop if postfix has more characters
		} // end while
	      return valueStack.peek();
	} // end ensureCapacity

	@Override
	public String convertToPostfix(String infix) {
		// TODO Auto-generated method stub
		return null;
	}
	
} // end ArrayStack