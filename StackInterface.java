/**An interface for the ADT stack.*/
public interface StackInterface<T> {
	/** Adds a new entry to the top of this stack.
	 * @paramnewEntryAn object to be added to the stack. */
	public void push(T newEntry);
	
	/** Removes and returns this stack's top entry.
	 * @returnThe object at the top of the stack. 
	 * @throwsEmptyStackExceptionif the stack is empty before the operation. */
	public T pop();
	
	/** Retrieves this stack's top entry.
	 * @returnThe object at the top of the stack.
	 * @throwsEmptyStackExceptionif the stack is empty. */
	public T peek();
	
	/** Detects whether this stack is empty.
	@returnTrue if the stack is empty. */
	public boolean isEmpty();
	
	/** Removes all entries from this stack. */
	public void clear();
	
	public String convertToPostfix(String infix);
	
	public int evaluatePostfix(String postfix);
} // end StackInterface
 
