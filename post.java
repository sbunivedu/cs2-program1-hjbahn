import java.util.Scanner;

public class post{

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

public static void main(String [] args){

    CharStack opstack = new CharStack();
	  Scanner scan = new Scanner(System.in);

    String backstack = "";
    int backlength = 0;

	  System.out.println("Please enter your infix expression: ");
	  String userIn = scan.nextLine();
	  int length = userIn.length();

	  for (int i = 0; i < length; i++){

	    char temp = userIn.charAt(i);

	     if (isOperand(temp)) //operand
	      System.out.print(temp);

	     else if (isOperator(temp)){
	    	while (!opstack.isEmpty() && opstack.peek() != '(' && precedenceOrder(opstack.peek()) >= precedenceOrder(temp)){
    			System.out.print(opstack.pop());
					}
  				opstack.push(temp);
	     }//else if

	     else if (temp == '('){ //left parenthesis
	      opstack.push(temp);}
	     else if (temp == ')'){//right parenthesis
          while (!opstack.isEmpty() && opstack.peek() != '('){
            System.out.print(opstack.pop());
          }//while
          opstack.pop();
	      }//else if
	    }//for

	  while (!opstack.isEmpty()) //write out the remaining operators in opstack if they exist
    System.out.print(opstack.pop());
    System.out.println();

  }//main
}//class
