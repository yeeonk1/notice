package org.cloud.controller;

import java.util.List;

import org.cloud.dto.NoticexDTO;
import org.cloud.service.NoticexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/api/notice")
public class NoticeApiController {

	@Autowired
    NoticexService noticexService;
	
	@GetMapping("/list")
	public List<NoticexDTO> noticexList() throws Exception {
		List<NoticexDTO> list = noticexService.noticexList();
		
		return list;
	}
	
	@PostMapping("/write")
	public ResponseEntity<String> noticexWrite(@RequestBody NoticexDTO noticex) throws Exception {
		noticexService.noticexWrite(noticex);
		return ResponseEntity.ok("write success");
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<NoticexDTO> noticexDetail(@PathVariable("id") int id) throws Exception {
		NoticexDTO detail = noticexService.noticexDetail(id);
		noticexService.noticexHitUp(id);
		return ResponseEntity.ok(detail);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> noticexUpdate(@RequestBody NoticexDTO noticex) throws Exception {
		noticexService.noticexUpdate(noticex);
		return ResponseEntity.ok("update success");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> noticexDelete(@PathVariable("id") int id) throws Exception {
		noticexService.noticexDelete(id);
		return ResponseEntity.ok("delete success");
	}
}
