/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab;

import java.util.Scanner;

/**
 * Matrix class
 * @author Gini Chacko
 *
 */
public class Matrix
{
	/**
	 * private instance variable, not accessible from outside the class
	 */
	private int row;
	private int cols;
	private double[][] matrix;
	
	/**
	 * Constructor to call Matrix
	 */
    public Matrix() {
		super();
	}
    
    /**
     * Getter for instance variable row
     * @return row
     */
	public int getRow() {
		return row;
	}

	/**
	 * Setter for instance variable rows
	 * @param row
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * Getter for instance variable cols
	 * @return cols
	 */
	public int getCols() {
		return cols;
	}

	/**
	 * Setter for instance variable cols
	 * @param cols
	 */
	public void setCols(int cols) {
		this.cols = cols;
	}

	/**
	 * Getter for instance variable matrix
	 * @return matrix
	 */
	public double[][] getMatrix() {
		return matrix;
	}

	/**
	 * Setter for instance variable matrix
	 * @param matrix
	 */
	public void setMatrix(double[][] matrix) {
		this.matrix = matrix;
	}

	/**
	 * Method to create a matrix
	 */
	public  void createMatrix()
    {
        Scanner sc = new Scanner(System.in);
         
        System.out.println  ("Enter The Number Of Rows : ");
         
        this.row = sc.nextInt();
        System.out.println();
         
        System.out.println("Enter The Number Of Columns : ");
         
        this.cols = sc.nextInt();
        System.out.println();
        this.matrix = new double[row][cols];
         
        System.out.print("Enter Matrix Data : ");
         
        for (int i = 0; i < row; i++)//loop to take matrix values as inputs
        {
            for (int j = 0; j < cols; j++)
            {
                matrix[i][j] = sc.nextInt();
            }
        }
         
        System.out.println("Your Matrix is : ");
         
        for (int i = 0; i < row; i++)//loop for printing the created matrix
        {
            for (int j = 0; j < cols; j++)
            {
                System.out.print(matrix[i][j]+"\t\t");
            }
             
            System.out.println();
        }
        System.out.println();
    }
	
   /**
    * Function to add the current matrix with passed matrix
    * @param m2
    * @throws IllegalDimensionException
    */
   public  void addMatrix(Matrix m2) throws IllegalDimensionException {
	   
	   System.out.println("Sum of the two matrix is ");
	   double sum[][]= new double[row][cols];
       for (int i = 0; i < row; i++)//loop for printing the sum matrix
       {
           for (int j = 0; j < cols; j++)
           {
        	   sum[i][j] = this.matrix[i][j] + m2.matrix[i][j];
                
               System.out.print(sum[i][j]+"\t\t");
           }
            
           System.out.println();
       }
       System.out.println();
	}
   
   /**
    * Function to subtract the passed matrix from current matrix
    * @param m2
    * @throws IllegalDimensionException
    */
   public void subtractMatrix(Matrix m2) throws IllegalDimensionException {
	   
	   System.out.println("Subtraction of the two matrix is ");
	   double sub[][]= new double[row][cols];
       for (int i = 0; i < row; i++)//loop for printing the sub matrix
       {
           for (int j = 0; j < cols; j++)
           {
        	   sub[i][j] = this.matrix[i][j] - m2.matrix[i][j];
                
               System.out.print(sub[i][j]+"\t\t");
           }
            
           System.out.println();
       }
       System.out.println();
   }
   
   /**
    * Function to multiply the current matrix with passed matrix
    * @param m2
    * @throws IllegalDimensionException
    */
   public void multiplyMatrix(Matrix m2) throws IllegalDimensionException {
	   
	   System.out.println("Product of the two matrix is ");
	   double[][] product = new double[this.row][m2.cols];
       for (int i = 0; i < this.row; i++)//loop for multiplication
       {
           for (int j = 0; j < m2.cols; j++)
           {
               for (int k = 0; k < this.cols; k++)
               {
                   product[i][j] +=  this.matrix[i][k] * m2.matrix[k][j];
               }
           }
       }
        
       for (int i = 0; i < this.row; i++)//loop for printing the product matrix
       {
           for (int j = 0; j < m2.cols; j++)
           {
               System.out.print(product[i][j]+"\t\t");
           }
            
           System.out.println();
       }
	   System.out.println();
   }
   
   /**
    * Function which returns a transposed matrix
    * @return transpose
    */
   public double[][] transposeMatrix() {//function which returns a transposed matrix
	   
	   double transpose[][]= new double[row][cols];
       for (int i = 0; i < row; i++)
       {
           for (int j = 0; j < cols; j++)
           {
               transpose[j][i] = matrix[i][j];
           }
       }
      return transpose;  
   }
   
   /**
    * Function which returns determinant value of the matrix
    * @return determinant
    * @throws NoSquareException
    */
   public double determinant() throws NoSquareException{
	   
	   if (row == 2)
	        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

	    int determinant1 = 0, determinant2 = 0;
	    for (int i = 0; i < row; i++) {
	        int temp = 1, temp2 = 1;
	        for (int j = 0; j < cols; j++) {
	            temp *= matrix[(i + j) % cols][j];
	            temp2 *= matrix[(i + j) % cols][row - 1 - j];
	        }

	        determinant1 += temp;
	        determinant2 += temp2;
	    }

	    return determinant1 - determinant2;
	}
   
   /**
    * Function which returns cofactor of the matrix
    * @return result
    * @throws NoSquareException
    */
   public double[][] cofactor() throws NoSquareException{
	   
	   double[][] result = new double[row][cols];
        Matrix a=new Matrix();
        a.setRow(row-1);
        a.setCols(cols-1);
	    for (int i = 0; i < row; i++) {
	        for (int j = 0; j < cols; j++){
	        	a.setMatrix(removeRowCol(matrix, row, cols, i, j));
	            result[i][j] = (double) ((Math.pow(-1, i + j)) *(a.determinant()));
	        }
	    }

	    return result;
	}
   
   /**
    * Function to remove rows and columns corresponding to a value and return a sub matrix
    * @param matrix
    * @param rows
    * @param cols
    * @param row
    * @param col
    * @return result
    */
	public double[][] removeRowCol(double[][] matrix, int rows, int cols,int row, int col) {
		
		double[][] result = new double[rows - 1][cols - 1];

	    int k = 0, l = 0;
	    for (int i = 0; i < rows; i++) {
	        if (i == row)
	            continue;
	        for (int j = 0; j < cols; j++) {
	            if (j == col)
	                continue;
	            result[l][k] = matrix[i][j];

	            k = (k + 1) % (rows - 1);
	            if (k == 0)
	                l++;
	        }
	    }

	    return result;
	}
	
	/**
	 * Function which returns inverse of the matrix
	 * @return inverse
	 * @throws NoSquareException
	 */
	public double[][] inverse() throws NoSquareException{
		
		double[][] cof = new double[row][cols];
		double[][] inverse = new double[row][cols];
		cof =cofactor();//calculating cofactor of the matrix
		double det=Math.abs(determinant());//calculating determinant of the matrix
	    Matrix a=new Matrix();
	    a.setRow(row);
	    a.setCols(cols);
	    a.setMatrix(cof);
	    cof =a.transposeMatrix();//calculating adjoint by transposing the cofactor matrix
	    for (int i = 0; i < row; i++)
	       {
	           for (int j = 0; j < cols; j++)
	           {
	               inverse[i][j] = (cof[i][j])/det;//formula for inverse of a matrix
	           }
	       }
	      return inverse;
		
	}
}
