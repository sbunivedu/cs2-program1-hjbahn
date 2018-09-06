public class CharStack
{
  private final int MAX_CAP = 100;
  private int top; //location of top item on the stack
  private char [] s; //The stack

  public CharStack(){
    //PRE:
    //POS:
    //TAS: Create an empty stack with a default capacity
    s = new char[MAX_CAP];
    top = -1;
  }

  public void push(char element){
    //PRE:the stack is not full
    //POS:the stack increases by one
    //TAS: Add a new item to the stack
    top ++;
    s[top] = element;
  }

  public char pop (){
    //PRE:the stack is not empty
    //POS:the stack is reduced by one
    //TAS: remove and return the item on the top of the stack
    return s[top--];
  }

  public boolean isEmpty(){
    //PRE:
    //POS:
    //TAS: Return whether or not the stack is empty. HINT: look
    //     at the constructor.
    return top == -1;
  }

  public boolean isFull(){
    //PRE:
    //POS:
    //TAS: return whether or not the stack is full
    return top == MAX_CAP-1;
  }
  public char peek(){
  //PRE: stack is not empty
  //POS: none
  //TAS:Return the char in the top of the stack
  return s[top];
}
  public String toString(){
  //PRE:
  //POS:
  //TAS:

  String temp = "";
	for (int i = top; i != -1; i--){
  temp += s[i];
	}//end for
	return temp;
}
}//constructor
