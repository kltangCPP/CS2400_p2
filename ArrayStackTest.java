public class ArrayStackTest
{
    public static void main(String[] args)
    {
        ResizeableArrayStack<Integer> stack = new ResizeableArrayStack<Integer>();

        System.out.println("Postfix expression: ab*ca-/de*+ \nEvaluate postfix: " + stack.evaluatePostfix("ab*ca-/de*+"));
    }
}