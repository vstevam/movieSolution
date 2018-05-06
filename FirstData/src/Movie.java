

public class Movie {
	private String total;

	private String per_page;

	private String page;

	private Data[] data;

	private String total_pages;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getPer_page() {
		return per_page;
	}

	public void setPer_page(String per_page) {
		this.per_page = per_page;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public Data[] getData() {
		return data;
	}

	public void setData(Data[] data) {
		this.data = data;
	}

	public String getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(String total_pages) {
		this.total_pages = total_pages;
	}

	@Override
	public String toString() {
		return "ClassPojo [total = " + total + ", per_page = " + per_page + ", page = " + page + ", data = " + data
				+ ", total_pages = " + total_pages + "]";
	}
}
