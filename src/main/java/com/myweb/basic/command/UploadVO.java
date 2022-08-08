package com.myweb.basic.command;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UploadVO {

	private Integer upload_no; //pk
	private String filename;
	private String filepath;
	private String uuid;
	private LocalDateTime regdate;
	private Integer prod_id; //fk
	private String prod_writer; //fk
}
