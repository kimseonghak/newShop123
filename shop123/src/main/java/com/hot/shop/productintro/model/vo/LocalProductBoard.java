package com.hot.shop.productintro.model.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class LocalProductBoard {
	private int LocalProductNo;
	private String LocalProductTitle;
	private String LocalProductContent;
	private Date LocalProductRegDate;
	private int LocalProductPhotoNo;//사진 번호
	private char LocalProductDelYN;
	private String LocalProductClassify;
	private String LocalProductPhotoFilePath;//사진 경로
	private int originalLocalphotoNo;

	
	public LocalProductBoard() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LocalProductBoard(int localProductNo, String localProductTitle, String localProductContent,
			Date localProductRegDate, int localProductPhotoNo, char localProductDelYN, String localProductClassify,
			String localProductPhotoFilePath, int originalLocalphotoNo) {
		super();
		LocalProductNo = localProductNo;
		LocalProductTitle = localProductTitle;
		LocalProductContent = localProductContent;
		LocalProductRegDate = localProductRegDate;
		LocalProductPhotoNo = localProductPhotoNo;
		LocalProductDelYN = localProductDelYN;
		LocalProductClassify = localProductClassify;
		LocalProductPhotoFilePath = localProductPhotoFilePath;
		this.originalLocalphotoNo = originalLocalphotoNo;
		
	}
	
	public int getLocalProductNo() {
		return LocalProductNo;
	}
	public void setLocalProductNo(int localProductNo) {
		LocalProductNo = localProductNo;
	}
	public String getLocalProductTitle() {
		return LocalProductTitle;
	}
	public void setLocalProductTitle(String localProductTitle) {
		LocalProductTitle = localProductTitle;
	}
	public String getLocalProductContent() {
		return LocalProductContent;
	}
	public void setLocalProductContent(String localProductContent) {
		LocalProductContent = localProductContent;
	}
	public Date getLocalProductRegDate() {
		return LocalProductRegDate;
	}
	public void setLocalProductRegDate(Date localProductRegDate) {
		LocalProductRegDate = localProductRegDate;
	}
	public int getLocalProductPhotoNo() {
		return LocalProductPhotoNo;
	}
	public void setLocalProductPhotoNo(int localProductPhotoNo) {
		LocalProductPhotoNo = localProductPhotoNo;
	}
	public char getLocalProductDelYN() {
		return LocalProductDelYN;
	}
	public void setLocalProductDelYN(char localProductDelYN) {
		LocalProductDelYN = localProductDelYN;
	}
	public String getLocalProductClassify() {
		return LocalProductClassify;
	}
	public void setLocalProductClassify(String localProductClassify) {
		LocalProductClassify = localProductClassify;
	}
	public String getLocalProductPhotoFilePath() {
		return LocalProductPhotoFilePath;
	}
	public void setLocalProductPhotoFilePath(String localProductPhotoFilePath) {
		LocalProductPhotoFilePath = localProductPhotoFilePath;
	}

	public int getOriginalLocalphotoNo() {
		return originalLocalphotoNo;
	}
	
	public void setOriginalLocalphotoNo(int originalLocalphotoNo) {
		this.originalLocalphotoNo = originalLocalphotoNo;
	}
	@Override
	public String toString() {
		return "LocalProductBoard [LocalProductNo=" + LocalProductNo + ", LocalProductTitle=" + LocalProductTitle
				+ ", LocalProductContent=" + LocalProductContent + ", LocalProductRegDate=" + LocalProductRegDate
				+ ", LocalProductPhotoNo=" + LocalProductPhotoNo + ", LocalProductDelYN=" + LocalProductDelYN
				+ ", LocalProductClassify=" + LocalProductClassify + ", LocalProductPhotoFilePath="
				+ LocalProductPhotoFilePath + ", originalLocalphotoNo=" + originalLocalphotoNo 
				;
	}


	
	
}
