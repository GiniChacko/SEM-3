/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab;

import java.util.HashMap;
import java.util.Map;

/**
 * String Operation class
 * @author Gini Chacko
 *
 */
public class StringOps {
	
	/**
	 * Default constructor
	 */
	public StringOps() {
		super();
	}

	/**
	 * Method to reverse the string
	 * @param abc
	 * @return reverse
	 */
	public String reverse(String abc) {
		String reverse = "";
		for (int i = abc.length() - 1; i >= 0; i--) {
			reverse = reverse + abc.charAt(i);
		}
	 return reverse;
	}
	
	/**
	 * Method to reverse the string recursively
	 * @param abc
	 * @return revere using recursion
	 */
	public String reverseRec(String abc) {//to reverse string recursively
		if (abc.isEmpty())
            return abc;
		else
        return reverseRec(abc.substring(1)) + abc.charAt(0);
	}
	
	/**
	 * Method to check whether the given input is a palindrome or no
	 * @param abc
	 * @return true
	 */
	public boolean palindrome(String abc) 
    { 
        int i = 0, j = abc.length() -1; 
  
        // While there are characters to compare
        while (i < j) { 
  
            // If characters doesn't match
            if (abc.charAt(i) != abc.charAt(j)) { 
                return false; 
            }
            i++; 
            j--; 
        } 
        return true;
    }
	
	/**
	 * Method to count the vowels
	 * @param abc
	 * @return count
	 */
	public int countVowels(String abc) {
		int count=0;
		abc=abc.toLowerCase();
		for (int i = 0; i < abc.length(); i++) {
			char ch=abc.charAt(i);
		    if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') {
		    	count++;
		    }
		}  	
		return count;
	}
	
	/**
	 * Method to count the consonants
	 * @param abc
	 * @return count
	 */
	public int countConsonants(String abc) {
		int count=0;
		abc=abc.toLowerCase();
		for (int i = 0; i < abc.length(); i++) {
			char ch=abc.charAt(i);
		    if(ch!='a'&&ch!='e'&&ch!='i'&&ch!='o'&&ch!='u'&&ch!=' ') {
		    	count++;
		    }
		}  	
		return count;
	}
	
	/**
	 * Method to calculate the frequency in order of occurence
	 * @param str
	 */
	public void FreqInOrderOfOccur(String str) {
		 int[] freq = new int[str.length()];  
	        int i, j;  
	          
	        //Converts given string into character array  
	        char string[] = str.toCharArray();  
	          
	        for(i = 0; i <str.length(); i++) {  
	            freq[i] = 1;  
	            for(j = i+1; j <str.length(); j++) {  
	                if(string[i] == string[j]) {  
	                    freq[i]++;  
	                      
	                    //Set string[j] to 0 to avoid printing visited character  
	                    string[j] = '0';  
	                }  
	            }  
	        }  
	          
	        //Displays each character and their corresponding frequency  
	        System.out.println("Characters and their corresponding frequencies");  
	        for(i = 0; i <freq.length; i++) {  
	            if(string[i] != ' ' && string[i] != '0')  
	                System.out.println(string[i] + "-" + freq[i]);  
	        }  
	    } 
	
	/**
	 * Method to calculate the even frequency in order of occurence
	 * @param str
	 */
	public void EvenFreqInOrderOfOccur(String str) {
		int SIZE=26;
		 int []freq = new int[SIZE]; 
		  
		    // Update the frequency of each character 
		    for (int i = 0; i < str.length(); i++) 
		        freq[str.charAt(i) - 'a']++; 
		  
		    // Traverse str character by character 
		    for (int i = 0; i < str.length(); i++)  
		    { 
		  
		        // If frequency of current character is even 
		        if (freq[str.charAt(i) - 'a'] % 2 == 0) 
		        { 
		            System.out.println(str.charAt(i)); 
		        } 
		    } 
		
	}
	
	/**
	 * Method to calculate the odd frequency in order of occurence
	 * @param str
	 */
	public void OddFreqInOrderOfOccur(String str) {
		int SIZE=26;
		 int []freq = new int[SIZE]; 
		  
		    // Update the frequency of each character 
		    for (int i = 0; i < str.length(); i++) 
		        freq[str.charAt(i) - 'a']++; 
		  
		    // Traverse str character by character 
		    for (int i = 0; i < str.length(); i++)  
		    { 
		  
		        // If frequency of current character is even 
		        if (freq[str.charAt(i) - 'a'] % 2 == 1) 
		        { 
		            System.out.println(str.charAt(i)); 
		        } 
		    } 
		
	}
	
	/**
	 * Method to reverse the string
	 * @param str
	 */
	public void wordReverse(String str) 
	{ 
	    int i = str.length() - 1; 
	    int start, end = i + 1; 
	    String result = ""; 
	      
	    while(i >= 0) 
	    { 
	        if(str.charAt(i) == ' ') 
	        { 
	            start = i + 1; 
	            while(start != end) 
	                result += str.charAt(start++); 
	              
	            result += ' '; 
	              
	            end = i; 
	        } 
	        i--; 
	    } 
	      
	    start = 0; 
	    while(start != end) 
	        result += str.charAt(start++); 
	      
	    System.out.println("Words in the string reversed!!!");
	    System.out.println(" ");
	    System.out.println(result);
	} 
	
	/**
	 * Method to print the char in decreasing order of frequency
	 */
	public void  printCharDecOrderOfFreq(String s, int len)
	{
	 
	    // To store the
	    HashMap<Character,
	              Integer> occ = new HashMap<Character,
	                                         Integer>();
	    for (int i = 0; i < len; i++)
	    {
	    	 if(occ.containsKey(s.charAt(i)))
	         {
	             occ.put((s.charAt(i)), occ.get((s.charAt(i))) + 1);
	         }
	           else
	         {
	             occ.put((s.charAt(i)), 1);
	         }
	    	 
	    }
	       
	 
	    // Map's size
	    int size = occ.size();
	 
	    // While there are elements in the map
	    while (size-- > 0) 
	    {
	 
	        // Finding the maximum value
	        // from the map
	        int currentMax = 0;
	        char arg_max = 0;
	        for (Map.Entry<Character,
	                        Integer> it : occ.entrySet())
	        {
	            if (it.getValue() > currentMax || 
	               (it.getValue() == currentMax && 
	                it.getKey() > arg_max)) 
	            {
	                arg_max = it.getKey();
	                currentMax = it.getValue();
	            }
	        }
	 
	        // Print the character
	        // alongwith its frequency
	        System.out.print(arg_max + " - " + 
	                         currentMax + "\n");
	 
	        // Delete the maximum value
	        occ.remove(arg_max);
	    }
	}
	}

