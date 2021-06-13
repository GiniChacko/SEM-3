package com.crce.oopmlab;

/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
public class Quote {

	private int quoteId;
	private String quoteValue;
	private String quoteAuthor;
	private String quoteType;

	/**
	 * 
	 * @return returns quoteId
	 */
	public int getQuoteId() {
		return quoteId;
	}

	/**
	 * Sets the quoteId
	 * 
	 * @param quoteId set the quoteId
	 */
	public void setQuoteId(int quoteId) {
		this.quoteId = quoteId;
	}

	/**
	 * 
	 * @return returns the actual quote
	 */

	public String getQuoteValue() {
		return quoteValue;
	}

	/**
	 * Sets quote value
	 * 
	 * @param quoteValue set quote value
	 */
	public void setQuoteValue(String quoteValue) {
		this.quoteValue = quoteValue;
	}

	/**
	 * gets the quote author
	 * 
	 * @return author who wrote the quote
	 */
	public String getQuoteAuthor() {
		return quoteAuthor;
	}

	/**
	 * Sets quote author
	 * 
	 * @param quoteValue set quote author
	 */
	public void setQuoteAuthor(String quoteAuthor) {
		this.quoteAuthor = quoteAuthor;
	}

	public String getQuoteType() {
		return quoteType;
	}

	/**
	 * Sets type of quote
	 * 
	 * @param quoteType it is a type of quote
	 * 
	 */
	public void setQuoteType(String quoteType) {
		this.quoteType = quoteType;
	}

	/**
	 * @param quoteId     quote id
	 * @param quoteValue  actual quote
	 * @param quoteAuthor writer of quote
	 * @param quoteType   type of quote
	 */
	public Quote(int quoteId, String quoteValue, String quoteAuthor, String quoteType) {
		super();
		this.quoteId = quoteId;
		this.quoteValue = quoteValue;
		this.quoteAuthor = quoteAuthor;
		this.quoteType = quoteType;
	}

	@Override
	public String toString() {
		return "Quote [quoteId=" + quoteId + ", quoteValue=" + quoteValue + ", quoteAuthor=" + quoteAuthor
				+ ", quoteType=" + quoteType + "]";
	}
}
