/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab;

import static java.lang.System.exit;
import java.util.Scanner;

/**
 * Array calculator tester class
 * @author Gini Chacko
 *
 */
public class ArrayCalculatorTester
{
            
    public static void main(String[] args)
    {
      ArrayCalculator a= new ArrayCalculator();
      Scanner s = new Scanner(System.in);
      System.out.println("----------------------------------------------------------------------------------------------------");
      System.out.println(" Enter the length of the array:");
      int length = s.nextInt();
      int [] arr = new int[length];
      System.out.println(" Enter the elements of the array:");

      for(int i=0; i<length; i++ )
      {
         arr[i] = s.nextInt();
         
      }
      
      Scanner scan = new Scanner(System.in); 
      System.out.println("----------------------------------------------------------------------------------------------------");
      System.out.println("                                                  MENU\n \n 1. Find Minimum element from array\n 2. Find Maximum element from array\n 3. Search element in array\n 4. Average of the array\n 5. Find Mode of elements in array\n 6. Find Median of elements in array\n 7. Search element in array using Binary search\n 8. Sorting array using Bubble Sort\n 9. Exit\n	");
      System.out.println("----------------------------------------------------------------------------------------------------");
      System.out.println(" Enter your choice : ");
      int choice = scan.nextInt();
      do
      {
        switch(choice)
        {
            case 1:
                a.minArray(arr);
                System.out.println("----------------------------------------------------------------------------------------------------");
                break;

            case 2:
                a.maxArray(arr);
                System.out.println("----------------------------------------------------------------------------------------------------");
                break;
                
            case 3:
                Scanner s1 = new Scanner(System.in);
                System.out.println(" Enter the element to search : ");
                int n = s1.nextInt();
                a.searchElement(arr, n);
                System.out.println("----------------------------------------------------------------------------------------------------");
                break;
                
            case 4:
                a.averageOfAnArrayElements(arr);
                System.out.println("----------------------------------------------------------------------------------------------------");
                break;
                
            case 5:
                a.modeOfArrayElements(arr);
                System.out.println("----------------------------------------------------------------------------------------------------");
                break;
                
            case 6:
                a.medianOfAnArray(arr);
                System.out.println("----------------------------------------------------------------------------------------------------");
                break;
                
            case 7:
                Scanner s2 = new Scanner(System.in);
                System.out.println(" Enter the element to search : ");
                int ele = s2.nextInt();
                a.searchElementUsingBinarySearch(arr, ele);
                System.out.println("----------------------------------------------------------------------------------------------------");
                break;
                
            case 8:
                a.bubbleSort(arr);
                System.out.println("----------------------------------------------------------------------------------------------------");
                break;
                
            case 9:
                exit(0);             
        }
          System.out.println(" Enter your choice : ");
          choice = scan.nextInt();
      }while(true);
    }
    
    
}
