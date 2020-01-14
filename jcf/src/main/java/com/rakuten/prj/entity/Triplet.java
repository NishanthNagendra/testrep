/**
 * 
 */
package com.rakuten.prj.entity;

/**
 * @author nishanth
 *
 */
public class Triplet {
	/**
	 * 
	 */
	private int first;
	/**
	 * 
	 */
	private int second;
	/**
	 * 
	 */
	private int third;
	/**
	 * @param first
	 * @param second
	 * @param third
	 */
	public Triplet(int first, int second, int third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}
	/**
	 * @return the first
	 */
	public int getFirst() {
		return first;
	}
	/**
	 * @param first the first to set
	 */
	public void setFirst(int first) {
		this.first = first;
	}
	/**
	 * @return the second
	 */
	public int getSecond() {
		return second;
	}
	/**
	 * @param second the second to set
	 */
	public void setSecond(int second) {
		this.second = second;
	}
	/**
	 * @return the third
	 */
	public int getThird() {
		return third;
	}
	/**
	 * @param third the third to set
	 */
	public void setThird(int third) {
		this.third = third;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + first;
		result = prime * result + second;
		result = prime * result + third;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triplet other = (Triplet) obj;
		if (first != other.first)
			return false;
		if (second != other.second)
			return false;
		if (third != other.third)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "< " + first + ", " + second + ", " + third + " >\n";
	}
	
	
}
