
public class Data {
	protected int articleId;
	protected String item, title, status;
	
	public Data(int articleId, String item, String title, String status) {
		super();
		this.articleId = articleId;
		this.item = item;
		this.title = title;
		this.status = status;
	}
	@Override
	public String toString() {
		return articleId + item + title + status;
	}

}
