package PostLab;

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

	
	public int getQuoteId() {
		return quoteId;
	}

	
	public void setQuoteId(int quoteId) {
		this.quoteId = quoteId;
	}



	public String getQuoteValue() {
		return quoteValue;
	}

	
	public void setQuoteValue(String quoteValue) {
		this.quoteValue = quoteValue;
	}

	
	public String getQuoteAuthor() {
		return quoteAuthor;
	}


	public void setQuoteAuthor(String quoteAuthor) {
		this.quoteAuthor = quoteAuthor;
	}

	public String getQuoteType() {
		return quoteType;
	}

	public void setQuoteType(String quoteType) {
		this.quoteType = quoteType;
	}

	
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

