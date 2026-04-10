package org.cloud.dto;

import lombok.Data;

@Data
public class NoticexDTO {

	private int id, hit;
	private String title, content, writer, regDate;
}
