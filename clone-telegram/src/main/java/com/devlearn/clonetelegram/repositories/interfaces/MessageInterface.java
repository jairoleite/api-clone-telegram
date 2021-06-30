package com.devlearn.clonetelegram.repositories.interfaces;

public interface MessageInterface {

	Long getMsId();
	String getText();
	Boolean getView();
	String getDate();
	String getUserUuid();
	String getImage();
}
