package data.Attraction;

public class busanAttraction {
attractionHeader header;	
attractionitem[] item;

int pageNo;
int numOfRows;
int totalCount;

public attractionHeader getHeader() {
	return header;
}
public attractionitem[] getItem() {
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
