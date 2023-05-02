package data.Attraction;

import java.util.Objects;

public class attractionitem {
	// 상세페이지 뽑을값
	int UC_SEQ;
	// 콘텐츠명
	String MAIN_TITLE;
	// 지역 구
	String GUGUN_NM;
	// 위도
	double LAT;
	// 경도
	double LNG;
	// 여행지
	String PLACE;
	// 제목
	String TITLE;
	// 부제목
	String SUBTITLE;
	// 주소
	String ADDR1;
	// 연락처
	String CNTCT_TEL;
	// 홈페이지
	String HOMEPAGE_URL;
	// 교통정보
	String TRFC_INFO;
	// 운영일
	String USAGE_DAY;
	// 운영 및 시간
	String HLDY_INFO;
	// 이용요금
	String USAGE_DAY_WEEK_AND_TIME;
	
	String MIDDLE_SIZE_RM1;
	// 이미지
	String MAIN_IMG_NORMAL;
	// 썸네일이미지
	String MAIN_IMG_THUMB;
	// 상세내용
	String ITEMCNTNTS;
	public int getUC_SEQ() {
		return UC_SEQ;
	}
	
	public void setUC_SEQ(int UC_SEQ) {
		this.UC_SEQ = UC_SEQ;
	}


	public String getMAIN_TITLE() {
		return MAIN_TITLE;
	}
	public String getGUGUN_NM() {
		return GUGUN_NM;
	}
	public double getLAT() {
		return LAT;
	}
	public double getLNG() {
		return LNG;
	}
	public String getPLACE() {
		return PLACE;
	}
	public String getTITLE() {
		return TITLE;
	}
	public String getSUBTITLE() {
		return SUBTITLE;
	}
	public String getADDR1() {
		return ADDR1;
	}
	public String getCNTCT_TEL() {
		return CNTCT_TEL;
	}
	public String getHOMEPAGE_URL() {
		return HOMEPAGE_URL;
	}
	public String getTRFC_INFO() {
		return TRFC_INFO;
	}
	public String getUSAGE_DAY() {
		return USAGE_DAY;
	}
	public String getHLDY_INFO() {
		return HLDY_INFO;
	}
	public String getUSAGE_DAY_WEEK_AND_TIME() {
		return USAGE_DAY_WEEK_AND_TIME;
	}
	public String getMIDDLE_SIZE_RM1() {
		return MIDDLE_SIZE_RM1;
	}
	public String getMAIN_IMG_NORMAL() {
		return MAIN_IMG_NORMAL;
	}
	public String getMAIN_IMG_THUMB() {
		return MAIN_IMG_THUMB;
	}
	public String getITEMCNTNTS() {
		return ITEMCNTNTS;
	}


	
}
