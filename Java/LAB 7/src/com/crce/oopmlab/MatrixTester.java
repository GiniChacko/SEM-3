/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab;
/**
 * Matrix Tester class
 * @author Gini Chacko
 *
 */
public class MatrixTester{

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		testAll();

	}
	
	/**
	 * Test All method containing all the methods to be tested
	 */
	public static void testAll() {
		testCreateMatrix();
		testAddMatrix();
		testSubtractMatrix();
		testMultiplyMatrix();
		testTransposeMatrix();
	    testDeterminant();
	    testCofactor();
		testInverse();
		}
	
	/**
	 * Tester method to Create Matrix
	 */
	public static void testCreateMatrix() {
		
		System.out.println("Testing creation of a matrix");
		System.out.println();
		Matrix a=new Matrix();
		a.createMatrix();
		System.out.println("----------------------------------------------");
	}
	
	/**
	 * Tester method to add matrices
	 */
	public static void testAddMatrix() {
		
		System.out.println("Testing addition of 2 matrices");
		System.out.println();
		Matrix a=new Matrix();
		a.createMatrix();
		Matrix b=new Matrix();
		b.createMatrix();
		try 
		{
			if((a.getRow()!=b.getRow())||(a.getCols()!=b.getCols())) {
				throw new IllegalDimensionException("For addition,rows and columns of both matrices should be same");
			}
			a.addMatrix(b);	     
		}
		catch(IllegalDimensionException e) {
			System.out.println("Error: "+e.getMessage());
		}
		System.out.println("----------------------------------------------");
	}
	
	/**
	 * Tester method to subtract matrices
	 */
	public static void testSubtractMatrix() {
		
		System.out.println("Testing subtraction of 2 matrices");
		System.out.println();
		Matrix a=new Matrix();
		System.out.println("Enter matrix 1 data : ");
		a.createMatrix();
		Matrix b=new Matrix();
		System.out.println("Enter matrix 2 data : ");
		b.createMatrix();
		try 
		{
			if((a.getRow()!=b.getRow())||(a.getCols()!=b.getCols())) {
				throw new IllegalDimensionException("For subtraction,rows and columns of both matrices should be same");
			}
			a.subtractMatrix(b);     
		}
		catch(IllegalDimensionException e) {
			System.out.println("Error: "+e.getMessage());
		}
		System.out.println("----------------------------------------------");
	}
	
	/**
	 * Tester method to multiply matrices
	 */
	public static void testMultiplyMatrix() {
		
		System.out.println("Testing multiplication of 2 matrices");
		System.out.println();
		Matrix a=new Matrix();
		System.out.println("Enter matrix 1 data");
		a.createMatrix();
		Matrix b=new Matrix();
		System.out.println("Enter matrix 2 data");
		b.createMatrix();
		try 
		{
			if(a.getCols()!=b.getRow()) {
				throw new IllegalDimensionException("(no of columns in first matrix should be equal to no of rows in second matrix for multiplication)");
			}
			a.multiplyMatrix(b);     
		}
		catch(IllegalDimensionException e) {
			System.out.println("Error: "+e.getMessage());
		}	
		System.out.println("----------------------------------------------");
	}
	
	/**
	 * Tester method to print transpose of matrix
	 */
	public static void testTransposeMatrix() {
		
		System.out.println("Testing transpose of a matrix");
		System.out.println();
		Matrix a=new Matrix();
		System.out.println("Enter matrix data : ");
		a.createMatrix();
		double transp[][]= new double[a.getRow()][a.getCols()];
		transp=a.transposeMatrix();
		System.out.println("  ");
		System.out.println("Transpose of the matrix is ");
		for (int i = 0; i < a.getCols(); i++)//loop to print transpose matrix
	    {
	        for (int j = 0; j < a.getRow(); j++)
	        {
	            System.out.print(transp[i][j]+"\t");
	        }
	         
	        System.out.println();
	    }
		System.out.println("----------------------------------------------");
	}
	
	/**
	 * Tester method to calculate determinant of matrix
	 */
	public static void testDeterminant() {
		
		System.out.println("Testing determinant of a matrix");
		System.out.println();
		Matrix a=new Matrix();
		System.out.println("Enter matrix data : ");
		a.createMatrix();
		try 
		{
			if(a.getRow()!=a.getCols()) {
				throw new NoSquareException("Matrix should be a square Matrix");
			}
			double det=a.determinant(); 
			System.out.println("Value of determinant is "+det);
		}
		catch(NoSquareException e) {
			System.out.println("Error: "+e.getMessage());
		}	
		System.out.println("----------------------------------------------");
	}
	
	/**
	 * Test to print cofactor of matrix
	 */
	public static void testCofactor() {
		
		System.out.println("Testing cofactor of a matrix");
		System.out.println();
		Matrix a=new Matrix();
		System.out.println("Enter matrix data : ");
		a.createMatrix();
		double cofact[][]= new double[a.getRow()][a.getCols()];
		try 
		{
			if(a.getRow()!=a.getCols()) {
				throw new NoSquareException("Matrix should be a square Matrix");
			}
			cofact=a.cofactor();
			System.out.println(" ");
			System.out.println("cofactor of the matrix is ");
			for (int i = 0; i < a.getCols(); i++)//loop to print cofactor matrix
		    {
		        for (int j = 0; j < a.getRow(); j++)
		        {
		            System.out.print(cofact[i][j]+"\t");
		        }
		         
		        System.out.println();
		    }
		}
		catch(NoSquareException e) {
			System.out.println("Error: "+e.getMessage());
		}
		System.out.println("----------------------------------------------");
	}
	
	/**
	 * Test method to inverse the matrix
	 */
	public static void testInverse() {
		
		System.out.println("Testing inverse of a matrix");
		Matrix a=new Matrix();
		System.out.println("Enter matrix data : ");
		a.createMatrix();
		try 
		{
			if(a.getRow()!=a.getCols()) {
				throw new NoSquareException("Matrix should be a square Matrix");
			}
			if(a.determinant()==0) {
				System.out.println("No inverse possible");
			}
			else 
			{
				double inv[][]= new double[a.getRow()][a.getCols()];
			    inv = a.inverse();
			    System.out.println(" ");
				System.out.println("inverse of the matrix is ");
				for (int i = 0; i < a.getCols(); i++)//loop to print inverse matrix
			    {
			        for (int j = 0; j < a.getRow(); j++)
			        {
			            System.out.print(inv[i][j]+"\t");
			        }
			         
			        System.out.println();
			    }
		     }
			
		}
		catch(NoSquareException e) {
			System.out.println("Error: "+e.getMessage());
		}	
		System.out.println("----------------------------------------------");
	}
	
}
	
	
