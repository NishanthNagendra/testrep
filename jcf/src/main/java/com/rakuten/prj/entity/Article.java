/**
 * 
 */
package com.rakuten.prj.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nishanth
 *
 */
public class Article {
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private int words;
	/**
	 * 
	 */
	private String type;
	/**
	 * 
	 */
	private List<String> tags = new ArrayList<>();

	/**
	 * 
	 */
	public Article() {
	}

	/**
	 * 
	 * @param title
	 * @param words
	 * @param type
	 * @param tags
	 */
	public Article(String title, int words, String type, List<String> tags) {
		this.title = title;
		this.words = words;
		this.type = type;
		this.tags = tags;
	}

	/**
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return
	 */
	public int getWords() {
		return words;
	}

	/**
	 * 
	 * @param words
	 */
	public void setWords(int words) {
		this.words = words;
	}

	/**
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * 
	 * @param tags
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
