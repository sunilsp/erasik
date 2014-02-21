package com.rasik.service;

import org.springframework.web.multipart.MultipartFile;


public class UploadedFile {

	private MultipartFile file;
	private boolean picture;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	/**
	 * @return the isPicture
	 */
	public boolean getPicture() {
		return picture;
	}

	/**
	 * @param isPicture the isPicture to set
	 */
	public void setPicture(boolean isPicture) {
		this.picture = isPicture;
	}
}
