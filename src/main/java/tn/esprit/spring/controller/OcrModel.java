package tn.esprit.spring.controller;

import org.springframework.web.multipart.MultipartFile;

public class OcrModel {
	
	private MultipartFile Image;

	public OcrModel() {
	}

	public OcrModel( MultipartFile Image) {
		
		this.Image = Image;

	}

	

	

	public MultipartFile getImage() {
		return Image;
	}

	public void setImage(MultipartFile image) {
		Image = image;
	}

}
