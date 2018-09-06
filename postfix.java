import java.util.Scanner;

public class postfix{

    public static boolean isOperand(char c){
    if(
      (c>='a' && c<='z') ||
      (c>='A' && c<='Z') ||
      (c>='0' && c<='9')){
        return true;
      }else{
        return false;
      }
  }

  public static boolean isOperator(char c){
    return c=='+' || c=='-' || c=='*' || c=='/';
  }

  public static int precedenceOrder(char c){
    if(c == '*' || c == '/' ){
      return 2;
    }else {
      return 1;
    }
  }

  //main
	public static void main(String [] args){

	  String backStack = "";
	  int backLength = 0;

	  CharStack opstack = new CharStack();
	  Scanner scan = new Scanner(System.in);

	  System.out.println("Please enter your infix expression: ");
	  String userIn = scan.nextLine();
	  int length = userIn.length();

	  for (int i = 0; i < length; i++){

	    char temp = userIn.charAt(i);

	    if (isOperand(temp)) //operand
	      System.out.print(temp);
	    else if (isOperator(temp){ //operator
	      if (opstack().isEmpty()) //if the stack is empty, push the operand to the stack
	      opstack.push(temp);
	      else{ //if the stack is not empty, pop the stack and write out signs with higher or equal precedence
	        while (!opstack.isEmpty()){
	          if (precedenceOrder(temp) == 2)
	            System.out.print(opstack.pop()); //higher precedence is written out
	          else if (precedenceOrder(temp) == 1){
	            opstack.pop(); //lower precedence is popped but not written out
	            backStack += opstack.pop(); //popped expressions added to string to be re-added to stack
	          }//else if
	        }//while
	        backLength = backStack.length();
	        for (int j = (backLength - 1);j > -1; j--){
	          opstack.push(backStack[j]); //push all operators that are lower precedence back to the stack
	        }//for
	        opstack.push(temp); //push temp to stack
	      }//else
	    }//else if
	     else if (temp == '(') //left parenthesis
	      opstack.push(temp);
	     else if (temp == ')'){//right parenthesis
        while (!opstack.isEmpty() && opstack.pop() != ')'){
          System.out.print(opstack.pop());
        }
	  }
  }//for

  while (!opstack.isEmpty()) //write out the remaining operators in opstack
    System.out.print(opstack.pop());

  }//main
}//class
