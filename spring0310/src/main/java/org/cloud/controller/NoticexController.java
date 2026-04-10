package org.cloud.controller;

import java.util.List;

import org.cloud.dto.NoticexDTO;
import org.cloud.service.NoticexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/noticex")
public class NoticexController {

	@Autowired
    NoticexService noticexService;
	
	@GetMapping
	public String noticexList(Model model) throws Exception {
		List<NoticexDTO> noticex = noticexService.noticexList();
		model.addAttribute("noticex", noticex);
		return "noticexList";
	}
	
	@GetMapping("/writeUI")
	public String noticexWriteUI() {
		return "noticexWriteUI";
	}
	
	@PostMapping("/write")
	public String noticexWrite(NoticexDTO noticex) throws Exception {
		noticexService.noticexWrite(noticex);
		return "redirect:/noticex/list";
	}
	
	@GetMapping("/detail")
	public String noticexDetail(@PathVariable("id") int id, Model model) throws Exception {
		NoticexDTO noticex = noticexService.noticexDetail(id);
		model.addAttribute("noticex", noticex);
		noticexService.noticexHitUp(id);
		return "noticexDetail";
	}
	
	@GetMapping("/updateUI/{id}")
	public String noticexUpdateUI(@PathVariable("id") int id, Model model) throws Exception {
		NoticexDTO noticex = noticexService.noticexDetail(id);
		model.addAttribute("noticex", noticex);
		return "noticexUpdateUI";
	}
	
	@PutMapping("/{id}")
	public String noticexUpdate(NoticexDTO noticex, Model model) throws Exception {
		noticexService.noticexUpdate(noticex);
		return "redirect:/noticex/list";
	}
	
	@DeleteMapping("/delete")
	public String noticexDelete(@PathVariable("id") int id) throws Exception {
		noticexService.noticexDelete(id);
		return "redirect:/noticex/list";
	}
	
	
}
