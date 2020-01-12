/**
 * 
 */
package com.rakuten.prj.util;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.rakuten.prj.entity.Product;
import com.rakuten.prj.entity.Triplet;

/**
 * @author nishanth
 *
 */
class ArrayUtilTest {

	@Test
	void testGetSum() {
		int[] values = {45, 0, 5};
		int expected = 50;
		assertEquals(expected, ArrayUtil.getSum(values));
	}

	@Test
	void testGetOccurence() {
		int[] values = {43, 6, 77, 6, 12, 6};
		int expected = 3;
		assertEquals(expected, ArrayUtil.getOccurence(values, 6));
	}

	@Test
	void testSort() {
		int[] values = {6, 2, 78, 12, 90};
		ArrayUtil.sort(values);
		int[] expected = {2, 6, 12, 78, 90};
		assertArrayEquals(expected, values);
	}

	@Test
	void testComparable() {
		String[] names = {"George", "Brad", "Lee", "Charlie", "Angelina"};
		ArrayUtil.sort(names);
		String[] sorted = {"Angelina", "Brad", "Charlie", "George", "Lee"};
		assertArrayEquals(sorted, names);
		
		Product[] products = new Product[6];
        products[0] = new Product(645, "Hp Laptop", 135000.00, "computer");
        products[1] = new Product(224, "iPhone", 98000.00, "mobile");
        products[2] = new Product(834, "Logitech Mouse", 600.00, "computer");
        products[3] = new Product(5, "Sony Bravia", 125000.00, "tv");
        products[4] = new Product(912, "One Plus", 32000.00, "mobile");
        products[5] = new Product(88, "HP Printer", 19000.00, "computer");
        
        ArrayUtil.sort(products);
        
        Product[] sps = new Product[6];
        sps[3] = new Product(645, "Hp Laptop", 135000.00, "computer");
        sps[2] = new Product(224, "iPhone", 98000.00, "mobile");
        sps[4] = new Product(834, "Logitech Mouse", 600.00, "computer");
        sps[0] = new Product(5, "Sony Bravia", 125000.00, "tv");
        sps[5] = new Product(912, "One Plus", 32000.00, "mobile");
        sps[1] = new Product(88, "HP Printer", 19000.00, "computer");
        
        assertArrayEquals(sps, products);
	}
	
	@Test
	void testPrintTriplets() {
		int[] data = {2,3,4,5,7};
		List<Triplet> triplets = ArrayUtil.printTriplets(data);
        Triplet t = triplets.get(0);
        
        assertEquals(3, triplets.size());
        assertEquals(2, t.getFirst());
        assertEquals(3, t.getSecond());
        assertEquals(5, t.getThird());
       
        t = triplets.get(2);
        assertEquals(3, triplets.size());
        assertEquals(3, t.getFirst());
        assertEquals(4, t.getSecond());
        assertEquals(7, t.getThird());
		
        System.out.println(ArrayUtil.printTriplets(data));
        
        int[] data1 = {1,2,3,4,5,7,9};
		List<Triplet> triplets1 = ArrayUtil.printTriplets(data1);
        Triplet t1 = triplets1.get(0);
        
        assertEquals(8, triplets1.size());
        assertEquals(1, t1.getFirst());
        assertEquals(2, t1.getSecond());
        assertEquals(3, t1.getThird());
       
        t1 = triplets1.get(7);
        assertEquals(8, triplets1.size());
        assertEquals(4, t1.getFirst());
        assertEquals(5, t1.getSecond());
        assertEquals(9, t1.getThird());
		
        System.out.println(ArrayUtil.printTriplets(data1));
	}
}
