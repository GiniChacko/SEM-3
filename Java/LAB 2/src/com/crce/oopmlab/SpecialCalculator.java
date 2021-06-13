/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab;

import static java.lang.System.exit;
import java.util.Scanner;

/**
 * Special calculator class
 * @author Gini Chacko
 *
 */
public class SpecialCalculator
{
    /**
     * 1.Method to find Factorial of a number
     * @param n
     * @return 
     */
    public int factorial(int n)
    {
        if (n == 0) 
            return 1; 
        else  
            return n*factorial(n-1); 
    }
    
    /**
     * 2.Method to find Power(base,exponent)
     * @param base
     * @param exponent
     * @return
     */
    public int power(int base,int exponent)
    {
        if(exponent!=0)
            return (base*power(base,exponent-1));
        else
            return 1;
    }
    
    /**
     * 3.Method to print fibonacci Series 
     */
    public void fibonacciSeries()
    {
        int n, first = 0,next = 1;
        System.out.println("Enter how may fibonnaci numbers to print");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        System.out.print("The first " + n + " Fibonacci numbers are: \n");
        System.out.print(first + " " + next + "\n");
        int i = 1;
        while (i<n-1)
        {
            int sum = first + next;
            first = next;
            next = sum;
            System.out.print(" " + sum);
            i++;
        }  
    }
    
    /**
     * 4.Method to check Number is palindrome or not
     * @param n
     * @param temp
     * @return palidrome
     */
    public int palindrome(int n,int temp)
    {
        // stores the reverse of a number 
        temp = (temp * 10) + (n % 10); 
        if(n==0)
            return temp;
        else
            return palindrome(n / 10, temp); 
        
        
    }
     
    /**
     * Function to calculate order of the number
     * @param x
     * @return n
     */
    int order(int x) 
    { 
        int n = 0; 
        while(x!=0) 
        { 
            n++; 
            x = x / 10; 
        } 
        return n; 
    } 
    
    /**
     * 5.Method to check Number is  ArmStrong Number or not
     * @param x
     */
    public void isArmstrong(int x) 
    { 
        int n = order(x); 
        int temp = x, sum = 0; 
        while (temp!=0) 
        { 
            int r = temp % 10; 
            //sum += power(r, n);
            sum += Math.pow(r, n);//r is the base and n is the exponent
            temp = temp / 10; 
        }   
        // If satisfies Armstrong condition 
        if (sum == x) 
            System.out.println( x + " is an Armstrong Number\n"); 
        else
            System.out.println( x + " is not an Armstrong Number\n");  
    }
    
    /**
     * 6.method to check Number is Prime Number or not.
     * @param num
     */
    public void isPrimeNo(int num)
    {
        boolean flag =false;
        for (int i = 2; i <= num / 2; i++)
        {
            // condition for nonprime number
            if (num % i == 0) 
            {
                flag = true;
                break;
            }
        }

    if (!flag)
      System.out.println( num + " is a prime number.");
    else
      System.out.println( num + " is not a prime number.");
  }

}
