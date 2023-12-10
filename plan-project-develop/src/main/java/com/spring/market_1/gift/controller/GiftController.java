package com.spring.market_1.gift.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.spring.market_1.gift.service.GiftService;

import com.spring.market_1.ObjectController;
@Controller("giftController")

public class GiftController implements ObjectController{
	@Autowired
	private GiftService giftService;
	
	@Override
	public ModelAndView ListObjects() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	
	@RequestMapping(value="/gift/GiftSelect.do" ,method = RequestMethod.GET)
	public ModelAndView ListObjects(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List giftList = giftService.ListObjects();
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("giftList", giftList);
		return mav;

	}
	
	@RequestMapping(value = "/gift/search.do", method = RequestMethod.GET)
    public ModelAndView searchGifts(
            @RequestParam(value = "category1", required = false) String category1,
            @RequestParam(value = "category2", required = false) String category2,
            @RequestParam(value = "item_brand", required = false) String item_brand,
            @RequestParam(value = "item_name", required = false) String item_name
    ) throws Exception {
        String viewName = "/gift/SearchResults"; // Set the view name for search results
        System.out.println("서치 실행");
        // Call the service method to get the filtered list of gifts
        List searchResults = giftService.searchGifts(category1, category2, item_brand, item_name);

        // Add the search results to the model
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("giftList", searchResults);

        return mav;
    }

	

	@Override
	public ModelAndView SelectObjects() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView AddObject() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView RemoveObject() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView ModObject() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView UpdateObject() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView SearchObject() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView Form() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/* 페이지 불러오기*/
	@RequestMapping(value = {"/gift/GiftList.do",
		},method = RequestMethod.GET)
	public ModelAndView ListObjects(@RequestParam(value = "type", required = false) String type, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
	
		if(uri.endsWith("GiftList.do")) {
			mav.setViewName("/gift/GiftList");
			
		}else if(uri.endsWith("LoginForm.do")) {
			mav.setViewName("/member/LoginForm");
		}
		
		
		return mav;
	}
	
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}
}
