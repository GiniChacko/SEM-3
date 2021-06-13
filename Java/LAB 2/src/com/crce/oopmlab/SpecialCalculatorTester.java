/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab;

import static java.lang.System.exit;
import java.util.Scanner;

/**
 * Special calculator tester class
 * @author Gini Chacko
 *
 */
public class SpecialCalculatorTester
{
            
    public static void main(String[] args)
    {
      SpecialCalculator s = new SpecialCalculator();
      Scanner scan = new Scanner(System.in); 
      System.out.println("----------------------------------------------------------------------------------------------------");
      System.out.println(" Enter your choice : \n 1. Factorial of a number\n 2. Power\n 3. Fibonacci Series\n 4. Palindrome \n 5. ArmStrong Number \n 6. Prime Number\n 7. Exit");
      System.out.println("----------------------------------------------------------------------------------------------------");
      int choice = scan.nextInt();
      do
      {
        switch(choice)
        {
            case 1:
                Scanner s1 = new Scanner(System.in);
                System.out.println(" Enter a no. : ");
                int n = s1.nextInt();
                System.out.println(" The factorial of " + n + " is " + s.factorial(n) + "\n");
                System.out.println("----------------------------------------------------------------------------------------------------");
                break;

            case 2:
                Scanner s2 = new Scanner(System.in);
                System.out.println(" Enter a no. : ");
                int base = s2.nextInt();
                System.out.println(" Enter its exponent : ");
                int exponent = s2.nextInt();
                System.out.println(" The value of " + base + "^" + exponent + " is " + s.power(base, exponent) + "\n");
                System.out.println("----------------------------------------------------------------------------------------------------");
                break;               
                
            case 3:
                s.fibonacciSeries();
                System.out.println("----------------------------------------------------------------------------------------------------");
                break;
                
            case 4:
                Scanner s3 = new Scanner(System.in);
                System.out.println(" Enter a no. : ");
                int no = s3.nextInt();
      
                int temp = s.palindrome(no, 0); 
    
                if (temp == no) 
                    System.out.println( no+" is a palindrome\n"); 
                else
                    System.out.println( no+" is not a palindrome\n");
                System.out.println("----------------------------------------------------------------------------------------------------");
                break;
            
            case 5:
                Scanner s4 = new Scanner(System.in);
                System.out.println(" Enter a no. : ");
                int nos = s4.nextInt();
                s.isArmstrong(nos);
                System.out.println("----------------------------------------------------------------------------------------------------");
                break;
                
            case 6:
                Scanner s5 = new Scanner(System.in);
                System.out.println(" Enter a no. : ");
                int no1 = s5.nextInt();               
                s.isPrimeNo(no1);
                System.out.println("----------------------------------------------------------------------------------------------------");
                break;
                
            case 7:
                exit(0);
              
        }
        
        System.out.println(" Enter your choice : ");
        choice = scan.nextInt();
      }while(true);
    }
    
    
}
