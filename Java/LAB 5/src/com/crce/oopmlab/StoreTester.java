/**
 * NAME : GINI CHACKO
 * CLASS : SE COMPS B
 * ROLL : 8942
 */

package com.crce.oopmlab;
/**
 * Store tester class to test all the test cases
 * @author Gini Chacko
 *
 */
public class StoreTester {

		public static void main(String[] args) {
			StoreTester storeTester = new StoreTester();
			storeTester.testAll();

		}
	    /**
		 * Test All method containing all the methods to be tested
		 */
		void testAll() {
			testCalculateTax();
			testDisplayGoods();
			testDisplayTaxableGoods();
			testCastingOfGoods();
			testcastingOfBook();
			testcastingOfToy();
			testExciseTaxWithBaseTax();
		}

	    /**
		 * Tester method to Calculate Tax
		 */
		void testCalculateTax() {
			
			System.out.println("===============================");
			System.out.println("testCalculateTax()");
			System.out.println();
			
			Goods gd = new Goods("bubble bath", 1.40);
			Food fd = new Food("ox tails", 4.45, 1500);
			Book bk = new Book("Emma", 24.95, "Austin");
			Toy ty = new Toy("Legos", 54.45, 8);

			System.out.println(gd);
			System.out.println();

			System.out.println(fd);
			System.out.println();

			System.out.println(ty);
			System.out.println("Tax of "+ty.getDescription()+" is " + ty.calculateTax() + "\n");

			System.out.println(bk);
			System.out.println("Tax of the book "+bk.getDescription()+" whose author "+bk.getAuthor()+" is " + bk.calculateTax() + "\n");

		}

	    /**
		 * Tester method to Display Goods
		 */
		void testDisplayGoods() {
			
			System.out.println("===============================");
			System.out.println("testDisplayGoods()");
			System.out.println();

			// here if the goods are taxable print the tax of the good as well
			/*Goods[] inventory = new Goods[10];
			inventory[0] = new Goods("bubble bath", 1.40);
			inventory[1] = new Food("ox tails", 4.45, 1500.0);
			inventory[2] = new Book("Emma", 24.95, "Austen");
			inventory[3] = new Toy("Leggos", 54.45, 8);

			System.out.println(inventory[0]);
			System.out.println(inventory[1]);
			System.out.println(inventory[2]);
			System.out.println(inventory[3]);*/

			Goods[] good = new Goods[4];
			good[0] = new Goods("bubble bath", 1.40);
			good[1] = new Food("ox tails", 4.45, 1500.0);
			good[2] = new Book("Emma", 24.95, "Austen");
			good[3] = new Toy("Leggos", 54.45, 8);

			for(Goods goods: good) {
				System.out.println(goods);
			}
		}

	    /**
		 * Tester method to Display Taxable Goods
		 */
		void testDisplayTaxableGoods() {
			
			System.out.println("===============================");
			System.out.println("testDisplayTaxableGoods()");
			System.out.println();
			
			// Declare taxable items and print their taxes
			Taxable item1 = new Book("Emma", 24.95, "Austen");
			Taxable item2 = new Toy("Leggos", 54.45, 8);

			System.out.println("Tax on item 1 is " + item1.calculateTax());
			System.out.println("Tax on item 2 is " + item2.calculateTax());

			System.out.println(item1.toString());
			System.out.println(item2.toString());
		}

	    /**
		 * Tester method to test casting Of Goods
		 */
		void testCastingOfGoods() {
			
			System.out.println("===============================");
			System.out.println("testCastingOfGoods()");
			System.out.println();
			
			Taxable item1 = new Book("Emma", 24.95, "Austen");
			System.out.println("Tax on item 1 " + item1.calculateTax());
			// System.out.println( "Author: " + item1.getAuthor() );
			 System.out.println("Author: " + ((Book) item1).getAuthor());
		}

	    /**
		 * Tester method to test casting Of Book
		 */
		void testcastingOfBook() {
			
			System.out.println("===============================");
			System.out.println("testcastingOfBook()");
			System.out.println();
			
			Book book;
			Taxable tax = new Book("Emma", 24.95, "Austen");
			
			book = (Book) tax;
			System.out.println(book);
			System.out.println("Tax on item 1 " + book.calculateTax());

		}

	    /**
		 * Tester method to test casting O fToy
		 */
		void testcastingOfToy() {
			
			System.out.println("===============================");
			System.out.println("testcastingOfToy()");
			System.out.println();
			
			Goods toy=null;
			Taxable tax = new Toy("Building Blocks", 1.49, 6);

			toy = (Toy) tax;
			System.out.println(toy);
			System.out.println("Tax: " + ((Taxable) toy).calculateTax());
		}


	    /**
		 * Tester method to test Excise Tax With Base Tax
		 */
		public void testExciseTaxWithBaseTax() {
			
			System.out.println("===============================");
			System.out.println("testExciseTaxWithBaseTax()");
			System.out.println();
			
			ImportedTV tv1 = new ImportedTV("samsung Imported", 50000.0);
			ImportedTV tv2 = new ImportedTV("LG " , 70000.0);
			System.out.println(tv1);
			System.out.println("Tax for Samsung Imported TV " + tv1.calculateTax());
			System.out.println("Excise Tax for LG  Imported TV " +tv1.calculateExtra());
		
			System.out.println();
			System.out.println(tv2);
			System.out.println("Tax for LG Imported TV " +tv2.calculateTax());
			System.out.println("Excise Tax for LG  Imported TV " +tv2.calculateExtra());
		}

	}

