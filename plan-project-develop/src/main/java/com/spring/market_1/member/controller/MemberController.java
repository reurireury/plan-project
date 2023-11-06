package com.spring.market_1.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.market_1.ObjectController;
import com.spring.market_1.member.dto.MemberDTO;
import com.spring.market_1.member.service.MemberService;

@Controller("memberController")
public class MemberController implements ObjectController
{
	/* @Autowired 필요한 의존 객체타입(생성자,setter,필드)에 맞춰서 해당하는 빈을 찾아 주입 */
	@Autowired
    private MemberService memberService;
	
	
	@Override
	public ModelAndView ListObjects() throws Exception {
		
		return null;
	}

	@Override
	public ModelAndView SelectObjects() throws Exception {
		
		return null;
	}

	@Override
	public ModelAndView AddObject() throws Exception {
		
		return null;
	}
	/*회원가입*/
	/* @ModelAttribute form의 데이터 처리할 때 사용 html의 태그명과 dto 일치한 경우 dto에 자동반영 */
	@RequestMapping(value = "/member/AddObject.do", method = RequestMethod.POST)
	public String AddObject(@ModelAttribute("member") MemberDTO member, HttpServletRequest request,
	        HttpServletResponse response) throws Exception {
		String uri = request.getRequestURI();
		System.out.println(uri); 
		String id = request.getParameter("id");
		System.out.println(id);
		memberService.AddObject(member);
		
	    String prepath = request.getParameter("path");
		return  "redirect:" + prepath;
	}


	@Override
	public ModelAndView RemoveObject() throws Exception {
		
		return null;
	}

	/* 마이페이지 */
	@Override
	public ModelAndView ModObject() throws Exception {
		
		return null;
	}
	
	
	/*마이페이지 수정 반영*/
	@Override
	public ModelAndView UpdateObject() throws Exception {
		
		return null;
	}

	 @RequestMapping(value = "/member/UpdateObject.do", method = {
		        RequestMethod.GET,
		        RequestMethod.POST
		    })
	 
	 /* @RequestParam 파라미터 이름으로 바인딩*/
	public ModelAndView UpdateObject(@RequestParam("id") String id,
			@ModelAttribute("member") MemberDTO member,HttpServletRequest request) throws Exception {
		String uri = request.getRequestURI();
		System.out.println(uri); 
		 
		memberService.UpdateObject(member);
		ModelAndView mav = new ModelAndView("redirect:/member/MypageForm.do?id="+id);
		
		return mav;
	}

	
	@Override
	public ModelAndView SearchObject() throws Exception {
		
		return null;
	}

	//jsp페이지 이동 위한 
	@Override
	public ModelAndView Form() throws Exception {
		
		return null;
	}
	@RequestMapping(value = {
		        "/member/JoinForm.do",
		        "/member/LoginForm.do",
		        "/member/MypageForm.do"
		    },method = RequestMethod.GET)
	public ModelAndView Form(@RequestParam(value = "type", required = false) String type, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
	
		String uri = request.getRequestURI();
		System.out.println(uri); ///plan/member/JoinForm.do 
		
		if(uri.endsWith("JoinForm.do")) {
			mav.setViewName("/member/JoinForm");
			
		}else if(uri.endsWith("LoginForm.do")) {
			mav.setViewName("/member/LoginForm");
		}else if(uri.endsWith("MypageForm.do")) {
			mav.setViewName("/member/MypageForm");
		}
		return mav;
	}
	/* 	@ResponseBody 비동기식처리인 경우 사용 */
	@ResponseBody
    @RequestMapping(value = "/member/Login.do", method = { 
    		RequestMethod.POST})
    public String Login(@RequestParam("id")String id,
    						@RequestParam("pwd") String pwd, 
    						HttpServletRequest request, HttpServletResponse response,Model model) throws Exception {
		String uri = request.getRequestURI();
		System.out.println(uri); 
		
    	System.out.println("전달받은 값 : "+id+","+pwd);
        System.out.println("로그인버튼 누름");
        
        HttpSession session = request.getSession();
        String result = "";
        
        //로그인검증
        MemberDTO loginResult = memberService.Login(id, pwd);
        if(loginResult==null) {
        	System.out.println("값을 가져오지 못함");
        	result = "fail";
        }else {
        	System.out.println("로그인일치");
        	session.setAttribute("member", loginResult);
        	System.out.println(loginResult);
        	result="success";
        	
        }
    	System.out.println("리턴되는 값 : " + loginResult.getId());
    	System.out.println("리턴되는 값 : " + loginResult.getPwd());
        System.out.println("result - > "+loginResult);
        return result;						
	    
	}
		
		
		
	/* 로그아웃 */
	@RequestMapping(value = "/member/LogOut.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String LogOut(HttpSession session,HttpServletRequest request,Model model)throws Exception {
        session.invalidate();
        model.addAttribute("logoutMessage", "로그아웃되었습니다.");
        return "redirect:/";
	}
	
	/* 아이디 중복검사 */
	@ResponseBody
	@RequestMapping(value = "/member/IdCheck.do", method = { 
    		RequestMethod.POST})
	 public int IdCheck(@RequestParam("id")String id,HttpServletRequest request) {
		String IdCheck=memberService.IdCheck(id);
		int result=0;
		if(IdCheck==null) {
			System.out.println("일치하는 정보 없음");
			result=1;
		}else {
			result=0;
		}
		
		return result;
	}
		
}
