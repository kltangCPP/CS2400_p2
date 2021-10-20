public class LinkedStackTest
{   
    public static void main(String[] args)
    {
        LinkedStack<String> stack = new LinkedStack<String>();

        System.out.println ("Infix expression: a*b/(c-a)+d*e \nPostfix expression: " + stack.convertToPostfix("a*b/(c-a)+d*e"));
    }
}
