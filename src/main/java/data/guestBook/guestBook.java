package data.guestBook;

import java.util.Date;

public class guestBook {
int boardId;
String boardPass;
String content;
String writer;
Date writed;
String userId;

public int getBoardId() {
	return boardId;
}
public void setBoardId(int boardId) {
	this.boardId = boardId;
}
public String getBoardPass() {
	return boardPass;
}
public void setBoardPass(String boardPass) {
	this.boardPass = boardPass;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getWriter() {
	return writer;
}
public void setWriter(String writer) {
	this.writer = writer;
}
public Date getWrited() {
	return writed;
}
public void setWrited(Date writed) {
	this.writed = writed;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}


}
