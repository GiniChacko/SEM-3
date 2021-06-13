/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab;

import java.util.Arrays;

/**
 * Array Calculator Class
 * @author Gini Chacko
 *
 */
public class ArrayCalculator 
{  
    /**
     * 1.Method to Find Minimum element from array
     * @param arr 
     */
    public void minArray(int arr[])
    {
        int i;
        int min = arr[0];
        
        for(i=0;i<arr.length;i++)
        {
            if(arr[i]<min)
                min = arr[i];
        }
        System.out.println(" The Minimum element of the Array is : "+ min);
    }   
    
    /**
     * 2.Method to Find Maximum element from array
     * @param arr 
     */
    public void maxArray(int arr[])
    {
        int i;
        int max = arr[0];
        
        for(i=0;i<arr.length;i++)
        {
            if(arr[i]>max)
                max = arr[i];
        }
        System.out.println(" The Maximum element of the Array is : "+ max);
    }
    
    /**
     * 3.Method to Search element in array
     * @param arr
     * @param ele you want to search
     */
    public void searchElement(int arr[],int ele)
    {
        int flag =0,index = 0;
        for(int i =0;i<arr.length;i++)
        {
            if(arr[i] == ele)
            {   
                index = i;
                flag = 1;
                break;
            }
            else
                flag =0; 
        } 
        
        if(flag==1)
            System.out.println(" The element is present at array index "+ index);
        else
            System.out.println(" The element doesn't exist in the array ");
        
    }
    
    /**
     * 4.Method to find Average of an array
     * @param arr 
     */
    public void averageOfAnArrayElements(int arr[])
    {
        float avg,sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum=sum+arr[i];
        }
        avg = sum/arr.length;
        System.out.println(" The Average of the array is : "+avg);
    }
    
    /**
     * 5.Method to Find Mode of elements in array
     * @param arr 
     */
    public void modeOfArrayElements(int arr[])
    {
        int count = 1,maxCount = 0,maxValue=0;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[j]==arr[i])
                {
                    count++;
                }
            } 
            if(count>maxCount)
            {    
                maxCount = count;
                maxValue = arr[i];
            }
            else if(count == maxCount)
            {
                maxValue = Math.min(maxValue, count);
            }
                       
        }
        System.out.println(" The mode of array elements is : "+maxValue);
    }
    
    /**
     * 6.Method to Find Median of elements in array
     * @param arr 
     */
    public void medianOfAnArray(int arr[])
    {
        int n= arr.length,median;
        bubbleSort(arr);
        if(n%2==1)
        {
            median = arr[((n+1)/2)-1];
        }
        else
        {
            median = (arr[(n/2)-1]+arr[n/2])/2;
        }
        System.out.println(" The median of array elements is : "+median);
    }
    
    /**
     * 7.Method to Search element in array using Binary search
     * @param arr
     * @param ele 
     */
    public void searchElementUsingBinarySearch(int arr[],int ele)
    {
        Arrays.sort(arr);
        int first = 0,last=arr.length;
        int mid = (first + last)/2;  
        while( first <= last )
        {  
            if ( arr[mid] < ele )
            {  
                first = mid + 1;     
            }
            else if ( arr[mid] == ele )
            {  
                System.out.println(" Element is found at array index: " + mid);  
                break;  
            }
            else
            {  
                last = mid - 1;  
            }  
            mid = (first + last)/2;  
        }  
        if ( first > last )
        {  
            System.out.println(" Element is not found!");  
        }  
    }
    
    /**
     * 8.Method to sort array using Bubble Sort	
     * @param arr 
     */
    public void bubbleSort(int arr[])
    {
        int i,j,flag =0,temp;
        for(i =0;i<arr.length;i++)
        {
            for(j=0;j<arr.length-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    flag = 1;
                    temp = arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;  
                }
            }
            if(flag == 0)
            {
                System.out.println(" The Array after Bubble Sort is : ");
                for(i=0;i<arr.length;i++)
                    System.out.println(arr[i]);
            }
        }
    }
}
