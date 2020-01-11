/**
 * 
 */
package com.rakuten.prj.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author nishanth
 *
 */
class ProductTest {

	/**
	 * Test method for {@link com.rakuten.prj.entity.Product#hashCode()}.
	 */
	@Test
	void testHashCode() {
		Product[] products = new Product[3];
        products[0] = new Product(645, "Hp Laptop", 135000.00, "computer");
        products[1] = new Product(645, "Hp Laptop", 135000.00, "computer");
        products[2] = new Product(0, null, 135000.00, "computer");
        assertEquals(products[0].hashCode(), products[1].hashCode());
        assertEquals(961, products[2].hashCode()); // actual value is calculated from the function
	}

	/**
	 * Test method for {@link com.rakuten.prj.entity.Product#compareTo(com.rakuten.prj.entity.Product)}.
	 */
	@Test
	void testCompareTo() {
		Product[] products = new Product[2];
        products[0] = new Product(645, "Hp Laptop", 135000.00, "computer");
        products[1] = new Product(224, "iPhone", 98000.00, "mobile");
        assertEquals(products[0].getId()-products[1].getId(), products[0].compareTo(products[1]));
	}

	/**
	 * Test method for {@link com.rakuten.prj.entity.Product#toString()}.
	 */
	@Test
	void testToString() {
		Product product = new Product(645, "Hp Laptop", 135000.00, "computer");
		assertEquals("Product [id=" + product.getId() + ", name=" + product.getName() + ", price=" + product.getPrice() + ", category=" + product.getCategory() + "]", product.toString());
	}

	/**
	 * Test method for {@link com.rakuten.prj.entity.Product#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		Product[] products = new Product[3];
        products[0] = new Product(645, "Hp Laptop", 135000.00, "computer");
        products[1] = new Product(645, "Hp Laptop", 135000.00, "computer");
        products[2] = null;
        assertEquals(true, products[0].equals(products[1]));
        assertEquals(false, products[1].equals(products[2]));
	}

}
