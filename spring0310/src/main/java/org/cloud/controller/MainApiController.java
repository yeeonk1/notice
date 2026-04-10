package org.cloud.controller;

import org.cloud.dto.MemberDTO;
import org.cloud.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/api/member")
public class MainApiController {

	@Autowired
	private MemberService memberService;
	
	// get, post 방식이 다르기 때문에 구분 가능
	@PostMapping("/login") // 사용자가 로그인 폼에서 로그인을 눌렀을 때 해당 메서드가 처리
	public ResponseEntity<?> login(@RequestBody MemberDTO member, HttpSession session, RedirectAttributes rttr) throws Exception {
		MemberDTO user = memberService.memberLoginCheck(member); // 서비스로 이동해서 해당 아이디와 비밀번호가 있는지 확인
		if (user != null) { // 만약 있으면 (로그인 성공 시)
			session.setAttribute("user", user); // 로그인한 회원의 정보를 서버 세션에 user라는 이름으로 저장
			return ResponseEntity.ok(user); // 로그인이 성공했으니 메인 페이지로 이동
		}
		
		return ResponseEntity.status(401).body("아이디 또는 비밀번호가 일치하지 않습니다.");
	}
	// HttpSession: 로그인 성공 시 사용자 정보를 서버 메모리(세션)에 저장
	// RedirectAttributes: 페이지 이동(리다이렉트)을 할 때, 에러 메시지 같은 데이터를 "일회성"으로 전달
	
	@PostMapping("/join")
	public ResponseEntity<String> memberJoin(@RequestBody MemberDTO member) throws Exception {
		memberService.memberJoin(member);
		return ResponseEntity.ok("join success");
	}
	
	@ResponseBody
	@GetMapping("/idCheck")
	public int idCheck(@RequestParam("userId") String userId) {
		return memberService.idCheck(userId);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<String> memberLogout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.ok("logout success");
	}
}
