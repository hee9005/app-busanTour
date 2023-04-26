package data.Food;

public class busanFood {
	foodHeader header;
	foodItem[] item;
	
	int pageNo;
	int numOfRows;
	int totalCount;
	
	
	public foodHeader getHeader() {
		return header;
	}
	public foodItem[] getItem() {
		return item;
	}
	public int getPageNo() {
		return pageNo;
	}
	public int getNumOfRows() {
		return numOfRows;
	}
	public int getTotalCount() {
		return totalCount;
	}
	
	
	
}
