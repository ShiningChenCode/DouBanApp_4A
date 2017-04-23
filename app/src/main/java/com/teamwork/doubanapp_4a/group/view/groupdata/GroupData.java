package com.teamwork.doubanapp_4a.group.view.groupdata;

/**
 * Created by Administrator on 2017/4/22.
 */

public class GroupData {
	private int topImgId;
	private String topText;
	private int leftImgId;
	private String titleText;
	private String contentText;
	private String numberText;

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	private boolean select;
	public int getTopImgId() {
		return topImgId;
	}

	public void setTopImgId(int topImgId) {
		this.topImgId = topImgId;
	}

	public String getTopText() {
		return topText;
	}

	public void setTopText(String topText) {
		this.topText = topText;
	}

	public int getLeftImgId() {
		return leftImgId;
	}

	public void setLeftImgId(int leftImgId) {
		this.leftImgId = leftImgId;
	}

	public String getTitleText() {
		return titleText;
	}

	public void setTitleText(String titleText) {
		this.titleText = titleText;
	}

	public String getContentText() {
		return contentText;
	}

	public void setContentText(String contentText) {
		this.contentText = contentText;
	}

	public String getNumberText() {
		return numberText;
	}

	public void setNumberText(String numberText) {
		this.numberText = numberText;
	}
}
