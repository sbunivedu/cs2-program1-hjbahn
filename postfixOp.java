
import java.util.Scanner;

public class postfixOp{

  public static void main (String [] args){
    CharStack opstack = new CharStack();
    Scanner scan = new Scanner(System.in);

    System.out.println("Please input your infix expression: ");
    String userIn = scan.nextLine();
    String operators = "";
    char backStack;

    int length = userIn.length();

    for (int i = 0; i < length; i ++){

      char temp = userIn.charAt(i);

      if ((((temp != '*') && (temp != '-')) && ((temp != '/') && (temp != '+'))) && ((temp != '(') && (temp != ')')))
        System.out.print(temp);

      if (temp == '(')
        opstack.push(temp);

      if (temp == ')'){
        while (opstack.peek() != '(')
          System.out.print(opstack.pop());
        opstack.pop();

      }

      if (((temp == '*') || (temp == '-')) || ((temp == '/') || (temp == '+'))){

        while (!opstack.isEmpty()){
          if (temp == '+' || temp == '-')
            System.out.print(opstack.pop());
          if ((temp == '*') || (temp == '/')){
            if (opstack.peek() == '*' || opstack.peek() == '/')
              System.out.print(opstack.pop());
            else
              operators += opstack.pop();
          }
        }//while

        int opLength = operators.length();

        for (int j = 0; j < opLength; j++){
          backStack = operators.charAt((opLength - 1) - j);
          opstack.push(backStack);
        }
      operators = "";

      }
      }//for

      while (opstack.isEmpty() == false)
        System.out.print(opstack.pop());


  }//main
}//class
